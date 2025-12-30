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
('12126990', 'ACTIVE', 5),
('56020', 'ACTIVE', 6),
('7501', 'SUSPENDED', 7),
('989090', 'ACTIVE', 8),
('43045', 'ACTIVE', 9),
('210210', 'ACTIVE', 10);

INSERT INTO JAATM_ADDRESS
(STREET_NUMBER, STREET_NAME, TOWN, CITY, PROVINCE, POSTAL_CODE, JAATM_USER_ID)
VALUES
('12', 'Main Street', 'Central', 'Johannesburg', 'Gauteng', '2001', 1),
('45', 'Oak Avenue', 'Northside', 'Pretoria', 'Gauteng', '0002', 2),
('78', 'Pine Road', 'West End', 'Cape Town', 'Western Cape', '8001', 3),
('9',  'Maple Lane', 'Eastwood', 'Durban', 'KwaZulu-Natal', '4001', 4),
('101','Cedar Boulevard', 'Riverside', 'Bloemfontein', 'Free State', '9301', 5),
('33', 'Elm Street', 'Greenfield', 'Polokwane', 'Limpopo', '0700', 6),
('56', 'Birch Way', 'Hillcrest', 'Nelspruit', 'Mpumalanga', '1200', 7),
('88', 'Willow Drive', 'Lakeside', 'East London', 'Eastern Cape', '5201', 8),
('14', 'Spruce Court', 'Midtown', 'Kimberley', 'Northern Cape', '8301', 9),
('67', 'Poplar Crescent', 'South Park', 'Mahikeng', 'North West', '2745', 10);
