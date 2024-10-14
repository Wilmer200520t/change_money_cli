
# change_money_cli

`change_money_cli` es una herramienta en la CLI que permite convertir montos entre diferentes monedas.

## Requisitos

- Java Development Kit (JDK) 8 o superior

## Instalación

1. Clona el repositorio:
    ```sh
    git clone https://github.com/Wilmer200520t/change_money_cli.git
    ```
2. Navega al directorio del proyecto:
    ```sh
    cd change_money_cli
    ```

## Uso

### Compilar y ejecutar

Para compilar y ejecutar la aplicación, usa los siguientes comandos:
    ```sh
    javac Main.java
    java Main
    ```

### Opciones de conversión

Al ejecutar el programa, se te presentarán las siguientes opciones de conversión:

1. **USD a ARS**: Dólar estadounidense a Peso argentino
2. **COP a BRL**: Peso colombiano a Real brasileño
3. **COP a USD**: Peso colombiano a Dólar estadounidense
4. **BRL a ARS**: Real brasileño a Peso argentino
5. **USD a BRL**: Dólar estadounidense a Real brasileño
6. **BRL a COP**: Real brasileño a Peso colombiano
7. **USD a COP**: Dólar estadounidense a Peso colombiano
8. **ARS a COP**: Peso argentino a Peso colombiano
9. **Salir**

### Ejemplo de uso

1. Selecciona un tipo de cambio ingresando el número correspondiente (1-9).
    ```sh
    Seleccione un tipo de cambio:
    1.- [USD] Dolar                ==> [ARS] Pesos Argentinos
    2.- [COP] Pesos colombianos    ==> [BRL] Real brasileño
    3.- [COP] Pesos colombianos    ==> [USD] Dólar estadounidense
    4.- [BRL] Real brasileño       ==> [ARS] Pesos argentinos
    5.- [USD] Dólar estadounidense ==> [BRL] Real brasileño
    6.- [BRL] Real brasileño       ==> [COP] Pesos colombianos
    7.- [USD] Dólar estadounidense ==> [COP] Pesos colombianos
    8.- [ARS] Pesos argentinos     ==> [COP] Pesos colombianos
    9.- Salir.
    ```
2. Ingresa el monto a convertir.
    ```sh
    Digite el monto a convertir:
    ```
3. El programa mostrará el monto convertido en la moneda de destino.
    ```sh
    100.0 USD es igual a 9500.00 ARS
    ```

### Salir del programa

Para salir del programa, selecciona la opción 9.
    ```sh
    9.- Salir.
    Saliste de la aplicacion.
    ```

## Manejo de errores

- Si se ingresa una opción no válida, el programa mostrará un mensaje de error y pedirá una nueva entrada.
- Si se ingresa un monto no válido, el programa mostrará un mensaje de error y pedirá una nueva entrada.
