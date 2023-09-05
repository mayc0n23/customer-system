CREATE TABLE IF NOT EXISTS phone_entity (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    code VARCHAR(255) NOT NULL,
    phone_number VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS customer_entity (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    type VARCHAR(255) NOT NULL,
    full_name VARCHAR(255) NOT NULL,
    main_document VARCHAR(255) NOT NULL UNIQUE,
    secondary_document VARCHAR(255),
    registration_date TIMESTAMP NOT NULL,
    active BOOLEAN NOT NULL
);

CREATE TABLE IF NOT EXISTS customer_entity_phones (
    customer_entity_id BIGINT NOT NULL,
    phones_id BIGINT NOT NULL,
    PRIMARY KEY (customer_entity_id, phones_id),
    CONSTRAINT FK_customer_entity_phones_customer_entity FOREIGN KEY (customer_entity_id) REFERENCES customer_entity (id),
    CONSTRAINT FK_customer_entity_phones_phones FOREIGN KEY (phones_id) REFERENCES phone_entity (id)
);