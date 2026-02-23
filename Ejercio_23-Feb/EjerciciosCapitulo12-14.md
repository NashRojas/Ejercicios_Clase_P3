# Ejercicios de Programación II

---

## Ejercicio 1 – Hilos de Ejecución (Capítulo 12)

### Sistema de Simulación de Cajeros Bancarios

Un banco tiene 3 cajeros automáticos que atienden clientes simultáneamente. Cada cajero es un hilo independiente que procesa transacciones. Debes simular el comportamiento concurrente del sistema con las siguientes condiciones:

- Cada cajero atiende entre **3 y 5 clientes** de forma aleatoria, y cada transacción tarda entre **1 y 3 segundos** (usa `Thread.sleep`).
- Existe un recurso compartido: la **bóveda del banco**, que tiene un saldo inicial de `$50,000`. Cada transacción retira un monto aleatorio entre `$500` y `$2,000`. Debes garantizar que dos cajeros no puedan acceder a la bóveda al mismo tiempo usando **sincronización**.
- Uno de los cajeros debe ser de tipo **demonio**, encargado de imprimir el saldo actual de la bóveda cada 2 segundos mientras los demás hilos estén activos.
- Al finalizar todos los cajeros, el sistema debe imprimir un **resumen** indicando cuántas transacciones procesó cada uno y el saldo final de la bóveda.

---

## Ejercicio 2 – Archivos (Capítulo 14)

### Sistema de Registro de Estudiantes

Debes construir una pequeña aplicación de consola que gestione el registro de estudiantes utilizando archivos. El sistema debe cumplir con lo siguiente:

- Al iniciar, el programa verifica si existe un archivo llamado `estudiantes.dat`. Si no existe, lo crea. Si existe, **carga los datos previamente guardados**.
- El usuario puede realizar 3 operaciones:
  - **Agregar** un estudiante (nombre, matrícula, promedio).
  - **Buscar** un estudiante por su número de matrícula usando `RandomAccessFile`.
  - **Listar** todos los estudiantes registrados.
- Los datos deben persistirse usando **serialización de objetos**, donde cada estudiante es una instancia de una clase `Estudiante` que implementa `Serializable`.
- Si ocurre algún error al leer o escribir el archivo (registro corrupto, archivo no encontrado, etc.), el programa debe **capturar la excepción** correspondiente, mostrar un mensaje descriptivo y continuar ejecutándose sin cerrarse abruptamente.
