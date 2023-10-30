const URL_BASE = "http://localhost:8080/api/waitlist";

export const addToWaitlist = async (username: string, programid: number) => {
  try {
    const response = await fetch(URL_BASE + `/add/${username}/${programid}`, {
      method: "POST",
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
