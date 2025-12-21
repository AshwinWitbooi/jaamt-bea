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
('150000', 'ACTIVE', 1),
('320050', 'ACTIVE', 2),
('0', 'SUSPENDED', 3),
('84575', 'ACTIVE', 4),
('1200000', 'ACTIVE', 5),
('56020', 'ACTIVE', 6),
('7500', 'SUSPENDED', 7),
('980090', 'ACTIVE', 8),
('43000', 'ACTIVE', 9),
('210010', 'ACTIVE', 10);
