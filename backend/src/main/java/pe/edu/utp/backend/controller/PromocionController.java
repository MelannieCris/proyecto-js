package pe.edu.utp.backend.controller;

import pe.edu.utp.backend.dto.PromocionRequest;
import pe.edu.utp.backend.dto.PromocionResponse;
import pe.edu.utp.backend.entity.Promocion;
import pe.edu.utp.backend.service.PromocionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/promociones")
@CrossOrigin(origins = "http://localhost:5173")
public class PromocionController {

    @Autowired
    private PromocionService service;

    @GetMapping
    public ResponseEntity<List<Promocion>> listarPromociones() {
        return ResponseEntity.ok(service.listarPromociones());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Promocion> obtenerPromocion(@PathVariable Integer id) {

        Promocion promocion = service.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Promoción no encontrada"));

        return ResponseEntity.ok(promocion);
    }

    @PostMapping
    public ResponseEntity<Promocion> guardarPromocion(@RequestBody Promocion promocion) {
        return ResponseEntity.ok(service.guardarPromocion(promocion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Promocion> actualizarPromocion(
            @PathVariable Integer id,
            @RequestBody Promocion promocion) {

        return ResponseEntity.ok(service.actualizarPromocion(id, promocion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPromocion(@PathVariable Integer id) {

        service.eliminarPromocion(id);

        return ResponseEntity.ok("Promoción eliminada correctamente");
    }

    @PostMapping("/validar")
    public ResponseEntity<PromocionResponse> validarPromocion(
            @RequestBody PromocionRequest request) {

        return ResponseEntity.ok(
                service.validarPromocion(
                        request.getCodigo()));
    }
}