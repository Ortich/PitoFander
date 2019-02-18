DROP DATABASE IF EXISTS pathManager;
CREATE DATABASE IF NOT EXISTS pathManager;
USE pathManager;

CREATE TABLE IF NOT EXISTS `personaje` 
(
	`codPersonaje` int(255) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	`nombre` varchar(20) NOT NULL,
	`apellidos` varchar(50),
	`alineamiento` varchar(30) NOT NULL,
	`religion` varchar(30),
	`genero` varchar(30) NOT NULL,
    `ptsGolpe` int(4) NOT NULL,
    `idiomas` varchar(50) NOT NULL,
    `nivel` int(3) NOT NULL,
    `edad` int(4) NOT NULL,
    `altura` int(4) NOT NULL,
    `peso` int(4) NOT NULL,
    `cabello` varchar(20) NOT NULL,
    `ojos` varchar(20) NOT NULL,
    `pc` int(3),
    `pp` int(3),
    `po` int(3),
    `ppr` int(3),
    `fuerza` int(2) NOT NULL,
    `destreza` int(2) NOT NULL,
    `constitucion` int(2) NOT NULL,
    `inteligencia` int(2) NOT NULL,
    `sabiduria` int(2) NOT NULL,
    `carisma` int(2) NOT NULL,
    `acrobacias` int(3)  NOT NULL,
    `artesania1` int(3)  NOT NULL,
    `artesania1Nombre` varchar(20),
    `artesania2` int(3)  NOT NULL,
    `artesania2Nombre` varchar(20),
    `artesania3` int(3)  NOT NULL,
    `artesania3Nombre` varchar(20),
    `averiguarIntenciones` int(3)  NOT NULL,
    `conocimientoDeConjuros` int(3)  NOT NULL,
    `curar` int(3)  NOT NULL,
    `diplomacia` int(3)  NOT NULL,
    `disfrazarse` int(3)  NOT NULL,
    `engannar` int(3)  NOT NULL,
    `escapismo` int(3)  NOT NULL,
    `interpretar1` int(3)  NOT NULL,
    `interpretar1Nombre` varchar(20),
    `interpretar2` int(3)  NOT NULL,
    `interpretar2Nombre` varchar(20),
    `intimidar` int(3)  NOT NULL,
    `inutilizarMecanismo` int(3)  NOT NULL,
    `juegoDeManos` int(3)  NOT NULL,
    `linguistica` int(3)  NOT NULL,
    `montar` int(3)  NOT NULL,
    `nadar` int(3)  NOT NULL,
    `percepcion` int(3)  NOT NULL,
    `profesion1` int(3)  NOT NULL,
    `profesion1Nombre` varchar(20),
    `profesion2` int(3)  NOT NULL,
    `profesion2Nombre` varchar(20),
    `saberArcano` int(3)  NOT NULL,
    `saberDungeons` int(3)  NOT NULL,
    `saberGeografia` int(3)  NOT NULL,
    `saberHistoria` int(3)  NOT NULL,
    `saberIngenieria` int(3)  NOT NULL,
    `saberLocal` int(3)  NOT NULL,
    `saberNaturaleza` int(3)  NOT NULL,
    `saberNobleza` int(3)  NOT NULL,
	`saberPlanos` int(3)  NOT NULL,
    `saberReligion` int(3)  NOT NULL,
    `sigilo` int(3)  NOT NULL,
    `supervivencia` int(3)  NOT NULL,
    `tasacion` int(3)  NOT NULL,
    `tratoConAnimales` int(3)  NOT NULL,
    `trepar` int(3)  NOT NULL,
    `usarObjetoMagico` int(3)  NOT NULL,
    `volar` int(3)  NOT NULL, 
    `raza` varchar(20)  NOT NULL,
    `clase` varchar(40) NOT NULL,
    `codUsuario` int(255) NOT NULL
) 
ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO `personaje` (`nombre`,`apellidos`,`alineamiento`,`religion`,`genero`,`ptsGolpe`,`idiomas`,
`nivel`, `edad`, `altura`, `peso`, `cabello`, `ojos`, `pc`, `pp`, `po`, `ppr`, `fuerza`, `destreza`, `constitucion`, `inteligencia`, `sabiduria`, `carisma`,
`acrobacias`,`artesania1`,`artesania1Nombre`,`artesania2`,`artesania2Nombre`,  
`artesania3`,`artesania3Nombre`,`averiguarIntenciones`,`conocimientoDeConjuros`,`curar`,`diplomacia`,`disfrazarse`,`engannar`,`escapismo`,
`interpretar1`,`interpretar1Nombre`,`interpretar2`,`interpretar2Nombre`,`intimidar`,`inutilizarMecanismo`,`juegoDeManos`,`linguistica`,
`montar`,`nadar`,`percepcion`,`profesion1`,`profesion1Nombre`,`profesion2`,`profesion2Nombre`,`saberArcano`,`saberDungeons`,`saberGeografia`,
`saberHistoria`,`saberIngenieria`,`saberLocal`,`saberNaturaleza`,`saberNobleza`,`saberPlanos`,`saberReligion`,`sigilo`,`supervivencia`,`tasacion`,
`tratoConAnimales`,`trepar`,`usarObjetoMagico`,`volar`,
`raza`, `clase`, `codUsuario`) 
VALUES 
('Caladrel', 'Fëanor', 'CN', 'Nethys', 'Hombre', 14, 'Común, Elfo, Celestial, Abisal, Draconico, Abisal',
3, 165, 185, 72, 'Rubio', 'Azules', 0, 5, 136, 0, 11, 17, 11, 19, 14, 10,
3, 4, 'Panadero', 2, 'Agricultor',
0, '-', 1, 4, 2, 1, 0, 0, 2, 
0, '-', 0, '-', 0, 1, 1, 10,
0, 0, 5, 3, 'Escritor', 0, '-', 4, 4, 4, 
4, 4, 4, 4, 4, 4, 4, 2, 0, 0, 
0, 0, 4, 3, 
'Elfo', 'Bardo', 2),
('Adolfito', 'Vendetta', 'LB', 'JesuCristo', 'Mujer', 23, 'Común y Enano',
4, 40, 154, 84, 'Moreno', 'Verde', 4, 17, 157, 0, 10, 15, 11, 12, 12, 14,
2, 3, 'Adobe', 1, '-',
0, '-', 1, 2, 3, 2, 1, 0, 2, 
0, '-', 0, '-', 0, 1, 2, 3,
0, 2, 1, 2, 'Lector', 0, '-', 4, 4, 4, 
4, 2, 0, 0, 0, 0, 0, 0, 1, 0, 
0, 1, 2, 3, 
'Enano', 'Bárbaro', 2),
('Patxi', 'Urrutia', 'LN', 'Olentxero', 'Hombre', 22, 'Común y Abisal',
5, 223, 181, 87, 'Moreno', 'Verdes', 0, 5, 121, 0, 13, 18, 12, 14, 15, 11,
2, 4, 'Verdulero', 1, 'Hostelero',
0, '-', 1, 2, 1, 5, 0, 0, 2, 
0, '-', 0, '-', 1, 1, 1, 3,
0, 1, 1, 3, 'Escudero', 0, '-', 4, 1, 2, 
4, 1, 1, 1, 1, 4, 1, 2, 0, 1, 
0, 1, 1, 3, 
'Gnomo', 'Clérigo', 1);

