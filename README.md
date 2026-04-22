# Clase 01: Fundamentos de Java — Tipos de Datos, Memoria e I/O

Este repositorio contiene los ejemplos y ejercicios prácticos de la sesión inicial de Java,
enfocada en entender cómo el lenguaje gestiona la información, la memoria y la interacción
con el usuario.

---

## Temas Tratados

### 1. Variables y Tipos de Datos


Una variable es un espacio de memoria que almacena un dato durante la ejecución del programa.
En Java **toda variable debe declararse indicando su tipo y su nombre** antes de usarse.
Los tipos se dividen en dos grandes grupos:

| Grupo | Ejemplos | Almacena |
|---|---|---|
| **Primitivos** | `int`, `double`, `boolean`, `char`, `byte`, `short`, `long`, `float` | El valor directamente |
| **Referencia** | `String`, arrays, objetos propios | Una dirección de memoria (referencia) |

Java garantiza que cada tipo primitivo ocupa **el mismo tamaño en todas las plataformas**
(ej. `int` siempre 32 bits), lo que asegura portabilidad frente a C/C++.

**Tabla de tipos primitivos**

| Tipo | Categoría | Tamaño | Valor por defecto | Rango / Notas |
|---|---|---|---|---|
| `boolean` | Lógico | 8 bits | `false` | `true` / `false` |
| `char` | Carácter | 16 bits | `'\0'` | Unicode |
| `byte` | Entero | 8 bits | `0` | −128 a 127 |
| `short` | Entero | 16 bits | `0` | −32 768 a 32 767 |
| `int` | Entero | 32 bits | `0` | −2 147 483 648 a 2 147 483 647 |
| `long` | Entero | 64 bits | `0` | ±9 × 10¹⁸ — agregar `L` al literal |
| `float` | Flotante | 32 bits | `0.0` | ±3.4 × 10³⁸ — agregar `f` al literal |
| `double` | Flotante | 64 bits | `0.0` | ±1.79 × 10³⁰⁸ |

> Los valores por defecto aplican solo a **variables de instancia o de clase**,
> no a variables locales (deben inicializarse explícitamente).

**Ejemplos:**

```java
boolean esEstudiante = true;
char    inicial      = 'J';
byte    edadMinima   = 18;
short   anio         = 2025;
int     dni          = 12345678;
long    poblacion    = 8_000_000_000L;
float   temperatura  = 36.6f;
double  salario      = 150_000.75;

final double PI = 3.14159; // constante: no puede cambiar después de asignarse
```

---

### 2. Gestión de Memoria


Java gestiona la memoria de forma automática a través de dos zonas principales:

| Zona | Qué almacena | Ciclo de vida |
|---|---|---|
| **Stack** (pila) | Variables locales y primitivos | Se libera al salir del bloque `{}` donde fue declarada |
| **Heap** (montón) | Objetos creados con `new` | Se libera cuando el **Garbage Collector** detecta que ya no hay referencias |

El **Garbage Collector** es el mecanismo automático de Java que elimina objetos
sin referencias activas, evitando fugas de memoria sin intervención del programador.

```java
// Stack: el valor 10 vive en la pila
int x = 10;

// Heap: el objeto String vive en el heap; "nombre" guarda una referencia
String nombre = new String("Juan");

// Cuando "nombre" deja de apuntar al objeto, el GC puede liberarlo
nombre = null;
```

**Valores por defecto (variables de instancia)**

```java
int     numero;   // → 0
boolean flag;     // → false
char    letra;    // → '\0'
String  texto;    // → null   (referencia a ningún objeto)
```

---

### 3. Primitivos vs. Objetos (Wrappers)


Cada tipo primitivo tiene una **clase de envoltura (Wrapper)** en `java.lang`
que lo convierte en objeto, habilitando el uso en colecciones y APIs que requieren objetos.

