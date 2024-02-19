// Class for basic animals in game
public class Animal {
    // Attributes
    private boolean alive = true;
    protected int lives = 3;
    public String name;
    private String type;
    private int hunger = 5;
    private int boredom = 5;
    private final int hungerMax = 10;
    private final int boredomLimit = 10;
    private Household household;

    // Constructors
    public Animal(String name, Household household, String type){
        this.name = name;
        this.household = household;
        this.type = type;
    }
    public Animal(){}

    // Methods
    // Feed pet, lowers hunger
    public void feed(){
        if (hunger == 0){
            // Övermatad
            this.lives--;
            resetLife();
        } else {
            hunger -= hungerMax/5;
            if (hunger > hungerMax){
                hunger = hungerMax;
            }
        }
    }
    // Play with pet, lowers boredom
    public void play(){
        if (boredom == 0){
            // Överstimulerad
            resetLife();
        } else {
            boredom -= boredomLimit/5;
            if (boredom > boredomLimit){
                boredom = boredomLimit;
            }
        }
    }
    // tick pet when action is done, raises hunger and boredom
    public void tick(){
        hunger += hungerMax/10;
        boredom += boredomLimit/10;

        if (hunger <= 1 || boredom <= 1){
            lives--;
            hunger = 5;
            boredom = 5;
        }

        if(lives == 0){
            System.out.println(name  + " har dött");
            System.out.println("Du kan besöka det i djurkyrkogården");
            alive = false;
            household.getPetCemetary().add(this);
        }
    }

    // Reset life when pet has lost one
    protected void resetLife() {
        System.out.println(name + " har blivit av med ett liv");
        System.out.println("Liv kvar: " + lives);
        hunger = 5;
        boredom = 5;
    }

    // Do an activity with a pet, different for different types
    public void activity(){
    }

    // Getters and setters
    public int getHunger() {
        return hunger;
    }

    public int getBoredom() {
        return boredom;
    }

    public int getHungerMax() {
        return hungerMax;
    }

    public int getBoredomLimit() {
        return boredomLimit;
    }

    public int getLives() {
        return lives;
    }

    public String getType() {
        return type;
    }
    public Household getHousehold() {
        return household;
    }
}
