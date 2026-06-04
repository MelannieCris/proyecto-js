import { BrowserRouter, Route, Routes } from "react-router";
import Inicio from "../../modules/home/pages/Inicio";
import PaginaNoEncontrada from "../../modules/home/pages/PaginaNoEncontrada";
import Informacion from "../../modules/home/pages/Informacion";
import Login from "../../modules/login/pages/Login";

export default function Router() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Inicio />} />
        <Route path="*" element={<PaginaNoEncontrada />} />
        <Route path="/informacion" element={<Informacion />} />
        <Route path="/login" element={<Login />} />
      </Routes>
    </BrowserRouter>
  );
}
