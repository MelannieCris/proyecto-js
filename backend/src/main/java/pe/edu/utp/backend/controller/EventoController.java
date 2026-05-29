package pe.edu.utp.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pe.edu.utp.backend.entity.Evento;
import pe.edu.utp.backend.service.EventoService;

import java.util.List;

@RestController
@RequestMapping("/api/eventos")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class EventoController {

	private final EventoService eventoService;

	@GetMapping
	public List<Evento> listar() {
		return eventoService.listar();
	}

	@GetMapping("/{id}")
	public Evento buscarPorId(@PathVariable Long id) {
		return eventoService.buscarPorId(id);
	}

	@PostMapping
	public Evento guardar(@RequestBody Evento evento) {
		return eventoService.guardar(evento);
	}

	@PutMapping("/{id}")
	public Evento actualizar(
			@PathVariable Long id,
			@RequestBody Evento evento) {
		return eventoService.actualizar(id, evento);
	}

	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable Long id) {
		eventoService.eliminar(id);
	}
}