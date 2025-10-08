import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Almacenamiento {

    private static final Path RUTA = Paths.get("ProyectoColaborativo", "usuarios.txt");

    public static void guardar(Usuario u) throws IOException {
        Files.createDirectories(RUTA.getParent());

        String linea = u.toRegistro() + System.lineSeparator();
        Files.write(
            RUTA,
            linea.getBytes(StandardCharsets.UTF_8),
            StandardOpenOption.CREATE,
            StandardOpenOption.APPEND
        );
    }

    public static List<Usuario> leerTodos() throws IOException {
        if (Files.notExists(RUTA)) {
            return Collections.emptyList();
        }

        List<String> lineas = Files.readAllLines(RUTA, StandardCharsets.UTF_8);
        List<Usuario> usuarios = new ArrayList<>();

        for (String l : lineas) {
            if (l == null || l.trim().isEmpty()) continue;
            String[] p = l.split(";", -1);
            if (p.length >= 3) {
                usuarios.add(new Usuario(p[0], p[1], p[2]));
            }
        }
        return usuarios;
    }
}
