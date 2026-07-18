import "./styles/formularios.css";

export default function UsuarioForm() {
  return (
    <div className="form-container">
      <h2>Formulario de Usuario</h2>
      <form>
        <div className="mb-3">
          <label className="form-label">Nombre</label>
          <input type="text" className="form-control" />
        </div>
        <div className="mb-3">
          <label className="form-label">Correo</label>
          <input type="email" className="form-control" />
        </div>
        <button type="submit" className="btn-form">Guardar</button>
      </form>
    </div>
  );
}
