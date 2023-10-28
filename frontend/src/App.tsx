import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Home from "./pages/Home";
import Washery from "./pages/Washery";

export default function App() {
  return (
    <>
      <Router>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/washery" element={<Washery />} />
        </Routes>
      </Router>
    </>
  );
}
