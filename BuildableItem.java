import java.util.HashSet;
/**
 * An item that can be built.
 *
 * @author Chris Coakley
 * @version 30 April 2018
 */
public class BuildableItem extends Item {
    /** A field for the items needed to build this. */
    private HashSet<Item> itemsNeeded;
    /** A field saying if its built. */
    private boolean isBuilt;
    
    /**
     * Constructor for a buildable item.
     * 
     * @param nameValue The name of an item.
     * @param descriptionValue The description of an item.
     * @param pointsValue The points associated with an item.
     * @param weightValue he weight of an item.
     */
    public BuildableItem(String nameValue, String descriptionValue, int pointsValue, double weightValue) {
        super(nameValue, descriptionValue, pointsValue, weightValue);
        itemsNeeded = new HashSet<Item>();
        isBuilt = false;
    }
    
    /**
     * Accessor method for the items needed to build this.
     * 
     * @return Names of the items neeeded to build this.
     */
    public HashSet<Item> getItemsNeeded() {
        return itemsNeeded;
    }
    
    /**
     * A method used to add an item to the items needed.
     * 
     * @param itemValue An item neeed to make this.
     */
    public void addItemNeeded(Item itemValue) {
        itemsNeeded.add(itemValue);
    }
}
