export interface PromocionResponse {
  idPromocion: number;
  codigo: string;
  descuentoPorcentaje: number;
  fechaInicio: string;
  fechaFin: string;
  estado: string;
  cantidadUsos: number;
  maximoUsos: number;
}

export interface PromocionRequest {
  codigo: string;
  descuentoPorcentaje: number;
  fechaInicio: string;
  fechaFin: string;
  maximoUsos: number;
}
