package Tema;

class ExercitiuToString {
    private int atr;

    public ExercitiuToString(int atr) {
        this.atr = atr;
    }

    @Override
    public String toString() {
        return "Valoarea este: " + atr;
    }
}

public class ExercitiuToStringMain {
    public static void main(String[] args) {
        ExercitiuToString exToString = new ExercitiuToString(14);
        System.out.println(exToString);
    }
}