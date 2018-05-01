import java.util.ArrayList;
import java.util.Random;

/**
 * A class for the player.
 *
 * @author Chris Coakley
 * @version 23 January 2018
 */
public class Player {
    /** A field for the players max carry weight. */
    private static final int MAX_WEIGHT = 25;
    /**  Afield for the players max health. */
    private static final int MAX_HEALTH = 100;
    /** A field for the players hit probability. */
    private static final int HIT_PROBABILITY = 75;
    /** A field for the room that the player is currently in. */
    private Room room;
    /** A field for the previous room. */
    private Room previousRoom;
    /** A field for the players inventory. */
    private ArrayList<Item> inventory;
    /** A field for the items equipped . */
    private Weapon equipped;
    /** A field for the players health. */
    private double health;
    /** A field for the players shield. */
    private double shield;
    /** A field for the players armor. */
    private Armor armor;
    /** A field for the players helmet. */
    private Helmet helmet;
    /** A field for the random int. */
    private Random rand;

    /**
     * Constructor for the player class.
     * 
     * @param roomValue The room the player starts in.
     */
    public Player(Room roomValue) {
        room = roomValue;
        previousRoom = roomValue;
        inventory = new ArrayList<Item>();
        equipped = null;
        armor = null;
        helmet = null;
        health = MAX_HEALTH;
        shield = 0;
        rand = new Random();
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
     * Mutator method for the item equipped.
     * 
     * @param equipping The item we are equipping
     */
    public void setItemEquipped(Weapon equipping) {
        equipped = equipping;
    }

    /**
     * A method that returns the items equipped
     * 
     * @return The item equipped.
     */
    public Weapon getItemEquipped() {
        return equipped;
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
    public void addHealth(double healthValue) {
        health += healthValue;
        if (health > MAX_HEALTH) {
            health = MAX_HEALTH;
        }
    }

    /**
     * A method that returns how much damage the player inflicts.
     * 
     * @return How much damage the player will inflict.
     */
    public double getDamageDone() {
        double damageFactor = .5;
        double damageDone = rand.nextInt(49);
        if (equipped != null) {
            damageFactor = equipped.getDamageFactor();
            damageDone = damageDone * 2;
        }
        return damageFactor * damageDone;
    }

    /**
     * Accessor for the players hit probability.
     * 
     * @return The players hit probability.
     */
    public int getHitProbability() {
        return HIT_PROBABILITY;
    }
    
    /**
     * Accessor method for the players shield
     * 
     * @return The amount of shield the player has.
     */
    public double getShield() {
        return shield;
    }
    
    /**
     * Mutator method for the players shield.
     * 
     * @param shieldValue The shield being added.
     */
    public void addShield(double shieldValue) {
        shield += shieldValue;
    }

    /**
     * Mutator method for the armor equipped.
     * 
     * @param equipping The armor we are equipping
     */
    public void setArmorEquipped(Armor equipping) {
        armor = equipping;
    }

    /**
     * A method that returns the items equipped
     * 
     * @return The item equipped.
     */
    public Armor getArmorEquipped() {
        return armor;
    }
    
    /**
     * Mutator method for the armor equipped.
     * 
     * @param equipping The armor we are equipping
     */
    public void setHelmetEquipped(Helmet equipping) {
        helmet = equipping;
    }

    /**
     * A method that returns the items equipped
     * 
     * @return The item equipped.
     */
    public Helmet getHelmetEquipped() {
        return helmet;
    }
}
