package es.uvigo.dagss.recetas.services.estrategias;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.uvigo.dagss.recetas.daos.RecetaDAO;
import es.uvigo.dagss.recetas.entidades.Prescripcion;
import es.uvigo.dagss.recetas.entidades.Receta;

@Component
public class EstrategiaGeneracionRecetasSemanal implements EstrategiaGeneracionRecetas {

    @Autowired
    private RecetaDAO recetaDAO;

    @Override
    public List<Receta> generarPlanRecetas(Prescripcion prescripcion) {

        List<Receta> planRecetas = new ArrayList<>();

        int dosisDiaria = prescripcion.getDosis();
        int dosisPorEnvase = prescripcion.getMedicamento().getDosis();

        LocalDate inicio = prescripcion.getFechaInicio();
        LocalDate fin = prescripcion.getFechaFin();

        int totalDias = (int) (fin.toEpochDay() - inicio.toEpochDay());
        int totalEnvases = (int) Math.ceil((double) (dosisDiaria * totalDias) / dosisPorEnvase);

        LocalDate fechaActual = inicio;

        for (int i = 0; i < totalEnvases; i++) {

            LocalDate fechaInicio = fechaActual;
            fechaActual = fechaActual.plusDays(dosisPorEnvase / dosisDiaria);
            LocalDate fechaFin = fechaActual;

            // Margen semanal: �7 d�as
            LocalDate fechaValidezInicio = fechaInicio.minusDays(7);
            LocalDate fechaValidezFin = fechaFin.plusDays(7);

            int cajasPorReceta = 1;

            Receta receta = new Receta(
                    prescripcion,
                    fechaValidezInicio,
                    fechaValidezFin,
                    cajasPorReceta,
                    Receta.estado.PLANIFICADA
            );

            planRecetas.add(receta);
            recetaDAO.save(receta);
        }

        return planRecetas;
    }
}