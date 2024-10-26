
class Masinaa {
    private String brand;
    private String model;
    private int anFabricatie;
    public static final String culoare = "verde";

    public Masinaa(String brand, String model, int anFabricatie) {
        this.brand = brand;
        this.model = model;
        this.anFabricatie = anFabricatie;
    }

    //intr-o metoda statica nu pot sa accesez campuri si metode non-statice
    @Override
    public String toString() {
        return "Masinaa{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", anFabricatie='" + anFabricatie + '\'' +
                ", culoare='" + culoare + '\'' +
                '}';
    }
}

public class StaticMain {
    public static void main(String[] args) {
        Masinaa daciaLogan = new Masinaa("Dacia", "Logan", 2021);
        Masinaa vwPolo = new Masinaa("VW", "Polo", 2019);

        // Masina.culoare="rosu";

        System.out.println(daciaLogan);
        System.out.println(vwPolo);
    }
}
