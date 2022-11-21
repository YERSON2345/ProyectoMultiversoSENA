USE bd_multiverso;

SELECT * FROM Usuario; 
SELECT * FROM TipoProducto;
SELECT * FROM Compras;
SELECT * FROM Producto;
SELECT * FROM Ventas;
SELECT * FROM Rol;
SELECT * FROM proveedor;
SELECT * FROM Cliente;
SELECT * FROM detalleCompras;

#-INSERTAR ROLES---------------------------------------------------------------------------------------------
INSERT INTO Rol VALUES
(1,"Gerente"),
(2, "Operador");
#-------------------------------------------------------------------------------------------------------------
#-INSERTAR TIPOS DE PRODUCTO----------------------------------------------------------------------------------
INSERT INTO tipoProducto VALUE(1,"Tecnología",1);
INSERT INTO tipoProducto VALUE(2,"Consumibles",1);
INSERT INTO tipoProducto VALUE(3,"Suplementos",1);
INSERT INTO tipoProducto VALUE(4,"Juguetes Infantiles",1);
INSERT INTO tipoProducto VALUE(5,"Aseo",1);
#-------------------------------------------------------------------------------------------------------------
#-INSERTAR PRODUCTOS------------------------------------------------------------------------------------------
INSERT INTO Producto VALUE(1,"Audifonos","Audifonos JBL de bueno calidad",10,1,50000,1);
INSERT INTO Producto VALUE(2,"Guey Gold Standart","Suplemento de proteina concentrada",100,1,350000,3);
INSERT INTO Producto VALUE(3,"Auto Lego","Figura de un carro con legos",10,1,150000,4);
INSERT INTO Producto VALUE(4,"Monitor Compac","Monitor generico y economico",5,1,40000,1);
INSERT INTO Producto VALUE(5,"Arroz",'2022-11-09',"libras Arroz Roa",50,1,23000,2,1101753174);
#-INSERTAR PROVEEDORES----------------------------------------------------------------------------------------
INSERT INTO Proveedor VALUE(1, "Maicol", "IBM", 1);
INSERT INTO Proveedor VALUE(2, "Andres", "S.A.S", 1);
INSERT INTO Proveedor VALUE(3, "Daniela", "UNITEC", 1);
INSERT INTO Proveedor VALUE(4, "Nicolas", "COMPUMAX", 1);
INSERT INTO Proveedor VALUE(5, "David", "A.S.A", 1);
#-------------------------------------------------------------------------------------------------------------
#-INSERTAR CLIENTES-------------------------------------------------------------------------------------------
INSERT INTO Cliente VALUE(1101755343,"Andrea","T.I","Marlina",312345345,"andreas.a4352a@gmail.com","cra 45 #234a -65",1);
INSERT INTO Cliente VALUE(1101433243,"Daniel","CC","Carrueco",313424235,"daniel.fgdwa@hotmail.com","cra 54 #234a -45",1);
INSERT INTO Cliente VALUE(154353176,"Kevin","T.I","Correa",312453435,"kevin.nhgfwa@outlook.com","cra 345 #234a -25",0);
INSERT INTO Cliente VALUE(110543176,"Julian","CC","Duarte",314535235,"julian.453wa@gmail.com","cra 45 #234a -45",0);
INSERT INTO Cliente VALUE(1153453176,"Esteban","T.I","Roncancio",312334535,"esteban.vd455a@gmail.com","cra 54 #234a -23",1);

#--------------------------------------------------------------------------------------------------------------
#-INSERTAR COMPRAS---------------------------------------------------------------------------------------------
INSERT INTO Compras VALUE(12,100);
INSERT INTO detalleCompras VALUE(1,"2003-12-30",12,20000,100,1,1);
INSERT INTO Compras VALUE(232,13423);
INSERT INTO detalleCompras VALUE(2,"2005-01-25",232,430000,13423,4,1);
INSERT INTO Compras VALUE(12,133);
INSERT INTO detalleCompras VALUE(3,"2006-05-12",12,65000,133,3,1);
INSERT INTO Compras VALUE(3412,231);
INSERT INTO detalleCompras VALUE(4,"2007-04-21",3412,334000,231,2,1);
INSERT INTO Compras VALUE(1,341,1323);
INSERT INTO detalleCompras VALUE(5,"2007-11-11",341,54000,1323,1,1);
#--------------------------------------------------------------------------------------------------------------
#--INSERTAR VENTAS--------------------------------------------------------------------------------------------
INSERT INTO Ventas VALUE(1,10,10000,1,110543176);
INSERT INTO Ventas VALUE(2,10,300000,3,1153453176);
INSERT INTO Ventas VALUE(3,10,590000,2,110543176);
INSERT INTO Ventas VALUE(4,10,320000,5,1101433243);
INSERT INTO Ventas VALUE(5,10,43000,3,1101755343);
#--------------------------------------------------------------------------------------------------------------
#--INSERTAR USUARIOS-------------------------------------------------------------------------------------------
INSERT INTO salidasCompras VALUE(1,10,"Mal estado",1);
#--------------------------------------------------------------------------------------------------------------
#--INSERTAR SALIDAS-------------------------------------------------------------------------------------------
INSERT INTO Usuario VALUE("Yerson","Bohorquez","T.I","yerson.bohorquez14@gmail.com",1101753174,"perobueno",1,1);
INSERT INTO Usuario VALUE("Nicolas","Peraza","CC","nicolasp12e@gmail.com",1000594639,"375195285465",1,2);
INSERT INTO Usuario VALUE("Maicol","Correo","T.I","maicolcorreaakjhsd@gmail.com",143235643,"asdasdasdasd",1,1);
#--------------------------------------------------------------------------------------------------------------
#--------------------------------------------------------------------------------------------------------------
#-----CONSULTA INNER JOIN DE VENTAS PARA MOSTRAR PRODUCTOS Y CLIENTES------------------------------------------

