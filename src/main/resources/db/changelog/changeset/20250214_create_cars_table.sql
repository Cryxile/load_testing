--liquibase formatted sql
--changeset dpetuhov:20250214_create_cars_table
CREATE TABLE IF NOT EXISTS cars
    (
        id UUID PRIMARY KEY,
        brand VARCHAR(9) NOT NULL,
        model VARCHAR(9) NOT NULL,
        color VARCHAR(15) NOT NULL,
        owner_id UUID REFERENCES people (id)
    )

--rollback DROP IF EXISTS TABLE cars;

--changeset dpetuhov:20250214_comment_cars_table runOnChange: true
COMMENT ON TABLE cars IS 'Contains people cars';
COMMENT ON COLUMN cars.id IS 'Contains unique id of car';
COMMENT ON COLUMN cars.brand IS 'Contains car brand';
COMMENT ON COLUMN cars.model IS 'Contains car model';
COMMENT ON COLUMN cars.color IS 'Contains car color';
COMMENT ON COLUMN cars.owner_id IS 'Contains an id of car owner'