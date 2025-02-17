--liquibase formatted sql
--changeset dpetuhov:20250214_create_passports_table
CREATE TABLE IF NOT EXISTS passports
    (
        id UUID PRIMARY KEY,
        first_name VARCHAR(15) NOT NULL,
        last_name VARCHAR(15) NOT NULL,
        birth_date date NOT NULL CONSTRAINT passports_birth_date_chk CHECK (birth_date < CURRENT_DATE),
        gender VARCHAR(6) NOT NULL,
        owner_id UUID REFERENCES people (id),
        address_id UUID REFERENCES addresses (id)
    )

--rollback DROP IF EXISTS TABLE passports;

--changeset dpetuhov:20250214_comment_passports_table runOnChange: true
COMMENT ON TABLE passports IS 'Contains people passports';
COMMENT ON COLUMN passports.id IS 'Contains unique id of passport';
COMMENT ON COLUMN passports.first_name IS 'Contains person first name';
COMMENT ON COLUMN passports.last_name IS 'Contains person last name';
COMMENT ON COLUMN passports.birth_date IS 'Contains person birth date';
COMMENT ON COLUMN passports.gender IS 'Contains person gender';
COMMENT ON COLUMN passports.owner_id IS 'Contains id of passport owner';
COMMENT ON COLUMN passports.address_id IS 'Contains persons living address'