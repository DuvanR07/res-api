
insert into `persona` (`_id`, `apellido1`, `apellido2`, `nombre`, `observacion`, `tipo`) values('1','Rosero','Lopez','Duvan',NULL,'Cliente');
insert into `persona` (`_id`, `apellido1`, `apellido2`, `nombre`, `observacion`, `tipo`) values('2','Rosero','Lopez','Danilo',NULL,'Cliente');
insert into `persona` (`_id`, `apellido1`, `apellido2`, `nombre`, `observacion`, `tipo`) values('3','Lopez','Lopez','Gladyz',NULL,'Cocinero');
insert into `persona` (`_id`, `apellido1`, `apellido2`, `nombre`, `observacion`, `tipo`) values('4','Rosero','Lopez','German',NULL,'Camarero');
insert into `persona` (`_id`, `apellido1`, `apellido2`, `nombre`, `observacion`, `tipo`) values('5','Rosero','Lopez','Diego',NULL,'Camarero');


insert into `mesa` (`_id`, `des`, `num_max`, `ubicacion`) values('1','Mesa 1','5','Entrada');
insert into `mesa` (`_id`, `des`, `num_max`, `ubicacion`) values('2', 'Mesa 2','4','Central');

insert into `factura` (`_id`, `fecha_factura`, `id_camarero`, `id_cliente`, `id_mesa`) values('6','2019-06-07','4','1','1');
insert into `factura` (`_id`, `fecha_factura`, `id_camarero`, `id_cliente`, `id_mesa`) values('9','2019-06-07','4','2','1');

insert into `detalle_factura` (`_id`, `plato`, `valor`, `id_cocinero`, `id_factura`) values('7','Arroz con pollo','7000','3','6');
insert into `detalle_factura` (`_id`, `plato`, `valor`, `id_cocinero`, `id_factura`) values('8','Jugo Natural en leche','2500','3','6');
insert into `detalle_factura` (`_id`, `plato`, `valor`, `id_cocinero`, `id_factura`) values('10','Bandeja paisa','25000','3','9');
insert into `detalle_factura` (`_id`, `plato`, `valor`, `id_cocinero`, `id_factura`) values('11','Limonada','3500','3','9');
