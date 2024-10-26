package Tema;

class Cerc {
    private double raza;
    private String culoare;

    public Cerc() {
        this.raza = 1.0;
        this.culoare = "alb";
    }

    public Cerc(double raza, String culoare) {
        this.raza = raza;
        this.culoare = culoare;
    }

    public double getRaza() {
        return raza;
    }

    @Override
    public String toString() {
        return "Cercul are raza " + raza + " si culoarea " + culoare;
    }

    public double getArie() {
        double arie = Math.PI * Math.pow(raza, 2);
        return arie;
    }
}

public class CercMain {
    public static Cerc comparaDupaRaza(Cerc c1, Cerc c2) {
        if (c1.getRaza() > c2.getRaza()) {
            return c1;
        } else if (c2.getRaza() > c1.getRaza()) {
            return c2;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        Cerc cerc1 = new Cerc();
        Cerc cerc2 = new Cerc(3.5, "rosu");
        System.out.println("Aria cercului cu raza: " + cerc2.getRaza() + " este: " + cerc2.getArie());
        Cerc cercMaiMare = comparaDupaRaza(cerc1, cerc2);
        if (cercMaiMare != null) {
            System.out.println("Cercul cu raza mai mare este: " + cercMaiMare);
        } else {
            System.out.println("Cele două cercuri au aceeași rază.");
        }
    }
}
