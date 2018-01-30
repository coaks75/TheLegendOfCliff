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
 * @version 2015.02.01
 */
public class Room {
    /** Counter for the total number of rooms created in the world. */
    private static int counter;
    /** The name of this room.  Room names should be unique. */
    private String name;
    /** The description of this room. */
    private String description;

    /** This room's north exit, null if none exits. */
    private Door northExit;
    /** This room's south exit, null if none exits. */
    private Door southExit;
    /** This room's east exit, null if none exits. */
    private Door eastExit;
    /** This room's west exit, null if none exits. */
    private Door westExit;

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
     * Returns the north exit.
     * 
     * @return The north exit.
     */
    public Door getNorthExit() {
        return northExit;
    }

    /**
     * Changes the north exit.
     * 
     * @param northExitValue
     */
    public void setNorthExit(Door northExitValue) {
        northExit = northExitValue;
    }
    
    /**
     * Returns the south exit.
     * 
     * @return The south exit.
     */
    public Door getSouthExit() {
        return southExit;
    }
    
    /**
     * Changes the south exit.
     * 
     * @param southExitValue
     */
    public void setSouthExit(Door southExitValue) {
        southExit = southExitValue;
    }
    
    /**
     * Returns the east exit.
     * 
     * @return The east exit.
     */
    public Door getEastExit() {
        return eastExit;
    }
    
    /**
     * Changes the east exit.
     * 
     * @param eastExitValue
     */
    public void setEastExit(Door eastExitValue) {
        eastExit = eastExitValue;
    }
    
    /**
     * Returns the west exit.
     * 
     * @return The west exit.
     */
    public Door getWestExit() {
        return westExit;
    }
    
    /**
     * Changes the west exit.
     * 
     * @param westExitValue
     */
    public void setWestExit(Door westExitValue) {
        westExit = westExitValue;
    }
}
