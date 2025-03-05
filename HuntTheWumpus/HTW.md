Este fue mi primer proyecto grande en java. Los requerimientos dados por el profesor:

Hunt the Wumps FJ 2023

Wumpus vive en un laberinto de cavernas. 

La caverna 0 es el campamento. El jugador inicia en el campamento.

El jugador se moverá por turnos,  en cada turno la pantalla mostrará las cavernas que están conectadas a la caverna donde se encuentra el jugador.

----------------------------------------------------

Estás en la caverna 0 (Campamento)

Tienes 50 de oxígeno

Hay salidas hacia: 20, 23, 2

¿A donde quieres ir? 20

----------------------------------------------------

Estás en la caverna  20

Tienes 49 de oxígeno

Se escucha el sonido de un río.

Hay salidas hacia: 0, 3, 13, 17, 23

¿A donde quieres ir?

----------------------------------------------------

 

Cada caverna está conectada bidireccionalmente con al menos 3 otras cavernas.

Cuando se cree el mundo si una caverna se conecta con otra, la otra debe conectarse con la una.

 

El jugador podrá moverse a través de las cavernas seleccionando el número de la caverna a la cual se quiera mover, en caso de que no haya camino, no se puede mover.

El jugador tendrá un marcador de oxígeno, cada vez que se mueva disminuirá la cantidad de oxígeno que le queda.

 

Objetivo del juego es: Atrapar a Wumpus y regresar al campamento antes de morir.

 

En las cavernas puede haber diferentes NPCs

1.- Wumpus: Al llegar a la casilla donde está Wumpus automáticamente el jugador lo atrapa.

2.- Agua: Al llegar a una casilla con agua, el oxígeno baja en 3.

3.- Tanque de oxígeno: Al pasar la primera vez por un tanque de oxígeno, tu oxígeno sube 15.

4.- Pozo sin fondo: Automáticamente pierdes.

5.- Murciélago gigante: Te mueve a una casilla al azar.

Si regresa al campamento sin haber atrapado a Wumpus se reinicia el oxígeno.

 

Alertas

En el caso de que el jugador se encuentre en una caverna adyacente a Wumpus, Agua o Pozo, el programa tendrá que avisarle al jugador.

Wumpus: Huele a Wumpus.

Agua: Se escucha el sonido de un río.

Pozo: Se siente frío.

Murciélago: Se escucha el aleteo de un animal.

 

Niveles

1: Oxígeno=50,  Cavernas = 20, Agua = 1, Tanque= 3, Pozo = 1, Murciélago = 2;

2: Oxígeno=45,  Cavernas = 30, Agua = 2, Tanque= 2, Pozo = 2, Murciélago = 6;

3: Oxígeno=40,  Cavernas = 40, Agua = 4, Tanque= 1, Pozo = 3, Murciélago = 8;

4: Oxígeno=30,  Cavernas = 50, Agua = 8, Tanque= 1, Pozo = 4, Murciélago = 10;

 

Cada vez que pase un turno la pantalla se limpiará.
