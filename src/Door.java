/**
 * Class Door - a door or portal between two Rooms in an adventure game.
 * 
 * This class is part of the "Campus of Kings" application. "Campus of Kings" is a
 * very simple, text based adventure game.
 * 
 * A "Door" represents a door or portal between two locations of the game.
 * It stores a reference to the neighboring room and whether that door
 * or portal is locked.  Doors are not locked by default.
 * 
 * @author Maria Jump
 * @author Chris Coakley
 * @version 2015.02.01
 */
public class Door implements Lockable{
    /** The room that this door leads to. */
    private Room destination;
    /** Whether this door is locked. */
    private boolean locked;
    /** The key to the door. */
    private Item key;
    
    /**
     * Constructor for the Door class.
     * @param destination The room this door leads to
     */
    public Door(Room destination) {
        this.destination = destination;
        this.locked = false;
    }
    
    /**
     * A getter for the room this door leads to.
     * @return The room this door leads to
     */
    public Room getDestination() {
        return destination;
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
