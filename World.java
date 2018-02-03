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
        Room outside = new Room("Outside", "outside in the center of the King's College campus.");
        Room holyCross = new Room("Holy Cross", "at one of two main dormitories on campus.");
        Room essef = new Room("Essef", "at the other main dormitory on campus.");
        Room campusCenter = new Room("Campus Center", "in the center of student activities on campus.");
        Room admin = new Room("Admin", "in the oldest building on campus and home to the computer science department.");
        Room jumpOffice = new Room("Jump's Office", "in Dr Jump's office.");
        Room hoggOffice = new Room("Hogg's Office", "in Dr Hogg's office.");
        Room lab = new Room("Computer Lab", "in the Computer Science and Math computing lab.");
        Room classroom = new Room("Classroom", "in the classroom where the computer science classes are taught.");

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
