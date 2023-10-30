/**
 * Mangler å ta inn parametere, og sette opp exceptions og feilhåndtering
 */

const URL_BASE = "http://localhost:8080/api/waitlist";

export const getWaitlist = () => {
  try {
    console.log(URL_BASE);
  } catch (err) {
    console.error(err);
  }
};

export const addToWaitlist = async (username: string) => {
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
