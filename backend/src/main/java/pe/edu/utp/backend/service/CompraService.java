package pe.edu.utp.backend.service;
import java.util.List;
import java.util.Optional;
import pe.edu.utp.backend.entity.Compra;
import pe.edu.utp.backend.entity.Entrada;

public interface CompraService {

    Compra Newcompra(Compra Compra);
     Optional<Compra> compraPorId(Long id);
    void DeleteCompra(Long id);
    Entrada actualizarEntrada(Long id, String estado );
    Compra actualizarCompra(Long id, Compra Compra );
    List<Compra> listcompras();
} 