package es.uvigo.dagss.recetas.services;


import java.util.List;
import java.util.Optional;

import es.uvigo.dagss.recetas.entidades.Farmacia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import es.uvigo.dagss.recetas.daos.MedicamentoDAO;
import es.uvigo.dagss.recetas.entidades.Medicamento;

@Service
public class MedicamentoServiceImpl implements MedicamentoService{
	@Autowired
	private MedicamentoDAO medicamentoDAO;

	public MedicamentoServiceImpl(){ }

	public void crearMedicamento(Medicamento medicamento){
		medicamentoDAO.save(medicamento);
	}

	public void eliminarMedicamento(Medicamento medicamento){
		medicamento.setActivo(false);
        medicamentoDAO.save(medicamento);
	}

	public void actualizarMedicamento(Medicamento medicamento){
		medicamentoDAO.save(medicamento);
	}

	public List<Medicamento> buscarTodos() {
        return medicamentoDAO.findAll();
    }

    public Medicamento buscarPorId(Long id) {
        return medicamentoDAO.findById(id).orElse(null);
    }
	
	public List<Medicamento> buscarActivos() {
		return medicamentoDAO.findByActivoTrue();
	}

	public List<Medicamento> buscarPorPrincipioActivo(String principioActivo){
		if(principioActivo != null && !principioActivo.isEmpty()){
			return medicamentoDAO.findByPrincipioActivoContainingIgnoreCase(principioActivo);
		}else{
			return medicamentoDAO.findAll();
		}
	}

	public List<Medicamento> buscarPorNombreComercial(String nombreComercial){
		if(nombreComercial != null && !nombreComercial.isEmpty()){
			return medicamentoDAO.findByNombreComercialContainingIgnoreCase(nombreComercial);
		}else{
			return medicamentoDAO.findAll();
		}
	}

	public List<Medicamento> buscarPorFamilia(String familia){
		if(familia != null && !familia.isEmpty()){
			return medicamentoDAO.findByFamiliaContainingIgnoreCase(familia);
		}else{
			return medicamentoDAO.findAll();
		}
	}

	public List<Medicamento> buscarPorFabricante(String fabricante){
		if(fabricante != null && !fabricante.isEmpty()){
			return medicamentoDAO.findByFabricanteContainingIgnoreCase(fabricante);
		}else{
			return medicamentoDAO.findAll();
		}
	}

    // HU-F1: Método para obtener el "Home" de un medicamento
    public String getMedicamentoHome(Long medicamentoId) {
        Optional<Medicamento> medicamento = medicamentoDAO.findById(medicamentoId);
        if (medicamento.isPresent()) {
            return "Home de medicamento: " + medicamento.get().getNombreComercial();
        } else {
            throw new RuntimeException("Medicamento no encontrado");
        }
    }
}