INSERT INTO person.users (id, secret_key, created, updated,
                          first_name, last_name, verified_at, archived_at, status, filled, address_id) VALUES
('3cafd4a0-b739-4568-a421-3d4c31d990e6', 'user1MockSecretKey', NOW(), NOW(), 'Igor', 'Popovich', '2024-01-01 12:00:00', '2024-01-09 12:00:00', 'active', true, null),
('0580e1af-f4c8-4b41-930f-826334d906fd', 'user2MockSecretKey', NOW(), NOW(), 'John', 'Doe', '2024-02-01 12:00:00', '2024-02-10 12:00:00', 'active', true, null),
('3d94a840-697e-4cf2-8d83-335dc766a8d8', 'user3MockSecretKey', NOW(), NOW(), 'Alex', 'Ivanov', '2024-01-02 12:00:00', '2024-02-11 12:00:00', 'active', true, null);