package com.example.trabajadorspring.controller;

import java.util.Optional;

import javax.persistence.PostPersist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.trabajadorspring.dao.TrabajadorDao;
import com.example.trabajadorspring.entity.Trabajador;

@RestController
public class Controller {

	@Autowired
	private TrabajadorDao trabajadorDao;

	@GetMapping("/trabajadores")
	public Iterable<Trabajador> getTrabajadores() {
		return trabajadorDao.findAll();
	}

	@PostMapping("/registrarTrabajador")
	public String registrarTrabajador(@RequestBody Trabajador trabajador) {
		trabajadorDao.save(trabajador);
		return "Trabajador agregado";
	}

	@GetMapping("/consultarTrabajador/{idTrabajador}")
	public Optional<Trabajador> consultarTrabajor(@PathVariable("idTrabajador") long idTrabajador) {
		return trabajadorDao.findById(idTrabajador);

	}

	@PutMapping("/modificarTrabajador/{id}")
	public String modificarTrabajador(@PathVariable(name = "id") long id, @RequestBody Trabajador trabajador2) {
		Trabajador trabajador = trabajadorDao.findById(id).get();
		trabajador.setNombre(trabajador2.getNombre());
		trabajador.setApellido(trabajador2.getApellido());
		trabajador.setEmail(trabajador2.getEmail());
		trabajador.setTelefono(trabajador2.getTelefono());

		trabajadorDao.save(trabajador);
		return "Trabajador modificado";

	}

	@DeleteMapping("/eliminarTrabajador/{id}")
	public String eliminarTrabajador(@PathVariable("id") long id) {
		trabajadorDao.deleteById(id);
		return "Eliminado correctamente";
	}

}
