
/**
 * Write a description of class Food here.
 *
 * @author Chris Coakley
 * @version 24 April 2018
 */
public class Food extends Item implements Edible{
    /** A field for the health gained form eating this. */
    private int healthGained;
    
    /**
     * Constructor for a food.
     * 
     * @param nameValue The name of the container.
     * @param descriptionValue The description of the container.
     * @param pointsValue The points associated with this container.
     * @param weightValue The weight of the item.
     */ 
    public Food(String nameValue, String descriptionValue, int pointsValue, int weightValue, int healthGainedValue) {
        super(nameValue, descriptionValue, pointsValue,weightValue);
        healthGained = healthGainedValue;
    }
    
    @Override
    public int getHealthGained() {
        return healthGained;
    }
    
    @Override
    public void setHealthgained(int healthGainedValue) {
        healthGained = healthGainedValue;
    }
    
    /**
     * The to string method for the food class.
     * 
     * @return The string of stuff
     */
    public String toStirng() {
        String answer = super.toString();
        answer += "\n\t" + super.getName() + " also should restore " + healthGained + " health.";
        return answer;
    }
}
