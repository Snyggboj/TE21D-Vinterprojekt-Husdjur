public class Animal {
    // Attributes
    private boolean alive = true;
    public String name;
    private int hunger = 10;
    private final int hungerMax = 10;
    private int boredom = 0;
    private final int boredomLimit = 10;

    // Constructors
    public Animal(String name){
        this.name = name;
        this.tick();
    }
    public Animal(){}

    // Methods
    public void feed(){
        if (hunger == hungerMax){
            alive = false;
        } else {
            hunger += hungerMax/5;
            if (hunger > hungerMax){
                hunger = hungerMax;
            }
        }
        this.tick();
    }
    public void play(){
        if (boredom == boredomLimit){
            alive = false;
        } else {
            boredom += boredomLimit/5;
            if (boredom > boredomLimit){
                boredom = boredomLimit;
            }
        }
        this.tick();
    }
    public void tick(){
        hunger += hungerMax/10;
        boredom += boredomLimit/10;
    }
}
