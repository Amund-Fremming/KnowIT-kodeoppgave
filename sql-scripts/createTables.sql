DROP TABLE IF EXISTS washingmachine CASCADE;
DROP TABLE IF EXISTS washingprogram CASCADE;
DROP TABLE IF EXISTS waitentry CASCADE;
DROP TABLE IF EXISTS reservation CASCADE;

CREATE TABLE washingprogram
(
    washingprogramid SERIAL PRIMARY KEY,
    washtype VARCHAR NOT NULL,
    temperature INTEGER NOT NULL,
    minutes INTEGER NOT NULL
);

CREATE TABLE washingmachine
(
    washingmachineid SERIAL PRIMARY KEY,
    status VARCHAR NOT NULL,
    userOfMachine VARCHAR,
    washingprogramid INTEGER REFERENCES washingprogram(washingprogramid)
);

CREATE TABLE waitentry
(
    waitentryid SERIAL PRIMARY KEY,
    username VARCHAR NOT NULL,
    timeadded TIMESTAMP NOT NULL,
    washingprogramid INTEGER REFERENCES washingprogram(washingprogramid)
);

CREATE TABLE reservation
(
    reservationid SERIAL PRIMARY KEY,
    username VARCHAR NOT NULL UNIQUE,
    status VARCHAR NOT NULL,
    starttime TIMESTAMP NOT NULL,
    endtime TIMESTAMP NOT NULL,
    washingmachineid INTEGER REFERENCES washingmachine(washingmachineid) ON DELETE CASCADE
);
