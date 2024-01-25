public class Animal {
    // Attributes
    private boolean alive = true;
    private int lives = 3;
    public String name;
    private int hunger = 5;
    private int boredom = 5;
    private final int hungerMax = 10;
    private final int boredomLimit = 10;

    // Constructors
    public Animal(String name){
        this.name = name;
    }
    public Animal(){}

    // Methods
    public void feed(){
        if (hunger == 0){
            // Övermatad
            this.lives--;
            hunger = 0;
        } else {
            hunger -= hungerMax/5;
            if (hunger > hungerMax){
                hunger = hungerMax;
            }
        }
    }
    public void play(){
        if (boredom == 0){
            // Överstimulerad
            this.lives--;
            boredom = 0;
        } else {
            boredom -= boredomLimit/5;
            if (boredom > boredomLimit){
                boredom = boredomLimit;
            }
        }
    }
    public void tick(){
        hunger += hungerMax/10;
        boredom += boredomLimit/10;

        if (hunger <= 1 || boredom <= 1){
            lives--;
            hunger = 5;
            boredom = 5;
        }

        if(lives == 0){
            alive = false;
            resetLife();
        }
    }

    private void resetLife() {
        lives = 3;
        hunger = 5;
        boredom = 5;
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
}