| Primitivo | Wrapper |
|---|---|
| `int` | `Integer` |
| `double` | `Double` |
| `boolean` | `Boolean` |
| `char` | `Character` |
| `long` | `Long` |

**Diferencias clave**

| Aspecto | Primitivo | Objeto / Wrapper |
|---|---|---|
| Almacenamiento | Stack (valor directo) | Heap (referencia) |
| Puede ser `null` | ❌ No | ✅ Sí |
| Métodos propios | ❌ No | ✅ Sí (ej. `Integer.parseInt()`) |
| Rendimiento | Mayor | Menor (overhead de objeto) |

**Autoboxing / Unboxing** — Java convierte automáticamente entre primitivo y Wrapper:

```java
Integer wrapperEdad = 25;    // autoboxing:   int  → Integer
int     edadPrimitiva = wrapperEdad; // unboxing: Integer → int
```

---

### 4. La Clase String


`String` es un tipo de referencia **especial** en Java:

- Los objetos `String` son **inmutables**: ninguna operación modifica el original;
  siempre devuelve una nueva cadena.
- Java mantiene un **pool de Strings** en el heap: los literales idénticos comparten
  la misma instancia para ahorrar memoria.
- Para comparar contenido se usa `equals()`, **no** `==`
  (que compara referencias, no valores).

```java
String a = "hola";
String b = "hola";
System.out.println(a == b);      // true  (misma referencia del pool)
System.out.println(a.equals(b)); // true  (mismo contenido) ← usar siempre esto
```

**Métodos principales**

| Método | Descripción |
|---|---|
| `length()` | Cantidad de caracteres |
| `charAt(i)` | Carácter en la posición `i` (base 0) |
| `substring(a, b)` | Subcadena entre índices `a` (incluido) y `b` (excluido) |
| `toUpperCase()` / `toLowerCase()` | Conversión de mayúsculas/minúsculas |
| `trim()` | Elimina espacios al inicio y al final |
| `contains(s)` | Indica si contiene la subsecuencia `s` |
| `replace(a, b)` | Reemplaza todas las ocurrencias de `a` por `b` |
| `equals(o)` | Compara contenido (no referencia) |
| `split(regex)` | Divide la cadena y devuelve un `String[]` |
| `indexOf(c)` | Posición de la primera ocurrencia de `c` |
| `startsWith(s)` / `endsWith(s)` | Verifica prefijo / sufijo |
| `isEmpty()` | `true` si la longitud es 0 |
| `concat(s)` | Concatena `s` al final |

**Ejemplos:**

```java
String nombre  = "  Juan Pérez  ";
String limpio  = nombre.trim();          // "Juan Pérez"
String mayus   = limpio.toUpperCase();   // "JUAN PÉREZ"
int    largo   = limpio.length();        // 10
char   primera = limpio.charAt(0);       // 'J'
String parte   = limpio.substring(5, 9); // "Pére"

String csv    = "rojo,verde,azul";
String[] cols = csv.split(",");          // ["rojo", "verde", "azul"]
```

---

### 5. Arreglos Estáticos (Arrays)


Un array es una estructura que almacena **múltiples elementos del mismo tipo**
bajo un único nombre de variable. En Java:

- Los arrays son **objetos** (viven en el heap).
- Su longitud es **fija** una vez creados con `new`.
- El índice comienza en **0** y el último es `length - 1`.
- Acceder a un índice fuera de rango lanza `ArrayIndexOutOfBoundsException`
  (a diferencia de C/C++, Java protege la memoria).

**Formas de declaración e inicialización**

```java
// Declaración recomendada
tipo[] nombreArray;

// a) Inicialización directa (tamaño implícito)
String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes"};

// b) Inicialización con new (tamaño explícito, valores por defecto)
int[] notas = new int[5];   // todos los elementos valen 0
notas[0] = 8;
notas[1] = 9;

// c) Arreglo bidimensional (matriz)
int[][] matriz = new int[3][4]; // 3 filas, 4 columnas
```

**Recorrido**

