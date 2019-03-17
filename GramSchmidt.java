import java.util.ArrayList;
import java.util.Scanner;

public class GramSchmidt {
    private static ArrayList<Vector> vectori = new ArrayList<>();
    private static ArrayList<Vector> vectoriOrtogonali = new ArrayList<>();
    private static ArrayList<Vector> vectoriOrtonormali = new ArrayList<>();

    private static void calculeazaOrtogonali() {
        for (Vector vector : vectori) {
            Vector ortogonal = vector.getOrtogonal(vectoriOrtogonali);
            vectoriOrtogonali.add(ortogonal);
        }
    }

    private static void calculeazaOrtonormali() {
        for (Vector vector : vectoriOrtogonali) {
            vectoriOrtonormali.add(vector.getOrtonormal());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introdu nr de vectori:");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.printf("Vector[%d].x = ", i);
            double x = sc.nextDouble();
            System.out.printf("Vector[%d].y = ", i);
            double y = sc.nextDouble();
            vectori.add(new Vector(x, y));
        }

        calculeazaOrtogonali();
        System.out.println("Vectori ortogonali:");
        System.out.println(vectoriOrtogonali);

        calculeazaOrtonormali();
        System.out.println("Vectori ortonormali:");
        System.out.println(vectoriOrtonormali);
    }
}
