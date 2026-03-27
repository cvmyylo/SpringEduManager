package com.alkemy.edu.controller;

import com.alkemy.edu.model.Estudiante;
import com.alkemy.edu.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteRestController {

    @Autowired
    private EstudianteRepository repository;

    @GetMapping
    public List<Estudiante> listarTodos() {
        return repository.findAll();
    }

    @PostMapping
    public Estudiante guardar(@RequestBody Estudiante estudiante) {
        return repository.save(estudiante);
    }
}