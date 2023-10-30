const URL_BASE = "http://localhost:8080/api/reservation";

export const getAllReservations = async () => {
  try {
    const response = await fetch(URL_BASE + "/reservations", {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
      },
    });

    if (!response.ok) {
      throw new Error(`HTTP errer! Status: ${response.status}}`);
    }

    const data = await response.json();
    console.log(data);
    return data;
  } catch (err) {
    console.error(err);
  }
};

export const createReservation = async (
  programId: number,
  machineId: number,
  username: string,
  starttime: Date
) => {
  try {
    const response = await fetch(URL_BASE + "/create", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        programId: programId,
        machineId: machineId,
        username: username,
        starttime: starttime.toISOString(),
      }),
    });

    if (!response.ok) {
      throw new Error(`HTTP error! Status: ${response.status}`);
    }

    const data = await response.json();
    console.log(data);
    return data;
  } catch (err) {
    console.error(err);
  }
};

export const cancelReservation = async (reservationId: number) => {
  try {
    const response = await fetch(URL_BASE + `/delete/${reservationId}`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
    });

    if (!response.ok) {
      throw new Error(`HTTP error! Status: ${response.status}`);
    }

    const data = await response.json();
    console.log(data);
    return data;
  } catch (err) {
    console.error(err);
  }
};

export const getAvailableTimes = async () => {
  try {
    const response = await fetch(URL_BASE + `/delete/${reservationId}`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
    });

    if (!response.ok) {
      throw new Error(`HTTP error! Status: ${response.status}`);
    }

    const data = await response.json();
    console.log(data);
    return data;
  } catch (err) {
    console.error(err);
  }
};
