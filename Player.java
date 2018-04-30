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
    /** A field for the players max equipped. */
    private static final int MAX_EQUIPPABLE = 2;
    /**  Afield for the players max health. */
    private static final int MAX_HEALTH = 100;
    /** A field for the room that the player is currently in. */
    private Room room;
    /** A field for the previous room. */
    private Room previousRoom;
    /** A field for the players inventory. */
    private ArrayList<Item> inventory;
    /** A field for the items equipped. */
    private ArrayList<Item> itemsEquipped;
    /** A field for the players health. */
    private double health;
    
    /**
     * Constructor for the player class.
     * 
     * @param roomValue The room the player starts in.
     */
    public Player(Room roomValue) {
        room = roomValue;
        previousRoom = roomValue;
        inventory = new ArrayList<Item>();
        itemsEquipped = new ArrayList<Item>();
        health = MAX_HEALTH;
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
        if (this.canAdd(itemValue)) {
            answer = true;
            inventory.add(itemValue);
        }
        return answer;
    }

    /**
     * A method used to check if an item can be added.
     * 
     * @param itemValue The item being added.
     * @return If the item was added or not.
     */
    public boolean canAdd(Item itemValue) {
        boolean answer = false;
        double currentWeight = 0;
        double potentialWeight = 0;
        for (Item element : inventory) {
            currentWeight += element.getWeight();
        }
        if (itemValue != null) {
            potentialWeight = currentWeight + itemValue.getWeight();
        }
        if (potentialWeight <= MAX_WEIGHT) {
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
        boolean done = false;
        int index = 0;
        while (index < inventory.size() && done == false) {
            if (inventory.get(index).getName().equalsIgnoreCase(itemName)) {
                itemValue = inventory.get(index);
                done = true;
            }
            index++;
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
        boolean done = false;
        int index = 0;
        while (index < inventory.size() && done == false) {
            if (inventory.get(index).getName().equalsIgnoreCase(itemValue)) {
                removing = inventory.get(index);
                done = true;
            }
            index++;
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
            answer += element.getName().toLowerCase() + ", ";
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
    
    /**
     * Accessor method for the items equipped.
     * 
     * @return The number of items the player has equipped.
     */
    public int getNumItemsEquipped() {
        return itemsEquipped.size();
    }
    
    /**
     * Mutator method for the items equipped.
     */
    public void addOneEquipped(Item itemValue) {
        itemsEquipped.add(itemValue);
    }
    
    /**
     * A method used to drop one equipped.
     */
    public void minusOneEquipped(Item itemValue) {
        itemsEquipped.remove(itemValue);
    }
    
    /**
     * A method that returns the max equippable.
     * 
     * @return The max equippable for the player.
     */
    public int getMaxEquippable() {
        return MAX_EQUIPPABLE;
    }
    
    /**
     * Accessor method for the players health.
     * 
     * @return The players current health.
     */
    public double getHealth() {
        return health;
    }
    
    /**
     * Mutator method for the players health.
     * 
     * @param healthValue The health being added.
     */
    public void setHealth(double healthValue) {
        health += healthValue;
        if (health > MAX_HEALTH) {
            health = MAX_HEALTH;
        }
    }
    
}
