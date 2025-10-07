
public class Menu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMENÚ PRINCIPAL");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Ver historial de usuarios");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción (1-3): ");

            String entrada = scanner.nextLine().trim();

            if (!entrada.matches("[1-3]")) {
                System.out.println("⚠ Entrada inválida. Escriba 1, 2 o 3.");
                continue;
            }

            int opcion = Integer.parseInt(entrada);

            switch (opcion) {
                case 1:
                    registrarUsuario(scanner); 
                    break;
                case 2:
                    mostrarHistorial();        
                    break;
                case 3:
                    System.out.println("¡Adios!");
                    scanner.close();
                    return;
            }
        }
    }

    private static void registrarUsuario(Scanner scanner) {
        System.out.println("[TODO] Registrar usuario (Issue #5)");
    }

    private static void mostrarHistorial() {
        System.out.println("[TODO] Mostrar historial (Issue #6)");
    }
}
