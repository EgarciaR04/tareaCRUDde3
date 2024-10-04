package com.tareas.crud.controllers;

import com.tareas.crud.DTO.Message;
import com.tareas.crud.models.Responsables;
import com.tareas.crud.repositories.ResponsableRepository;
import com.tareas.crud.services.ReponsableService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/responsables")
@RequiredArgsConstructor
public class ResponsableController {

    private final ReponsableService reponsableService;

    @GetMapping(path = "/enlistar/{id_task}")
    public List<Responsables> enlistarResponsables(@PathVariable long id_task) {
        return this.reponsableService.enlistarResponsables(id_task);
    }

    @PostMapping(path = "/crear/{id_task}")
    public Message crearResponsable(@RequestBody Responsables request, @PathVariable long id_task) {
        return this.reponsableService.createResponsable(request, id_task);
    }

    @PutMapping(path = "/update/{id_res}")
    public Message updateResponsable(@RequestBody Responsables request, @PathVariable long id_res) {
        return this.reponsableService.updateResponsable(request, id_res);
    }

    @DeleteMapping(path = "/delete/{id_res}")
    public Message deleteResponsable(@PathVariable long id_res) {
        return this.reponsableService.deleteResponsable(id_res);
    }
}
