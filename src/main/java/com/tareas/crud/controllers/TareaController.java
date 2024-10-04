package com.tareas.crud.controllers;

import com.tareas.crud.DTO.Message;
import com.tareas.crud.models.Tareas;
import com.tareas.crud.services.TareaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarea")
@RequiredArgsConstructor
public class TareaController {
    private final TareaService tareaService;

    @GetMapping(path = "/enlistar/{id_proyecto}")
    public List<Tareas> enlistarTareas(@PathVariable long id_proyecto) {
        return this.tareaService.buscarTareasPorIdProyecto(id_proyecto);
    }

    @PostMapping(path = "/crear/{id_proyecto}")
    public Message crearTarea(@RequestBody Tareas request, @PathVariable long id_proyecto) {
        return this.tareaService.crearTarea(request, id_proyecto);
    }

    @PutMapping(path = "/update/{id_task}")
    public Message updateProyecto(@RequestBody Tareas request, @PathVariable long id_task) {
        return this.tareaService.updateTarea(request, id_task);
    }

    @DeleteMapping(path = "/delete/{id_task}")
    public Message deleteTask(@PathVariable long id_task) {
        return this.tareaService.deleteTarea(id_task);
    }
}
