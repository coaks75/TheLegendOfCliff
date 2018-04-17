import java.util.ArrayList;

/**
 * A class for a container.
 *
 * @author Chris Coakley
 * @version 16 April 2018
 */
public class Container extends Item{
    /** A field for the items in the container. */
    private ArrayList<Item> items;

    /**
     * Constructor for a container.
     * 
     * @param nameValue The name of the container.
     * @param descriptionValue The description of the container.
     * @param pointsValue The points associated with this container.
     * @param weightValue The weight of the item.
     */ 
    public Container(String nameValue, String descriptionValue, int pointsValue, int weightValue) {
        super(nameValue, descriptionValue, pointsValue,weightValue);
        items = new ArrayList<Item>();
    }

    /**
     * A method used to add an item to the container.
     * 
     * @param itemValue The item we are adding to the container.
     */
    public void addItem(Item itemValue) {
        items.add(itemValue);
    }

    /**
     * A method used to remove an item from a container.
     * 
     * @param name The name of item we are removing from the container.
     */
    public Item removeItem(String name) {
        Item removing = null;
        boolean done = false;
        int index = 0;
        while (index < items.size() && done == false) {
            if (items.get(index).getName().equalsIgnoreCase(name)) {
                removing = items.get(index);
                items.remove(removing);
                done = true;
            }
            index++;
        }
        return removing;
    }
    
    /**
     * The to string method of the container class.
     */
    public String toString() {
        String answer = "";
        for (Item element : items) {
            answer += element.getName() + ", ";
        }
        return answer;
    }
    
}
