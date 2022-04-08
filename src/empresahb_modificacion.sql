USE empresahb;

CREATE TABLE IF NOT EXISTS telefono (
    NumTelefono INT NOT NULL,
    NSS VARCHAR(15) NOT NULL,
    CONSTRAINT PK_Telefono PRIMARY KEY (NSS , NumTelefono),
    CONSTRAINT FK_Empregado_Telefono FOREIGN KEY (NSS)
        REFERENCES empregado (NSS)
);

ALTER TABLE telefono ADD COLUMN Descricion VARCHAR(25);

ALTER TABLE telefono ADD CONSTRAINT U_Telefono UNIQUE (NumTelefono);

CREATE TABLE IF NOT EXISTS horas (
    Id INT NOT NULL AUTO_INCREMENT,
    NSS VARCHAR(15) NOT NULL,
    Horas INT NOT NULL,
    Fecha DATE NOT NULL,
    CONSTRAINT PK_Horas PRIMARY KEY (Id),
    CONSTRAINT FK_Empregado_Horas FOREIGN KEY (NSS)
        REFERENCES empregado (NSS)
);

CREATE TABLE IF NOT EXISTS domicilio (
    NSS VARCHAR(15),
    calle VARCHAR(30),
    numero INTEGER,
    piso VARCHAR(10),
    codigoPostal VARCHAR(5),
    localidad VARCHAR(30),
    provincia VARCHAR(20),
    CONSTRAINT PK_Domicilio PRIMARY KEY (NSS),
    CONSTRAINT FK_Empregado_Domicilio FOREIGN KEY (NSS)
        REFERENCES empregado (NSS)
);