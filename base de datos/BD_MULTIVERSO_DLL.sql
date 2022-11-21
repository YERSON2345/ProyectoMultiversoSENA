CREATE DATABASE bd_multiverso;
USE bd_multiverso;

CREATE TABLE Rol
(
	idRol INT PRIMARY KEY,
    tipoRol VARCHAR(50) NOT NULL
);

CREATE TABLE Usuario
(
	nombreUsuario VARCHAR(100) NOT NULL,
    apellidoUsuario VARCHAR(100) NOT NULL,
    tipoDocUsuario VARCHAR(10) NOT NULL,
    correoUsuario VARCHAR(100) UNIQUE NOT NULL,
	noDocUsuario INT PRIMARY KEY,
    contrasenaUsuario VARCHAR(100) NOT NULL,
    estadoUsuario BOOLEAN,
	idRol INT NOT NULL,
    FOREIGN KEY idRol (idRol) REFERENCES Rol (idRol)
    
);

CREATE TABLE TipoProducto
(
	idTipoProducto INT PRIMARY KEY auto_increment,
    nombreTipoProducto VARCHAR(100),
    estadoTipoProducto BOOLEAN
);

CREATE TABLE Producto
(		
	idProducto INT PRIMARY KEY auto_increment,
    nombreProducto VARCHAR(100) UNIQUE NOT NULL,
    fechaVencimiento VARCHAR(20),
    observacionesProducto VARCHAR(100),
    cantidadProducto INT NOT NULL,
    estadoProducto BOOLEAN NOT NULL,
    precioProducto INT NOT NULL,
    idTipoProducto INT NOT NULL,
    FOREIGN KEY idTipoProducto (idTipoProducto) REFERENCES TipoProducto (idTipoProducto),
    noDocUsuario INT,
    FOREIGN KEY noDocUsuario (noDocUsuario) REFERENCES Usuario (noDocUsuario)
);

CREATE TABLE salidasProducto
(
	idSalida INT PRIMARY KEY AUTO_INCREMENT,
    cantidadSalidas INT NOT NULL,
    motivoSalidas VARCHAR(100),
    fechaSalidas TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    idProductoSalidas INT,
	FOREIGN KEY idProductoSalidas (idProductoSalidas) REFERENCES Producto (idProducto)
);


CREATE TABLE Proveedor
(
	idProveedor INT PRIMARY KEY auto_increment,
    nombreProveedor VARCHAR(100),
    empresaProveedor VARCHAR(100),
    estadoProveedor BOOLEAN
    
);

CREATE TABLE Cliente
(
    noDocCliente INT PRIMARY KEY,
    nombreCliente VARCHAR(100) NOT NULL,
    tipoDocCliente VARCHAR(50) NOT NULL,
    apellidoCliente VARCHAR(100) NOT NULL,
    telefonoCliente INT NOT NULL,
    correoCliente VARCHAR(100) NOT NULL,
    direccionDestinoVenta VARCHAR(50) NOT NULL,
    frecuenciaCliente BOOLEAN
);

CREATE TABLE Ventas
(
	idDetalleVenta INT PRIMARY KEY auto_increment, 
    cantidadVendida INT,
    precioTotal INT NOT NULL,
	idProductoFK INT,
    fechaSalidas TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY idProductoFK (idProductoFK) REFERENCES Producto (idProducto),
	noDocCliente INT,
    FOREIGN KEY noDocCliente (noDocCliente) REFERENCES Cliente (noDocCliente)
);

CREATE TABLE Compras
(
	idDetalleCompras INT PRIMARY KEY auto_increment,
    fechaCompra DATE,
    entradasCompras INT,
    precioProveedor INT,
    noOrdenCompra INT UNIQUE,
	idProducto INT,
	FOREIGN KEY idProducto (idProducto) REFERENCES Producto (idProducto),
	idProveedor INT,
	FOREIGN KEY idProveedor (idProveedor) REFERENCES Proveedor (idProveedor)
);

DROP DATABASE bd_multiverso;
SET SQL_SAFE_UPDATES = 0;

#--TRIGGER PARA ACTUALIZAR LA CANTIDAD (FALTA REVISAR)-------------------------------------------------------------

SELECT * FROM Compras;
drop database bd_multiverso;

DELIMITER $$
CREATE TRIGGER trgActualizarStock BEFORE INSERT ON Ventas
FOR EACH ROW
BEGIN
SET @stockAntiguo = (SELECT cantidadProducto FROM Producto WHERE idProducto = idProducto);
UPDATE Producto
SET cantidadProducto = @stockAntiguo - new.cantidadVendida WHERE idProducto = idProducto;
END
$$
DELIMITER ;


INSERT INTO Ventas VALUE(1,10,10000,1,110543176);

DELETE FROM detalleCompras WHERE idDetalleCompras =10; 
SELECT * FROM detalleCOmpras;
DELETE FROM Compras WHERE noOrdenCompra =789;
SELECT * FROM Compras;

INSERT INTO salidasCompras VALUES(1,100,"sadasd");

SELECT DATEDIFF(DAY, GETDATE(), fechaVencimientoProducto ) FROM DetalleCompras WHERE DAY = 30;

 
SELECT DATEDIFF(CURRENT_TIMESTAMP , "2022-06-15");  

select p.nombreProducto -- <<< AQUI SOLO PONES LOS CAMPOS QUE NECESITARAS.
from producto p inner join 
tipoproducto i on p.idTipoProducto = i.idTipoProducto 
and CURRENT_TIMESTAMP >= DATEADD(M,-3, '2017/08/25');

SELECT * FROM Producto;


INSERT INTO detalleCompras VALUES(2,'2022-11-06',100,1000,10,2,1);

SELECT * FROM Producto;
INSERT INTO Producto VALUE(8,"Arroz",'2022-12-01',"libras Arroz Roa",50,1,23000,2,1101753174);

SELECT nombreProducto, NOW() AS fechaActual, DATEDIFF(fechaVencimiento, NOW()) AS DIFERENCIA_DIAS FROM producto  
WHERE DATEDIFF(fechaVencimiento,NOW()) <= 30 AND estadoProducto = 1;

SELECT COUNT(*) AS cantidadRegistros FROM producto  
WHERE DATEDIFF(fechaVencimiento,NOW()) <= 30 AND estadoProducto = 1;

SELECT nombreProducto,cantidadProducto FROM producto  
WHERE cantidadProducto <= 10 AND estadoProducto = 1;

SELECT COUNT(*) AS cantidad FROM producto  
WHERE cantidadProducto <= 10 AND estadoProducto = 1;



SELECT * FROM Proveedor;
