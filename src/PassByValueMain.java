public class PassByValueMain {
    public static void schimbareNumar(int numar) {
        numar = 10;
        System.out.println("In metoda: " + numar);
    }
    public static void main(String[] args) {
        int numar = 50;
        schimbareNumar(numar);
        System.out.println(numar);
    }
}