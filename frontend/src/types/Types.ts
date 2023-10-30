// ENUMS

export enum WashingMachineStatus {
  AVAILABLE = "AVAILABLE",
  IN_USE = "IN_USE",
  MAINTENANCE = "MAINTENANCE",
}

export type WashType = "KOKVASK" | "TOYVASK" | "HANDVASK";

export type ReservationStatus =
  | "PENDING"
  | "IN_PROGRESS"
  | "COMPLETED"
  | "CANCELLED";

// INTERFACES

export interface IWashingProgram {
  washingprogramid: number;
  washtype: WashType;
  temperature: number;
  minutes: number;
  washingMachines?: IWashingMachine[];
  waitEntries?: IWaitEntry[];
}

export interface IWaitEntry {
  waitentryid: number;
  washingProgram?: IWashingProgram;
  username: string;
  timeadded: Date;
}

export interface IReservation {
  reservationid: number;
  washingMachine?: IWashingMachine;
  username: string;
  status: ReservationStatus;
  starttime: Date;
  endtime: Date;
}

export interface IWashingMachine {
  washingmachineid: number;
  status: WashingMachineStatus;
  userofmachine?: string;
  washingProgram?: IWashingProgram;
  reservations?: IReservation[];
}