CREATE TABLE IF NOT EXISTS `raza`
(
	`nombre` varchar(20) NOT NULL PRIMARY KEY,
    `fuerza` int(2) NOT NULL,
    `destreza` int(2) NOT NULL,
    `constitucion` int(2) NOT NULL,
    `inteligencia` int(2) NOT NULL,
    `sabiduria` int(2) NOT NULL,
    `carisma` int(2) NOT NULL,
    `adaptativo` int(2) NOT NULL,
    `tamaño` varchar(50) NOT NULL,
    `velocidad` varchar(50) NOT NULL,
    `idiomas` varchar(50) NOT NULL,
    `idiomasAprendibles` TEXT NOT NULL,
    `aptitudesEspeciales` TEXT
)
ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO `raza` (`nombre`,`fuerza`,`destreza`,`constitucion`,`inteligencia`,`sabiduria`,`carisma`,`adaptativo`,
`tamaño`,`velocidad`,`idiomas`,`idiomasAprendibles`,`aptitudesEspeciales`) 
VALUES 
('Elfo',0,2,-2,2,0,0,0,'Mediano','30 pies/9 m','Común, Elfo','Celestial, Dracónico, Goblin, Gnoll, Gnomo, Orco, Silvano', 'Vision en la penumbra, Magia Elfica, Sentidos Agudos, Familiaridad con Arcos largos, Espadas largas, Espadas roperas, Arcos Cortos y cualquier arma con la palabra "élfico".'),
('Enano', 0,0,2,0,2,-2,0, 'Mediano', '20 pies/6 m', 'Común, Enano','Gigante, Gnomo, Goblin, Infracomún, Orco, Térraro', 'Visión en la oscuridad, Entrenamiento defensivo, Avaricia, Odio, Resistencia, Estabilidad, Afinidad de la piedra, Familiaridad con las armas: Hachas de batalla, picos pesados, martillos de guerra y cualquier arma con la palabra "enano".'),
('Gnomo',-2,0,2,0,0,2,0,'Pequeño', '20 pies/6 m', 'Común, Gnomo, Silvano', 'Dracónico, Elfo, Enano, Gigante, Goblin, Orco', 'Visión en la penumbra, Entrenamiento defensivo, Magia de los Gnomos, Odio, Resistencia a la ilusión, Sentidos Agudos, Obsesivo, Familiaridad con las armas: cualquier arma con la palabra "Gnomo".');

