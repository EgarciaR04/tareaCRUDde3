package com.tareas.crud.services;

import com.tareas.crud.DTO.Message;
import com.tareas.crud.models.Responsables;
import com.tareas.crud.models.Tareas;
import com.tareas.crud.repositories.ResponsableRepository;
import com.tareas.crud.repositories.TareaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReponsableService {
    private final ResponsableRepository responsableRepository;
    private final TareaRepository tareaRepository;

    public List<Responsables> enlistarResponsables(long id_tarea){
        return this.responsableRepository.getResponsablesByid(id_tarea);
    }

    public Message createResponsable(Responsables request, long id_task) {
        Tareas tarea = this.tareaRepository.findById(id_task).get();
        request.setTask(tarea);

        this.responsableRepository.save(request);

        return new Message("Responsable creado correctamente");
    }

    public Message updateResponsable(Responsables request, long id_responsable) {
        Responsables responsable = this.responsableRepository.findById(id_responsable).get();

        responsable.setEmail(request.getEmail());
        responsable.setName(request.getName());
        this.responsableRepository.save(responsable);

        return new Message("Responsable actualziado");
    }

    public Message deleteResponsable(long id_responsable){
        try {
            this.responsableRepository.deleteById(id_responsable);
            return new Message("Responsable eliminado correctamente");
        } catch (Exception e) {
            return new Message("Responsable no encontrado");
        }
    }
}
