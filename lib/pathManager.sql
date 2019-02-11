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
    `conociemientoDeConjuros` int(3)  NOT NULL,
    `curar` int(3)  NOT NULL,
    `diplomacia` int(3)  NOT NULL,
    `disfrazarse` int(3)  NOT NULL,
    `engañar` int(3)  NOT NULL,
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
    `clase` varchar(40) NOT NULL
) 
ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO `personaje` (`codPersonaje`,`nombre`,`apellidos`,`alineamiento`,`religion`,`genero`,`ptsGolpe`,`idiomas`,
`nivel`, `edad`, `altura`, `peso`, `cabello`, `ojos`, `pc`, `pp`, `po`, `ppr`, `fuerza`, `destreza`, `constitucion`, `inteligencia`, `sabiduria`, `carisma`,
`acrobacias`,`artesania1`,`artesania1Nombre`,`artesania2`,`artesania2Nombre`,  
`artesania3`,`artesania3Nombre`,`averiguarIntenciones`,`conociemientoDeConjuros`,`curar`,`diplomacia`,`disfrazarse`,`engañar`,`escapismo`,
`interpretar1`,`interpretar1Nombre`,`interpretar2`,`interpretar2Nombre`,`intimidar`,`inutilizarMecanismo`,`juegoDeManos`,`linguistica`,
`montar`,`nadar`,`percepcion`,`profesion1`,`profesion1Nombre`,`profesion2`,`profesion2Nombre`,`saberArcano`,`saberDungeons`,`saberGeografia`,
`saberHistoria`,`saberIngenieria`,`saberLocal`,`saberNaturaleza`,`saberNobleza`,`saberPlanos`,`saberReligion`,`sigilo`,`supervivencia`,`tasacion`,
`tratoConAnimales`,`trepar`,`usarObjetoMagico`,`volar`,
`raza`, `clase`) 
VALUES 
(1, 'Caladrel', 'Fëanor', 'CN', 'Nethys', 'Hombre', 14, 'Común, Elfo, Celestial, Abisal, Draconico, Abisal',
3, 165, 185, 72, 'Rubio', 'Azules', 0, 5, 136, 0, 11, 17, 11, 19, 14, 10,
3, 4, 'Panadero', 2, 'Agricultor',
3, '-', 1, 4, 2, 1, 0, 0, 2, 
0, '-', 0, '-', 0, 1, 1, 10,
0, 0, 5, 3, 'Escritor', 0, '-', 4, 4, 4, 
4, 4, 4, 4, 4, 4, 4, 2, 0, 0, 
0, 0, 4, 3, 
'Elfo', 'Bardo'),
(2, 'Adolfito', 'Vendetta', 'LB', 'JesuCristo', 'Mujer', 23, 'Común y Enano',
4, 40, 154, 84, 'Moreno', 'Verde', 4, 17, 157, 0, 10, 15, 11, 12, 12, 14,
2, 3, 'Adobe', 1, '-',
0, '-', 1, 2, 3, 2, 1, 0, 2, 
0, '-', 0, '-', 0, 1, 2, 3,
0, 2, 1, 2, 'Lector', 0, '-', 4, 4, 4, 
4, 2, 0, 0, 0, 0, 0, 0, 1, 0, 
0, 1, 2, 3, 
'Enano', 'Bárbaro');

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
('Elfo',0,2,-2,2,0,0,0,'Mediano','30 pies/9 m/6 casillas','Común, Elfo','Celestial, Dracónico, Goblin, Gnoll, Gnomo, Orco, Silvano', 'Vision en la penumbra, Magia Elfica, Sentidos Agudos, Familiaridad con Arcos largos, Espadas largas, Espadas roperas, Arcos Cortos y cualquier arma con la palabra "élfico".'),
('Enano', 0,0,2,0,2,-2,0, 'Mediano', '20 pies/6 m/4 casillas', 'Común, Enano','Gigante, Gnomo, Goblin, Infracomún, Orco, Térraro', 'Visión en la oscuridad, Entrenamiento defensivo, Avaricia, Odio, Resistencia, Estabilidad, Afinidad de la piedra, Familiaridad con las armas: Hachas de batalla, picos pesados, martillos de guerra y cualquier arma con la palabra "enano".'),
('Gnomo',-2,0,2,0,0,2,0,'Pequeño', '20 pies/6 m/4 casillas', 'Común, Gnomo, Silvano', 'Dracónico, Elfo, Enano, Gigante, Goblin, Orco', 'Visión en la penumbra, Entrenamiento defensivo, Magia de los Gnomos, Odio, Resistencia a la ilusión, Sentidos Agudos, Obsesivo, Familiaridad con las armas: cualquier arma con la palabra "Gnomo".');

