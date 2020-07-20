CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE person (
    id uuid DEFAULT uuid_generate_v4() PRIMARY KEY,
    legalName VARCHAR,
    motherName VARCHAR,
    birthDate DATE,
    registrationId VARCHAR(11),
    displayName VARCHAR
);

CREATE TABLE address (
    id uuid DEFAULT uuid_generate_v4() PRIMARY KEY,
    street VARCHAR(70),
    number VARCHAR(6),
    complement VARCHAR,
    neighborhood VARCHAR,
    city VARCHAR,
    person_id uuid,
    CONSTRAINT fk_person
    FOREIGN KEY(person_id)
    REFERENCES person(id)
    ON DELETE CASCADE
);

CREATE TYPE ledger_account_type AS ENUM ('Asset', 'Liability', 'Equity', 'Revenue', 'Expense');

CREATE TABLE ledger_account(
    id uuid DEFAULT uuid_generate_v4() PRIMARY KEY,
    name VARCHAR,
    type ledger_account_type,
    description TEXT
);