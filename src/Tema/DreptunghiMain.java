package Tema;

import com.sun.security.jgss.GSSUtil;

class Dreptunghi {
    private int lungime;
    private int latime;
    public static int count = 0;

    public Dreptunghi(int lungime, int latime) {
        this.lungime = lungime;
        this.latime = latime;
        count++;
    }

    public static int getCount() {
        return count;
    }

    public int arie() {
        return lungime * latime;
    }

    public int perimetru() {
        return 2 * lungime + 2 * latime;
    }

    @Override
    public String toString() {
        return "Lungime: " + lungime + ", Latime: " + latime + ", Arie: " + arie() + ", Perimetru: " + perimetru();
    }
}

public class DreptunghiMain {
    public static void main(String[] args) {
        Dreptunghi dr = new Dreptunghi(5, 7);
        Dreptunghi dr1 = new Dreptunghi(3, 10);
        Dreptunghi dr2 = new Dreptunghi(2, 2);
        System.out.println("Primul dreptunghi creat: " + dr);
        System.out.println("Aria dreptungiului: " + dr.arie());
        System.out.println("Perimetrul dreptunghiului: " + dr.perimetru());
        System.out.println("S-au creat: " + Dreptunghi.getCount() + " instante ale clasei Dreptunghi");
    }
}
