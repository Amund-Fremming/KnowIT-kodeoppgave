interface IWashingMachine {
  id: number;
  available: boolean;
  user: string;
}

export default function WashingMachine({
  id,
  available,
  user,
}: IWashingMachine) {
  return (
    <>
      <div className="flex flex-col justify-center items-center">
        <h1 className="font-serif font-semibold text-md">User: {user}</h1>
        <div className="h-[160px] w-[120px] flex flex-col">
          <div
            className={`w-full h-[35px] rounded-t-2xl border-4 border-black flex justify-center items-center gap-x-1 ${
              available ? "bg-green-300" : "bg-red-300"
            }`}
          >
            <div className="border-4 border-black rounded-full w-[15px] h-[15px]"></div>
            <div className="border-2 border-black rounded-full w-[10px] h-[10px]"></div>
            <div className="border-2 border-black rounded-full w-[10px] h-[10px]"></div>
            <div className="border-2 border-black rounded-full w-[10px] h-[10px]"></div>
            <div className="border-4 border-black rounded-2xl w-[30px] h-[17.5px]"></div>
          </div>
          <div
            className={`flex flex-col border-l-4 border-r-4 border-b-4 border-black rounded-b-2xl mt-[7.5px] h-full ${
              available ? "bg-green-300" : "bg-red-300"
            }`}
          >
            <div className="w-full border-t-4 border-black h-[90px] flex justify-center items-center">
              <div className="border-4 border-black rounded-full h-[72.5px] w-[72.5px] flex justify-center items-center">
                <div className="border-2 border-black rounded-full h-[60px] w-[60px] flex justify-center items-center">
                  <h1 className="font-serif text-2xl">{id}</h1>
                </div>
              </div>
            </div>
            <div className="w-full border-t-4 border-black"></div>
          </div>
        </div>
      </div>
    </>
  );
}
