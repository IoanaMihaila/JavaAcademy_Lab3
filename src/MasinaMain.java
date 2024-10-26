import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Masina {
    private String brand;
    private String model;
    private int anFabricatie;
    private double capacitateCilindrica;
    private String serieSasiu;
    private static int serieCounter = 1000;

    public Masina() {
    }

    public Masina(String brand, String model, int anFabricatie, double capacitateCilindrica) {
        this.brand = brand;
        this.model = model;
        this.anFabricatie = anFabricatie;
        this.capacitateCilindrica = capacitateCilindrica;
        this.serieSasiu = "S" + serieCounter++;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getAnFabricatie() {
        return anFabricatie;
    }

    public void setAnFabricatie(int anFabricatie) {
        this.anFabricatie = anFabricatie;
    }

    public double getCapacitateCilindrica() {
        return capacitateCilindrica;
    }

    public void setCapacitateCilindrica(double capacitateCilindrica) {
        this.capacitateCilindrica = capacitateCilindrica;
    }

    public String getSerieSasiu() {
        return serieSasiu;
    }

    public void setSerieSasiu(String serieSasiu) {
        this.serieSasiu = serieSasiu;
    }

    @Override
    public String toString() {
        return "Masina{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", anFabricatie=" + anFabricatie +
                ", capacitateCilindrica=" + capacitateCilindrica +
                ", serieSasiu='" + serieSasiu + '\'' +
                '}';
    }
}

class Proprietar {
    private String cnp;
    private String nume;
    private String prenume;
    private int anulNasterii;
    private ArrayList<Masina> masini = new ArrayList<>();

    public Proprietar() {
    }

    public Proprietar(String cnp, String nume, String prenume, int anulNasterii) {
        this.cnp = cnp;
        this.nume = nume;
        this.prenume = prenume;
        this.anulNasterii = anulNasterii;
    }

    public ArrayList<Masina> getMasini() {
        return masini;
    }

    public void setMasini(ArrayList<Masina> masini) {
        this.masini = masini;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public int getAnulNasterii() {
        return anulNasterii;
    }

    public void setAnulNasterii(int anulNasterii) {
        this.anulNasterii = anulNasterii;
    }

    public int getVarsta(int anulCurent) {
        return anulCurent - anulNasterii;
    }

    @Override
    public String toString() {
        return "Proprietar{" +
                "cnp='" + cnp + '\'' +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", anulNasterii=" + anulNasterii +
                '}';
    }
}

class StatRoman {
    private static List<Masina> masiniInCirculatie = new ArrayList<>();

    public static void adaugaMasina(Masina masina) {
        masiniInCirculatie.add(masina);
    }

    public static void stergeMasina(String serieSasiu) {
        masiniInCirculatie.removeIf(m -> m.getSerieSasiu().equals(serieSasiu));
    }

    public static double procentajMasiniDupaAn(int an) {
        long count = masiniInCirculatie.stream().filter(m -> m.getAnFabricatie() > an).count();
        return (count * 100.0) / masiniInCirculatie.size();
    }

    public static double procentajMasiniDupaBrand(String brand) {
        long count = masiniInCirculatie.stream().filter(m -> m.getBrand().equals(brand)).count();
        return (count * 100.0) / masiniInCirculatie.size();
    }

    public static long numarMasiniCapacitatePeste(double capacitate) {
        return masiniInCirculatie.stream().filter(m -> m.getCapacitateCilindrica() > capacitate).count();
    }

    public static List<Masina> masiniDetinuteDeProprietariPesteVarsta(List<Proprietar> proprietari, int varsta, int anulCurent) {
        List<Masina> masiniProprietari = new ArrayList<>();
        for (Proprietar p : proprietari) {
            if (p.getVarsta(anulCurent) > varsta) {
                masiniProprietari.addAll(p.getMasini());
            }
        }
        return masiniProprietari;
    }
}

public class MasinaMain {
    public static void adaugareMasiniLaProprietar(Proprietar p) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Brand-ul masinii: ");
        String brand = scanner.nextLine();
        System.out.println("Modelul masinii: ");
        String model = scanner.nextLine();
        System.out.println("Anul de fabricatie al masinii: ");
        int anFabricatie = scanner.nextInt();
        System.out.println("Capacitatea cilindrica a masinii: ");
        double capacitateCilindrica = scanner.nextDouble();
        Masina masina = new Masina(brand, model, anFabricatie, capacitateCilindrica);
        p.getMasini().add(masina);
        StatRoman.adaugaMasina(masina);
    }

    public static void afisareMasini(Proprietar p) {
        for (Masina m : p.getMasini()) {
            System.out.println(m.toString());
        }
    }

    public static void stergeMasina(Proprietar p) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Dati seria de sasiu: ");
        String serieSasiu = scanner.nextLine();
        for (Masina m : p.getMasini()) {
            if (m.getSerieSasiu().equals(serieSasiu)) {
                p.getMasini().remove(m);
                StatRoman.stergeMasina(serieSasiu);
            } else {
                System.out.println("Nu s-a gasit o masina cu seria de sasiu: " + serieSasiu);
            }
        }
    }

    //construirea unei metode care va returna toate mașinile ce au o capacitate cilindrică peste
    // cea specificată ca parametru
    public static ArrayList<Masina> capacitateCilindricaPesteParam(Proprietar p, double capacitateCilindrica) {
        ArrayList<Masina> capacitatePesteParam = new ArrayList<>();
        for (Masina m : p.getMasini()) {
            if (m.getCapacitateCilindrica() > capacitateCilindrica) {
                capacitatePesteParam.add(m);
            }
        }
        return capacitatePesteParam;
    }

    public static void main(String[] args) {
        Proprietar p = new Proprietar("6030430201796", "Tomesc", "Maria", 2003);
        Proprietar p1=new Proprietar("5050923313586", "Rosca", "Ionut", 2005);
        List<Proprietar> proprietari = new ArrayList<>();
        proprietari.add(p);
        System.out.println("Adauga o masina in colectia proprietarului: ");
        while (true) {
            System.out.println("1.Adaugare masina in colectia proprietarului");
            System.out.println("2.Sterge masina din colectia proprietarului");
            System.out.println("3.Masini ce au o capacitate cilindrica peste cea specificată");
            System.out.println("4.Procentajulu de masini ce depășesc un anumit an");
            System.out.println("5.Procentajulu de masini identificate după un anumit brand");
            System.out.println("Alege optiunea:");
            Scanner scanner = new Scanner(System.in);
            int opt = scanner.nextInt();
            switch (opt) {
                case 1:
                    adaugareMasiniLaProprietar(p);
                    afisareMasini(p);
                    break;
                case 2:
                    stergeMasina(p);
                    afisareMasini(p);
                    break;
                case 3:
                    System.out.println("Dati capacitatea cilindrica: ");
                    Double capacitateCilindrica = scanner.nextDouble();
                    System.out.println(capacitateCilindricaPesteParam(p, capacitateCilindrica));
                    break;
                case 4:
                    System.out.println("Care este anul care va intereseaza?");
                    int an = scanner.nextInt();
                    System.out.println("Procentaj masini dupa anul " + an + ": " + StatRoman.procentajMasiniDupaAn(an) + "%");
                    break;
                case 5:
                    System.out.println("Care este brand-ul care va intereseaza?");
                    String brand = scanner.nextLine();
                    System.out.println("Procentaj masini brand " + brand + ": " + StatRoman.procentajMasiniDupaBrand(brand) + "%");
                    break;
                case 6:
                    System.out.println("Dati capacitatea cilindrica: ");
                    Double capacitateCilindricaa = scanner.nextDouble();
                    System.out.println("Numar masini cu capacitate peste " + capacitateCilindricaa + ": " + StatRoman.numarMasiniCapacitatePeste(capacitateCilindricaa));
                    break;
                case 7:
                    System.out.println("Masini detinute de proprietari peste varsta de 20 ani:");
                    List<Masina> masiniVarsta = StatRoman.masiniDetinuteDeProprietariPesteVarsta(proprietari, 20, 2024);
                    masiniVarsta.forEach(System.out::println);
                    break;
            }
        }
    }
}
