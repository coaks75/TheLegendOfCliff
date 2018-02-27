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
        Room theTrappingChamber = new Room("The Trapping Chamber", "It doesn't look like there's much in here besides some canned food.");
        Room endOfSouthernHallway = new Room("End of Southern Hallway", "This looks like the end of this small hallway. There are stairs going down, but it's very dark and eerie sounding down there...");
        Room southernBasement = new Room("SouthernBasement", "This is very deep into the caverns. You are at the beginning of a long hallway. You can see things down the hall, nut not clearly.");
        Room equipmentRoom = new Room("Equipment Room", "This looks like an old equipment rooom for the guards. It appears that everything was taken besides some things on the table.");
        Room theOldLibrary = new Room("The Old Library", "This looks like it was once a library. There's bookshelves all over the wall, but one book shelf is missing a book...");
        Room hiddenToolRoom = new Room("Hidden Tool Room", "This room looks ransacked as well. The only thing left is a big heavy chest that's being held shut with rope.");
        Room southernBasementBend = new Room("Southern bsaement bend", "This straight hallway has come to an end. There's a short hallway to the west. There doesn't seem to be much over there.");
        Room endOfSouthernBasement = new Room("End of Southern Basement", "On the floor is a copy of Plato's 'Apology'. This wall here is made of iron and seems to be pretty beat up because there's some holes in it...");
        Room hiddenPuzzleRoom = new Room("Hidden Puzzle Room", " Oh look! It's a piece to a puzzle!");
        Room easternDoor = new Room("Eastern Door", "You look at the door. There is a key hole to unlock the door.");
        Room easternHallway = new Room("Eastern Hallway", "You walk into the beginning of a long passageway. You can't see all the way down the hallway. Slightly down the hall however; you see metal bars on the wall to the south and hear a feint mumbling, and a painting to the north.");
        Room theJailcell = new Room("The Jailcell", "Help help!! The Queen had me sentencde here long ago... Release me from this jailcell and I can definitely help you escape from here...");
        Room endOfEasternHallway = new Room("End of Eastern Hallway", "There's a door here... The sign on the door reads 'If the doors are closed, it means stay out.'");
        Room theBreakRoom = new Room("The Break Room", "There are two doors here.One to the south which has a sign that says 'Meal times are 10am and 5pm'. The door to the north has a sign that reads 'DO NOT ENTER'.");
        Room corneliusDen = new Room("Cornelius' Den", "There doesn't seem to be anthing here.");
        Room sirSeanFortevirsRoom = new Room("Sir Sean Fortevir's Room", "This looks like it could be someone's own kitchen. in big letters on the wall it says 'Sir Sean Fortevir'. There are cabinets on the wall. There are doors to the north and east");
        Room maximusDen = new Room("Maximus' Den", "AH! Another three headed lion??? This time with a necklace around its middle head.");
        Room sirSeanFortevirsSecretDoor = new Room("Sir Sean Fortevir's Secret Door", "There's something odd about this door...");
        Room sirSeanFortevirsSecretRoom = new Room("Sir Sean Fortevir's Secret Room", "This room is empty except for someting in the corner...");
        Room northernDoor = new Room("Northern Door", "You look at the door. There seem to be three different sized cut outs on the door. There is nothing on the ground around.");
        Room northernHallway = new Room("Northern Hallway", "You walk into the beginning of a long hallway. This hallway has gold walls and a shiny floor. There must be somthing good here... Slightly down the hall there are doors to the east and west.");
        Room theRoyalEquipmentRoom = new Room("The Royal Equipment Room", "This must be where the royal guards get their armour from. This room is filled with armour.");
        Room theRoyalToolRoom = new Room("The Royal Tool Room", "This must be where the guards get their swords from. This room is filled with swords.");
        Room endOfNorthernHallway = new Room("End of Northern Hallway", "This looks like the end of the northern hallway. There's a big gold plated door here.");
        Room theQueensHiddenRoom = new Room("The Queen's Hidden Room", "This must be a room for the Queen! There seems to be everything in here. There's a chest at the foot of the bed, a closet, and diamonds and gold everywhere.");
        
        // Adding all the rooms to the world.
        this.addRoom(mainRoom);
        this.addRoom(westernDoor);
        this.addRoom(westernHallway);
        this.addRoom(sleepingChamber);
        this.addRoom(diningChamber);
        this.addRoom(endOfWesternHallway);
        this.addRoom(southWestBasement);
        this.addRoom(forkedPassage);
        this.addRoom(endOfForkedPassage);
        this.addRoom(theHallwaysEnd);
        this.addRoom(southernDoor);
        this.addRoom(southernHallway);
        this.addRoom(theQueensArtChamber);
        this.addRoom(theTrappingChamber);
        this.addRoom(endOfSouthernHallway);
        this.addRoom(southernBasement);
        this.addRoom(equipmentRoom);
        this.addRoom(theOldLibrary);
        this.addRoom(hiddenToolRoom);
        this.addRoom(southernBasementBend);
        this.addRoom(endOfSouthernBasement);
        this.addRoom(hiddenPuzzleRoom);
        this.addRoom(easternDoor);
        this.addRoom(easternHallway);
        this.addRoom(theJailcell);
        this.addRoom(endOfEasternHallway);
        this.addRoom(theBreakRoom);
        this.addRoom(corneliusDen);
        this.addRoom(sirSeanFortevirsRoom);
        this.addRoom(maximusDen);
        this.addRoom(sirSeanFortevirsSecretDoor);
        this.addRoom(sirSeanFortevirsSecretRoom);
        this.addRoom(northernDoor);
        this.addRoom(northernHallway);
        this.addRoom(theRoyalEquipmentRoom);
        this.addRoom(theRoyalToolRoom);
        this.addRoom(endOfNorthernHallway);
        this.addRoom(theQueensHiddenRoom);
        
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
