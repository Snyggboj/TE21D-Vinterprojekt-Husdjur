import java.util.ArrayList;
import java.util.Scanner;

public class PetGame {
    private Scanner skannare = new Scanner(System.in);
    private ArrayList<Household> households = new ArrayList<Household>();

    public PetGame(){
        System.out.println("Du har inget hushåll");
        System.out.println("Dags att skapa ett!");
        households.add(addHousehold());

        showMenu(chooseHousehold());
    }

    public Household addHousehold(){
        System.out.println("Välj namn på hushåll:");

        return new Household(skannare.nextLine());
    }

    public Household chooseHousehold(){
        System.out.println("Vilket hushåll är tillhör du?");
        printHouseholds();
        System.out.println((households.size() + 1) + ".Skapa nytt");
        int index;
        while(true) {
            try {
                index = Integer.parseInt(skannare.nextLine()) - 1;
                if(index >= 0 && index < households.size()){
                    break;
                } else {
                    if (index == households.size()){
                        households.add(addHousehold());
                    }
                    System.out.println("Välj ett nummer på listan");
                }
            } catch (NumberFormatException e) {
                System.out.println("Välj ett nummer på listan");
            }
        }
        return households.get(index);
    }

    public void printHouseholds(){
        for (int i = 0; i < households.size(); i++){
            System.out.println((i + 1) + ". " + households.get(i).getName());
        }
    }

    public void showMenu(Household household){
        boolean keepGoing = true;
        while(keepGoing){
            System.out.println("Vad vill du göra?");
            System.out.println("1.Komma åt dina djur");
            System.out.println("2.Besöka djurkyrkogården");
            System.out.println("3.Byta hushåll");
            System.out.println("4.Avsluta spelet");

            boolean svar = true;
            while(svar){
                svar = false;
                switch (skannare.nextLine()){
                    case "1" -> accessAnimals(household);
                    case "2" -> household.printPets(household.getPetCemetary());
                    case "3" -> household = chooseHousehold();
                    case "4" -> keepGoing = false;
                    default -> {
                        System.out.println("tal tack");
                        svar = true;
                    }
                }
            }
        }
    }

    public void accessAnimals(Household household){
        if (household.getPets().isEmpty()){
            System.out.println("Du har inga djur");
            System.out.println("Dags att skaffa ett!");
            household.addPet();
        } else{
            System.out.println("Välj ett djur:");
            household.printPets(household.getPets());
            System.out.println((household.getPets().size() + 1) + ". Skaffa nytt");
            int index;
            while(true) {
                try {
                    index = Integer.parseInt(skannare.nextLine()) - 1;
                    if(index >= 0 && index < household.getPets().size()){
                        break;
                    } else {
                        if(index == household.getPets().size()){
                            household.addPet();
                        } else {
                            System.out.println("Välj ett nummer på listan");
                        }
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Välj ett nummer på listan");
                }
            }
            petAction(household.getPets().get(index));
        }
    }

    public void petAction(Animal animal){
        System.out.println("Vad vill du göra?");
        System.out.println("1.Leka \n2.Mata \n3.Aktivitet");

        boolean svar = true;
        while(svar){
            svar = false;
            switch (skannare.nextLine()) {
                case "1" -> animal.play();
                case "2" -> animal.feed();
                case "3" -> animal.activity();
                default -> {
                    System.out.println("tal tack");
                    svar = true;
                }
            }
        }
    }
}
