import { createReservation } from "../utils/ReservationApiManager";
import { Link } from "react-router-dom";

import wall from "../assets/images/wall.jpeg";
import { useState } from "react";

export default function Reservation() {
  const [programId, setProgramId] = useState(0);
  const [machineId, setMachineId] = useState(0);
  const [username, setUsername] = useState("");
  const [startTime, setStartTime] = useState<Date>(new Date());

  const handleCreate = () => {
    createReservation(programId, machineId, username, startTime);
  };

  return (
    <>
      <div
        className="bg-cover w-full h-screen flex gap-10 flex-col items-center pb-[200px]"
        style={{
          backgroundImage: `linear-gradient(rgba(255, 255, 255, 0.5), rgba(255, 255, 255, 0.5)), url(${wall})`,
        }}
      >
        <div className="pt-8 w-full flex flex-col items-center">
          <h1 className="md:text-6xl sm:text-5xl text-5xl font-serif font-bold text-black">
            WashIT
          </h1>
          <div className="flex flex-col mt-8 justify-center items-center">
            <input />
            <input
              className="m-4 rounded-xl h-10 text-center text-xl"
              placeholder="Username"
              onChange={(e) => setUsername(e.target.value)}
            />
            <input />
            <button
              className="w-[120px] mt-[20px] h-[40px] border-b-4 border-red-500 hover:border-none hover:translate-y-[2px] bg-red-300 rounded-l-full rounded-r-full"
              onClick={handleCreate}
            >
              Create
            </button>
            <button className="w-[120px] mt-[10px] h-[40px] border-b-4 border-red-500 hover:border-none hover:translate-y-[2px] bg-red-300 rounded-l-full rounded-r-full">
              <Link to="/washery">Back</Link>
            </button>
          </div>
        </div>
      </div>
    </>
  );
}
