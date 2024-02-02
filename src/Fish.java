import java.util.Scanner;

public class Fish extends Animal{
    public Fish(String name, Household household) {
        super(name, household, "fish");
    }

    @Override
    public void activity() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Knacka på glaset? J/N");

        switch(scan.nextLine().toUpperCase()){
            case "J" -> {
                System.out.println("Du knackade på glaset \nDin fisk tappade ett liv");
                lives--;
            }
            default -> System.out.println("Du knackade inte på glaset \nInget hände");
        }
    }
}
