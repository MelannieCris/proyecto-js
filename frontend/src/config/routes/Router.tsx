import { BrowserRouter, Route, Routes } from "react-router";
import Inicio from "../../modules/home/pages/Inicio";
import Cargando from "../../modules/home/pages/cargando";
import PaginaNoEncontrada from "../../modules/home/pages/PaginaNoEncontrada";

export default function Router() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Inicio />} />
        <Route path="/cargando" element={<Cargando />} />
        <Route path="*" element={<PaginaNoEncontrada />} />
      </Routes>
    </BrowserRouter>
  );
}
