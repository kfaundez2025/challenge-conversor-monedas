import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] monedasValidas = {"USD", "EUR", "CLP", "BRL", "COP", "PEN"};
        List<String> historial = new ArrayList<>();
        int opcion;

        do {
            System.out.println("\n=== CONVERSOR DE MONEDAS ===");
            System.out.println("1. Dólar estadounidense (USD) → Pesos chilenos (CLP)");
            System.out.println("2. Pesos chilenos (CLP) → Dólar estadounidense (USD)");
            System.out.println("3. Euro (EUR) → Pesos chilenos (CLP)");
            System.out.println("4. Pesos chilenos (CLP) → Euro (EUR)");
            System.out.println("5. Otro tipo de cambio");
            System.out.println("6. Salir");
            // System.out.print("Seleccione una opción: ");
            // opcion = sc.nextInt();
            opcion = 0;
            boolean opcionValida = false;
            while (!opcionValida) {
                System.out.print("Seleccione una opción (1-6): ");
                if (sc.hasNextInt()) {
                    opcion = sc.nextInt();
                    if (opcion >= 1 && opcion <= 6) {
                        opcionValida = true;
                    } else {
                        System.out.println("❌ Opción fuera de rango.");
                    }
                } else {
                    System.out.println("❌ Entrada no válida. Ingrese un número del 1 al 6.");
                    sc.next(); // limpiar entrada inválida
                }
            }

            String base = "";
            String destino = "";

            switch (opcion) {
                case 1:
                    base = "USD";
                    destino = "CLP";
                    break;
                case 2:
                    base = "CLP";
                    destino = "USD";
                    break;
                case 3:
                    base = "EUR";
                    destino = "CLP";
                    break;
                case 4:
                    base = "CLP";
                    destino = "EUR";
                    break;
                case 5:
                    System.out.println("\n🔤 Opciones de moneda:");
                    System.out.println("USD - Dólar estadounidense");
                    System.out.println("EUR - Euro");
                    System.out.println("CLP - Peso chileno");
                    System.out.println("BRL - Real brasileño");
                    System.out.println("COP - Peso colombiano");
                    System.out.println("PEN - Sol peruano");
                    //System.out.print("Ingrese la moneda base (ej: USD): ");
                    // base = sc.next().toUpperCase();
                    //System.out.print("Ingrese la moneda destino (ej: CLP): ");
                    //destino = sc.next().toUpperCase();
                    // Validar moneda base
                    while (true) {
                        System.out.print("Ingrese la moneda base (ej: USD): ");
                        base = sc.next().toUpperCase();
                        if (esMonedaValida(base, monedasValidas)) {
                            break;
                        } else {
                            System.out.println("❌ Moneda base no válida. Intente con una de las siguientes: USD, EUR, CLP, BRL, COP, PEN");
                        }
                    }

                    // Validar moneda destino
                    while (true) {
                        System.out.print("Ingrese la moneda destino (ej: CLP): ");
                        destino = sc.next().toUpperCase();
                        if (esMonedaValida(destino, monedasValidas)) {
                            break;
                        } else {
                            System.out.println("❌ Moneda destino no válida. Intente con una de las siguientes: USD, EUR, CLP, BRL, COP, PEN");
                        }
                    }
                    break;
                case 6:
                    System.out.println("\n📋 Historial de conversiones:");
                    for (String entrada : historial) {
                        System.out.println("- " + entrada);
                    }
                    System.out.println("👋 ¡Hasta luego!");
                    return;
                default:
                    System.out.println("❌ Opción no válida.");
                    continue;
            }

            // Mejora 1: validación de entrada
            double cantidad = 0;
            boolean entradaValida = false;
            while (!entradaValida) {
                System.out.print("Ingrese la cantidad a convertir: ");
                if (sc.hasNextDouble()) {
                    cantidad = sc.nextDouble();
                    entradaValida = true;
                } else {
                    System.out.println("❌ Entrada no válida. Intente nuevamente con un número.");
                    sc.next(); // limpiar entrada no válida
                }
            }

            double resultado = Conversor.convertir(base, destino, cantidad);
            if (resultado != -1) {
                String resumen = String.format("%.2f %s = %.2f %s", cantidad, base, resultado, destino);
                System.out.println("✅ Resultado: " + resumen);
                historial.add(resumen);
            }

        } while (opcion != 6);
    }

    private static boolean esMonedaValida(String codigo, String[] lista) {
        for (String m : lista) {
            if (m.equalsIgnoreCase(codigo)) {
                return true;
            }
        }
        return false;
    }
}
