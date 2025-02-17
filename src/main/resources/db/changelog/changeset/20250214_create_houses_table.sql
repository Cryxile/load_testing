--liquibase formatted sql
--changeset dpetuhov:20250214_create_houses_table
CREATE TABLE IF NOT EXISTS houses
    (
        id UUID PRIMARY KEY,
        wall_material VARCHAR(9) NOT NULL,
        build_date DATE NOT NULL CONSTRAINT houses_build_date_chk CHECK (build_date < CURRENT_DATE),
        has_gas_supply BOOL NOT NULL,
        address_id UUID REFERENCES addresses (id)
    )

--rollback DROP IF EXISTS TABLE houses;

--changeset dpetuhov:20250214_comment_houses_table runOnChange: true
COMMENT ON TABLE houses IS 'Contains houses';
COMMENT ON COLUMN houses.id IS 'Contains unique id of house';
COMMENT ON COLUMN houses.wall_material IS 'Contains house wall material';
COMMENT ON COLUMN houses.build_date IS 'Contains house date of build';
COMMENT ON COLUMN houses.has_gas_supply IS 'Contains info about house gas supply';
COMMENT ON COLUMN houses.address_id IS 'Contains an id of address of house'