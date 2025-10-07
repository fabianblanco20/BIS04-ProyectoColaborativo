    System.out.println("\n--- Registrar usuario ---");

    System.out.print("Nombre completo: ");
    String nombre = scanner.nextLine().trim();

    System.out.print("Correo electrónico: ");
    String correo = scanner.nextLine().trim();

    System.out.print("Teléfono: ");
    String telefono = scanner.nextLine().trim();

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
        System.out.println(" Usuario guardado en 'ProyectoColaborativo/usuarios.txt'.");
    } catch (Exception e) {
        System.out.println(" Error al guardar: " + e.getMessage());
    }
}
