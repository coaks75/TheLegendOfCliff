
/**
 * An interface for something that can be eaten.
 *
 * @author Chris Coakley
 * @version 29 April 2018
 */
public interface Edible {
    /**
     * Accessor method for the healthGained
     * 
     * @return The health gained
     */
    public int getHealthGained();
    
    /**
     * Mutator method for the health gained from this food
     * 
     * @param healthGainedValue The health you will gain from eating this.
     */
    public void setHealthgained(int healthGainedValue);
    
    
}
