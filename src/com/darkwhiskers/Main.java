package com.darkwhiskers;

import java.util.Scanner; // Librería para usar objeto Scanner, que graba captura por pantalla.
import java.io.PrintStream; // Librería para mostrar caracteres especiales.

/**
 * @author  Mamba & Mike
 * @version 1.0
 * @since   2026
 * @see     java.util.Scanner
 * @see     java.lang.String
*/
public class Main {

    // No es necesario ingresar "throws Exception", es para poder utilizar,
    // atrapando errores, el objeto para leer caracteres especiales.
    public static void main(String[] args) throws Exception {
        
        // Con este objeto podemos mosttrar los caracteres propios de ASCCI,
        // es decir, letras con tildes y caracteres especiales.
        System.setOut(new PrintStream(System.out, true, "UTF-8"));
        
        // =============================================
        // 1. TIPOS DE DATOS PRIMITIVOS
        // =============================================

        // Lógico
        boolean esEstudiante = true;

        // Carácter
        char inicial = 'J';

        // Enteros
        byte edadMinima = 18;
        short anio = 2026;
        int dni = 12345678;
        // La barra baja no afecta el valor del número, pero sirve para leer mejor el número
        long poblacionMundo = 8_000_000_000L; // con L diferenciamos un long.

        // Decimales
        float temperatura = 36.6f;
        double salario = 150_000.75;

        // Constante de clase
        final double PI = 3.14159;

        System.out.println("===== TIPOS DE DATOS PRIMITIVOS =====");
        System.out.println("boolean  esEstudiante : " + esEstudiante);
        System.out.println("char     inicial      : " + inicial);
        System.out.println("byte     edadMinima   : " + edadMinima);
        System.out.println("short    anio         : " + anio);
        System.out.println("int      dni          : " + dni);
        System.out.println("long     poblacion    : " + poblacionMundo);
        System.out.println("float    temperatura  : " + temperatura);
        System.out.println("double   salario      : " + salario);
        System.out.println("final    PI           : " + PI);

        // =============================================
        // 2. MANEJO DE CADENAS (String)
        // =============================================
        System.out.println("\n===== MANEJO DE STRING =====");

        String nombre = "  Juan Pérez  ";
        String apellido = "González";
        String completo = nombre.trim() + " " + apellido;

        System.out.println("Original con espacios : '" + nombre + "'");
        System.out.println("trim()                : '" + nombre.trim() + "'");
        System.out.println("Nombre completo       : " + completo);
        System.out.println("length()              : " + completo.length());
        System.out.println("toUpperCase()         : " + completo.toUpperCase());
        System.out.println("toLowerCase()         : " + completo.toLowerCase());
        System.out.println("charAt(0)             : " + completo.charAt(0));
        System.out.println("indexOf('P')          : " + completo.indexOf('P'));
        System.out.println("substring(5, 9)       : " + completo.substring(5, 9));
        System.out.println("contains('González') : " + completo.contains("González"));
        System.out.println("replace('J','X')      : " + completo.replace('J', 'X'));
        System.out.println("startsWith('Juan')    : " + completo.startsWith("Juan"));
        System.out.println("endsWith('lez')       : " + completo.endsWith("lez"));
        System.out.println("isEmpty()             : " + completo.isEmpty());
        System.out.println("equals(apellido)      : " + completo.equals(apellido));
        System.out.println("concat(' Jr.')        : " + completo.concat(" Jr."));

        // Separar una cadena
        String csv = "rojo,verde,azul";
        String[] colores = csv.split(",");
        System.out.print("split(',') → ");
        for (String c : colores) {
            System.out.print("[" + c + "] ");
        }
        System.out.println();

        // =============================================
        // 3. ARREGLOS (ARRAYS) ESTÁTICOS
        // =============================================
        System.out.println("\n===== ARREGLOS ESTÁTICOS =====");

        // Inicialización directa
        String[] diasLaborables = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes"};

        // Inicialización con new
        int[] notas = new int[5];
        notas[0] = 8;
        notas[1] = 9;
        notas[2] = 7;
        notas[3] = 10;
        notas[4] = 6;

        // Recorrido con for tradicional
        System.out.print("Notas (for clásico)  : ");
        for (int i = 0; i < notas.length; i++) {
            System.out.print(notas[i] + " ");
        }
        System.out.println();

        // Recorrido con for-each
        System.out.print("Días (for-each)      : ");
        for (String dia : diasLaborables) {
            System.out.print(dia + " ");
        }
        System.out.println();

        // Calcular promedio usando el arreglo
        int suma = 0;
        for (int nota : notas) {
            suma += nota;
        }
        double promedio = (double) suma / notas.length;
        System.out.println("Promedio de notas    : " + promedio);

        // Arreglo bidimensional (matriz)
        int[][] matriz = new int[2][3];
        int valor = 1;
        for (int f = 0; f < matriz.length; f++) {
            for (int c = 0; c < matriz[f].length; c++) {
                matriz[f][c] = valor++;
            }
        }

        System.out.println("Matriz 2x3:");
        for (int[] fila : matriz) {
            for (int elem : fila) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }

        // =============================================
        // 4. ESTRUCTURAS CONDICIONALES
        // =============================================
        System.out.println("\n===== CONDICIONALES =====");

        // if – else if – else
        int nota = notas[0];
        if (nota >= 9) {
            System.out.println("Nota " + nota + " -> Sobresaliente");
        } else if (nota >= 7) {
            System.out.println("Nota " + nota + " -> Aprobado");
        } else if (nota >= 4) {
            System.out.println("Nota " + nota + " -> Regular");
        } else {
            System.out.println("Nota " + nota + " -> Desaprobado");
        }

        // Operador ternario
        String estado = (promedio >= 7) ? "APROBADO" : "DESAPROBADO";
        System.out.println("Estado del alumno (ternario): " + estado);

        // switch
        int diaSemana = 3;
        String nombreDia;
        switch (diaSemana) {
            case 1:
                nombreDia = "Lunes";
                break;
            case 2:
                nombreDia = "Martes";
                break;
            case 3:
                nombreDia = "Miércoles";
                break;
            case 4:
                nombreDia = "Jueves";
                break;
            case 5:
                nombreDia = "Viernes";
                break;
            default:
                nombreDia = "Fin de semana";
        }
        System.out.println("Día " + diaSemana + " (switch): " + nombreDia);

        // =============================================
        // 5. ESTRUCTURAS REPETITIVAS (CICLOS)
        // =============================================
        System.out.println("\n===== CICLOS =====");

        // while
        System.out.print("while  (pares 0 - 8)   : ");
        int i = 0;
        while (i < 10) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
            i++;
        }
        System.out.println();

