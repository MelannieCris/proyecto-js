package pe.edu.utp.backend.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.utp.backend.entity.Zona;
import pe.edu.utp.backend.repository.ZonaRepository;
import pe.edu.utp.backend.service.ZonaService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ZonaServiceImpl implements ZonaService {

    private final ZonaRepository zonaRepository;

    @Override
    public List<Zona> listar() {
        return zonaRepository.findAll();
    }

    @Override
    public Zona buscarPorId(Long id) {
        return zonaRepository.findById(id).orElse(null);
    }

    @Override
    public Zona guardar(Zona zona) {
        return zonaRepository.save(zona);
    }

    @Override
    public Zona actualizar(Long id, Zona nueva) {

        Zona actual = zonaRepository.findById(id).orElseThrow();

        actual.setNombre_zona(nueva.getNombre_zona());
        actual.setCapacidad(nueva.getCapacidad());
        actual.setEstado(nueva.getEstado());

        return zonaRepository.save(actual);
    }

    @Override
    public void eliminar(Long id) {
        zonaRepository.deleteById(id);
    }
}