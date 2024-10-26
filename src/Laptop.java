public class Laptop {
    private int memorie;
    private String marca;
    private String model;
    private int pretAchizitie;
    private int memorieStocare;

    public Laptop() {

    }

    public Laptop(int memorie, String marca, String model, int pretAchizitie, int memorieStocare) {
        this.memorie = memorie;
        this.marca = marca;
        this.model = model;
        this.pretAchizitie = pretAchizitie;
        this.memorieStocare = memorieStocare;
    }

    public Laptop(int memorie, String marca, String model){
        this.memorie=memorie;
        this.marca=marca;
        this.model=model;
        this.pretAchizitie=3500;
        this.memorieStocare=50;
    }

    public void afisareMesajBunVenit() {
        System.out.println("Hello!");
    }

    public void porneste() {
        System.out.println("Laptop-ul porneste...");
    }

    public int getMemorie() {
        return memorie;
    }

    public void setMemorie(int memorie) {
        if (memorie < 0 || memorie > 128) {
            System.out.println("Valoarea memorie nu se afla in intervalul [0,128]");
        } else {
            this.memorie = memorie;
        }
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPretAchizitie() {
        return pretAchizitie;
    }

    public void setPretAchizitie(int pretAchizitie) {
        this.pretAchizitie = pretAchizitie;
    }

    public int getMemorieStocare() {
        return memorieStocare;
    }

    public void setMemorieStocare(int memorieStocare) {
        this.memorieStocare = memorieStocare;
    }

    //suprascriere
    public String toString(){
        return "Laptop"+this.memorie;
    }


}




