/**
 * Mangler å ta inn parametere, og sette opp exceptions og feilhåndtering
 */

const URL_BASE = "";

export const getAllReservations = () => {
  try {
    console.log(URL_BASE);
  } catch (err) {
    console.error(err);
  }
};

export const createReservationNow = () => {
  try {
    console.log("HEY");
  } catch (err) {
    console.error(err);
  }
};

export const createReservationLater = () => {
  try {
    console.log("HEY");
  } catch (err) {
    console.error(err);
  }
};

export const deleteReservationLater = () => {
  try {
    console.log("HEY");
  } catch (err) {
    console.error(err);
  }
};
