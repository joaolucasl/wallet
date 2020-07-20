CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE persons (
    id uuid DEFAULT uuid_generate_v4() PRIMARY KEY,
    legalName VARCHAR,
    displayName VARCHAR,
    motherName VARCHAR,
    birthDate DATE,
    registrationId VARCHAR(11),
    created_at timestamp NOT NULL DEFAULT current_timestamp,
    updated_at timestamp NOT NULL DEFAULT current_timestamp
);

CREATE TABLE addresses (
    id uuid DEFAULT uuid_generate_v4() PRIMARY KEY,
    street VARCHAR(70),
    number VARCHAR(6),
    complement VARCHAR,
    neighborhood VARCHAR,
    city VARCHAR,
    person_id uuid,
    created_at timestamp NOT NULL DEFAULT current_timestamp,
    updated_at timestamp NOT NULL DEFAULT current_timestamp,
    CONSTRAINT fk_person
        FOREIGN KEY(person_id)
        REFERENCES persons(id)
        ON DELETE CASCADE
);

CREATE TABLE ledger_accounts (
    id uuid DEFAULT uuid_generate_v4() PRIMARY KEY,
    name VARCHAR,
    type ledger_account_type,
    description TEXT,
    created_at timestamp NOT NULL DEFAULT current_timestamp,
    updated_at timestamp NOT NULL DEFAULT current_timestamp
);