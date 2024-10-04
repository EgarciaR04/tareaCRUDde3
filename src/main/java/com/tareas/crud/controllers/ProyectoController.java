package com.tareas.crud.controllers;

import com.tareas.crud.DTO.Message;
import com.tareas.crud.models.Proyecto;
import com.tareas.crud.services.ProyectoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proyecto")
@RequiredArgsConstructor
public class ProyectoController {
    private final ProyectoService proyectoService;

    @GetMapping(path = "/enlistar")
    public List<Proyecto> enlistarProyectos() {
        return this.proyectoService.getProyectoList();
    }

    @PostMapping(path = "/crear")
    public Message crearProyecto(@RequestBody Proyecto request) {
        return this.proyectoService.saveProyecto(request);
    }

    @PutMapping(path = "/update/{id_proyecto}")
    public Message updateProyecto(@RequestBody Proyecto request, @PathVariable long id_proyecto) {
        return this.proyectoService.updateProyectoById(request, id_proyecto);
    }

    @DeleteMapping(path = "/delete/{id_proyecto}")
    public Message deleteProyecto(@PathVariable long id_proyecto) {
        return this.proyectoService.deleteProyecto(id_proyecto);
    }
}
