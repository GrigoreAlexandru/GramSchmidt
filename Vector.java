import java.util.ArrayList;

import static java.lang.Math.sqrt;

public class Vector {
    private final double x, y;
    public final double lungime;

    public Vector(double x, double y) {
        this.y = y;
        this.x = x;
        lungime = sqrt(x * x + y * y);
    }

    private Vector proiectie(Vector f) {
        double scalar = inmultire(this, f) / inmultire(f, f);
        return inmultireScalar(f, scalar);
    }

    private double inmultire(Vector v1, Vector v2) {
        return (v1.x * v2.x) + (v1.y * v2.y);
    }

    private Vector inmultireScalar(Vector v, double scalar) {
        return new Vector(v.x * scalar, v.y * scalar);
    }

    private Vector scadere(Vector v1, Vector v2) {
        return new Vector(v1.x - v2.x, v1.y - v2.y);
    }

    public Vector getOrtogonal(ArrayList<Vector> vectori) {
        if (vectori.isEmpty()) return this;
        Vector rezultat = this;
        for (Vector f : vectori) {
            Vector proiectie = proiectie(f);
            rezultat = scadere(rezultat, proiectie);
        }
        return rezultat;
    }

    public Vector getOrtonormal() {
        return new Vector(this.x / lungime, this.y / lungime);
    }

    @Override
    public String toString() {
        return "Vector{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

