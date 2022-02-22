package com.example.trabajadorspring.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.trabajadorspring.entity.Trabajador;

public interface TrabajadorDao extends CrudRepository<Trabajador, Long> {

}
