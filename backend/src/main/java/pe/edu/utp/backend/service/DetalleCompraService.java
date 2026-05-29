package pe.edu.utp.backend.service;

import pe.edu.utp.backend.entity.DetalleCompra;

import java.util.List;

public interface DetalleCompraService {

    List<DetalleCompra> listar();

    DetalleCompra buscarPorId(Long id);

    DetalleCompra guardar(DetalleCompra detalleCompra);

    DetalleCompra actualizar(Long id, DetalleCompra detalleCompra);

    void eliminar(Long id);
}