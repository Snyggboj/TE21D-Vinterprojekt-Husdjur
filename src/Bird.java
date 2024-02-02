import java.util.ArrayList;

public class Bird extends Animal{
    // Attributes
    ArrayList<String> vocabulary = new ArrayList<String>();
    public Bird(String name, Household household) {
        super(name, household, "bird");
    }

    @Override
    public void activity() {

    }
}
