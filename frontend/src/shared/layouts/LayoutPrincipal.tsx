import Footer from "../components/Footer";
import Navbar from "../components/Navbar";

interface IProps {
  children: React.ReactNode;
}

export default function LayoutPrincipal({ children }: IProps) {
  return (
    <>
      <Navbar />

      {children}

      <Footer />
    </>
  );
}
