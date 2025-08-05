
CONVERSOR DE MONEDAS - JAVA (API ExchangeRate-API)
===================================================

DESCRIPCIÓN
-----------
Este proyecto consiste en una aplicación de consola escrita en Java que permite convertir montos de una moneda a otra utilizando la API pública de ExchangeRate-API.

El usuario puede seleccionar conversiones predefinidas (por ejemplo: USD a CLP), o ingresar manualmente los códigos de las monedas que desea utilizar.

El sistema se conecta a internet para consultar en tiempo real las tasas de cambio, y utiliza la biblioteca Gson para interpretar las respuestas JSON.

---------------------------------------------------

FUNCIONALIDADES
---------------
✔ Conversión entre monedas con tasas actualizadas desde la API  
✔ Menú interactivo para elegir tipo de conversión  
✔ Validación de entrada: solo se aceptan números válidos y códigos de moneda permitidos  
✔ Historial de conversiones que se muestra al cerrar el programa  

---------------------------------------------------

REQUISITOS
----------
- Java 8 o superior
- Conexión a internet
- Biblioteca externa Gson (gson-2.10.1.jar)
- Clave (API Key) gratuita de ExchangeRate-API

---------------------------------------------------

ARCHIVOS CLAVE
--------------
1. Conversor.java  
   → Contiene la lógica para conectarse a la API, interpretar el JSON con Gson y realizar la conversión.

2. Main.java  
   → Muestra el menú de usuario, gestiona la entrada, valida las monedas y muestra el resultado.

3. gson-2.10.1.jar  
   → Librería externa necesaria para interpretar el JSON. Debe estar agregada al classpath del proyecto.

---------------------------------------------------

INSTRUCCIONES DE USO
--------------------
1. Registra una cuenta gratuita en: https://www.exchangerate-api.com  
2. Copia tu API key y reemplaza `"TU_API_KEY"` en el archivo `Conversor.java` por tu clave real.
3. Asegúrate de haber agregado el archivo `gson-2.10.1.jar` a las dependencias de tu proyecto.
4. Ejecuta `Main.java` desde IntelliJ o desde terminal.
5. Selecciona la opción deseada en el menú e ingresa la cantidad a convertir.

---------------------------------------------------

EJEMPLO DE USO
--------------
=== CONVERSOR DE MONEDAS ===

1.- USD → CLP

2.- CLP → USD

3.- EUR → CLP

4.- CLP → EUR

5.-Otro tipo de cambio

6.- Salir

Seleccione una opción: 1

Ingrese la cantidad a convertir: 100
✅ Resultado: 100.00 USD = 92700.00 CLP


Al presionar la opción 6 para salir, se va a desplegar el listado de conversiones realizadas:

📋 Historial de conversiones:
- 100.00 USD = 92700.00 CLP

---------------------------------------------------
