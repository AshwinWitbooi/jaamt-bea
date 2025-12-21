-- =========================
-- JAATM_USER DATA (10 rows)
-- =========================
INSERT INTO JAATM_USER (JUID, FIRSTNAME, LASTNAME) VALUES
('JAATM-U001', 'John', 'Doe'),
('JAATM-U002', 'Jane', 'Smith'),
('JAATM-U003', 'Michael', 'Brown'),
('JAATM-U004', 'Emily', 'Johnson'),
('JAATM-U005', 'David', 'Wilson'),
('JAATM-U006', 'Sarah', 'Miller'),
('JAATM-U007', 'Daniel', 'Taylor'),
('JAATM-U008', 'Laura', 'Anderson'),
('JAATM-U009', 'Robert', 'Thomas'),
('JAATM-U010', 'Olivia', 'Jackson');

-- =========================
-- JAATM_ACCOUNT DATA (10 rows)
-- =========================
INSERT INTO JAATM_ACCOUNT (BALANCE, STATUS, JAATM_USER_ID) VALUES
('1500.00', 'ACTIVE', 1),
('3200.50', 'ACTIVE', 2),
('0.00', 'SUSPENDED', 3),
('845.75', 'ACTIVE', 4),
('12000.00', 'ACTIVE', 5),
('560.20', 'ACTIVE', 6),
('75.00', 'SUSPENDED', 7),
('9800.90', 'ACTIVE', 8),
('430.00', 'ACTIVE', 9),
('2100.10', 'ACTIVE', 10);
