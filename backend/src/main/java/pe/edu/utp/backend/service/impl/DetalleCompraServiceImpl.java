package pe.edu.utp.backend.service.impl;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import pe.edu.utp.backend.entity.Compra;
import pe.edu.utp.backend.entity.DetalleCompra;
import pe.edu.utp.backend.entity.EventoZonaPrecio;

import pe.edu.utp.backend.repository.CompraRepository;
import pe.edu.utp.backend.repository.DetalleCompraRepository;
import pe.edu.utp.backend.repository.EventoZonaPrecioRepository;

import pe.edu.utp.backend.service.DetalleCompraService;

import java.util.List;

@Service
@RequiredArgsConstructor

public class DetalleCompraServiceImpl
        implements DetalleCompraService {

    private final DetalleCompraRepository repository;

    private final CompraRepository compraRepository;

    private final EventoZonaPrecioRepository eventoZonaPrecioRepository;

    @Override
    public List<DetalleCompra> listar() {

        return repository.findAll();
    }

    @Override
    public DetalleCompra buscarPorId(Long id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public DetalleCompra guardar(
            DetalleCompra detalleCompra) {

        Compra compra = compraRepository.findById(
                detalleCompra.getCompra().getId_compra()).orElseThrow();

        EventoZonaPrecio eventoZonaPrecio = eventoZonaPrecioRepository.findById(
                detalleCompra
                        .getEventoZonaPrecio()
                        .getId())
                .orElseThrow();

        detalleCompra.setCompra(compra);

        detalleCompra.setEventoZonaPrecio(
                eventoZonaPrecio);

        return repository.save(detalleCompra);
    }

    @Override
    public DetalleCompra actualizar(
            Long id,
            DetalleCompra nuevo) {

        DetalleCompra actual = repository.findById(id).orElseThrow();

        actual.setCantidad(nuevo.getCantidad());

        actual.setPrecio_unitario(
                nuevo.getPrecio_unitario());

        actual.setSubtotal(
                nuevo.getSubtotal());

        return repository.save(actual);
    }

    @Override
    public void eliminar(Long id) {

        repository.deleteById(id);
    }
}