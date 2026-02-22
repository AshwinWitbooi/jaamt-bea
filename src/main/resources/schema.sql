CREATE TABLE jaatm_user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    juid VARCHAR(50) NOT NULL,
    firstname VARCHAR(100) NOT NULL,
    lastname VARCHAR(100) NOT NULL,
    dob DATE NOT NULL,

    CONSTRAINT uk_jaatm_juid UNIQUE (juid)
);

CREATE TABLE jaatm_account (
    id BIGINT  AUTO_INCREMENT PRIMARY KEY,
    balance VARCHAR(50),
    status VARCHAR(20),
    jaatm_user_id BIGINT NOT NULL,

    CONSTRAINT fk_user_account
        FOREIGN KEY (jaatm_user_id)
        REFERENCES JAATM_USER(id)
        ON DELETE CASCADE
);

CREATE TABLE jaatm_address (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    street_number VARCHAR(20),
    street_name VARCHAR(150),
    town VARCHAR(100),
    city VARCHAR(100),
    province VARCHAR(100),
    postal_code VARCHAR(20),
    jaatm_user_id BIGINT NOT NULL,

    CONSTRAINT fk_address_user
        FOREIGN KEY (jaatm_user_id)
        REFERENCES JAATM_USER(id)
        ON DELETE CASCADE
);


