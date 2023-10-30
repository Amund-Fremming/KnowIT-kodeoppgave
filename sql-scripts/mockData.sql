-- Inserting mock data into washingprogram
INSERT INTO washingprogram (washtype, temperature, minutes)
VALUES ('KOKVASK', 60, 90),
       ('TOYVASK', 40, 60),
       ('HANDVASK', 30, 20);

-- Inserting mock data into washingmachine
INSERT INTO washingmachine (status, userOfMachine, washingprogramid)
VALUES ('AVAILABLE', NULL, NULL),
       ('AVAILABLE', NULL, NULL),
       ('AVAILABLE', NULL, NULL),
       ('AVAILABLE', NULL, NULL),
       ('AVAILABLE', NULL, NULL),
       ('AVAILABLE', NULL, NULL),
       ('AVAILABLE', NULL, NULL),
       ('AVAILABLE', NULL, NULL),
       ('AVAILABLE', NULL, NULL),
       ('AVAILABLE', NULL, NULL),
       ('IN_USE', 'alice', 1),
       ('IN_USE', 'bob', 2);
    

-- Inserting mock data into waitentry
INSERT INTO waitentry (username, timeadded, washingprogramid)
VALUES ('carol', CURRENT_TIMESTAMP, 1),
       ('dave', CURRENT_TIMESTAMP, 2);

-- Inserting mock data into reservation
INSERT INTO reservation (username, status, starttime, endtime, washingmachineid)
VALUES ('alice', 'PENDING', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP + interval '1 hour', 3),
       ('bob', 'PENDING', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP + interval '1 hour', 5);

