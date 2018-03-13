import java.util.HashMap;

/**
 * Class Room - a room in an adventure game.
 * 
 * This class is part of the "Campus of Kings" application. "Campus of Kings" is a
 * very simple, text based adventure game.
 * 
 * A "Room" represents one location in the scenery of the game. It is connected
 * to other rooms via doors. The doors are labeled north, east, south, west.
 * For each direction, the room stores a reference to an instance of door.
 * 
 * @author Maria Jump
 * @author Chris Coakley
 * @version 2015.02.01
 */
public class Room {
    /** Counter for the total number of rooms created in the world. */
    private static int counter;
    /** The name of this room.  Room names should be unique. */
    private String name;
    /** The description of this room. */
    private String description;
    
    /** The hashmap for the directions. */ 
    private HashMap<String, Door> roomMap;
    
    /** A field for the points a player can score for entering rooms. */
    private int points;
    
    /**
     * Static initializer.
     */
    static {
        counter = 0;
    }
    /**
     * Create a room described "description". Initially, it has no exits.
     * "description" is something like "a kitchen" or "an open court yard".
     * 
     * @param name  The room's name.
     * @param description
     *            The room's description.
     */
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        roomMap = new HashMap<String, Door>();
        counter++;
    }

    /**
     * Returns the name of this room.
     * 
     * @return The name of this room.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the description of this room.
     * 
     * @return The description of this room.
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * Returns the number of rooms that have been created in the world.
     * @return The number of rooms that have been created in the world.
     */
    public static int getCounter() {
        return counter;
    }

    /**
     * Defines an exit from this room.
     * 
     * @param direction The direction of the exit.
     * @param neighbor The door in the given direction.
     */
    public void setExit(String direction, Door neighbor) {
        roomMap.put(direction, neighbor);
    }
    
    /**
     * Gets a door in a specified direction if it exists.
     * 
     * @param direction The direction we are looking for a door in.
     * @return The door in the specified direction or null if it does not.
     */
    public Door getExit(String direction) {
        Door answer = roomMap.get(direction);
        return answer;
    }

    /**
     * Returns a string description including all the details of a Room.
     * 
     * @return A string representing all the details of a Room.
     */
    public String toString() {
        String line1 = String.format("%s :\n", name);
        String line2 = String.format("%s \n", description);
        String line3 = ("Exits: ");
        for (String element : roomMap.keySet()) {
            if (roomMap.get(element) != null) {
                line3 += element + ", ";
            }
        }
        String line4 = ("\n");
        
        String answer = String.format("%s%s%s%s", line1, line2, line3, line4);
        return answer;
    }
    
    /**
     * Mutator for the points field.
     * 
     * @param pointsValue The amount of points for a certain room.
     */
    public void setPoints(int pointsValue) {
        points = pointsValue;
    }
    
    /**
     * Accessor for the points field.
     * 
     * @return The number of points.
     */
    public int getPoints() {
        int answer = points;
        
        points = 0;
        
        return answer;
    }
}