CREATE TABLE IF NOT EXISTS `objetos`
(
	`codObjeto` int(255) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `nombre` varchar(30) NOT NULL,
    `peso` varchar(30) NOT NULL,
    `magico` BOOL NOT NULL,
    `descripcion` TEXT NOT NULL
)
ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO `objetos` (`nombre`,`peso`,`magico`,`descripcion`) 
VALUES 
('Abrojos', '2 libras(900g)', 0, 'Pequeñas puas metalicas que tiran al suelo.'),
('Aceite(1 pinta[0,5L])', '1 libra(450g)', 0, 'Una pequeña botella de aceite de multiples usos.'),
('Aguja de costura', '-', 0, 'Una pequeña aguja utilizada para la costura.'),
('Almádena', '10 libras(4,5kg)', 0, 'herramienta similar a un martillo que consiste en una gran cabeza metálica introducida en el extremo de un palo de madera que se usa como mango.'),
('Antorcha', '1 libra(450g)', 0, 'Un palo de madera recubierto en un extremo de tela que puede iluminar si se enciende.'),
('Anzuelo', '-', 0, 'Dispositivo para la captura de peces, que se engancha en el paladar, en la boca y muy raramente en el cuerpo del pez.'),
('Aparejo de poleas', '5 libras(2,25kg)', 0, 'Un complicado sistema de poleas que puede usarse para elevar cosas de mucho peso.'),
('Ariete portátil', '20 libras(9 kg)', 0, 'Herramienta grande y pesada usada para tirar puertas y muros.'),
('Barril(vacío)', '30 libras(13,5kg)', 0, 'Un barril de gran tamaño usado para almacenar todo tipo de liquidos.'),
('Bolsa para el cinto(vacía)', '1/2libra(225)', 0, 'Pequeña bolsa que se pone en el cinto, usada para guardar pequeños objetos.');

CREATE TABLE IF NOT EXISTS `armas`
(
	`codArma` int(255) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `nombre` varchar(30) NOT NULL,
    `peso` varchar(30) NOT NULL,
    `magico` BOOL NOT NULL,
    `descripcion` TEXT NOT NULL,
    `dannoP` varchar(20) NOT NULL,
    `dannoM` varchar(20) NOT NULL,
    `critico` varchar(20) NOT NULL,
    `rango` varchar(20) NOT NULL,
    `tipo` varchar(20) NOT NULL,
    `especial` varchar(50)
)
ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO `armas` (`nombre`,`peso`,`magico`,`descripcion`,`dannoP`,`dannoM`,`critico`,`rango`,`tipo`,`especial`) 
VALUES 
('Guantelete', '1 libra(450g)', 0, 'Ataques sin armas. Guante considerado como ataque sin arma', '1d2', '1d3', 'x2', '-', 'Con', '-'),
('Impacto sin armas', '-', 0, 'Ataques sin armas. Ataque con las manos desnudas', '1d2', '1d3', 'x2', '-', 'Con', 'No letal'),
('Daga', '1 libra(450g)', 0, 'Armas cuerpo a cuerpo ligeras. Pequeño cuchillo utilizado por asesinos y picaros', '1d3', '1d4', '19-20/x2', '10 pies(3m)', 'Per o Cor', '-'),
('Guantelete armado', '1 libra(450g)', 0, 'Armas cuerpo a cuerpo ligeras. Guantelete armado de pinchos para maximizar el daño de los golpes', '1d3', '1d4', 'x2', '-', 'Per', '-'),
('Hoz', '2 libras(900g)', 0, 'Armas cuerpo a cuerpo ligeras. Consiste en una cuchilla metálica en forma de media luna y un mango para poder dirigirla.', '1d4', '1d6', 'x2', '-', 'Cor', 'derribar'),
('Maza ligera', '4 libras(1,80kg)', 0, 'Armas cuerpo a cuerpo ligeras. Maza de una mano usada para dar golpes rapidos', '1d4', '1d6', 'x2', '-', 'Con', '-'),
('Puñal', '1 libra(450g)', 0, 'Armas cuerpo a cuerpo ligeras. Pequeño puñal usado para asesinar de forma sigiloso', '1d3', '1d4', 'x2', '-', 'Per', '-'),
('Clava', '3 libras(1,35kg)', 0, 'Armas cuerpo a una mano. Maza de tamaño pequeño y redondo', '1d4', '1d6', 'x2', '10 pies(3m)', 'Con', '-'),
('Lanza corta', '3 libras(1,35kg)', 0, 'Armas cuerpo a cuerpo a una mano. Pequeña lanza que se lanza para perforar', '1d4', '1d6', 'x2', '20 pies(6m)', 'Per', '-'),
('Maza pesada', '8 libras(3,60kg)', 0, 'Armas cuerpo a cuerpo a una mano. Maza muy pesada que puede hacer mucho daño', '1d6', '1d8', 'x2', '-', 'Con', '-');

