package Imutabilitate;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Adresa domiciliu = new Adresa("Timisoara", "4A");
        Persoana persoana = new Persoana(1, "Teo", domiciliu);
        String numePersoana = persoana.getNume().toUpperCase();
        System.out.println(persoana);
        System.out.println(numePersoana);

        String stradaUppercase = domiciliu.getStrada().toUpperCase();
        domiciliu.setStrada(stradaUppercase);
        System.out.println(persoana);

        Adresa adresaDomiciliu = persoana.getAdresa();
        adresaDomiciliu.setStrada(adresaDomiciliu.getStrada().toUpperCase());
        System.out.println(persoana);

    }
}
