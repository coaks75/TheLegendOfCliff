
/**
 * A class for the player.
 *
 * @author Chris Coakley
 * @version 23 January 2018
 */
public class Player
{
    /** A field for the room that the player is currently in. */
    private Room room;
    
    /**
     * Constructor for the player class.
     * 
     * @param rooomValue The room the player starts in.
     */
    public Player(Room roomValue) {
        room = roomValue;
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
     * Mutator method for the room.
     * 
     * @param roomValue The new room.
     */
    public void setRoom(Room roomValue) {
        room = roomValue;
    }
    
}
