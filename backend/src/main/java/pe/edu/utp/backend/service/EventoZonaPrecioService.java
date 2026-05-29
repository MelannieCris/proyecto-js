package pe.edu.utp.backend.service;

import pe.edu.utp.backend.entity.EventoZonaPrecio;

import java.util.List;

public interface EventoZonaPrecioService {

    List<EventoZonaPrecio> listar();

    EventoZonaPrecio buscarPorId(Long id);

    EventoZonaPrecio guardar(EventoZonaPrecio eventoZonaPrecio);

    EventoZonaPrecio actualizar(Long id, EventoZonaPrecio eventoZonaPrecio);

    void eliminar(Long id);
}