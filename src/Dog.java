import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

// Class for in game dogs, subclass of Animal
public class Dog extends Animal{
    // Attributes
    ArrayList<String> tricks = new ArrayList<String>();

    // Constructor
    public Dog(String name, Household household){
        super(name, household, "dog");
    }

    // Override method activity for dogs
    // Enables player to choose from a list of tricks for the dog to do or teach the dog a new trick
    @Override
    public void activity() {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        if (tricks.isEmpty()){
            System.out.println(name + " kan inga trick än");
            System.out.println("Lär den ett!");
            String nyttTrick = scan.nextLine();
            tricks.add(nyttTrick);
            System.out.println(name + " har nu lärt sig att göra tricket " + nyttTrick);
        } else {
            System.out.println("Ska " + name + " göra ett trick (J/N) eller vill du lära den ett nytt Trick?");
            String val = scan.nextLine().toUpperCase();
            switch (val){
                case "J" -> {
                    System.out.println("Vilket trick ska " + name + " göra?");
                    for (int i = 0; i < tricks.size(); i++){
                        System.out.println((i + 1) + "." + tricks.get(i));
                    }
                    int trickIndex;
                    while (true){
                        try {
                            trickIndex = Integer.parseInt(scan.nextLine()) - 1;
                            if (trickIndex >= tricks.size()){
                                System.out.println(name  + "  gjorde tricket " + tricks.get(trickIndex));
                                break;
                            } else {
                                System.out.println("Skriv ett nummer på listan");
                            }
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Skriv ett nummer på listan");
                        }
                    }
                }
                case "N" -> System.out.println(name + " gjorde inget trick");
                default -> {
                    if (val.contains("LÄR") || val.contains("NYTT")){
                        System.out.println("Vilket trick vill du lära " + name + ":");
                        String nyttOrd = scan.nextLine();
                        tricks.add(nyttOrd);
                        System.out.println(name + " har nu lärt sig att göra tricket " + nyttOrd);
                    } else {
                        System.out.println(name + " gjorde inget trick");
                    }
                }
            }
        }
    }
}
