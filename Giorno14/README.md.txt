-- Creazione tabella utenti personalizzata
CREATE TABLE utente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    attivo TINYINT(1) NOT NULL DEFAULT 1
);

-- Creazione tabella ruoli personalizzata
CREATE TABLE ruolo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    ruolo VARCHAR(50) NOT NULL,
    FOREIGN KEY (username) REFERENCES utente(username)
);