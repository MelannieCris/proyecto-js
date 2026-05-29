package pe.edu.utp.backend.service;

import pe.edu.utp.backend.entity.Usuario;
import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    Usuario registrar(Usuario usuario);
    List<Usuario> listarTodos();
    Optional<Usuario> obtenerPorId(Long id);
    Usuario actualizar(Long id, Usuario usuario); 
    void eliminar(Long id);
    Usuario login(String correo, String contrasena);
    Optional<Usuario> buscarPorCorreo(String correo);
}