CREATE TABLE IF NOT EXISTS `objetos`
(
	`codObjeto` int(255) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `nombre` varchar(30) NOT NULL,
    `peso` int(4) NOT NULL,
    `magico` BOOL NOT NULL,
    `descripcion` TEXT NOT NULL
)
ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO `objetos` (`codObjeto`,`nombre`,`peso`,`magico`,`descripcion`) 
VALUES 
(1,'Abrojos', '2 libras(900g)', 0, 'Pequeñas puas metalicas que tiran al suelo.'),
(2,'Aceite(1 pinta[0,5L])', '1 libra(450g)', 0, 'Una pequeña botella de aceite de multiples usos.'),
(3,'Aguja de costura', '-', 0, 'Una pequeña aguja utilizada para la costura.');


CREATE TABLE IF NOT EXISTS `armas`
(
	`codArma` int(255) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `nombre` varchar(30) NOT NULL,
    `peso` int(4) NOT NULL,
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

INSERT INTO `armas` (`codArma`,`nombre`,`peso`,`magico`,`descripcion`,`dannoP`,`dannoM`,`critico`,`rango`,`tipo`,`especial`) 
VALUES 
(1, 'Guantelete', '1 libra(450g)', 0, 'Guante considerado como ataque sin arma', '1d2', '1d3', 'x2', '-', 'Con', '-'),
(2,'Impacto sin armas', '-', 0, 'Ataque con las manos desnudas', '1d2', '1d3', 'x2', '-', 'Con', 'No letal'),
(3,'Daga', '1 libra(450g)', 0, 'Pequeño cuchillo utilizado por asesinos y picaros', '1d3', '1d4', '19-20/x2', '10 pies(3m)', 'Per o Cor', '-');

CREATE TABLE IF NOT EXISTS `armaduras`
(
	`codArmadura` int(255) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `nombre` varchar(30) NOT NULL,
    `bonificador` int(4) NOT NULL,
    `peso` int(4) NOT NULL,
    `magico` BOOL NOT NULL,
    `descripcion` TEXT NOT NULL,
    `velocidad` varchar(30) NOT NULL,
    `dexBonus` int(2),
    `penalizacion` int(2),
    `falloHechizo` int(3)
)
ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO `armaduras` (`codArmadura`,`nombre`,`bonificador`,`peso`,`magico`,`descripcion`,`velocidad`,`dexBonus`,`penalizacion`,`falloHechizo`) 
VALUES 
(1,'Acolchada', 1,'10 libras(4,5kg)', 0, 'Armadura ligera basica. Poco más que ropa gruesa y acolchada.', '30 pies(9m) / 20 pies(6m)', 8, 0, 5),
(2,'Cuero', 2, '15 libras(6,8kg)', 0, 'Armadura ligera. Hecha con trozos de cuero hervido, cuidadosamente cosidos.', '30 pies(9m) / 20 pies(6m)', 6, 0, 10),
(3,'Cuero tachonado', 3, '20 libras(9kg)', 0, 'Armadura ligera. Similar a la de cuero pero con pequeños trozos de metal.', '30 pies(9m) / 20 pies(6m)', 5, -1, 15);

CREATE TABLE IF NOT EXISTS `dotes`
(
	`nombre` varchar(40) NOT NULL PRIMARY KEY,
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
 el bonificador se incrementa a +4 para dicha habilidad.', '', '', 'Eres hábil trabajando con animales y con monturas.', '');

CREATE TABLE IF NOT EXISTS `hechizos`
(
	`nombre` varchar(40) NOT NULL PRIMARY KEY,
    `escuela` varchar(20) NOT NULL,
    `tiempoCasteo` varchar(20) NOT NULL,
    `componentes` TEXT NOT NULL,
    `descripcion` TEXT NOT NULL,
    `rango` varchar(30) NOT NULL,
    `objetivo` varchar(30),
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
como una frase corta, o tan elaborado como una rima cr´ptica o un presagio. Si tu grupo no actúa basándose en la información, 
las condiciones pueden cambiar e invalidarla. La probabilidad base de llevar a cabo una adivinación correcta es del 70% + 1 % por nivel de lanzador. 
Si la tirada falla eres consciente de que el conjuro ha fracasado, a no ser que haya una magia concreta que te facilite respuestas falsas.', 
'personal', 'Tú', '', 'instantanea', '', '', -1, -1, 4, -1, -1, -1, -1, -1, -1, -1, -1),
('Alineamiento Indetectable', 'Abjuracion', '1 acción estandar', 'V,S', 'Este conjuro oculta el alineamiento de un 
objeto o criatura de toda forma de adivinación.','Corto(25 pies [7,5m] + 5 pies[1,5m]/2 niveles)', '1 criatura u objeto', '', '24 horas',
'Voluntad niega(Objeto)', 'Sí(Objeto)', -1, 1, 2, -1, -1, -1, -1, 2, -1, -1, -1);

CREATE TABLE IF NOT EXISTS `clases`
(
	`nombre` varchar(40) NOT NULL PRIMARY KEY,
    `alineamiento` varchar(20) NOT NULL,
    `rol` TEXT NOT NULL,
    `dadoDeGolpe` varchar(20) NOT NULL,
    `rangoPorNivel` varchar(20) NOT NULL,
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
    `conociemientoDeConjuros` BOOL NOT NULL,
    `curar` BOOL NOT NULL,
    `diplomacia` BOOL NOT NULL,
    `disfrazarse` BOOL NOT NULL,
    `engañar` BOOL NOT NULL,
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
`artesania3`,`artesania3Nombre`,`averiguarIntenciones`,`conociemientoDeConjuros`,`curar`,`diplomacia`,`disfrazarse`,`engañar`,`escapismo`,
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
	`nombre` varchar(40) NOT NULL PRIMARY KEY,
    `ex` BOOL NOT NULL,
    `descripcion` TEXT NOT NULL,
    `objeto` TEXT,
    `nombreClase` varchar(40) NOT NULL
)
ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO `habilidadesDeClases` (`nombre`,`ex`,`descripcion`,`objeto`, `nombreClase`) 
VALUES 
('Movimiento rápido', 1, 'La velocidad terrestre de un bárbaro es mayor que la normal de su raza en +10 pies(3m), beneficio que sólo se aplica cuando no lleva armadura, o lleva armadura ligera o intermedia, y no lleva una carga pesada', '', 'Bárbaro'),
('Conocimiento de bardo', 1, 'Un bardo suma la mitad de su nivel de clase (mínimo 1) a todas las pruebas de Saber, y puede llevar a cabo todas las pruebas de Saber sin estar entrenado.', '', 'Bardo'),
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
(1, 1, 1),
(1, 2, 2);

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
(1, 1, 1),
(1, 2, 1);

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
(1, 1, 1);

CREATE TABLE IF NOT EXISTS `personajeDotes`
(
	`codPersonaje` int(255) NOT NULL,
    `nombreDote` varchar(40) NOT NULL,
    PRIMARY KEY(`nombreDote`,`codPersonaje`)
)
ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO `personajeDotes` (`codPersonaje`,`nombreDote`) 
VALUES 
(1, 1);

CREATE TABLE IF NOT EXISTS `personajeHechizos`
(
	`codPersonaje` int(255) NOT NULL,
    `nombreHechizo` varchar(40) NOT NULL,
    PRIMARY KEY(`nombreHechizo`,`codPersonaje`)
)
ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO `personajeHechizos` (`codPersonaje`,`nombreHechizo`) 
VALUES 
(1, 'Abrir/Cerrar');

CREATE TABLE IF NOT EXISTS `usuario`
(
	`id` int(255) NOT NULL AUTO_INCREMENT,
	`nombre` varchar(20) NOT NULL,
    `pass` varchar(20) NOT NULL,
    PRIMARY KEY (`id`)
)ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO `usuario` (`id`,`nombre`,`pass`) 
VALUES 
(1, 'root', ''),
(2, 'dani', 'barba');

CREATE TABLE IF NOT EXISTS `usuarioPersonaje`
(
	`codPersonaje` int(255) NOT NULL,
    `id` int(255) NOT NULL,
    PRIMARY KEY (`id`, `codPersonaje`)
)ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;










