import java.util.ArrayList;
import java.util.Scanner;

public class Household {
    private String name;
    private ArrayList<Animal> pets = new ArrayList<Animal>();
    private ArrayList<Animal> petCemetary = new ArrayList<Animal>();

    // Constructor
    public Household(String name){
        this.name = name;
    }

    // Methods
    public void addPet(Animal animal){
        pets.add(animal);
    }
    public void printPets(){
        for(int i = 0; i < pets.size(); i++){
            System.out.println((i + 1) + ". " + pets.get(i).name);
            System.out.println("Lives: " + pets.get(i).getLives());
            System.out.println("Hunger: " + pets.get(i).getHunger());
            System.out.println("Boredom: " + pets.get(i).getBoredom());
        }
    }
    public void addDog(){
        Scanner nameScan = new Scanner(System.in);
        pets.add(new Dog(nameScan.nextLine()));
    }
    public void addFish(){
        Scanner nameScan = new Scanner(System.in);
        pets.add(new Fish(nameScan.nextLine()));
    }
    public void addBird(){
        Scanner nameScan = new Scanner(System.in);
        pets.add(new Bird(nameScan.nextLine()));
    }


    // Getters och setters
    public ArrayList<Animal> getPets() {
        return pets;
    }
}