```java
// for clásico: permite acceder y modificar por índice
for (int i = 0; i < notas.length; i++) {
    System.out.println(notas[i]);
}

// for-each: más limpio, solo lectura
for (int nota : notas) {
    System.out.println(nota);
}
```

> El atributo `.length` (sin paréntesis) devuelve la cantidad de elementos del array.

---

### 6. Estructuras Condicionales


Permiten ejecutar distintos bloques de código según el valor de una expresión lógica.

| Estructura | Cuándo usarla |
|---|---|
| `if` | Una sola condición |
| `if-else` | Condición con alternativa |
| `if-else if-else` | Múltiples condiciones encadenadas |
| Operador ternario `?:` | Asignación condicional compacta |
| `switch` | Selección por valor exacto (`int`, `char`, `String`, etc.) |

**Ejemplos:**

```java
// if - else if - else
int nota = 8;
if (nota >= 9) {
    System.out.println("Sobresaliente");
} else if (nota >= 7) {
    System.out.println("Aprobado");
} else {
    System.out.println("Desaprobado");
}

// Operador ternario
String estado = (nota >= 7) ? "APROBADO" : "DESAPROBADO";

// switch
int dia = 3;
switch (dia) {
    case 1: System.out.println("Lunes");     break;
    case 2: System.out.println("Martes");    break;
    case 3: System.out.println("Miércoles"); break;
    default: System.out.println("Otro día");
}
```

> En el `switch`, `break` evita la "caída" (fall-through) al siguiente `case`.
> `default` es opcional y se ejecuta si ningún `case` coincide.

---

### 7. Estructuras Repetitivas (Ciclos)


Permiten repetir un bloque de instrucciones mientras se cumpla una condición.

| Ciclo | Evalúa condición | Mínimo de ejecuciones | Cuándo usarlo |
|---|---|---|---|
| `while` | Antes del bloque | 0 veces | Cantidad de iteraciones desconocida |
| `do-while` | Después del bloque | 1 vez (siempre) | Se necesita ejecutar al menos una vez |
| `for` | Antes del bloque | 0 veces | Cantidad de iteraciones conocida |
| `for-each` | Interna | 0 veces | Recorrer arrays u objetos `Iterable` |

**Palabras clave de control**

| Palabra | Efecto |
|---|---|
| `break` | Sale del ciclo inmediatamente |
| `continue` | Salta la iteración actual y pasa a la siguiente |

**Ejemplos:**

```java
// while
int i = 0;
while (i < 5) {
    System.out.print(i + " "); // 0 1 2 3 4
    i++;
}

// do-while
int cuenta = 3;
do {
    System.out.print(cuenta + " "); // 3 2 1
    cuenta--;
} while (cuenta > 0);

// for con break y continue
for (int n = 1; n <= 10; n++) {
    if (n % 2 == 0) continue; // saltar pares
    if (n > 7)      break;    // detener en 7
    System.out.print(n + " "); // 1 3 5 7
}
```

---

### 8. Entrada y Salida de Datos (I/O)


Java interactúa con el usuario a través de:

- **`System.out`** — flujo de **salida** estándar (consola).
- **`Scanner`** — clase de la API Java para **entrada** desde teclado (`java.util.Scanner`).

#### Salida — `System.out`

| Método | Comportamiento |
|---|---|
| `System.out.println(x)` | Imprime `x` y **avanza de línea** |
| `System.out.print(x)` | Imprime `x` **sin** avanzar de línea |
| `System.out.printf(fmt, args)` | Imprime con **formato** al estilo C |

**Especificadores de formato (`printf`)**

| Especificador | Tipo |
|---|---|
| `%s` | `String` |
| `%d` | Entero decimal |
| `%f` / `%.2f` | Flotante / con 2 decimales |
| `%c` | Carácter |
| `%b` | Booleano |
| `%n` | Salto de línea (portátil entre sistemas operativos) |

