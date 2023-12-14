import java.util.ArrayList;

public class Household {
    String name;
    ArrayList<Animal> pets = new ArrayList<Animal>();

    // Constructor
    public Household(String name){
        this.name = name;
    }

    // Methods
    public void addPet(String name){
        pets.add(new Animal(name));
    }
    public void printPets(){
        System.out.println(name + "´s husdjur: ");
        for(int i = 0; i < pets.size(); i++){
            System.out.println((i + 1) + ". " + pets.get(i).name);
        }
    }

}
