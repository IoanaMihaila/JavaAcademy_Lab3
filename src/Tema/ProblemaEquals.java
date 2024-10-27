package Tema;


import java.util.Arrays;
import java.util.Objects;

class ColectiePantofi {
    private String[] pantofi;
    private int nrPantofi;
    private int indexCurent;

    public ColectiePantofi(int nrPantofi) {
        this.nrPantofi = nrPantofi;
        this.pantofi = new String[nrPantofi];
        this.indexCurent = 0;
    }

    public String[] getPantofi() {
        return pantofi;
    }

    public void setPantofi(String[] pantofi) {
        this.pantofi = pantofi;
    }

    public int getNrPantofi() {
        return nrPantofi;
    }

    public void setNrPantofi(int nrPantofi) {
        this.nrPantofi = nrPantofi;
    }

    public void adaugaPantofi(String pantof) {
        if (indexCurent < nrPantofi) { // Verifică dacă mai este spațiu
            pantofi[indexCurent] = pantof;
            indexCurent++; // Incrementează indexul pentru următoarea poziție
        } else {
            System.out.println("Nu mai există spațiu pentru a adăuga pantofi noi.");
        }
    }

    @Override
    public String toString() {
        return "colectiePantofi{" +
                "pantofi=" + Arrays.toString(pantofi) +
                ", nrPantofi=" + nrPantofi +
                '}';
    }

    //equals verifica continutul
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; //verifica daca cele doua referinte sunt identice in memorie
        if (o == null || getClass() != o.getClass())
            return false; //verifica daca o e null si daca cele doua obiecte sunt instante ale aceleiasi clase
        ColectiePantofi that = (ColectiePantofi) o; //cast obiectului o la tipul colectiePantofi
        return nrPantofi == that.nrPantofi;//Compară atributul nrPantofi al obiectului curent (this.nrPantofi) cu atributul nrPantofi al obiectului that
    }
}

public class ProblemaEquals {
    public static void main(String[] args) {
        ColectiePantofi cp1 = new ColectiePantofi(3);
        ColectiePantofi cp2 = new ColectiePantofi(3);
        cp1.adaugaPantofi("Nike");
        cp1.adaugaPantofi("botine");
        cp1.adaugaPantofi("bocanci");
        System.out.println(cp1);
        cp2.adaugaPantofi("Converse");
        cp2.adaugaPantofi("Adidas");
        cp2.adaugaPantofi("sandale");
        System.out.println(cp2);

        System.out.println(cp1 == cp2);//verifica daca cele doua obiecte se afla la aceasi locatie de memorie
        System.out.println(cp1.equals(cp2)); //verifica daca cele doua obiecte au acelasi numar de pantofi
    }
}
