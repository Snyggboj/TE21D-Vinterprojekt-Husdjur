import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello husdjur!");

        Scanner skannarGreg = new Scanner(System.in);
        System.out.println("Välj namn på hushåll:");

        Household hh1 = new Household(skannarGreg.nextLine());

        showMenu(hh1);

    }

    public static void showMenu(Household household){
        Scanner menuScan = new Scanner(System.in);
        if (household.getPets().isEmpty()){
            System.out.println("Du har inga djur");
            System.out.println("Dags att skaffa ett!");
            System.out.println("Välj typ:");
            System.out.println("1.Hund \n2.Fisk \n3.Fågel");
            
            boolean svar = true;
            while(svar){
                svar = false;
                switch (menuScan.nextLine()) {
                    case "1" -> household.addDog();
                    case "2" -> household.addFish();
                    case "3" -> household.addBird();
                    default -> {
                        System.out.println("tal tack");
                        svar = true;
                    }
                }
            }
        } else{
            System.out.println("Välj ett djur:");
            household.printPets();
        }
    }
}