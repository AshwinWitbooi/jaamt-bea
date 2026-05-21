-- =========================
-- JAATM_USER DATA (10 rows)
-- =========================
INSERT INTO JAATM_USER (JUID, FIRSTNAME, LASTNAME, DOB) VALUES
('JUID0001', 'John', 'Doe',DATE '1993-11-01'),
('JUID0002', 'Jane', 'Smith',DATE '1973-03-12'),
('JUID0003', 'Michael', 'Brown',DATE '1993-12-13'),
('JUID0004', 'Emily', 'Johnson',DATE '1963-01-01'),
('JUID0005', 'David', 'Wilson',DATE '1969-04-01'),
('JUID0006', 'Sarah', 'Miller',DATE '1989-09-17'),
('JUID0007', 'Daniel', 'Taylor',DATE '1996-08-06'),
('JUID0008', 'Laura', 'Anderson',DATE '1998-09-18'),
('JUID0009', 'Robert', 'Thomas',DATE '1954-05-01'),
('JUID0010', 'Olivia', 'Jackson',DATE '1968-11-02');

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

INSERT INTO jaatm_transaction (juid, transaction_type, amount, transaction_date, status) VALUES
('JUID0001', 'DEPOSIT', '550000', '2026-05-01', 'SUCCESS'),
('JUID0001', 'WITHDRAWAL', '20000', '2026-05-02', 'SUCCESS'),
('JUID0002', 'TRANSFER', '125050', '2026-05-03', 'PENDING'),
('JUID0003', 'DEPOSIT', '1000000', '2026-05-04', 'SUCCESS'),
('JUID0001', 'PAYMENT', '45025', '2026-05-05', 'FAILED'),
('JUID0004', 'WITHDRAWAL', '150000', '2026-05-06', 'SUCCESS'),
('JUID0002', 'DEPOSIT', '30000', '2026-05-07', 'SUCCESS'),
('JUID0001', 'TRANSFER', '120574501', '2026-05-08', 'SUCCESS'),
('JUID0005', 'PAYMENT', '8999', '2026-05-09', 'PENDING'),
('JUID0003', 'WITHDRAWAL', '5000', '2026-05-09', 'SUCCESS');
