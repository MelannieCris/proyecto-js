import { BrowserRouter, Route, Routes } from "react-router";
import Inicio from "../../modules/home/pages/Inicio";
import PaginaNoEncontrada from "../../modules/home/pages/PaginaNoEncontrada";
import Informacion from "../../modules/home/pages/Informacion";
import Login from "../../modules/auth/pages/Login";
import Registro from "../../modules/auth/pages/Registro";
import Compras from "../../modules/compras/pages/Compras";
import VerBoletos from "../../modules/compras/pages/VerBoletos";

export default function Router() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Inicio />} />
        <Route path="/informacion" element={<Informacion />} />
        <Route path="/login" element={<Login />} />
        <Route path="/registro" element={<Registro />} />
        <Route path="/compras" element={<Compras />} />
        <Route path="/ver-boletos" element={<VerBoletos />} />
        <Route path="*" element={<PaginaNoEncontrada />} />
      </Routes>
    </BrowserRouter>
  );
}
