package Tema;

class Priza {
    private int tensiune;

    public Priza(int tensiune) {
        this.tensiune = tensiune;
    }

    public void setTensiune(int t) {
        this.tensiune = t;
    }

    public int getTensiune() {
        return this.tensiune;
    }

}

public class PrizaMain {
    public static void main(String argv[]) {
        Priza p1, p2, p3;
        p1 = new Priza(200); //p1.getTensiune=200
        p2 = p1;//p2 indica acum la acelasi obiect din memorie ca si p1. p1 si p2 refera la aceasi instanta a clasei Priza
        p2.setTensiune(400); //p1.getTensiune()=p2.getTensiune()=400
        p3 = p2;
        p3.setTensiune(100);//p1.getTensiune()=p2.getTensiune()=p3.getTensiune()=100
        System.out.println(p1.getTensiune());//100
    }

}
