import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    private static boolean running = true;
    public static void printExchange(){
        int choice;
        Double amount;
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        String[][] conversions = {
                {"USD", "ARS"}, // Dólar a Peso argentino
                {"COP", "BRL"}, // Peso colombiano a Real brasileño
                {"COP", "USD"}, // Peso colombiano a Dólar estadounidense
                {"BRL", "ARS"}, // Real brasileño a Peso argentino
                {"USD", "BRL"}, // Dólar estadounidense a Real brasileño
                {"BRL", "COP"}, // Real brasileño a Peso colombiano
                {"USD", "COP"}, // Dólar estadounidense a Peso colombiano
                {"ARS", "COP"}, // Peso argentino a Peso colombiano
        };

        Exchange exchange = new Exchange();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione un tipo de cambio:");
        System.out.println("1.- [USD] Dolar                ==> [ARS] Pesos Argentinos");
        System.out.println("2.- [COP] Pesos colombianos    ==> [BRL] Real brasileño");
        System.out.println("3.- [COP] Pesos colombianos    ==> [USD] Dólar estadounidense");
        System.out.println("4.- [BRL] Real brasileño       ==> [ARS] Pesos argentinos");
        System.out.println("5.- [USD] Dólar estadounidense ==> [BRL] Real brasileño");
        System.out.println("6.- [BRL] Real brasileño       ==> [COP] Pesos colombianos");
        System.out.println("7.- [USD] Dólar estadounidense ==> [COP] Pesos colombianos");
        System.out.println("8.- [ARS] Pesos argentinos     ==> [COP] Pesos colombianos");
        System.out.println("9.- Salir.");
        String input = scanner.nextLine().trim();

        try {
            choice = Integer.parseInt(input);
            if (choice < 1 || choice > 9) throw new IndexOutOfBoundsException();
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            System.out.println("Selección inválida. Intente nuevamente. Ejemplo: Digitar '1'");
            return;
        }

        if (choice == 9){
            System.out.println("Saliste de la aplicacion.");
            running = false;
            return;
        }

        System.out.println("Digite el monto a convertir:");

        try {
            amount = Double.parseDouble(scanner.nextLine().trim());
            if (amount < 0 ) throw new IndexOutOfBoundsException();
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            System.out.println("Monto invalido, Ejemplo: Digitar '10.2'");
            return;
        }

        String fromCurrency = conversions[choice - 1][0];
        String toCurrency = conversions[choice - 1][1];

        try {
            double convertedAmount = exchange.getExchange(fromCurrency, toCurrency, amount);
            String formattedAmount = decimalFormat.format(convertedAmount);
            if(Double.parseDouble(formattedAmount) == 0.00) formattedAmount = String.valueOf(convertedAmount);
            System.out.println(amount + " " + fromCurrency + ", es igual a " + formattedAmount + " " + toCurrency);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        while (running){
            printExchange();
        }

    }


}


