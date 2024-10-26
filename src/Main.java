public class Main {
    public static void main(String[] args) {
        Laptop laptopMarco=new Laptop();//1referinta=2obiect
        Laptop laptopMihai=new Laptop();
        laptopMarco=laptopMihai;
        Laptop hpXyzy=new Laptop(16,"HP","Xyzy");
        System.out.println("Memoria este: "+hpXyzy.getMemorie());

        System.out.println(hpXyzy); //afiseaza Laptop si o zona de memorie daca nu redefinim toString(metoda toString din Object)
        System.out.println(hpXyzy.toString());//same thing
    }
}
