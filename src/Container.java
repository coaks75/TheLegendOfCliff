import java.util.ArrayList;

/**
 * A class for a container.
 *
 * @author Chris Coakley
 * @version 16 April 2018
 */
public class Container extends Item implements Lockable{
    /** A field for the items in the container. */
    private ArrayList<Item> items;
    /** Whether this container is locked. */
    private boolean locked;
    /** The key to the container. */
    private Item key;

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

    @Override
    public double getWeight() {
        double answer = super.getWeight();
        for (Item element : items) {
            answer += element.getWeight();
        }
        return answer;
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
     * @return The item we removed.
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
     * A method to check if a container is holding an item.
     * 
     * @param name The name of the item we are looking for.
     * @return If it is in the container.
     */
    public Item getItem(String name) {
        Item answer = null;
        boolean done = false;
        int index = 0;
        while (index < items.size() && done == false) {
            if (items.get(index).getName().equalsIgnoreCase(name)) {
                answer = items.get(index);
                done = true;
            }
            index++;
        }
        return answer;
    }

    /**
     * The to string method of the container class.
     * 
     * @return The string of stuff
     */
    public String toString() {
        String answer = super.toString();
        if (!locked) {
            answer += "\nContains\n\t";
            if (items.size() > 0) {
                for (Item element : items) {
                    answer += element.getName() + ", ";
                }
            }
            else {
                answer += "Nothing right now";
            }
        }
        else {
            answer += " is locked right now.";
        }
        return answer;
    }
    
    /**
     * A method used to get a string of the items inhere
     * 
     * @return A string of all the items in this container.
     */
    public String getItemString() {
        String answer = "";
        
        if (items.size() == 0) {
            answer += "currently nothing";
        }
        else {
            for (Item element : items) {
                answer += element.getName() + ", ";
            }
        }
        
        return answer;
    }

    @Override
    public boolean isLocked() {
        return locked;
    }

    @Override
    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    @Override
    public Item getKey() {
        return key;
    }

    @Override
    public void setKey(Item keyValue) {
        key = keyValue;
    }

}
