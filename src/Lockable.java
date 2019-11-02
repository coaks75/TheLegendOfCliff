
/**
 * An interface for something that can be locked.
 *
 * @author Chris Coakley
 * @version 17 April 2018
 */
public interface Lockable {
    /**
     * A getter for whether this door is locked.
     * @return Whether this door is locked
     */
    public abstract boolean isLocked();
    
    /**
     * A setter for whether this door is locked.
     * @param locked Whether this door is locked.
     */
    public abstract void setLocked(boolean locked);
    
    /**
     * A method to get the key to the door.
     * 
     * @return The key
     */
    public abstract Item getKey();
    
    /**
     * A method to set the key to a door.
     * 
     * @param keyValue The key to the door.
     */
    public abstract void setKey(Item keyValue);
}
