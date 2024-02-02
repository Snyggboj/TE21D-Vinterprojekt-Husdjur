import java.util.ArrayList;

public class Dog extends Animal{
    // Attributes
    ArrayList<String> tricks = new ArrayList<String>();

    public Dog(String name, Household household){
        super(name, household, "dog");
    }

    @Override
    public void activity() {
        super.activity();
    }
}
