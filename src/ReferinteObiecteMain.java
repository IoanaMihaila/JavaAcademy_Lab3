class Numar{
    private int numar;
    public Numar(int numar){
        this.numar=numar;
    }

    public int getNumar() {
        return numar;
    }

    public void setNumar(int numar) {
        this.numar = numar;
    }

    @Override
    public String toString() {
        return "Numar{" +
                "numar=" + numar +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Numar numar1 = (Numar) o; //down cast, coboram de la Object la Numar(periculos-e nevoie de verificare)
        //aici e ok datorita verificarii de mai sus
        return numar == numar1.numar;
    }
}

public class ReferinteObiecteMain {
    public static void main(String[] args) {
        Numar numar1=new Numar(1);
        Numar numar2=new Numar(2);
        Numar numar3=new Numar(3);
        numar2=numar3;
        //numar1= numar2;//numar1 indica spre obiectul numar2
        System.out.println(numar1);
        System.out.println(numar2);
        System.out.println(numar3);

        System.out.println(numar1==numar2); //verifica daca adresele de memorie sunt egale
        System.out.println(numar1.equals(numar2)); //verifica continutul
    }
}
