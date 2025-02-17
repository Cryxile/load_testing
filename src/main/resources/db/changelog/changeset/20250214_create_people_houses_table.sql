--liquibase formatted sql
--changeset dpetuhov:20250214_create_people_houses_table
CREATE TABLE IF NOT EXISTS people_houses
    (
        owner_id UUID REFERENCES people (id),
        house_id UUID REFERENCES houses (id)
    )

--rollback DROP IF EXISTS TABLE people_houses;

--changeset dpetuhov:20250214_comment_people_houses_table runOnChange: true
COMMENT ON TABLE people_houses IS 'Contains list of people that own the house';
COMMENT ON COLUMN people_houses.owner_id IS 'Contains an id of person';
COMMENT ON COLUMN people_houses.house_id IS 'Contains an id of house'