SELECT U.idDetalleVenta,U.cantidadVendida,U.precioTotal,U.idProductoFK, U.noDocCliente,C.nombreProducto,O.nombreCliente FROM Ventas U INNER JOIN 
Producto C ON U.idProductoFK = C.idProducto INNER JOIN Cliente O ON O.noDocCliente = U.noDocCliente;

SELECT U.idDetalleVenta,U.cantidadVendida,U.precioTotal,U.idProductoFK, U.noDocCliente,C.nombreProducto,C.observacionesProducto,C.cantidadProducto,C.precioProducto FROM Ventas U INNER JOIN 
Producto C ON U.idProductoFK = C.idProducto WHERE U.idDetalleVenta = 14;

SELECT * FROM Ventas;


#--------------------------------------------------------------------------------------------------------------
#-----CONSULTA INNER JOIN DE SALIDAS PARA MOSTRAR NUMERO DE ORDEN Y NOMBRE DEL PRODUCTO------------------------------------------

SELECT U.idSalida,I.noOrdenCompra, U.cantidadSalidas, U.motivoSalidas, U.idDetalleCompras, O.nombreProducto,O.cantidadProducto FROM salidasCompras U INNER JOIN 
detalleCompras C ON U.idDetalleCompras = C.idDetalleCompras INNER JOIN Producto O ON O.idProducto = C.idProducto INNER JOIN Compras I ON C.noOrdenCompra = I.noOrdenCompra WHERE U.idSalida = 1;

#--------------------------------------------------------------------------------------------------------------
#-----CONSULTA INNER JOIN DE SALIDAS PARA MOSTRAR EL PRODUCTO Y EL NUMERO DE ORDEN-----------------------------------

SELECT U.idDetalleCompras,C.noOrdenCompra,P.nombreProducto,P.cantidadProducto FROM detalleCompras U INNER JOIN 
Compras C ON U.noOrdenCompra = C.noOrdenCompra INNER JOIN Producto P ON U.idProducto = P.idProducto;

#---------------------------------------------------------------------------------------------------------------------------------------------------
#-----CONSULTA INNER JOIN DE COMPRAS PARA MOSTRAR EL PRODUCTO Y EL PROVEEDOR-----------------------------------

SELECT U.idDetalleCompras,U.fechaCompra,U.precioProveedor,U.noOrdenCompra,O.nombreProveedor,P.nombreProducto FROM 
Compras U INNER JOIN Proveedor O ON U.idProveedor = O.idProveedor INNER JOIN Producto P ON U.idProducto = P.idProducto ;

INSERT INTO compras VALUES(1,'2022-10-09',10,1000,10232912,5,1);

SELECT U.idDetalleCompras,U.fechaCompra,U.precioProveedor,U.noOrdenCompra,O.nombreProveedor,P.nombreProducto FROM 
Compras U INNER JOIN Proveedor O ON U.idProveedor = O.idProveedor INNER JOIN Producto P ON U.idProducto = P.idProducto WHERE idDetalleCompras=1;


#---------------------------------------------------------------------------------------------------------------------------------------------------
#-----CONSULTA INNER JOIN DE COMPRAS PARA MOSTRAR EL PRODUCTO Y EL PROVEEDOR-----------------------------------

SELECT U.idDetalleCompras,C.noOrdenCompra,P.nombreProducto,P.cantidadProducto FROM detalleCompras U INNER JOIN 
Compras C ON U.noOrdenCompra = C.noOrdenCompra INNER JOIN Producto P ON U.idProducto = P.idProducto;

SELECT U.idDetalleCompras,C.noOrdenCompra,P.nombreProducto,P.cantidadProducto FROM detalleCompras U INNER JOIN 
Compras C ON U.noOrdenCompra = C.noOrdenCompra INNER JOIN Producto P ON U.idProducto = P.idProducto WHERE U.idDetalleCompras = 11;

SELECT P.idProducto,P.nombreProducto,P.cantidadProducto,P.observacionesProducto,P.precioProducto,T.nombreTipoProducto FROM Producto P INNER JOIN tipoProducto T ON P.idTipoProducto = T.idTipoProducto WHERE P.idProducto = 1;



#---------------------------------------------------------------------------------------------------------------------------------------------------
#-----CONSULTA INNER JOIN DEL LOGIN------------------------------------------------------------------------------------------------------------------
SELECT count(noDocUsuario) FROM Usuario WHERE correoUsuario = "yerson.bohorquez14@gmail.com";

SELECT U.noDocUsuario,U.nombreUsuario,U.apellidoUsuario,U.estadoUsuario, C.tipoRol FROM Usuario U INNER JOIN 
rol C ON U.idRol = C.idRol WHERE U.correoUsuario ="yerson.bohorquez14@gmail.com" AND U.contrasenaUsuario =3243541344533323;
#----------------------------------------------------------------------------------------------------------------------------------------------------

UPDATE Producto SET cantidadProducto = 5 WHERE nombreProducto ="Audifonos";
UPDATE Producto 

SET SQL_SAFE_UPDATES = 0;

ASD

