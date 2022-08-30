create table fotos(
	idFoto int not null,
	nombre varchar(45),
	archivo blob,
	PRIMARY KEY (`idFoto`)
);

drop table if exists fotos_productos;
create table fotos_productos(
	idFoto int not null,
	idProducto int not null,
	PRIMARY KEY (`idFoto`,`idProducto`),
  	CONSTRAINT `fk_fotos_productos_productos` FOREIGN KEY (`idProducto`) REFERENCES `productos` (`idProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  	CONSTRAINT `fk_fotos_productos_fotos` FOREIGN KEY (`idFoto`) REFERENCES `fotos` (`idFoto`) ON DELETE NO ACTION ON UPDATE NO ACTION
);