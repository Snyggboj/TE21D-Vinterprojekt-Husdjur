import java.util.ArrayList;
import java.util.Scanner;

// Class for in game households
public class Household {
    // Attributes
    private String name;
    private ArrayList<Animal> pets = new ArrayList<Animal>();
    private ArrayList<Animal> petCemetary = new ArrayList<Animal>();

    // Constructor
    public Household(String name){
        this.name = name;
    }

    // Methods
    // Add pet to household
    public void addPet(){
        Scanner scanType = new Scanner(System.in);
        System.out.println("Välj typ:");
        System.out.println("1.Hund \n2.Fisk \n3.Fågel");

        boolean svar = true;
        while(svar){
            svar = false;
            switch (scanType.nextLine()) {
                case "1" -> this.addDog();
                case "2" -> this.addFish();
                case "3" -> this.addBird();
                default -> {
                    System.out.println("tal tack");
                    svar = true;
                }
            }
        }
    }
    // Write out all pets in list
    public void printPets(ArrayList<Animal> lista){
        for(int i = 0; i < lista.size(); i++){
            System.out.println((i + 1) + ". " + lista.get(i).name);
            System.out.println("Typ: " + lista.get(i).getType());
            System.out.println("Liv kvar: " + lista.get(i).getLives());
            System.out.println("Hunger: " + lista.get(i).getHunger() + "/" + lista.get(i).getHungerMax());
            System.out.println("Uttråknad: " + lista.get(i).getBoredom() + "/" + lista.get(i).getBoredomLimit());
            System.out.println();
        }
    }
    // Specific method for adding a dog
    public void addDog(){
        System.out.println("Vad ska din hund heta? ");
        Scanner nameScan = new Scanner(System.in);
        pets.add(new Dog(nameScan.nextLine(), this));
    }
    // Specific method for adding a fish
    public void addFish(){
        System.out.println("Vad ska din fisk heta? ");
        Scanner nameScan = new Scanner(System.in);
        pets.add(new Fish(nameScan.nextLine(), this));
    }
    // Specific method for adding a bird
    public void addBird(){
        System.out.println("Vad ska din fågel heta? ");
        Scanner nameScan = new Scanner(System.in);
        pets.add(new Bird(nameScan.nextLine(), this));
    }
    // Ticks all animals to raise hunger and boredom
    public void tickAnimals(){
        for (int i = 0; i < pets.size(); i++){
            pets.get(i).tick();
        }
    }

    // Getters och setters
    public ArrayList<Animal> getPets() {
        return pets;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Animal> getPetCemetary() {
        return petCemetary;
    }
}
