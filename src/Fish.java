import java.util.Scanner;

// Class for in game fish, subclass of Animal
public class Fish extends Animal{
    // Constructor
    public Fish(String name, Household household) {
        super(name, household, "fish");
    }

    // Override method activity for fish
    // Enables player to choose to tap on fishes glass resulting in death
    @Override
    public void activity() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Knacka på glaset? J/N");

        switch(scan.nextLine().toUpperCase()){
            case "J" -> {
                System.out.println("Du knackade på glaset \nDin fisk tappade ett liv");
                lives--;
                resetLife();
            }
            default -> System.out.println("Du knackade inte på glaset \nInget hände");
        }
    }
}
