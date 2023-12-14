public class Main {
    public static void main(String[] args) {
        System.out.println("Hello husdjur!");

        Household hh1 = new Household("Carlberg");

        hh1.addPet("carl");
        hh1.addPet("berg");

        hh1.printPets();
    }
}