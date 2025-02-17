--liquibase formatted sql
--changeset dpetuhov:20250214_create_people_table
CREATE TABLE IF NOT EXISTS people
    (
        id UUID PRIMARY KEY,
        height INTEGER NOT NULL,
        weight INTEGER NOT NULL,
        hair_color VARCHAR(15) NOT NULL
    )

--rollback DROP IF EXISTS TABLE people;

--changeset dpetuhov:20250214_comment_people_table runOnChange: true
COMMENT ON TABLE people IS 'Contains person information';
COMMENT ON COLUMN people.id IS 'Contains unique id of person';
COMMENT ON COLUMN people.height IS 'Contains person height';
COMMENT ON COLUMN people.weight IS 'Contains person weight';
COMMENT ON COLUMN people.hair_color IS 'Contains persons hair color';