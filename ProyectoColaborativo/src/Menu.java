import java.util.Scanner;
import java.util.List;

public class Menu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== MENÚ PRINCIPAL =====");
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
                    System.out.println("¡Hasta luego!");
                    scanner.close();
                    return;
            }
        }
    }

    private static void registrarUsuario(Scanner scanner) {
        System.out.println("\n--- Registrar usuario ---");

        System.out.print("Nombre completo: ");
        String nombre = scanner.nextLine().trim();

        System.out.print("Correo electrónico: ");
        String correo = scanner.nextLine().trim();

        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine().trim();

        // Validaciones básicas
        if (nombre.isEmpty() || correo.isEmpty() || telefono.isEmpty()) {
            System.out.println("⚠ Todos los campos son obligatorios.");
            return;
        }
        if (!correo.contains("@") || !correo.contains(".")) {
            System.out.println("⚠ Correo inválido.");
            return;
        }
        if (!telefono.matches("\\d{8,15}")) {
            System.out.println("⚠ Teléfono inválido. Use solo dígitos (8 a 15).");
            return;
        }

        Usuario u = new Usuario(nombre, correo, telefono);
        try {
            Almacenamiento.guardar(u);
            System.out.println("✅ Usuario guardado en 'ProyectoColaborativo/usuarios.txt'.");
        } catch (Exception e) {
            System.out.println("❌ Error al guardar: " + e.getMessage());
        }
    }

    private static void mostrarHistorial() {
        System.out.println("\n--- Historial de usuarios ---");
        try {
            List<Usuario> usuarios = Almacenamiento.leerTodos();
            if (usuarios.isEmpty()) {
                System.out.println("No hay usuarios registrados.");
                return;
            }
            int i = 1;
            for (Usuario u : usuarios) {
                System.out.printf("%d) %s | %s | %s%n",
                        i++, u.getNombre(), u.getCorreo(), u.getTelefono());
            }
        } catch (Exception e) {
            System.out.println(" Error al leer: " + e.getMessage());
        }
    }
}
