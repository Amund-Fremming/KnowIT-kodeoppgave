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

export const removeEntry = () => {
  try {
    console.log("HEY");
  } catch (err) {
    console.error(err);
  }
};

export const addEntry = () => {
  try {
    console.log("HEY");
  } catch (err) {
    console.error(err);
  }
};