        // do-while (se ejecuta al menos una vez)
        System.out.print("do-while (5 a 1)     : ");
        int cuenta = 5;
        do {
            System.out.print(cuenta + " ");
            cuenta--;
        } while (cuenta > 0);
        System.out.println();

        // for con break y continue
        System.out.print("for con continue/break (impares, para en 7): ");
        for (int n = 1; n <= 10; n++) {
            if (n % 2 == 0) {
                continue;   // saltar pares
            }
            if (n > 7) {
                break;      // detener en 7
            }
            System.out.print(n + " ");
        }
        System.out.println(); // Salto de línea.

        // =============================================
        // 6. ENTRADA DE DATOS (Scanner)
        // =============================================
        System.out.println("\n===== ENTRADA DE DATOS (Scanner) =====");

        Scanner sc = new Scanner(System.in); // Creaa el objeto sc para capturar datos por teclado.

        System.out.print("Ingrese su nombre    : ");
        String nombreUsuario = sc.nextLine();

        System.out.print("Ingrese su edad      : ");
        int edadUsuario = sc.nextInt();
        sc.nextLine();  // limpiar buffer tras nextInt()

        System.out.print("Ingrese su promedio  : ");
        double promedioUsuario = sc.nextDouble();
        sc.nextLine();  // limpiar buffer tras nextDouble() o cualquier número

        System.out.print("Ingrese dirección    : ");
        String direccion = sc.nextLine();
        // =============================================
        // 7. SALIDA DE DATOS (System.out)
        // =============================================
        System.out.println("\n===== SALIDA DE DATOS (System.out) =====");

        // println  → imprime y salta de línea
        System.out.println("Nombre    : " + nombreUsuario);

        // print    → imprime sin saltar de línea
        System.out.print("Edad      : ");
        System.out.println(edadUsuario + " años");

        // printf   → formato con especificadores
        System.out.printf("Promedio  : %.2f%n", promedioUsuario);

        // Resultado final con ternario
        String resultadoFinal = (promedioUsuario >= 7) ? "APROBADO" : "DESAPROBADO";
        System.out.println("Estado    : " + resultadoFinal);  // println  → imprime y salta de línea
        System.out.println("Dirección : " + direccion);
        
        sc.close(); // Se debe cerrar el objeto de captura de datos por teclado.
    }
}
