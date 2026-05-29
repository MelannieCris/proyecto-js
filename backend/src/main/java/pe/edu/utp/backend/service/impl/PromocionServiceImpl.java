package pe.edu.utp.backend.service.impl;

import pe.edu.utp.backend.dto.PromocionResponse;
import pe.edu.utp.backend.entity.Promocion;
import pe.edu.utp.backend.repository.PromocionRepository;
import pe.edu.utp.backend.service.PromocionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PromocionServiceImpl implements PromocionService {

    @Autowired
    private PromocionRepository repository;

    @Override
    public List<Promocion> listarPromociones() {
        return repository.findAll();
    }

    @Override
    public Optional<Promocion> buscarPorId(Integer id) {
        return repository.findById((long) id);
    }

    @Override
    public Promocion guardarPromocion(Promocion promocion) {
        return repository.save(promocion);
    }

    @Override
    public Promocion actualizarPromocion(Integer id, Promocion promocion) {

        Promocion promoExistente = repository.findById((long) id)
                .orElseThrow(() -> new RuntimeException("Promoción no encontrada"));

        promoExistente.setCodigo(promocion.getCodigo());
        promoExistente.setDescuentoPorcentaje(promocion.getDescuentoPorcentaje());
        promoExistente.setFechaInicio(promocion.getFechaInicio());
        promoExistente.setFechaFin(promocion.getFechaFin());
        promoExistente.setEstado(promocion.getEstado());

        return repository.save(promoExistente);
    }

    @Override
    public void eliminarPromocion(Integer id) {

        Promocion promo = repository.findById((long) id)
                .orElseThrow(() -> new RuntimeException("Promoción no encontrada"));

        repository.delete(promo);
    }

    @Override
    public PromocionResponse validarPromocion(String codigo) {

        Optional<Promocion> promoOpt = repository.findByCodigo(codigo);

        if (promoOpt.isEmpty()) {

            return new PromocionResponse(
                    false,
                    "Promoción no encontrada",
                    null);
        }

        Promocion promo = promoOpt.get();

        LocalDate hoy = LocalDate.now();

        // VALIDAR ESTADO
        if (!promo.getEstado().equalsIgnoreCase("ACTIVO")) {

            return new PromocionResponse(
                    false,
                    "Promoción inactiva",
                    null);
        }

        // VALIDAR FECHA
        if (hoy.isAfter(promo.getFechaFin())) {

            return new PromocionResponse(
                    false,
                    "Promoción expirada",
                    null);
        }

        // VALIDAR USOS
        if (promo.getCantidadUsos() >= promo.getMaximoUsos()) {

            return new PromocionResponse(
                    false,
                    "Promoción agotada",
                    null);
        }

        return new PromocionResponse(true, "Promoción válida", promo.getDescuentoPorcentaje());
    }
}