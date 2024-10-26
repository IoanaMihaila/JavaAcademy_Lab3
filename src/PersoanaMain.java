import org.w3c.dom.ls.LSOutput;

import java.util.Objects;

class Persoana {
    private String nume;
    private String prenume;
    private int varsta;
    public static int count=0;

    public Persoana() {
        count++;
    }

    public Persoana(String nume, String prenume, int varsta) {
        this.nume = nume;
        this.prenume = prenume;
        this.varsta = varsta;
        count++;
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

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    @Override
    public String toString() {
        return "Persoana{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", varsta=" + varsta +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persoana persoana = (Persoana) o;
        return varsta == persoana.varsta && Objects.equals(nume, persoana.nume) && Objects.equals(prenume, persoana.prenume);
    }
}

public class PersoanaMain {
    public static void main(String[] args) {
        Persoana p=new Persoana();
        Persoana p1 = new Persoana("Mihaila", "Ioana", 21);
        Persoana p2 = new Persoana("Mihaila", "Ioana", 21);
        //System.out.println(p1.toString());//afiseaza null, null, 0
        System.out.println(p2.toString());
        System.out.println(p1.equals(p2));//true pt ca p1 si p2 au aceleasi valori
        System.out.println(p1 == p2); //false pt ca nu se afla la aceasi zona de memorie

        System.out.println("S-au creat: "+Persoana.count+" persoane");
    }
}