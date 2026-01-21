package es.uvigo.dagss.recetas.services;

import java.util.List;
import es.uvigo.dagss.recetas.entidades.Medicamento;

public interface MedicamentoService{
	void crearMedicamento(Medicamento medicamento);
	void actualizarMedicamento(Medicamento medicamento);
	void eliminarMedicamento(Medicamento medicamento);
	Medicamento buscarPorId(Long id);
	List<Medicamento> buscarActivos();
	List<Medicamento> buscarPorNombreComercial(String nombreComercial);
	List<Medicamento> buscarPorPrincipioActivo(String principioActivo);
	List<Medicamento> buscarPorFabricante(String fabricante);
	List<Medicamento> buscarPorFamilia(String familia);
}