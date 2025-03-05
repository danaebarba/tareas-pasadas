Requerimientos:

Proyecto: La Vaca - Adivina el Animal
Objetivo:
El objetivo de "La Vaca" es desarrollar un programa interactivo que, mediante el uso de árboles de decisión y recursión, adivine el animal en el que el usuario está pensando. El programa aprenderá con cada interacción, mejorando su capacidad de adivinanza.

Descripción:
El programa comenzará con una pregunta principal: "¿El animal tiene cuernos?". Si la respuesta es afirmativa, el programa adivinará que el animal es una vaca; de lo contrario, adivinará que el animal es un gato. En caso de error, el programa solicitará al usuario que indique qué animal estaba pensando y cuál es la diferencia con el animal adivinado.

Funcionalidades Clave:
Adivinanza Inicial:

La pregunta inicial será: "¿El animal tiene cuernos?".
Si la respuesta es sí, se adivinará que es una vaca; de lo contrario, se adivinará que es un gato.
Proceso de Aprendizaje:

Si el programa no acierta, preguntará al usuario qué animal era y cuál es la diferencia con el animal adivinado.
Agregará esta información como un nuevo nodo hijo del nodo hoja anterior.
Recursión:

Utilizará la recursión para hacer preguntas y avanzar a través del árbol de decisiones.
Implementación:
Estructura del Árbol:

Nodo raíz: "¿El animal tiene cuernos?"
Si la respuesta es sí, nodo hoja: "Vaca".
Si la respuesta es no, nodo hoja: "Gato".
Nodos adicionales para el proceso de aprendizaje.
Interfaz de Usuario:

Interfaz simple para la interacción del usuario y visualización de las preguntas y respuestas.
Proceso de Aprendizaje:

Implementar la lógica para aprender de las interacciones y mejorar el árbol de decisiones.
