# Juego-de-Naipes

# Truco Simplificado - Juego de Cartas Españolas

## Integrantes del equipo

- Lautaro Mejias
- Elias Perez
- Uriel Vega

---

## Descripción del proyecto

Este proyecto consiste en la implementación de un juego de Truco Simplificado utilizando Java y Programación Orientada a Objetos.

La aplicación reutiliza la estructura desarrollada previamente para representar una baraja española, utilizando clases como:

- Carta
- Palo
- Baraja
- Jugador

Sobre esta base se agregó la lógica necesaria para simular una partida simple de Truco por consola.

El objetivo es aplicar conceptos de POO como:
- Clases y objetos.
- Encapsulamiento.
- Separación de responsabilidades.
- Uso de ArrayList.
- Reutilización de código.

---

# Juego elegido

## Truco Simplificado

El juego consiste en una partida entre dos jugadores utilizando una baraja española de 40 cartas.

En esta versión se implementan las reglas principales del Truco, pero se excluye la etapa de **Envido**.

---

# Reglas del juego

## Preparación

- Se utiliza una baraja española de 40 cartas.
- Se mezclan las cartas antes de comenzar.
- Cada jugador recibe 3 cartas.
- Los jugadores juegan una carta por turno.

---

# Orden de las cartas

Para determinar el ganador de cada ronda se utiliza el siguiente orden simplificado:

1. As de Espada
2. As de Basto
3. Siete de Espada
4. Siete de Oro
5. Tres
6. Dos
7. Uno de oro y copa
8. Doce
9. Once
10. Diez
11. Siete de basto y copa
12. Seis
13. Cinco
14. Cuatro

Las cartas con mayor valor ganan contra las de menor valor.

---

# Desarrollo de la partida

Una partida está formada por hasta 3 rondas.

En cada ronda:

1. Cada jugador coloca una carta.
2. Se comparan las cartas jugadas.
3. El jugador con la carta de mayor valor gana la ronda.

---

# Determinación del ganador

- El jugador que gana más rondas gana la partida.
- Si un jugador gana 2 de las 3 rondas, se considera ganador.

---