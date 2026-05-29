package pe.edu.utp.backend.service;

import pe.edu.utp.backend.dto.PromocionResponse;
import pe.edu.utp.backend.entity.Promocion;

import java.util.List;
import java.util.Optional;

public interface PromocionService {

    List<Promocion> listarPromociones();

    Optional<Promocion> buscarPorId(Integer id);

    Promocion guardarPromocion(Promocion promocion);

    Promocion actualizarPromocion(Integer id, Promocion promocion);

    void eliminarPromocion(Integer id);

    PromocionResponse validarPromocion(String codigo);
}