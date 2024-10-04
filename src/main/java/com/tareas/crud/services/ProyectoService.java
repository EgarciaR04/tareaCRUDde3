package com.tareas.crud.services;

import com.tareas.crud.DTO.Message;
import com.tareas.crud.models.Proyecto;
import com.tareas.crud.repositories.ProyectoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProyectoService {
    private final ProyectoRepository proyectoRepository;

    public List<Proyecto> getProyectoList(){
        return this.proyectoRepository.findAll();
    }

    public Proyecto getProyectoByid(long id_proyecto){
        return this.proyectoRepository.findById(id_proyecto).get();
    }

    public Message saveProyecto(Proyecto request) {
        this.proyectoRepository.save(request);
        return new Message("Proyecto creado correctamente");

    }

    public Message updateProyectoById(Proyecto request, long id_proyecto) {
        Proyecto proyecto = new Proyecto();
        proyecto.setName(request.getName());
        proyecto.setDescription(request.getDescription());
        proyecto.setStartDate(request.getStartDate());
        this.proyectoRepository.save(proyecto);

        return new Message("Proyecto actualizado");
    }

    public Message deleteProyecto(long id_proyecto) {
        try {
            this.proyectoRepository.deleteById(id_proyecto);
            return new Message("Proyecto eliminado correctamente");
        } catch (Exception exception) {
            return new Message("Proyecto no encontrado");
        }
    }
}
