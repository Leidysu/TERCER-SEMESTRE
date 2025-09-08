import java.util.*;

public class TorneoFutbol {
    public static void main(String[] args) {
        // Mapa: Equipo -> Conjunto de jugadores
        Map<String, Set<String>> torneo = new HashMap<>();

        // Agregar equipos y jugadores
        torneo.putIfAbsent("Tigres", new HashSet<>());
        torneo.get("Tigres").add("Carlos Pérez");
        torneo.get("Tigres").add("Juan López");
        torneo.get("Tigres").add("Carlos Pérez"); // No se duplicará

        torneo.putIfAbsent("Leones", new HashSet<>());
        torneo.get("Leones").add("Andrés Gómez");
        torneo.get("Leones").add("Mario Díaz");

        // Listar equipos y jugadores
        for (String equipo : torneo.keySet()) {
            System.out.println("Equipo: " + equipo);
            System.out.println("Jugadores: " + torneo.get(equipo));
            System.out.println("-------------");
        }

        // Consultar si un jugador pertenece a un equipo
        String jugador = "Carlos Pérez";
        if (torneo.get("Tigres").contains(jugador)) {
            System.out.println(jugador + " juega en Tigres.");
        }
    }
}
