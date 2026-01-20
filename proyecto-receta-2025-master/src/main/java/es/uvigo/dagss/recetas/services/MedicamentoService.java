package es.uvigo.dagss.recetas.services;

import java.util.List;
import es.uvigo.dagss.recetas.entidades.Medicamento;

public interface MedicamentoService{
	public void crearMedicamento(Medicamento medicamento);
	public void actualizarMedicamento(Medicamento medicamento);
	public void eliminarMedicamento(Medicamento medicamento);
	public List<Medicamento> buscarTodos();
	public Medicamento buscarPorId(Long id);
	public List<Medicamento> buscarActivos();
	public List<Medicamento> buscarPorNombreComercial(String nombreComercial);
	public List<Medicamento> buscarPorPrincipioActivo(String principioActivo);
	public List<Medicamento> buscarPorFabricante(String fabricante);
	public List<Medicamento> buscarPorFamilia(String familia);
    public String getMedicamentoHome(Long medicamentoId);
}