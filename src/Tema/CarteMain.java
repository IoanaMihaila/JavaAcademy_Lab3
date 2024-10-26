package Tema;

import java.util.ArrayList;
import java.util.List;

class Carte {
    private String titlu;
    private String editura;
    private int nrPagini;

    public Carte(String titlu, String editura, int nrPagini) {
        this.titlu = titlu;
        this.editura = editura;
        this.nrPagini = nrPagini;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public String getEditura() {
        return editura;
    }

    public void setEditura(String editura) {
        this.editura = editura;
    }

    public int getNrPagini() {
        return nrPagini;
    }

    public void setNrPagini(int nrPagini) {
        this.nrPagini = nrPagini;
    }

    @Override
    public String toString() {
        return "Carte{" +
                "titlu='" + titlu + '\'' +
                ", editura='" + editura + '\'' +
                ", nrPagini=" + nrPagini +
                '}';
    }
}

class Autor {
    private String nume;
    private List<Carte> carti;

    public Autor(String nume) {
        this.nume = nume;
        this.carti = new ArrayList<>();
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public List<Carte> getCarti() {
        return carti;
    }

    public void setCarti(List<Carte> carti) {
        this.carti = carti;
    }

    public void adaugaCarte(Carte carte) {
        carti.add(carte);
    }

    public Carte carteNrMaximPagini() {
        Carte carteMax = carti.get(0); //setam cartea cu nr maxim de pagini ca fiind prima carte din lista
        if (carti.isEmpty()) {
            return null;
        }
        for (Carte carte : carti) {
            if (carte.getNrPagini() > carteMax.getNrPagini()) {
                carteMax = carte;
            }
        }
        return carteMax;
    }

    public Carte dupaNume(String nume) {
        for (Carte carte : carti) {
            if (carte.getTitlu() == nume) {
                return carte;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "nume='" + nume + '\'' +
                ", carti=" + carti +
                '}';
    }
}

public class CarteMain {
    public static void main(String[] args) {
        Autor autor = new Autor("Collen Hoover");
        Carte carte1 = new Carte("It Ends with Us", "Atria Books", 384);
        Carte carte2 = new Carte("Ugly Love", "Atria Books", 336);
        Carte carte3 = new Carte("Verity", "Grand Central Publishing", 336);
        autor.adaugaCarte(carte1);
        autor.adaugaCarte(carte2);
        autor.adaugaCarte(carte3);

        System.out.println("Cartea cu numarul maxim de pagini: " + autor.carteNrMaximPagini());
        String titluCautat = "Verity";
        Carte carteGasita = autor.dupaNume(titluCautat);
        if (carteGasita != null) {
            System.out.println("Cartea gasita: " + carteGasita);
        } else {
            System.out.println("Cartea cu titlul cautat " + titluCautat + " nu exista in colectia autorului " + autor.getNume());
        }
    }
}
