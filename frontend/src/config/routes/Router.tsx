import { BrowserRouter, Route, Routes } from "react-router";
import Inicio from "../../modules/home/pages/Inicio";

export default function Router() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Inicio />} />
      </Routes>
    </BrowserRouter>
  );
}