CREATE TABLE IF NOT EXISTS `armaduras`
(
	`codArmadura` int(255) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `nombre` varchar(30) NOT NULL,
    `bonificador` int(4) NOT NULL,
    `peso` varchar(30) NOT NULL,
    `magico` BOOL NOT NULL,
    `descripcion` TEXT NOT NULL,
    `velocidad` varchar(30) NOT NULL,
    `dexBonus` int(2),
    `penalizacion` int(2),
    `falloHechizo` int(3)
)
ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO `armaduras` (`nombre`,`bonificador`,`peso`,`magico`,`descripcion`,`velocidad`,`dexBonus`,`penalizacion`,`falloHechizo`) 
VALUES 
('Acolchada', 1,'10 libras(4,5kg)', 0, 'Armadura ligera basica. Poco más que ropa gruesa y acolchada.', '30 pies(9m) / 20 pies(6m)', 8, 0, 5),
('Cuero', 2, '15 libras(6,8kg)', 0, 'Armadura ligera. Hecha con trozos de cuero hervido, cuidadosamente cosidos.', '30 pies(9m) / 20 pies(6m)', 6, 0, 10),
('Cuero tachonado', 3, '20 libras(9kg)', 0, 'Armadura ligera. Similar a la de cuero pero con pequeños trozos de metal.', '30 pies(9m) / 20 pies(6m)', 5, -1, 15),
('Camisote de mallas', 4,'25 libras(11kg)', 0, 'Armadura ligera. Cubriendo el torso, este camisote está hecha de miles de anillos de metal entrelazados.', '30 pies(9m) / 20 pies(6m)', 4, -2, 20),
('De pieles', 4,'25 libras(11kg)', 0, 'Armadura intermedia. Hecha de piel curtida y preservada de cualquier bestia de piel gruesa.', '20 pies(6m) / 15 pies(4,5m)', 4, -3, 20),
('Cota de escamas', 5,'30 libras(13,6kg)', 0, 'Armadura intermedia. Compuesta de docenas de pequeñas placas de metal superpuestas.', '20 pies(6m) / 15 pies(4,5m)', 3, -4, 25),
('Cota de mallas', 6,'40 libras(18kg)', 0, 'Armadura intermedia. Cubre piernas y brazos, además incluye guanteletes.', '20 pies(6m) / 15 pies(4,5m)', 2, -5, 30),
('Coraza', 6,'30 libras(13,6kg)', 0, 'Armadura intermedia. Cubre solo el torso, una gran pieza de metal cincelado.', '20 pies(6m) / 15 pies(4,5m)', 3, -4, 25),
('Laminada', 7,'45 libras(20,4kg)', 0, 'Armadura pesada. Hecha de tiras de metal, incluye guanteletes.', '20 pies(6m) / 15 pies(4,5m)', 0, -7, 40),
('Cota de bandas', 7,'35 libras(15,9kg)', 0, 'Armadura pesada. Hecha a base de tiras metal superpuestas, atadas a una base de cuero.', '20 pies(6m) / 15 pies(4,5m)', 1, -6, 35);

