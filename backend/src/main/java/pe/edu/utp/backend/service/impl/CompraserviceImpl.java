package pe.edu.utp.backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.utp.backend.entity.Compra;
import pe.edu.utp.backend.entity.Entrada;
import pe.edu.utp.backend.repository.CompraRepository;
import pe.edu.utp.backend.repository.EntradaRepository;
import pe.edu.utp.backend.service.CompraService;

@Service
public class CompraserviceImpl implements CompraService {
    @Autowired
private CompraRepository compraRepository;
 @Autowired
private EntradaRepository entradaRepository;
    @Override
    public Compra Newcompra(Compra Compra) {
       return compraRepository.save(Compra);
    }
    @Override
    public void DeleteCompra(Long id) {
        Compra compraExs = compraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("compra no encontrada"));
                compraRepository.delete(compraExs);
    }

    @Override
    public Entrada actualizarEntrada(Long id, String estado) {
       Entrada Entradaexistente=entradaRepository.findById(id).
       orElseThrow(() -> new RuntimeException("Entrada no encontrada"));
      Entradaexistente.setEstado(estado);
      return entradaRepository.save(Entradaexistente);
    }

    @Override
    public Compra actualizarCompra(Long id, Compra Compra) {
         Compra compraexistente = compraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("compra no encontrada"));

        compraexistente.setEstado(Compra.getEstado());
        compraexistente.setFecha_compra(Compra.getFecha_compra());
        compraexistente.setTotal(Compra.getTotal());
        compraexistente.setTotal(Compra.getTotal());

        return compraRepository.save(compraexistente);
    }
    @Override
    public List<Compra> listcompras() {
        return compraRepository.findAll();
    
}
    @Override
    public Optional<Compra> compraPorId(Long id) {
       return compraRepository.findById(id);
    }}