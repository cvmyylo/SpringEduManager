package com.alkemy.edu.controller;

import com.alkemy.edu.model.Curso;
import com.alkemy.edu.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoRestController {

    @Autowired
    private CursoRepository repository;

    @GetMapping
    public List<Curso> listarTodos() {
        return repository.findAll();
    }

    @PostMapping
    public Curso guardar(@RequestBody Curso curso) {
        return repository.save(curso);
    }
}