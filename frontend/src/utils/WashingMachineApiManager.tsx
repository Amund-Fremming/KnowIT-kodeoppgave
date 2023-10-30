const URL_BASE = "http://localhost:8080/api/machine";

export const getAllWashingMachines = async () => {
  try {
    const response = await fetch(URL_BASE + "/washingmachines", {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
      },
    });

    if (!response.ok) {
      throw new Error(`HTTP error! Status: ${response.status}}`);
    }

    const data = await response.json();
    console.log(data);
    return data;
  } catch (err) {
    console.error(err);
  }
};

export const getUpdatedMachines = async () => {
  try {
    const response = await fetch(URL_BASE + "/updatedmachines", {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
      },
    });

    if (!response.ok) {
      throw new Error(`HTTP error! Status: ${response.status}}`);
    }

    const data = await response.json();
    console.log(data);
    return data;
  } catch (err) {
    console.error(err);
  }
};
