--liquibase formatted sql
--changeset dpetuhov:test_insert_cars

INSERT INTO people VALUES ('550e8400-e29b-41d4-a716-446655440000', 170, 80, 'Black');
INSERT INTO people VALUES ('550e8400-e29b-41d4-a716-446655440003', 180, 60, 'White');
INSERT INTO cars VALUES ('550e8400-e29b-41d4-a716-446655440001', 'Toyota', 'Camry', 'Yellow', '550e8400-e29b-41d4-a716-446655440000');
INSERT INTO cars VALUES ('550e8400-e29b-41d4-a716-446655440002', 'Honda', 'Accord', 'Black', '550e8400-e29b-41d4-a716-446655440003')

--rollback DELETE FROM cars; DELETE FROM people;