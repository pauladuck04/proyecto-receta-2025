package es.uvigo.dagss.recetas.controladores;

import java.net.URI;
import java.util.List;

import org.aspectj.weaver.ast.Not;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import es.uvigo.dagss.recetas.entidades.Administrador;
import es.uvigo.dagss.recetas.services.AdministradorService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/admins")
public class AdministradorController{
	@Autowired
	private AdministradorService administradorService;

	@GetMapping
	public List<Administrador> listarAdministradores(){
		return administradorService.buscarTodos();
	}