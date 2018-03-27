
/**
 * A class for basic items.
 *
 * @author Chris Coakley
 * @version 20 March 2018
 */
public class Item {
    /** A field for the name of an item. */
    private String name;
    /** A field for the description of an item. */
    private String description;
    /** A field for the point value associated with an item. */
    private int points;
    /** A field for the weight of an item. */
    private double weight;
    
    /**
     * Constructor for an item.
     * 
     * @param nameValue The name of an item.
     * @param descriptionValue The description of an item.
     * @param pointsValue The points associated with an item.
     * @param weightValue he weight of an item.
     */
    public Item(String nameValue, String descriptionValue, int pointsValue, double weightValue) {
        name = nameValue;
        description = descriptionValue;
        points = pointsValue;
        weight = weightValue;
    }
    
    /**
     * Mutator method for the description.
     * 
     * @param descriptionValue The new description.
     */
    public void setDescription(String descriptionValue) {
        description = descriptionValue;
    }
    
    /**
     * Mutator method for the weight of an item.
     *      This method is for if an item breaks,
     *      a broken sword does not weigh as much as a regular sword.
     *      
     * @param weightValue The new weight of an item.
     */
    public void setWeight(Double weightValue) {
        weight = weightValue;
    }
    
    /**
     * Accessor method for the name of an item.
     * 
     * @reurn The name of an item.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Accessor method for the description of an item.
     * 
     * @return The description of an item.
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * Accessor method for the points of an item.
     * 
     * @return The points of an item.
     */
    public int getPoints() {
        return points;
    }
    
    /**
     * Accessor method for the weight of an item.
     * 
     * @return The weight of an item.
     */
    public double getWeight() {
        return weight;
    }
    
    /**
     * A method used to get the complete description of an item.
     * 
     * @return A toString for the item.
     */
    public String toString() {
        String answer = "This " + name + " is " + description;
        if (weight >= 7) {
            answer += " and is heavy.";
        }
        else {
            answer += " and is light.";
        }
        return answer;
    }
}
