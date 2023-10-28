import { Link } from "react-router-dom";
import laundryshop from "../assets/images/laundryshop.jpeg";

export default function Home() {
  return (
    <>
      <div
        className="bg-cover w-full h-screen flex gap-10 flex-col justify-center items-center pb-[200px]"
        style={{
          backgroundImage: `linear-gradient(rgba(255, 255, 255, 0.5), rgba(255, 255, 255, 0.5)), url(${laundryshop})`,
        }}
      >
        <h1 className="md:text-8xl sm:text-6xl text-6xl font-serif font-bold text-black">
          WashIT
        </h1>
        <Link to="/washery">
          <button className="font-serif text-black font-semibold text-xl bg-red-300 h-[50px] w-[200px] rounded-l-full rounded-r-full border-b-4 border-red-500 hover:translate-y-[2px] hover:border-none">
            Find a machine
          </button>
        </Link>
      </div>
    </>
  );
}
