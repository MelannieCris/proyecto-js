import { useState } from "react";
import { useLocation } from "react-router-dom";
import styles from "../styles/compras.module.css";
import LayoutPrincipal from "../../../shared/layouts/LayoutPrincipal";

interface PromocionResponse {
  mensaje: string;
  valido: boolean;
  descuento: number;
}

const validarPromocion = async (codigo: string): Promise<PromocionResponse> => {
  const response = await fetch(
    `http://localhost:8080/api/promociones/validar?codigo=${codigo}`,
  );
  if (!response.ok) throw new Error("Error al validar promoción");
  return response.json();
};

interface DatosCompraState {
  evento: string;
  fecha: string;
  lugar: string;
  zona: string;
  tipo: string;
  precio: number;
}

function Compras() {
  const location = useLocation();
  const datosCompra = location.state as DatosCompraState | null;
  const precioUnitario = datosCompra?.precio || 0;
  const [cantidad, setCantidad] = useState<number>(1);
  const [codigoPromo, setCodigoPromo] = useState<string>("");
  const [mensajePromo, setMensajePromo] = useState<string>("");
  const [promoValida, setPromoValida] = useState<boolean | null>(null);
  const [descuento, setDescuento] = useState<number>(0);
  const subtotal = precioUnitario * cantidad;
  const totalFinal = subtotal - (subtotal * descuento) / 100;

  const aplicarPromocion = async () => {
    if (!codigoPromo.trim()) return;

    try {
      const data = await validarPromocion(codigoPromo);

      setMensajePromo(data.mensaje);
      setPromoValida(data.valido);

      if (data.valido) {
        setDescuento(data.descuento);
      } else {
        setDescuento(0);
      }
    } catch {
      setMensajePromo("Error del servidor");
      setPromoValida(false);
      setDescuento(0);
    }
  };

  return (
    <LayoutPrincipal>
      <div className={styles.page}>
        {/* HERO */}
        <section
          className={`d-flex align-items-center justify-content-center ${styles["seccion-principal"]}`}
        >
          <h1 className="text-white fw-bold">Compra tus entradas</h1>
        </section>

        {/* CONTENIDO */}
        <section
          className="container my-5"
          style={{ backgroundColor: "white" }}
        >
          <div className="row g-4">
            {/* RESUMEN */}
            <div className="col-md-6">
              <div className="card bg-dark text-white p-4 h-100">
                <h3 className="text-white">
                  {datosCompra?.evento || "Evento no seleccionado"}
                </h3>

                <hr />

                <p className="text-white">
                  <strong>Fecha:</strong> {datosCompra?.fecha}
                </p>
                <p className="text-white">
                  <strong>Lugar:</strong> {datosCompra?.lugar}
                </p>
                <p className="text-white">
                  <strong>Zona:</strong> {datosCompra?.zona}
                </p>
                <p className="text-white">
                  <strong>Tipo:</strong> {datosCompra?.tipo}
                </p>

                <h4 className="mt-3">Precio unitario</h4>
                <h2 className="text-danger">S/ {precioUnitario.toFixed(2)}</h2>
              </div>
            </div>

            {/* FORMULARIO */}
            <div className="col-md-6">
              <div className="card p-4 shadow h-100">
                <h4 className="mb-3">Selecciona tus entradas</h4>

                {/* CANTIDAD */}
                <label className="form-label">Cantidad de boletos</label>
                <input
                  type="number"
                  className="form-control mb-3"
                  value={cantidad}
                  min="1"
                  onChange={(e) => setCantidad(Number(e.target.value))}
                />

                {/* PAGO */}
                <label className="form-label">Método de pago</label>
                <select className="form-select mb-3">
                  <option>Tarjeta de crédito</option>
                  <option>Tarjeta de débito</option>
                  <option>Yape / Plin</option>
                </select>

                {/* PROMOCIÓN */}
                <label className="form-label fw-bold">Código promocional</label>
                <div className="d-flex gap-2 mb-2">
                  <input
                    type="text"
                    className={`form-control ${
                      promoValida === true
                        ? "border-success"
                        : promoValida === false
                          ? "border-danger"
                          : ""
                    }`}
                    placeholder="Ej: INTERBANK2026"
                    value={codigoPromo}
                    onChange={(e) => setCodigoPromo(e.target.value)}
                  />
                  <button
                    type="button"
                    className="btn btn-danger"
                    onClick={aplicarPromocion}
                  >
                    Aplicar
                  </button>
                </div>

                {/* MENSAJE CUUPÓN */}
                {mensajePromo && (
                  <div
                    className={`fw-bold mb-3 ${
                      promoValida ? "text-success" : "text-danger"
                    }`}
                  >
                    {mensajePromo}
                  </div>
                )}

                <hr />

                {/* TOTAL */}
                <h5>Total estimado</h5>

                {/* DESCUENTO */}
                {descuento > 0 && (
                  <p className="text-success fw-bold">
                    Descuento aplicado: {descuento}%
                  </p>
                )}

                <h3 className="text-danger">S/ {totalFinal.toFixed(2)}</h3>

                {/* BOTÓN */}
                <button
                  type="button"
                  className="btn btn-danger w-100 mt-3 fw-bold"
                >
                  Confirmar compra
                </button>
              </div>
            </div>
          </div>
        </section>

        {/* INFO */}
        <section
          className="container text-center mb-5"
          style={{ backgroundColor: "white" }}
        >
          <small>Los boletos serán enviados a tu correo electrónico.</small>
        </section>
      </div>
    </LayoutPrincipal>
  );
}

export default Compras;
