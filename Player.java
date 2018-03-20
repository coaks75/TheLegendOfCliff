
/**
 * A class for the player.
 *
 * @author Chris Coakley
 * @version 23 January 2018
 */
public class Player {
    /** A field for the room that the player is currently in. */
    private Room room;
    private Room previousRoom;
    
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
}
