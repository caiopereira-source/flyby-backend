-- Create table for passengers
CREATE TABLE passenger (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(128) NOT NULL,
    cpf BIGINT NOT NULL CHECK (char_length(cpf::text) = 11),
    phone_number BIGINT NOT NULL CHECK (char_length(phone_number::text) = 13),
    flight_id BIGINT REFERENCES flights (id)
);
