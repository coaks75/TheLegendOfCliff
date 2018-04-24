
/**
 * Write a description of class Food here.
 *
 * @author Chris Coakley
 * @version 24 April 2018
 */
public class Food extends Item{
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
    
    /**
     * Accessor method for the healthGained
     * 
     * @return The health gained
     */
    public int getHealthGained() {
        return healthGained;
    }
    
    /**
     * Mutator method for the health gained from this food
     * 
     * @param healthGainedValue The health you will gain from eating this.
     */
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
