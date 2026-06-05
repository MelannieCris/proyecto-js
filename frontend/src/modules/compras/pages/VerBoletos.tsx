import LayoutPrincipal from "../../../shared/layouts/LayoutPrincipal";

export default function VerBoletos() {
  return (
    <LayoutPrincipal>
      <div className="container py-5">
        <main className="container py-2 mb-5">
          <div className="d-flex justify-content-between align-items-center my-4">
            <h1 className="h3 text-dark">Mis Boletos</h1>

            {/* DROPDOWN DE OPCIONES */}
            <div className="dropdown">
              <button
                className="btn btn-secondary dropdown-toggle"
                type="button"
                data-bs-toggle="dropdown"
                aria-expanded="false"
              >
                COMPRAS & E-TICKETS
              </button>
              <ul className="dropdown-menu">
                <li>
                  <a className="dropdown-item" href="#mis-compras">
                    MIS COMPRAS
                  </a>
                </li>
                <li>
                  <a className="dropdown-item" href="#e-tickets">
                    E-TICKETS
                  </a>
                </li>
                <li>
                  <a className="dropdown-item" href="#devoluciones">
                    MIS DEVOLUCIONES
                  </a>
                </li>
                <li>
                  <a className="dropdown-item" href="#password">
                    CAMBIAR CONTRASEÑA
                  </a>
                </li>
                <li>
                  <hr className="dropdown-divider" />
                </li>
                <li>
                  <button type="button" className="dropdown-item text-danger">
                    CERRAR SESIÓN
                  </button>
                </li>
              </ul>
            </div>
          </div>

          {/* TABS DE FILTRO */}
          <ul className="row list-unstyled text-center bg-light m-0 p-0">
            <li className="col-4 btn py-3 btn-outline-secondary rounded-0 border-0">
              MIS COMPRAS
            </li>
            <li className="col-4 btn py-3 btn-outline-secondary rounded-0 border-0">
              ETICKETS
            </li>
            <li className="col-4 btn py-3 btn-outline-secondary rounded-0 border-0">
              MIS DEVOLUCIONES
            </li>
          </ul>

          {/* MENSAJE CUANDO NO HAY ENTRADAS */}
          <div className="container text-center my-5 py-5">
            <h3 className="text-dark mb-3">No tiene boletos disponibles</h3>
            <a href="/" className="btn btn-danger px-4 fw-bold">
              Comprar Boletos
            </a>
          </div>
        </main>
      </div>
    </LayoutPrincipal>
  );
}
