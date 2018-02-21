import java.util.HashMap;

/**
 * This class represents the entire world that makes up the "Campus of Kings"
 * application. "Campus of Kings" is a very simple, text based adventure game.
 * Users can walk around some scenery. That's all. It should really be extended
 * to make it more interesting!
 * 
 * This world class creates the world where the game takes place.
 * 
 * @author Maria Jump
 * @version 2015.02.01
 */
public class World {
    /** The rooms in the world. */
    private HashMap<String, Room> rooms;

    /**
     * Constructor for the world.
     */
    public World() {
        rooms = new HashMap<String, Room>();
        createRooms();
    }

    /**
     * This method takes care of creating all of the aspects of the world for
     * the "Campus of Kings" application.
     * 
     * @param name
     *            The provided name of the room.
     * @return The room associated with the provided name
     */
    public Room getRoom(String name) {
        return rooms.get(name.toLowerCase());
    }

    /////////////////////////////////////////////////////////////////////////////////////
    // Start of private helper methods

    /**
     * Helper method for recreating a Room. Ensure that the room is created and
     * installed in to the collection of Rooms
     * 
     * @param theRoom
     *            The room to add to the world.
     */
    private void addRoom(Room theRoom) {
        rooms.put(theRoom.getName().toLowerCase(), theRoom);
    }

    /**
     * Helper method for creating doors between rooms.
     * 
     * @param from The room where the door originates.
     * @param direction The direction of the door in the 'from' room.
     * @param to The room where the door goes.
     */
    private void createDoor(Room from, String direction, Room to) {
        from.setExit(direction, new Door(to));
    }

    /**
     * This method creates all of the individual places in this world and all
     * the doors connecting them.
     */
    private void createRooms() {
        // Creating all the rooms.
        Room mainRoom = new Room("Main Room", "The room is big and open. You don't see much here but an altar in the center, and a door in each cardinal direction. The door to the west pops open from the shock wave of you hitting the ground.");
        Room westernDoor = new Room("Western Door", "This door is open. There is a carving on the door that reads 'Turn around! Don't do it! save yourself! They've come afte...' It ends there");
        Room westernHallway = new Room("Western Hallway", "You walk into the begginning of a long passageway. You can't see all the way down the hallway. Slightly down the hall however; you see two doors. One to the north and one to the south.");
        Room sleepingChamber = new Room("Sleeping Chamber", "This looks like it was a sleeping chamber for the queen's Royal Guard. Someone must have been stuck in here, because it looks like there is a skeleton in the corner.");
        Room diningChamber = new Room("Dining Chamber", "This looks like it was a once a small dining chamber for the queen's Royal Guard. Someone must have been stuck in here, because it looks like there is a skeleton in the chair.");
        Room endOfWesternHallway = new Room("End of Western Hallway", "This looks like the end of this small hallway. There are stairs going down, but its very dark and eerie sounding down there...");
        Room southWestBasement = new Room("South-West Basement", "This is very deep into the caverns. You are at the beginning of a long hallway. You can see things down the hall, but not clearly.");
        Room forkedPassage = new Room("Forked Passage", "The hallway seems to fork here. To your west on the wall is a painting. Straight ahead is the rest of the hallway. It doesn't look like anyhting is down there. To your right is another short hallway. it looks like there's something shiny down there...");
        Room endOfForkedPassage = new Room("End of Forked Passage", "Oh no! There's a big hole in the ground so you can't walk across! On the other side of the hole i a key resting on a cinderblock. Should you attempt the jump?");
        Room theHallwaysEnd = new Room("The Hallway's End", "There doesn't seem to be anything over here. Just an iron wall here instead of cobblestone like the rest.");
        Room southernDoor = new Room("Southern Door", "You look at the door. The door has no lock, but there are a few slightly cracked, and rusty, iron bars in front of the door. You see something shiny on top of the door frame, but you can't reach it. If only there was something to reach this with...");
        Room southernHallway = new Room("Southern Hallway", "You walk into the beginning of a long passageway. You can't see all the way down the hallway. Slightly down the hall however; you see two doors. One to the east and west.");
        Room theQueensArtChamber = new Room("The Queen's Art Chamber", "Here is where the queen's most precious art is kept. DO NOT ENTER if you aren't of her Royal Guard.");
        
        
        // Adding all the rooms to the world.
        this.addRoom(outside);
        this.addRoom(holyCross);
        this.addRoom(essef);
        this.addRoom(campusCenter);
        this.addRoom(admin);
        this.addRoom(jumpOffice);
        this.addRoom(hoggOffice);
        this.addRoom(lab);
        this.addRoom(classroom);

        // Creating all the doors between the rooms.
        this.createDoor(essef, "south", outside);
        this.createDoor(outside, "north", essef);

        this.createDoor(campusCenter, "east", outside);
        this.createDoor(outside, "west", campusCenter);

        this.createDoor(outside, "east", holyCross);
        this.createDoor(holyCross, "west", outside);

        this.createDoor(outside, "south", admin);
        this.createDoor(admin, "north", outside);

        this.createDoor(admin, "east", lab);
        this.createDoor(lab, "west", admin);

        this.createDoor(admin, "south", hoggOffice);
        this.createDoor(hoggOffice, "north", admin);

        this.createDoor(admin, "west", jumpOffice);
        this.createDoor(jumpOffice, "east", admin);

        this.createDoor(lab, "south", classroom);
        this.createDoor(classroom, "north", lab);
    }
}
