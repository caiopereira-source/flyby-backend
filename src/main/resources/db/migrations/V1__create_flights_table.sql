-- Create table for flights
CREATE TABLE flights (
    id BIGSERIAL PRIMARY KEY,
    departure VARCHAR(128) NOT NULL,
    destination VARCHAR(128) NOT NULL,
    airport VARCHAR(128) NOT NULL
);
