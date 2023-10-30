import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Home from "./pages/Home";
import Washery from "./pages/Washery";
import Reservation from "./pages/Reservation";
import CancelReservation from "./pages/CancelReservation";
import Waitlist from "./pages/Waitlist";

export default function App() {
  return (
    <>
      <Router>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/washery" element={<Washery />} />
          <Route path="/reservation" element={<Reservation />} />
          <Route path="/cancelreservation" element={<CancelReservation />} />
          <Route path="/waitlist" element={<Waitlist />} />
        </Routes>
      </Router>
    </>
  );
}
