package pe.edu.utp.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.utp.backend.entity.EventoZonaPrecio;

public interface EventoZonaPrecioRepository
        extends JpaRepository<EventoZonaPrecio, Long> {

}