CREATE TABLE IF NOT EXISTS `dotes`
(
	`codDote` int(3) NOT NULL PRIMARY KEY auto_increment,
	`nombre` varchar(40) NOT NULL,
    `beneficio` TEXT NOT NULL,
    `normal` TEXT,
    `especial` TEXT,
    `descripcion` TEXT NOT NULL,
    `preRequisitos` TEXT NOT NULL
)
ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO `dotes` (`nombre`,`beneficio`,`normal`,`especial`,`descripcion`,`preRequisitos`) 
VALUES 
('Acometer(Combate)', 'Puedes aumentar el alcanze de tus ataques cuerpo a cuerpo 5 pies(1,5m) 
hasta el final del turno aceptando un penalizador de -2CA hasta el siguiente turno.', '', '', 'Puedes atacar a enemigos que normalmente estarian fuera 
de tu alcance.','ataque base +6'),
('Acrobático', 'Obtienes un bonificador +2 a todas las pruebas de habilidad de Acrobacias y de Volar. Si tienes 10 o más rangos en una de estas habilidades, 
el bonificador se incrementa en un +4 para dicha habilidad.', '', '', 'Eres hábil en dar saltos de altura y de longitud, y en volar.', ''),
('Afinidad con los animales', 'Obtienes un bonificador +2 a las pruebas de habilidad de Montar y de Trato con animales. Con 10 o más rangos en una de ellas,
 el bonificador se incrementa a +4 para dicha habilidad.', '', '', 'Eres hábil trabajando con animales y con monturas.', ''),
('Aguante', 'Obtienes un bonificador +4 a las pruebas y salvaciones: pruebas de nadar, pruebas de constitucion, salvaciones de Fortaleza. 
Puedes dormir don armadura intermedia o pesada sin quedar fatigado.', 'Un personaje sin esta dote que duerme con una armadura intermedia o mas pesada puesta, queda fatigado.', '', 
'Ni las condiciones desfavorables, ni los esfuerzos prolongados te cansan con facilidad', ''),
('Alerta', 'Obtienes un bonificador +2 a las pruebas de Percepcion y de Averiguar intenciones. 
Si tienes 10 o mas rangos en una de estas habilidades el bonificador se incrementa a +4.', '', '', 'A menudo te das cuenta de cosas que otros podrian perderse.', ''),
('Ampliar conjuro(MetaMagica)', 'Puedes alterar un conjuro con un alcance de cercano medio, o largo para incrementar su alcance un 100%. 
Hechizos cuyos alcances no este definidos no reciben beneficio de esta dote.', '', '', 'Puedes incrementar el rango de tus conjuros.', ''),
('Apresurar conjuro(MetaMagica)', 'Lanzar un conjuro apresurado es un accion rapida. 
Puedes llevar a cabo otra accion, e incluso lanzar otro el mismo asalto en el que lo lanzas. Lanzarlo no provoca ataques de oprtunidad.', '', 
'Puedes lanzar los efectos de esta dote a un conjuro lanzado espontaneamente.', 'Puedes lanzar conjuros en una fraccion del tiempo normal', ''),
('Aptitudes Magicas', 'Obtienes un bonificador +2 a todas las pruebas de Conocimiento de Conjuros y de Usar Objeto Magico. 
Si tienes 10 o mas rangos en una de estas habilidades el bonificador se incrementa a +4.', '', '', 'Eres habil lanzando conjuros, y utilizando objetos magicos.', '');

CREATE TABLE IF NOT EXISTS `hechizos`
(
	`codHechizo` int(3) NOT NULL PRIMARY KEY auto_increment,
	`nombre` varchar(40) NOT NULL,
    `escuela` varchar(20) NOT NULL,
    `tiempoCasteo` varchar(20) NOT NULL,
    `componentes` TEXT NOT NULL,
    `descripcion` TEXT NOT NULL,
    `rango` varchar(50) NOT NULL,
    `objetivo` varchar(90),
    `efecto` varchar(30) NOT NULL,
    `duracion` varchar(30),
    `tiradaSalvacion` TEXT NOT NULL,
    `resistenciaHechizo` varchar(30),
    `barbaro` int(2) NOT NULL,
    `bardo` int(2) NOT NULL,
    `clerigo` int(2) NOT NULL,
    `druida` int(2) NOT NULL,
    `explorador` int(2) NOT NULL,
    `guerrero` int(2) NOT NULL,
    `monje` int(2) NOT NULL,
    `paladin` int(2) NOT NULL,
    `picaro` int(2) NOT NULL,
    `hechicero` int(2) NOT NULL,
    `mago` int(2) NOT NULL
)
ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO `hechizos` (`nombre`,`escuela`,`tiempoCasteo`,`componentes`,`descripcion`,`rango`,`objetivo`,`efecto`,`duracion`,
`tiradaSalvacion`,`resistenciaHechizo`,`barbaro`,`bardo`,`clerigo`,`druida`,`explorador`,`guerrero`,`monje`,`paladin`,`picaro`,`hechicero`,`mago`) 
VALUES 
('Abrir/Cerrar', 'transmutación', '1 acción estandar', 'V,S,F(Una llave de latón)', 'Puedes abrir o cerrar una puerta, cofre, ventana, mochila, bolsa, 
botella, barril o cualquier otro recipiente. Si algo se opone a esta actividad(como una tranca en una puerta), el conjuro fracasa.', 
'Corto(25 pies [7,5m] + 5 pies[1,5m]/2 niveles)', 'Un objeto que pesa hasta 30 libras(13,5kg), o un portal que puede abrirse o cerrarse', '','instantanea',
'Voluntado niega(objeto)', 'si(objeto)', -1, 0, -1, -1, -1, -1, -1, -1, -1, 0, 0),
('Adivinación', 'adivinación', '10 minutos', 'V, S, M(incienso y una ofrenda apropiada de 25 po)', 'El conjuro de adivinación puede darte un consejo útil en 
respuesta a un apregunta concreta sobre un objetivo, acontecimiento, o actividad que vaya a tener lugar antes de 1 semana, que puede ser tan sencillo 
como una frase corta, o tan elaborado como una rima criptica o un presagio. Si tu grupo no actúa basándose en la información, 
las condiciones pueden cambiar e invalidarla. La probabilidad base de llevar a cabo una adivinación correcta es del 70% + 1 % por nivel de lanzador. 
Si la tirada falla eres consciente de que el conjuro ha fracasado, a no ser que haya una magia concreta que te facilite respuestas falsas.', 
'personal', 'Tú', '', 'instantanea', '', '', -1, -1, 4, -1, -1, -1, -1, -1, -1, -1, -1),
('Alineamiento Indetectable', 'Abjuracion', '1 acción estandar', 'V,S', 'Este conjuro oculta el alineamiento de un 
objeto o criatura de toda forma de adivinación.','Corto(25 pies [7,5m] + 5 pies[1,5m]/2 niveles)', '1 criatura u objeto', '', '24 horas',
'Voluntad niega(Objeto)', 'Sí(Objeto)', -1, 1, 2, -1, -1, -1, -1, 2, -1, -1, -1),
('Acelerar', 'transmutación', '1 acción estandar', 'V, S, M(Una viruta de raiz de regaliz)', 'la criatura transmutada se mueve y actua mas rapido de lo normal. 
Cuando lleva a cabo una accion de ataque completo puede llevar acabo una ataque adicional con un arma natural. Una criatura acelerada obtiene un bonificador +1 a las tiradas de ataque.',
'Corto(25 pies [7,5m] + 5 pies[1,5m]/2 niveles)', '1 criatura', '', '1 asalto/nivel', 
'Fortaleza niega (inofensivo)', 'Si', -1, 3,-1,-1,-1,-1,-1,-1,-1,3,3);

CREATE TABLE IF NOT EXISTS `clases`
(
	`codClase` int(3) NOT NULL PRIMARY KEY auto_increment,
	`nombre` varchar(40) NOT NULL,
    `alineamiento` varchar(60) NOT NULL,
    `rol` TEXT NOT NULL,
    `dadoDeGolpe` varchar(20) NOT NULL,
    `rangoPorNivel` varchar(60) NOT NULL,
    `ataqueBase` int(2) NOT NULL,
    `tiradaSalvacionFortaleza` int(2) NOT NULL,
    `tiradaSalvacionReflejos` int(2) NOT NULL,
    `tiradaSalvacionVoluntad` int(2) NOT NULL,
    `acrobacias` BOOL NOT NULL,
    `artesania1` BOOL NOT NULL,
    `artesania1Nombre` BOOL NOT NULL,
    `artesania2` BOOL NOT NULL,
    `artesania2Nombre` BOOL NOT NULL,
    `artesania3` BOOL NOT NULL,
    `artesania3Nombre` BOOL NOT NULL,
    `averiguarIntenciones` BOOL NOT NULL,
    `conocimientoDeConjuros` BOOL NOT NULL,
    `curar` BOOL NOT NULL,
    `diplomacia` BOOL NOT NULL,
    `disfrazarse` BOOL NOT NULL,
    `engannar` BOOL NOT NULL,
    `escapismo` BOOL NOT NULL,
    `interpretar1` BOOL NOT NULL,
    `interpretar1Nombre` BOOL NOT NULL,
    `interpretar2` BOOL NOT NULL,
    `interpretar2Nombre` BOOL NOT NULL,
    `intimidar` BOOL NOT NULL,
    `inutilizarMecanismo` BOOL NOT NULL,
    `juegoDeManos` BOOL NOT NULL,
    `linguistica` BOOL NOT NULL,
    `montar` BOOL NOT NULL,
    `nadar` BOOL NOT NULL,
    `percepcion` BOOL NOT NULL,
    `profesion1` BOOL NOT NULL,
    `profesion1Nombre` BOOL NOT NULL,
    `profesion2` BOOL NOT NULL,
    `profesion2Nombre` BOOL NOT NULL,
    `saberArcano` BOOL NOT NULL,
    `saberDungeons` BOOL NOT NULL,
    `saberGeografia` BOOL NOT NULL,
    `saberHistoria` BOOL NOT NULL,
    `saberIngenieria` BOOL NOT NULL,
    `saberLocal` BOOL NOT NULL,
    `saberNaturaleza` BOOL NOT NULL,
    `saberNobleza` BOOL NOT NULL,
	`saberPlanos` BOOL NOT NULL,
    `saberReligion` BOOL NOT NULL,
    `sigilo` BOOL NOT NULL,
    `supervivencia` BOOL NOT NULL,
    `tasacion` BOOL NOT NULL,
    `tratoConAnimales` BOOL NOT NULL,
    `trepar` BOOL NOT NULL,
    `usarObjetoMagico` BOOL NOT NULL,
    `volar` BOOL NOT NULL
)
ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO `clases` (`nombre`,`alineamiento`,`rol`,`dadoDeGolpe`,`rangoPorNivel`,`ataqueBase`,`tiradaSalvacionFortaleza`,
`tiradaSalvacionReflejos`,`tiradaSalvacionVoluntad`,`acrobacias`,`artesania1`,`artesania1Nombre`,`artesania2`,`artesania2Nombre`,  
`artesania3`,`artesania3Nombre`,`averiguarIntenciones`,`conocimientoDeConjuros`,`curar`,`diplomacia`,`disfrazarse`,`engannar`,`escapismo`,
`interpretar1`,`interpretar1Nombre`,`interpretar2`,`interpretar2Nombre`,`intimidar`,`inutilizarMecanismo`,`juegoDeManos`,`linguistica`,
`montar`,`nadar`,`percepcion`,`profesion1`,`profesion1Nombre`,`profesion2`,`profesion2Nombre`,`saberArcano`,`saberDungeons`,`saberGeografia`,
`saberHistoria`,`saberIngenieria`,`saberLocal`,`saberNaturaleza`,`saberNobleza`,`saberPlanos`,`saberReligion`,`sigilo`,`supervivencia`,`tasacion`,
`tratoConAnimales`,`trepar`,`usarObjetoMagico`,`volar`) 
VALUES 
('Bárbaro', 'Cualquiera que no sea legal', 'Los bárbaros alcanzan la excelencia en el combate, poseyendo la capacidad marcial y la fortaleza necesarias para enfrentarse a enemigos aparentementes superiores a ellos. Con la furia proporcionándoles audacia y coraje más allá de los que posee la mayor parte de los combatienes, los bárbaros cargan con furia a la batalla, y destruyen todo lo que se interpone en su camino.', 'd12', '4 + modificador por Int', 1, 2, 
0, 0, 1, 1, 1, 0, 0, 
0, 0, 0, 0, 0, 0, 0, 0, 0,
0, 0, 0, 0, 1, 0, 0, 0, 
1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 
0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 
1, 1, 0, 0),
('Bardo', 'Cualquiera', 'Los bardos son capaces de confundir y desconcertar a sus enemigos, a la vez que inspiran a sus aliados a empresas cada vez más osadas. Si bien son prácticos tanto con las armas como con la magia, su auténtica fuerza reside lejos del combate cuerpo a cuerpo, desde donde pueden apoyar a sus compañeros y minar a sus adversarios sin temor a que interrumpan sus interpretaciones.', 'd8', '6 + modificador por Int', 0, 0,
2, 2, 1, 1, 1, 0, 0,
0, 0, 1, 1, 0, 1, 1, 1, 1,
1, 1, 0, 0, 1, 0, 1, 1,
0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 
1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 
0, 1, 1, 0),
('Clérigo', 'El alineamiento de un clérigo debe estar como máximo a un paso del de su dios, o bien a lo largo del eje ley/caos, o del eje bien/mal.', 'Más que capaces de defender el honor de sus dioses en combate, los clérigos demuestran a menudo ser combatientes recios y capaces. Su auténtica fuerza es su capacidad de empuñar el poder sus dioses, ya sea para aumentar su propia potencia y la de sus aliados en combate, agraviar a sus enemigos con magia divina, o proveer curación a aquellos compañeros que lo necesitan. Como quiera que sus poderes están influenciados por su fe, todos los clérigos deben enfocar su adoración en una fuente divina. Si bien la inmensa mayoría adora a un dios específico, hay una pequeña cantidad que se dedica a un concepoto divino digno de la devoción, como por ejemplo la batalla, la muerte, la justicia, o el saber, libres de una abstracción deífica.', 'd8', '2 + modificador de Int', 0, '2',
0, 2, 0, 1, 1, 0, 0,
0, 0, 1, 1, 1, 1, 0, 0, 0,
0, 0, 0, 0, 0, 0, 0, 1,
0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 
1, 0, 0, 0, 1, 1, 1, 0, 0, 1,
0, 0, 0, 0);


CREATE TABLE IF NOT EXISTS `habilidadesDeClases`
(
	`codHabilidadDeClase` int(3) NOT NULL PRIMARY KEY auto_increment,
    `nombre` varchar(40) NOT NULL,
    `ex` BOOL NOT NULL,
    `descripcion` TEXT NOT NULL,
    `objeto` TEXT,
    `nombreClase` varchar(40) NOT NULL
)
ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO `habilidadesDeClases` (`nombre`,`ex`,`descripcion`,`objeto`, `nombreClase`) 
VALUES 
('Movimiento rápido', 1, 'La velocidad terrestre de un bárbaro es mayor que la normal de su raza en +10 pies(3m), beneficio que sólo se aplica cuando no lleva armadura, o lleva armadura ligera o intermedia, y no lleva una carga pesada', '', 'Bárbaro'),
('Esquiva Asombrosa', 1, 'Un bárbaro con esta dote no puede ser sorprendido. No pierde su bonificador de CA si su atacante es invisible. La pierde si es inmovilizado', '', 'Bárbaro'),
('Sentido de las trampas', 1, 'El bárbaro obtiene un bonificador +1 a las salvaciones de Reflejos para evitar trampas, y un bonificador +1 por esquiva a la CA contra ataques de trampa.', '', 'Bárbaro'),
('Conocimiento de bardo', 1, 'Un bardo suma la mitad de su nivel de clase (mínimo 1) a todas las pruebas de Saber, y puede llevar a cabo todas las pruebas de Saber sin estar entrenado.', '', 'Bardo'),
('Interpretacion versatil', 1, 'Un bardo puede escoger un tipo de habilidad de Interpretacion, y utilizar su bonificador en dicha habilidad en lugar de su bonificador en las habilidades.', '', 'Bardo'),
('Aura', 1, 'Un clérigo  de un dios caótico, maligno, bueno o legal, tiene un aura particularmente poderosa que corresponde al alineamiento del dios', '', 'Clérigo');

CREATE TABLE IF NOT EXISTS `personajeObjetos`
(
	`codPersonaje` int(255) NOT NULL,
    `codObjeto` int(255) NOT NULL,
    `cantidad` int(3) NOT NULL,
    PRIMARY KEY(`codObjeto`,`codPersonaje`)
)
ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO `personajeObjetos` (`codPersonaje`,`codObjeto`,`cantidad`) 
VALUES 
(1, 1, 3),
(1, 4, 2),
(1, 5, 1),
(1, 6, 2),
(1, 7, 1),
(1, 8, 2),
(2, 1, 4),
(2, 2, 2),
(2, 3, 1),
(2, 5, 3),
(2, 6, 5),
(2, 7, 1),
(2, 8, 2),
(2, 10, 1),
(3, 1, 1),
(3, 3, 1),
(3, 4, 2),
(3, 5, 1),
(3, 8, 2),
(3, 9, 1),
(3, 10, 2);

CREATE TABLE IF NOT EXISTS `personajeArmas`
(
	`codPersonaje` int(255) NOT NULL,
    `codArma` int(255) NOT NULL,
    `cantidad` int(3) NOT NULL,
    PRIMARY KEY(`codArma`,`codPersonaje`)
)
ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO `personajeArmas` (`codPersonaje`,`codArma`,`cantidad`) 
VALUES 
(1, 5, 2),
(1, 2, 1),
(2, 5, 1),
(2, 6, 3),
(3, 7, 1),
(3, 8, 2),
(3, 9, 1),
(3, 10, 1);

CREATE TABLE IF NOT EXISTS `personajeArmaduras`
(
	`codPersonaje` int(255) NOT NULL,
    `codArmadura` int(255) NOT NULL,
    `cantidad` int(3) NOT NULL,
    PRIMARY KEY(`codArmadura`,`codPersonaje`)
)
ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO `personajeArmaduras` (`codPersonaje`,`codArmadura`,`cantidad`) 
VALUES 
(1, 1, 1),
(1, 2, 2),
(1, 6, 1),
(2, 3, 1),
(2, 4, 4),
(3, 5, 1);

CREATE TABLE IF NOT EXISTS `personajeDotes`
(
	`codPersonaje` int(255) NOT NULL,
    `codDote` int(3) NOT NULL,
    PRIMARY KEY(`codDote`,`codPersonaje`)
)
ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO `personajeDotes` (`codPersonaje`, `codDote`) 
VALUES 
(1, 2),
(1, 4),
(1, 1),
(2, 3),
(2, 5),
(2, 4),
(2, 7),
(3, 1),
(3, 8),
(3, 6);

CREATE TABLE IF NOT EXISTS `clasesHabilidadesDeClases`
(
	`codClase` int(3) NOT NULL,
    `codHabilidadDeClase` int(3) NOT NULL,
    PRIMARY KEY(`codClase`,`codHabilidadDeClase`)
)
ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO `clasesHabilidadesDeClases` (`codClase`,`codHabilidadDeClase`)
VALUES 
(1, 1),
(1, 2),
(1, 3),
(2, 4),
(2, 5),
(3, 6);

CREATE TABLE IF NOT EXISTS `personajeHechizos`
(
	`codPersonaje` int(255) NOT NULL,
    `codHechizo` int(3) NOT NULL,
    PRIMARY KEY(`codHechizo`,`codPersonaje`)
)
ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO `personajeHechizos` (`codPersonaje`,`codHechizo`) 
VALUES 
(1, 1),
(1, 4),
(3, 2);

CREATE TABLE IF NOT EXISTS `usuario`
(
	`codUsuario` int(255) NOT NULL AUTO_INCREMENT,
	`nombre` varchar(20) NOT NULL,
    `pass` varchar(20) NOT NULL,
    PRIMARY KEY (`codUsuario`)
)ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO `usuario` (`nombre`,`pass`) 
VALUES 
('root', ''),
('dani', 'barba');












