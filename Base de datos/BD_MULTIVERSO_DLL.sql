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
    correoUsuario VARCHAR(100) NOT NULL,
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

CREATE TABLE Compras
(
    entradasCompras INT NOT NULL,
    noOrdenCompra INT PRIMARY KEY,
	idUsuarioCompra INT,
    FOREIGN KEY idUsuarioCompra (idUsuarioCompra) REFERENCES Usuario (noDocUsuario)
);

CREATE TABLE Producto
(		
	idProducto INT PRIMARY KEY auto_increment,
    nombreProducto VARCHAR(100) NOT NULL,
    observacionesProducto VARCHAR(100),
    cantidadProducto INT NOT NULL,
    estadoProducto BOOLEAN NOT NULL,
    precioProducto INT NOT NULL,
    idTipoProducto INT NOT NULL,
    FOREIGN KEY idTipoProducto (idTipoProducto) REFERENCES TipoProducto (idTipoProducto)
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
    FOREIGN KEY idProductoFK (idProductoFK) REFERENCES Producto (idProducto),
	noDocCliente INT,
    FOREIGN KEY noDocCliente (noDocCliente) REFERENCES Cliente (noDocCliente)
);



CREATE TABLE DetalleCompras
(
	idDetalleCompras INT PRIMARY KEY auto_increment,
	fechaVencimientoProducto DATE,
	cantidadCompra INT,
    precioProveedor INT,
    noOrdenCompra INT,
	FOREIGN KEY noOrdenCompra (noOrdenCompra) REFERENCES Compras (noOrdenCompra),
	idProducto INT,
	FOREIGN KEY idProducto (idProducto) REFERENCES Producto (idProducto),
	idProveedor INT,
	FOREIGN KEY idProveedor (idProveedor) REFERENCES Proveedor (idProveedor)
    
);

CREATE TABLE salidasCompras
(
	idSalida INT PRIMARY KEY AUTO_INCREMENT,
    cantidadSalidas INT NOT NULL,
    motivoSalidas VARCHAR(100),
	idDetalleCompras INT,
    FOREIGN KEY idDetalleCompras (idDetalleCompras) REFERENCES DetalleCompras (idDetalleCompras)
);

DROP DATABASE bd_multiverso;
SET SQL_SAFE_UPDATES = 0;

#--TRIGGER PARA ACTUALIZAR LA CANTIDAD (FALTA REVISAR)-------------------------------------------------------------

SELECT * FROM Producto;

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