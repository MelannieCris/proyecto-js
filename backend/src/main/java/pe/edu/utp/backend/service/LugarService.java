package pe.edu.utp.backend.service;

import pe.edu.utp.backend.entity.Lugar;

import java.util.List;

public interface LugarService {

    List<Lugar> listar();

    Lugar buscarPorId(Long id);

    Lugar guardar(Lugar lugar);

    Lugar actualizar(Long id, Lugar lugar);

    void eliminar(Long id);
}