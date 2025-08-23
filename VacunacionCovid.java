import java.util.*;
import java.io.FileWriter;
import java.io.IOException;

public class VacunacionCovid {

    public static void main(String[] args) {

        // 1) Conjunto universal: 500 ciudadanos
        Set<String> ciudadanos = new HashSet<>();
        for (int i = 1; i <= 500; i++) {
            ciudadanos.add("Ciudadano " + i);
        }

        // 2) Pfizer: 75 ciudadanos (Ciudadano 1..75)
        Set<String> pfizer = new HashSet<>();
        for (int i = 1; i <= 75; i++) {
            pfizer.add("Ciudadano " + i);
        }

        // 3) AstraZeneca: 75 ciudadanos (Ciudadano 50..124)
        Set<String> astrazeneca = new HashSet<>();
        for (int i = 50; i < 125; i++) {
            astrazeneca.add("Ciudadano " + i);
        }

        // 4) Operaciones de conjuntos

        // No vacunados: U − (P ∪ A)
        Set<String> noVacunados = new HashSet<>(ciudadanos);
        noVacunados.removeAll(pfizer);
        noVacunados.removeAll(astrazeneca);

        // Ambas dosis: P ∩ A
        Set<String> ambas = new HashSet<>(pfizer);
        ambas.retainAll(astrazeneca);

        // Solo Pfizer: P − A
        Set<String> soloPfizer = new HashSet<>(pfizer);
        soloPfizer.removeAll(astrazeneca);

        // Solo AstraZeneca: A − P
        Set<String> soloAstra = new HashSet<>(astrazeneca);
        soloAstra.removeAll(pfizer);

        // 5) Mostrar resultados en consola
        System.out.println("📌 Total ciudadanos: " + ciudadanos.size());
        System.out.println("➡ No vacunados: " + noVacunados.size());
        System.out.println("➡ Ambas dosis: " + ambas.size());
        System.out.println("➡ Solo Pfizer: " + soloPfizer.size());
        System.out.println("➡ Solo AstraZeneca: " + soloAstra.size());

        // 6) (Opcional) Exportar reporte a archivo
        try (FileWriter writer = new FileWriter("reporte_vacunacion.txt")) {
            writer.write("=== REPORTE DE VACUNACIÓN COVID-19 ===\n\n");
            writer.write("No vacunados (" + noVacunados.size() + "): " + noVacunados + "\n\n");
            writer.write("Ambas dosis (" + ambas.size() + "): " + ambas + "\n\n");
            writer.write("Solo Pfizer (" + soloPfizer.size() + "): " + soloPfizer + "\n\n");
            writer.write("Solo AstraZeneca (" + soloAstra.size() + "): " + soloAstra + "\n\n");
        } catch (IOException e) {
            System.out.println("Error al generar el reporte: " + e.getMessage());
        }
    }
}
