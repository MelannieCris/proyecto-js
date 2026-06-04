import { BrowserRouter, Route, Routes } from "react-router";
import Inicio from "../../modules/home/pages/Inicio";
import PaginaNoEncontrada from "../../modules/home/pages/PaginaNoEncontrada";
import Informacion from "../../modules/home/pages/Informacion";
import Login from "../../modules/auth/pages/Login";
import Registro from "../../modules/auth/pages/Registro";

export default function Router() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Inicio />} />
        <Route path="/informacion" element={<Informacion />} />
        <Route path="/login" element={<Login />} />
        <Route path="/registro" element={<Registro />} />
        <Route path="*" element={<PaginaNoEncontrada />} />
      </Routes>
    </BrowserRouter>
  );
}
