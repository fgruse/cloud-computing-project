DROP TABLE IF EXISTS flugstatus;
CREATE TABLE flugstatus
(
    id INTEGER PRIMARY KEY auto_increment,
    flugnummer VARCHAR(64),
    airline VARCHAR(64),
    von VARCHAR(64),
    nach VARCHAR(64),
    flugdatum DATE,
    uhrzeit TIME
);
