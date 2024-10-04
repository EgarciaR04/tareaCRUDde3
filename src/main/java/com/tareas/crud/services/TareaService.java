package com.tareas.crud.services;

import com.tareas.crud.DTO.Message;
import com.tareas.crud.models.Proyecto;
import com.tareas.crud.models.Tareas;
import com.tareas.crud.repositories.ProyectoRepository;
import com.tareas.crud.repositories.TareaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TareaService {
    private final TareaRepository tareaRepository;
    private final ProyectoRepository proyectoRepository;

    public List<Tareas> buscarTareasPorIdProyecto(long id_proyecto) {
        return tareaRepository.getTareasByProyectoId(id_proyecto);
    }

    public Message crearTarea(Tareas request, long id_proyecto) {
        Proyecto proyecto = this.proyectoRepository.findById(id_proyecto).get();

        request.setProject(proyecto);

        this.tareaRepository.save(request);

        return new Message("Tarea creada");
    }

    public Message updateTarea(Tareas request, long id_tarea) {
        Tareas tarea = this.tareaRepository.findById(id_tarea).get();
        tarea.setTitle(request.getTitle());
        tarea.setDescription(request.getDescription());
        tarea.setDueDate(request.getDueDate());

        this.tareaRepository.save(tarea);

        return new Message("Tarea Actualizada");
    }

    public Message deleteTarea(long id_tarea){
        try {
            this.tareaRepository.deleteById(id_tarea);
            return new Message("Tarea eliminada");
        } catch (Exception e) {
            return new Message("Tarea no encontrada");
        }
    }
}
