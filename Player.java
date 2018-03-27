import java.util.ArrayList;

/**
 * A class for the player.
 *
 * @author Chris Coakley
 * @version 23 January 2018
 */
public class Player {
    /** A field for the room that the player is currently in. */
    private Room room;
    /** A field for the previous room. */
    private Room previousRoom;
    /** A field for the players inventory. */
    private ArrayList<Item> inventory;
    /** A field for the players max carry weight. */
    private static final int MAX_WEIGHT = 25;
    
    /**
     * Constructor for the player class.
     * 
     * @param roomValue The room the player starts in.
     */
    public Player(Room roomValue) {
        room = roomValue;
        previousRoom = roomValue;
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
}