```java
System.out.println("Hola, mundo");          // salto de línea automático
System.out.print("Sin salto ");
System.out.print("de línea\n");
System.out.printf("Promedio: %.2f%n", 8.5); // Promedio: 8.50
```

> **Tildes en NetBeans:** agregar `-Dfile.encoding=UTF-8` en
> *Run → Set Project Configuration → Customize → Run → VM Options*,
> o al inicio del `main`:
> ```java
> System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
> ```

---

#### Entrada — `Scanner`

**Pasos para usarlo**

```java
// 1. Importar la clase
import java.util.Scanner;

// 2. Crear el objeto (vinculado a la entrada estándar)
Scanner sc = new Scanner(System.in);

// 3. Leer datos según el tipo
String nombre  = sc.nextLine();   // línea completa (incluye espacios)
String palabra = sc.next();       // una palabra (hasta el primer espacio)
int    edad    = sc.nextInt();     // número entero
double precio  = sc.nextDouble(); // número decimal

// 4. Cerrar el recurso al terminar
sc.close();
```

**Métodos de `Scanner`**

| Método | Lee |
|---|---|
| `nextLine()` | Línea completa (hasta `\n`) |
| `next()` | Siguiente token (palabra) |
| `nextInt()` | Entero (`int`) |
| `nextLong()` | Entero largo (`long`) |
| `nextDouble()` | Decimal (`double`) |
| `nextFloat()` | Decimal (`float`) |
| `nextBoolean()` | Booleano (`true` / `false`) |

> ⚠️ **Problema frecuente — buffer residual:**
> Después de `nextInt()` o `nextDouble()` queda un `\n` en el buffer.
> Si luego se llama `nextLine()`, leerá esa línea vacía en lugar del dato del usuario.
>
> **Solución:** agregar un `sc.nextLine()` extra para limpiar el buffer.

```java
int edad = sc.nextInt();
sc.nextLine();               // ← limpia el '\n' residual
String nombre = sc.nextLine(); // ahora lee correctamente
```

**Ejemplo completo**

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese su nombre    : ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese su edad      : ");
        int edad = sc.nextInt();
        sc.nextLine(); // limpia buffer

        System.out.print("Ingrese su promedio  : ");
        double promedio = sc.nextDouble();

        System.out.println("\n--- Resultado ---");
        System.out.println("Nombre  : " + nombre);
        System.out.printf("Edad    : %d años%n", edad);
        System.out.printf("Promedio: %.2f → %s%n",
            promedio, (promedio >= 7 ? "APROBADO" : "DESAPROBADO"));

        sc.close();
    }
}
```

---

## Cómo usar estos ejemplos

1. **Clonar el repositorio:**
   ```bash
   git clone https://github.com/darkwhiskers/POO_Clase01.git
   ```

2. **Abrir en NetBeans:**
   Ir a *File → Open Project* y seleccionar la carpeta clonada.

3. **Generar Javadoc:**
   ```bash
   javadoc -d doc -encoding UTF-8 Main.java
   ```

---

## Referencia rápida

| Tema | Concepto clave |
|---|---|
| Tipos primitivos | 8 tipos, tamaño fijo, portables |
| Tipos referencia | Viven en el heap, pueden ser `null` |
| Constantes | `final tipo NOMBRE = valor;` |
| Arrays | Longitud fija, índice base 0, atributo `.length` |
| String | Inmutable, pool de literales, usar `equals()` para comparar |
| Condicionales | `if-else`, ternario `?:`, `switch` con `break` |
| Ciclos | `while`, `do-while`, `for`, `for-each` |
| Salida | `println`, `print`, `printf` |
| Entrada | `Scanner` — recordar limpiar buffer con `nextLine()` extra |
| Memoria | Stack → primitivos locales / Heap → objetos (`new`) |
| GC | Libera automáticamente objetos sin referencias |

---

*Realizado por **Miguel Silva C.** -*
*Licencia: CC BY-NC-ND 4.0*
