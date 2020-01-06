CREATE TABLE flugstatus (
  id           BIGINT PRIMARY KEY AUTO_INCREMENT,
  Flugnummer   INTEGER (255) NOT NULL,
  Airline      VARCHAR (255) NOT NULL,
  von          VARCHAR (255) NOT NULL,
  nach         VARCHAR (255) NOT NULL,
  Flugdatum    DATE,
  Uhrzeit      TIME
);
