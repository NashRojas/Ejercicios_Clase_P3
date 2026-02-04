# Ejercicios en Clase – Java 

Todos los ejercicios deben desarrollarse dentro de un **solo proyecto Java**.
El proyecto debe iniciar con un **menú en consola**, donde cada opción permita ejecutar un ejercicio específico.

Ejemplo de menú:
1. Cuenta Bancaria
2. Polimorfismo con Empleados
3. Ocultamiento de Atributos
4. Arrays y Referencias
0. Salir

---

## Ejercicio 1: Cuenta Bancaria (Encapsulamiento)

### Enunciado
Implementa una clase `CuentaBancaria` que represente una cuenta simple.

### Requisitos
- Atributos privados:
  - `saldo` (double)
  - `numeroCuenta` (String)
- Constructor que inicialice los atributos
- Método `depositar(double monto)`
- Método `retirar(double monto)`
- Método `getSaldo()`
- No se permite acceso directo al saldo desde otras clases

---

## Ejercicio 2: Polimorfismo con Empleados

### Enunciado
Crea una jerarquía de empleados donde cada tipo calcule su salario de forma distinta.

### Requisitos
- Clase base `Empleado` con método `calcularSalario()`
- Subclases:
  - `EmpleadoFijo`
  - `EmpleadoPorHora`
- Cada subclase debe sobrescribir `calcularSalario()`
- En el menú, usar una referencia `Empleado` para ejecutar el cálculo

---

## Ejercicio 3: Ocultamiento de Atributos

### Enunciado
Analiza el comportamiento de atributos heredados.

### Requisitos
- Clase `A` con atributo `x`
- Clase `B` que herede de `A` y tenga su propio `x`
- Desde el menú, crear un objeto `B` referenciado como `A`
- Mostrar el valor de `x`
- Explicar el resultado en un comentario del código

---

## Ejercicio 4: Arrays y Referencias

### Enunciado
Analiza cómo funcionan las referencias en arrays.

### Requisitos
- Crear un array de enteros
- Asignar ese array a otra variable
- Modificar el segundo array
- Mostrar el contenido del primero
- Ejecutar todo desde una opción del menú
