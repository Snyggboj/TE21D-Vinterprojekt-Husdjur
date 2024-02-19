import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

// Class for in game birds, subclass of Animal
public class Bird extends Animal{
    // Attributes
    ArrayList<String> vocabulary = new ArrayList<String>();

    // Constructor
    public Bird(String name, Household household) {
        super(name, household, "bird");
    }

    // Override method activity for birds
    // Enables bird to say a random word from a list or teach the bird a new word
    @Override
    public void activity() {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        if (vocabulary.isEmpty()){
            System.out.println(name + " kan inga ord än");
            System.out.println("Lär den ett!");
            String nyttOrd = scan.nextLine();
            vocabulary.add(nyttOrd);
            System.out.println(name + " har nu lärt sig att säga " + nyttOrd);
        } else {
            System.out.println("Ska " + name + " säga nåt (J/N) eller vill du lära den ett nytt ord?");
            String val = scan.nextLine().toUpperCase();
            switch (val){
                case "J" -> System.out.println(name + " sa " + vocabulary.get(random.nextInt(vocabulary.size())));
                case "N" -> System.out.println(name + " sa inget");
                default -> {
                    if (val.contains("LÄR") || val.contains("NYTT")){
                        System.out.println("Vilket ord vill du lära " + name + ":");
                        String nyttOrd = scan.nextLine();
                        vocabulary.add(nyttOrd);
                        System.out.println(name + " har nu lärt sig att säga " + nyttOrd);
                    } else {
                        System.out.println(name + " sa inget");
                    }
                }
            }
        }
    }
}
