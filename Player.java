import java.util.ArrayList;

/**
 * A class for the player.
 *
 * @author Chris Coakley
 * @version 23 January 2018
 */
public class Player {
    /** A field for the players max carry weight. */
    private static final int MAX_WEIGHT = 25;
    /** A field for the room that the player is currently in. */
    private Room room;
    /** A field for the previous room. */
    private Room previousRoom;
    /** A field for the players inventory. */
    private ArrayList<Item> inventory;
    
    /**
     * Constructor for the player class.
     * 
     * @param roomValue The room the player starts in.
     */
    public Player(Room roomValue) {
        room = roomValue;
        previousRoom = roomValue;
        inventory = new ArrayList<Item>();
    }
    
    /**
     * Accessor method for the room the player is in.
     * 
     * @return The room the player is in.
     */
    public Room getRoom() {
        return room;
    }
    
    /**
     * Accessor method for the previous room.
     * 
     * @return The previous room.
     */
    public Room getPreviousRoom() {
        return previousRoom;
    }
    
    /**
     * Mutator method for the room.
     * 
     * @param roomValue The new room.
     */
    public void setRoom(Room roomValue) {
        previousRoom = room;
        room = roomValue;
    }
    
    /**
     * A method for a player to add an item to the inventory.
     * 
     * @param itemValue The item being added.
     * @return If they item was added or not.
     */
    public boolean addToInventory(Item itemValue) {
        boolean answer = false;
        double currentWeight = 0;
        for (Item element : inventory) {
            currentWeight += element.getWeight();
        }
        double potentialWeight = currentWeight + itemValue.getWeight();
        if (potentialWeight < MAX_WEIGHT) {
            inventory.add(itemValue);
            answer = true;
        }
        return answer;
    }
    
    /**
     * A method used to get an item from the inventory by name.
     * 
     * @param itemValue The item we want the name of.
     * @return A string of the name.
     */
    public String getName(Item itemValue) {
        return itemValue.getName();
    }
    
    /**
     * A method used to check if a player has an item.
     * 
     * @param itemValue The item we are looking for.
     * @return If the player has the item or not.
     */
    public boolean hasItem(Item itemValue) {
        boolean answer = false;
        if (inventory.contains(itemValue)) {
            answer = true;
        }
        return answer;
    }
    
    /**
     * A method used to get an item from a string.
     * 
     * @param itemName The name of the item.
     * @return The item we are looking for
     *          or null if the item is not in the inventory.
     */
    public Item getItem(String itemName) {
        Item itemValue = null;
        for (Item element : inventory) {
            if (element.getName().equalsIgnoreCase(itemName)) {
                itemValue = element;
            }
        }
        return itemValue;
    }
    
    /**
     * A method used to remove an item from the inventory.
     * 
     * @param itemValue The item we are looking to remove.
     */
    public void removeItem(String itemValue) {
        Item removing = null;
        for (Item element : inventory) {
            if (element.getName().equalsIgnoreCase(itemValue)) {
                removing = element;
            }
        }
        inventory.remove(removing);
    }
    
    /**
     * A method that returns all items in the inventory.
     * 
     * @return A string of all items in the inventory.
     */
    public String getInventory() {
        String answer = "";
        for (Item element : inventory) {
            answer += element.getName() + ", ";
        }
        return answer;
    }
    
    /**
     * A method that returns the max carrying weight.
     * 
     * @return The max weight.
     */
    public int getMaxWeight() {
        return MAX_WEIGHT;
    }
}
