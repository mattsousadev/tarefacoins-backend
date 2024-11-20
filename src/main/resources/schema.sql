CREATE TABLE IF NOT EXISTS users (
    id CHARACTER(36) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    is_active BOOLEAN NOT NULL,
    serial_number INTEGER NOT NULL,
    birth_date DATE NOT NULL,
    id_files CHARACTER(36) NULL,
    created_at TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NULL 
);

CREATE TABLE IF NOT EXISTS files (
    id CHARACTER(36) PRIMARY KEY,
    filename VARCHAR(255) NOT NULL,
    size_bytes INTEGER NOT NULL,
    content blob NULL,
    created_at TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NULL 
);
