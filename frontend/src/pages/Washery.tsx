import { useEffect, useState } from "react";

import wall from "../assets/images/wall.jpeg";
import WashingMachine from "../components/WashingMachine";

import { getUpdatedMachines } from "../utils/WashingMachineApiManager";

import { IWashingMachine, WashingMachineStatus } from "../types/Types";
import { Link } from "react-router-dom";

export default function Washery() {
  useEffect(() => {
    const fetchData = async () => {
      const data = await getUpdatedMachines();
      setWashingMachines(data);
    };

    fetchData();
  }, []);

  useEffect(() => {
    const fetchData = async () => {
      const data = await getUpdatedMachines();
      setWashingMachines(data);
    };

    const now = new Date();
    const timeUntilNextMinute = 60 - now.getSeconds();

    const timeoutId = setTimeout(() => {
      fetchData();

      setInterval(fetchData, 60000);
    }, timeUntilNextMinute * 1000);

    return () => {
      clearTimeout(timeoutId);
    };
  }, []);

  const [washingMachines, setWashingMachines] = useState<
    IWashingMachine[] | null
  >();

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
          <div className="flex gap-8 mt-10 mb-10">
            <button className="w-[160px] bg-red-300 h-[40px] rounded-l-full rounded-r-full font-serif text-black border-b-4 border-red-500 hover:tranlate-y-2 hover:border-none">
              <Link to="/reservation">Make reservation</Link>
            </button>
            <button className="w-[160px] bg-red-300 h-[40px] rounded-l-full rounded-r-full font-serif text-black border-b-4 border-red-500 hover:tranlate-y-2 hover:border-none">
              <Link to="/cancelreservation">Cancel reservation</Link>
            </button>
            <button className="w-[160px] bg-red-300 h-[40px] rounded-l-full rounded-r-full font-serif text-black border-b-4 border-red-500 hover:tranlate-y-2 hover:border-none">
              <Link to="/waitlist">Join waitlist</Link>
            </button>
          </div>
          <div className="gap-[100px] flex flex-wrap items-center justify-center w-[80%]">
            {washingMachines &&
              washingMachines.map((machine) => (
                <WashingMachine
                  key={machine.washingmachineid}
                  id={machine.washingmachineid}
                  available={machine.status === WashingMachineStatus.AVAILABLE}
                  user={machine.userofmachine}
                />
              ))}
          </div>
        </div>
      </div>
    </>
  );
}
