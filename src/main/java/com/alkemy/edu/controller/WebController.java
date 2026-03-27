package com.alkemy.edu.controller;

import com.alkemy.edu.model.Curso;
import com.alkemy.edu.model.Estudiante;
import com.alkemy.edu.repository.CursoRepository;
import com.alkemy.edu.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {

    @Autowired
    private EstudianteRepository estudianteRepo;

    @Autowired
    private CursoRepository cursoRepo;

    // --- RUTA PRINCIPAL ---
    @GetMapping("/")
    public String index() {
        return "index"; // Carga index.html
    }

    // --- RUTAS PARA ESTUDIANTES ---
    @GetMapping("/estudiantes")
    public String listarEstudiantes(Model model) {
        model.addAttribute("estudiantes", estudianteRepo.findAll());
        return "lista-estudiantes"; // Carga lista-estudiantes.html
    }

    @GetMapping("/estudiantes/nuevo")
    public String mostrarFormularioEstudiante(Model model) {
        model.addAttribute("estudiante", new Estudiante());
        return "form-estudiante"; // Carga form-estudiante.html
    }

    @PostMapping("/estudiantes")
    public String guardarEstudiante(@ModelAttribute("estudiante") Estudiante estudiante) {
        estudianteRepo.save(estudiante);
        return "redirect:/estudiantes";
    }

    // --- RUTAS PARA CURSOS ---
    @GetMapping("/cursos")
    public String listarCursos(Model model) {
        model.addAttribute("cursos", cursoRepo.findAll());
        return "lista-cursos"; // Carga lista-cursos.html
    }

    // Esta ruta está protegida para ADMIN en SecurityConfig
    @GetMapping("/cursos/nuevo")
    public String mostrarFormularioCurso(Model model) {
        model.addAttribute("curso", new Curso());
        return "form-curso"; // Carga form-curso.html
    }

    @PostMapping("/cursos")
    public String guardarCurso(@ModelAttribute Curso curso) {
        cursoRepo.save(curso);
        return "redirect:/cursos";
    }
}