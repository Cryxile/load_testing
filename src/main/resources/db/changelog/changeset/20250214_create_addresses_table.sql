--liquibase formatted sql
--changeset dpetuhov:20250214_create_addresses_table
CREATE TABLE IF NOT EXISTS addresses
    (
        id UUID PRIMARY KEY,
        city VARCHAR(100) NOT NULL,
        street VARCHAR(150) NOT NULL,
        house_number VARCHAR(6) NOT NULL
    )

--rollback DROP IF EXISTS TABLE addresses;

--changeset dpetuhov:20250214_comment_addresses_table runOnChange: true
COMMENT ON TABLE addresses IS 'Contains addresses for passports and houses';
COMMENT ON COLUMN addresses.id IS 'Contains unique id of address';
COMMENT ON COLUMN addresses.city IS 'Contains city name';
COMMENT ON COLUMN addresses.street IS 'Contains streets name';
COMMENT ON COLUMN addresses.house_number IS 'Contains house number'