# Arrays de Objetos en Java
## Laboratorio: Pokedex de Monstruos

### Objetivos

Al finalizar este laboratorio serás capaz de:

- Crear objetos.
- Almacenar objetos en un arreglo.
- Recorrer arreglos de objetos.
- Buscar elementos.
- Calcular máximos y mínimos.
- Realizar conteos y acumulaciones.
- Diseñar una clase que encapsule una colección.

### Consigna:

#### Se desea desarrollar un programa para administrar una colección de monstruos de un videojuego.

## Clase `Monstruo`

Implementar la clase `Monstruo` con los siguientes atributos:

* `nombre` (`String`)
* `tipo` (`String`)
* `puntosVida` (`int`)
* `capturado` (`boolean`)

La clase debe incluir:

* Constructor.
* Getters.
* Método `toString()`.

## Teoría:

Un arreglo de objetos no almacena los objetos directamenteo, sino referencias a esos objetos. 

Por ejemplo:

```java
Monstruo[] monstruos = new Monstruo[8];
```

crea espacio para almacenar referencias a 8 monstruos.

#### Pregunta: 

¿Que hay en cada una de las 8 posiciones del arreglo monstruos, luego de ejecutar la linea que se encuantra mas arriba?


## Clase `Pokedex`

Encapsularemos la colección dentro de una clase Pokedex. Usamos un arreglo de monstruos para construir una instancia de Bestiario.

Implementar una clase `Pokedex` que almacene una colección de monstruos.

### Atributo

```java
private Monstruo[] monstruos;
```

### Constructor

```java
public Pokedex(Monstruo[] monstruos)
```

El constructor recibe el array de monstruos y lo almacena en la pokedex.


## Datos de prueba

Utilizar el siguiente array para realizar las pruebas:

```java
Monstruo[] monstruos = {
    new Monstruo("Drako", "Fuego", 120, true),
    new Monstruo("Aquar", "Agua", 90, false),
    new Monstruo("Terron", "Tierra", 150, true),
    new Monstruo("Voltix", "Electrico", 110, false),
    new Monstruo("Frost", "Hielo", 80, true),
    new Monstruo("Shadow", "Oscuridad", 200, true),
    new Monstruo("Leafy", "Planta", 70, false),
    new Monstruo("Zephyr", "Aire", 130, true)
};

Pokedex pokedex = new Pokedex(monstruos);
```

#### Pregunta:

¿Que es lo que realmente recibe el constructor como parámetro de inicialización?


## Métodos a implementar

### 1. Mostrar todos los monstruos

```java
public void mostrarMonstruos()
```

Muestra la información de todos los monstruos de la colección.


### 2. Buscar un monstruo por nombre

```java
public Monstruo buscarPorNombre(String nombre)
```

Devuelve el monstruo cuyo nombre coincide con el recibido por parámetro.

Si no existe, devuelve `null`.


### 3. Contar monstruos capturados

```java
public int contarCapturados()
```

Devuelve la cantidad de monstruos capturados.


### 4. Obtener el monstruo con más puntos de vida

```java
public Monstruo monstruoMasFuerte()
```

Devuelve el monstruo que tiene la mayor cantidad de puntos de vida.


### 5. Obtener el monstruo con menos puntos de vida

```java
public Monstruo monstruoMasDebil()
```

Devuelve el monstruo que tiene la menor cantidad de puntos de vida.


### 6. Calcular el promedio de puntos de vida

```java
public double promedioVida()
```

Devuelve el promedio de puntos de vida de todos los monstruos de la colección.


### 7. Mostrar los monstruos de un tipo

```java
public void mostrarMonstruosDeTipo(String tipo)
```

Muestra todos los monstruos cuyo tipo coincide con el recibido por parámetro.


### 8. Verificar si existe algún monstruo capturado

```java
public boolean hayCapturados()
```

Devuelve `true` si existe al menos un monstruo capturado y `false` en caso contrario.


## Desafío extra

Implementar el siguiente método:

```java
public Monstruo[] monstruosCapturados()
```

Devuelve un nuevo array que contenga únicamente los monstruos capturados.


## Resultados esperados para verificar la implementación

Con los datos de prueba proporcionados:

* Cantidad de monstruos capturados: **5**
* Monstruo más fuerte: **Shadow (200 puntos de vida)**
* Monstruo más débil: **Leafy (70 puntos de vida)**
* Promedio de vida: **118.75**
* `hayCapturados()` debe devolver **true**
* `buscarPorNombre("Voltix")` debe devolver el monstruo correspondiente.
* `buscarPorNombre("Pikachu")` debe devolver **null**.

[Ver solucíón de Pokédex en GitHub](https://github.com/leoblautzik/AyP1-CUDI-ejercicios-resueltos/tree/main/workspace-ayp1-2026/GARR1/src/pokedesk)

```java
/**
* FIN
*/
```
