# Respositorio resumen del curso de git avanzado (versi�n para Java / Eclipse)

Este repositorio contiene un resumen de parte de los pasos que damos durante el curso avanzado de git para entender qu� es un commit, qu� es una rama y c�mo funcionan los repositorios remotos.

Tiene como objetivo que aquellas personas que asistieron al curso recuerden los pasos que dimos para explicar algunos de los conceptos m�s importantes como:

* Qu� ocurre cuando hacemos un commit
* Una rama no es un contenedor de commits
* Qu� es un merge que se resuelve mediante fast-forward
* Qu� es un merge commit y cu�ndo se produce una bifurcaci�n en la estructura de datos en la que git almacena los commits del repositorio.

En los comentarios de los commits de este respositorio encontrar�is informaci�n detallada de los pasos que fuimos dando para desarrollar el proyecto.

## C�digo fuente

Con objeto de agilizar el desarrollo del curso, y no emplear m�s tiempo del necesario en programar (el objetivo del curso no es programar en Java sino aprender git) 
ten�is a vuestra disposici�n una serie de fragmentos de c�digo (gists) que pod�is utilizar para copiar y pegar el c�digo que utilizamos durante el curso:

* Los primeros commits commits que hacemos antes de pasar a usar ramas realizan cambios en el c�digo que son muy sencillos y no tienen un fragmento de c�digo asociado
* La primera rama: [mostrar_tweets]
  * commit 1: [Obtener del info de autenticaci�n de Twitter](https://gist.github.com/aalbagarcia/4d3916bb3acf9f4c7550a9b03e8478c6)
  * commit 2: Convertir el proyecto a Maven (sin frangemnto de c�digo)
  * commit 3: [Extraer token de la respuesta JSN](https://gist.github.com/aalbagarcia/1fc9736e73a19ff29d59ae21d7fff36e)
  * commit 4: [Muestra los tweeets por pantalla](https://gist.github.com/aalbagarcia/8ecaf92168264ed2336ba319cb39383e)
* Cambio de contexto:
  * Rama argumentos commit 1: [Pasa usuario de twitter como argumento](https://gist.github.com/aalbagarcia/49872a195fe89913f11df17d3d1c8c7c)
  * Rama fecha_tweets commit 1: [Muestra la fecha de los tweets en la consola](https://gist.github.com/aalbagarcia/8b82b2c9186722acb8f9f07c5551dd41)
  * Rama argumentos commit 2: Integraci�n de la rama master (sin fragmento de c�digo)
  * Rama argumentos commit 3: [Muestra error si no se pasa un argumento](https://gist.github.com/aalbagarcia/017d7bc68c7deac0ee88fd61d058908b)
* Repositorios remotos:
  * Rama colores commit 1: [Muestra error en color rojo](https://gist.github.com/aalbagarcia/f4eb238e6490dc423733e4a04cf2ca7e)
  * Rama master commit 1: C�digo subido por nuestros compa�eros (simulado desde interfaz web, sin fragmento de c�digo)
  * Rama colores commit 2: [Muestra mensaje en color verde](https://gist.github.com/aalbagarcia/b2981d12f782404fb01676e1ae3d869b)
* Resoluci�n de conflictos:
  * Rama refactoring commit 1: [Extrae la clase Connection](https://gist.github.com/aalbagarcia/1dc0c48b1bd49c55f84b74ef69c39480)
  * Rama master: [A�ade colores a los tweets por consola](https://gist.github.com/aalbagarcia/b481752ee086d9e432e993cd5b29e620)
  * Rama refactoring commit 2: [Extrae la clase Client y el m�todo displayTweets](https://gist.github.com/aalbagarcia/787f6e464bf9bbdd93b1343445bb9f96)
  * Al hacer la integraci�n de la rama refactoring en la rama master, tendremos un conflictos.
* Integraci�n cont�nua:
  * Rama master: a�adimos al repositorio un �ltimo commit con un primer test cuya ejecuci�n
    queremos automatizar: [A�ade test unitario para la clase Client](https://gist.github.com/aalbagarcia/4c61d49328acfd776ef2695d2cb925b0)  
## Software utilizado

Para poder seguir los pasos que damos en este repositorio es necesario instalar Eclipse.
