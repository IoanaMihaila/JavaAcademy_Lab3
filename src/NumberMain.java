/*Creati o clasa Numar, ce va avea un atribut privat, de tip intreg. Definiti doi constructori, unul in care atributul ia o valoarea standard, aleasa de voi, si unul care va primi ca parametru o valoare.
Definiti o metoda publica ce va returna valoarea atributului.
Definiti o metoda adunare, ce va primi ca parametru un obiect de tip Numar. Metoda
va returna un alt obiect de tip Numar, noul obiect fiind compus din adunarea atributului
 numar de pe obiectul curent si valoarea atributului de la obiectul primit ca parametru.

Creati (cel putin) doua obiecte si salvati noul obiect primit in urma adunarii
celor doua obiecte, apoi afisati pe ecran valoarea continuta de noul obiect.
 */


class Number {
    private int nr;

    public Number() {
        this.nr=10;
    }
    public Number(int nr) {
        this.nr = nr;
    }

    public int getNr() {
        return nr;
    }

    public Number adunare(Number num){
        return new Number(this.nr+num.getNr());
    }

    @Override
    public String toString() {
        return "Suma dintre nr1 si nr2 este: " + nr;
    }
}

public class NumberMain{
    public static void main(String[] args) {
        Number nr1=new Number(15);
        Number nr2=new Number();
        System.out.println(nr1.adunare(nr2));
    }
}
