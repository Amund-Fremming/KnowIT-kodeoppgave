import wall from "../assets/images/wall.jpeg";
import WashingMachine from "../components/WashingMachine";

export default function Washery() {
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
          <div className="h-[200px]" />
          <div className="gap-[100px] flex flex-wrap items-center justify-center w-[80%]">
            {[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12].map((num) => (
              <WashingMachine
                key={num}
                id={num}
                available={true}
                user={"user"}
              />
            ))}
          </div>
        </div>
      </div>
    </>
  );
}
