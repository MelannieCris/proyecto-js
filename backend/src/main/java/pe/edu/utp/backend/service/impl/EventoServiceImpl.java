package pe.edu.utp.backend.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.utp.backend.entity.Evento;
import pe.edu.utp.backend.entity.Lugar;
import pe.edu.utp.backend.repository.EventoRepository;
import pe.edu.utp.backend.repository.LugarRepository;
import pe.edu.utp.backend.service.EventoService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventoServiceImpl implements EventoService {

    private final EventoRepository eventoRepository;

    private final LugarRepository lugarRepository;

    @Override
    public List<Evento> listar() {
        return eventoRepository.findAll();
    }

    @Override
    public Evento buscarPorId(Long id) {
        return eventoRepository.findById(id).orElse(null);
    }

    @Override
    public Evento guardar(Evento evento) {

        Lugar lugar = lugarRepository.findById(
                evento.getLugar().getId_lugar()).orElseThrow();

        evento.setLugar(lugar);

        return eventoRepository.save(evento);
    }

    @Override
    public Evento actualizar(Long id, Evento nuevo) {

        Evento actual = eventoRepository.findById(id).orElseThrow();

        actual.setTitulo(nuevo.getTitulo());
        actual.setDescripcion(nuevo.getDescripcion());
        actual.setFecha_evento(nuevo.getFecha_evento());
        actual.setHora_evento(nuevo.getHora_evento());
        actual.setImagen(nuevo.getImagen());
        actual.setEstado(nuevo.getEstado());

        return eventoRepository.save(actual);
    }

    @Override
    public void eliminar(Long id) {
        eventoRepository.deleteById(id);
    }
}