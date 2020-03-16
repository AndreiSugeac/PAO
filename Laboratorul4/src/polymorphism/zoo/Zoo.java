package polymorphism.zoo;

public class Zoo {

    /*static {

    }
    blocuri de initializare
    {
        nrMaxAnimale = 5;
    }*/

    private final int nrMaxAnimale;
    Animal[] animaleZoo;
    private int indexCurent;

    public Zoo(int nrMaxAnimale) {
        if (nrMaxAnimale > 0) {
            this.nrMaxAnimale = nrMaxAnimale;
            this.animaleZoo = new Animal[nrMaxAnimale];
        } else {
            throw new RuntimeException("Nu ati introdus un numar intreg pozitiv.");
        }
    }

    public void adaugaAnimal(Animal animal) {
        if(indexCurent < animaleZoo.length) {
            animaleZoo[indexCurent] = animal;
            System.out.println("Adauga animal " + animal.getClass().getSimpleName() + " la pozitia " + indexCurent++);
        }
    }

}
