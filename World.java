import java.util.HashMap;
import java.util.ArrayList;

/**
 * This class represents the entire world that makes up the "Campus of Kings"
 * application. "Campus of Kings" is a very simple, text based adventure game.
 * Users can walk around some scenery. That's all. It should really be extended
 * to make it more interesting!
 * 
 * This world class creates the world where the game takes place.
 * 
 * @author Maria Jump
 * @author Chris Coakley
 * @version 2015.02.01
 */
public class World {
    /** The rooms in the world. */
    private HashMap<String, Room> rooms;
    /** All of the buildable items in the game. */
    private HashMap<String, BuildableItem> buildables;
    
    /**
     * Constructor for the world.
     */
    public World() {
        rooms = new HashMap<String, Room>();
        createRooms();
        createItems();
    }

    /**
     * This method takes care of creating all of the aspects of the world for
     * the "The Legend of Cliff" application.
     * 
     * @param name
     *            The provided name of the room.
     * @return The room associated with the provided name
     */
    public Room getRoom(String name) {
        return rooms.get(name.toLowerCase());
    }
    
    /**
     * A method used to get all the buildableItems.
     * 
     * @return A string of all of the buildable items in the game.
     */
    public ArrayList<BuildableItem> getBuildables() {
        ArrayList<BuildableItem> buildablesList = new ArrayList<BuildableItem>();
        for (String element : buildables.keySet()) {
            buildablesList.add(buildables.get(element));
        }
        return buildablesList;
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
        Room forkedPassage = new Room("Forked Passage", "The hallway seems to fork here. To your west on the wall is a painting. Straight ahead is the rest of the hallway. It doesn't look like anyhting is down there. To your south-west is another long hallway.");
        Room endOfForkedPassage = new Room("End of Forked Passage", "Oh no! There's a big hole in the ground so you can't walk any further!");
        Room theHallwaysEnd = new Room("The Hallway's End", "There doesn't seem to be anything over here. Just a dusty cavern like the rest.");
        Room southernDoor = new Room("Southern Door", "You look at the door. It looks like the lock is made out of wood so the key can'y possibly be metal...");
        Room southernHallway = new Room("Southern Hallway", "You walk into the beginning of a long passageway. You can't see all the way down the hallway. Slightly down the hall however; you see two doors. One to the east and west.");
        Room theQueensArtChamber = new Room("The Queen's Art Chamber", "Here is where the queen's most precious art is kept. DO NOT ENTER if you aren't of her Royal Guard.");
        Room theTrappingChamber = new Room("The Trapping Chamber", "It doesn't look like there's much in here besides some canned food.");
        Room endOfSouthernHallway = new Room("End of Southern Hallway", "This looks like the end of this small hallway. There are stairs going down, but it's very dark and eerie sounding down there...");
        Room southernBasement = new Room("SouthernBasement", "This is very deep into the caverns. You are at the beginning of a long hallway. You can see things down the hall, but not clearly.");
        Room equipmentRoom = new Room("Equipment Room", "This looks like an old equipment rooom for the guards. It appears that everything was taken besides some things on the table.");
        Room theOldLibrary = new Room("The Old Library", "This looks like it was once a library. There's bookshelves all over the wall, but one book shelf to the north is missing a book...");
        Room hiddenToolRoom = new Room("Hidden Tool Room", "This room looks ransacked as well. The only thing left is a big heavy chest with a broken lock");
        Room southernBasementBend = new Room("Southern bsaement bend", "This straight hallway has come to an end. There's a short hallway to the west. There doesn't seem to be much over there.");
        Room endOfSouthernBasement = new Room("End of Southern Basement", "On the floor is some weird book...");
        Room hiddenPuzzleRoom = new Room("Hidden Puzzle Room", " Oh look! It's a piece to a puzzle!");
        Room easternDoor = new Room("Eastern Door", "You look at the door. There is a shiny key hole to unlock the door.");
        Room easternHallway = new Room("Eastern Hallway", "You walk into the beginning of a long passageway. You can't see all the way down the hallway. Slightly down the hall however; you see metal bars on the wall to the south and hear a feint mumbling, and a painting to the north.");
        Room theJailcell = new Room("The Jailcell", "Woah, Queen Isa really kept prisoners down here in the caverns.");
        Room endOfEasternHallway = new Room("End of Eastern Hallway", "There's a door here... The sign on the door reads 'If the doors are closed, it means stay out.'");
        Room theBreakRoom = new Room("The Break Room", "There are two doors here.One to the south which has a sign that says 'Meal times are 10am and 5pm'. The door to the north has a sign that reads 'DO NOT ENTER'.");
        Room corneliusDen = new Room("Cornelius' Den", "There doesn't seem to be anthing here.");
        Room sirSeanFortevirsRoom = new Room("Sir Sean Fortevir's Room", "This looks like it could be someone's own kitchen. in big letters on the wall it says 'Sir Sean Fortevir'. There are cabinets on the wall. There are doors to the north and east");
        Room maximusDen = new Room("Maximus' Den", "Ah, so Maximus must be a royal pet... Theres some sort of fur everywhere, along with blood.");
        Room sirSeanFortevirsSecretDoor = new Room("Sir Sean Fortevir's Secret Door", "There's something odd about this wall... There must be some sort of key for it.");
        Room sirSeanFortevirsSecretRoom = new Room("Sir Sean Fortevir's Secret Room", "This room is empty except for someting in the corner...");
        Room northernDoor = new Room("Northern Door", "You look at the door. There is a huge puzzle piece shaped cut out on the door.");
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
        this.createDoor(mainRoom, "west", westernDoor);
        this.createDoor(westernDoor, "east", mainRoom);

        this.createDoor(westernDoor, "west", westernHallway);
        this.createDoor(westernHallway, "east", westernDoor);

        this.createDoor(westernHallway, "south", diningChamber);
        this.createDoor(diningChamber, "north", westernHallway);

        this.createDoor(westernHallway, "north", sleepingChamber);
        this.createDoor(sleepingChamber, "south", westernHallway);

        this.createDoor(westernHallway, "west", endOfWesternHallway);
        this.createDoor(endOfWesternHallway, "east", westernHallway);

        this.createDoor(endOfWesternHallway, "down", southWestBasement);
        this.createDoor(southWestBasement, "up", endOfWesternHallway);

        this.createDoor(southWestBasement, "south", forkedPassage);
        this.createDoor(forkedPassage, "north", southWestBasement);

        this.createDoor(forkedPassage, "south-west", endOfForkedPassage);
        this.createDoor(endOfForkedPassage, "north-east", forkedPassage);

        this.createDoor(forkedPassage, "south", theHallwaysEnd);
        this.createDoor(theHallwaysEnd, "north", forkedPassage);
        
        this.createDoor(mainRoom, "south", southernDoor);
        this.createDoor(southernDoor, "north", mainRoom);

        this.createDoor(southernDoor, "south", southernHallway);
        this.createDoor(southernHallway, "north", southernDoor);

        this.createDoor(southernHallway, "west", theQueensArtChamber);
        this.createDoor(theQueensArtChamber, "east", southernHallway);

        this.createDoor(southernHallway, "east", theTrappingChamber);
        this.createDoor(theTrappingChamber, "west", southernHallway);

        this.createDoor(southernHallway, "south", endOfSouthernHallway);
        this.createDoor(endOfSouthernHallway, "north", southernHallway);

        this.createDoor(endOfSouthernHallway, "down", southernBasement);
        this.createDoor(southernBasement, "up", endOfSouthernHallway);

        this.createDoor(southernBasement, "west", equipmentRoom);
        this.createDoor(equipmentRoom, "east", southernBasement);

        this.createDoor(southernBasement, "east", theOldLibrary);
        this.createDoor(theOldLibrary, "west", southernBasement);

        this.createDoor(theOldLibrary, "north", hiddenToolRoom);
        this.createDoor(hiddenToolRoom, "south", theOldLibrary);

        this.createDoor(southernBasement, "south", southernBasementBend);
        this.createDoor(southernBasementBend, "north", southernBasement);

        this.createDoor(southernBasementBend, "west", endOfSouthernBasement);
        this.createDoor(endOfSouthernBasement, "east", southernBasementBend);

        this.createDoor(endOfSouthernBasement, "west", hiddenPuzzleRoom);
        this.createDoor(hiddenPuzzleRoom, "east", endOfSouthernBasement);

        this.createDoor(mainRoom, "east", easternDoor);
        this.createDoor(easternDoor, "west", mainRoom);

        this.createDoor(easternDoor, "east", easternHallway);
        this.createDoor(easternHallway, "west", easternDoor);

        this.createDoor(easternHallway, "south", theJailcell);
        this.createDoor(theJailcell, "north", easternHallway);

        this.createDoor(easternHallway, "east", endOfEasternHallway);
        this.createDoor(endOfEasternHallway, "west", easternHallway);

        this.createDoor(endOfEasternHallway, "east", theBreakRoom);
        this.createDoor(theBreakRoom, "west", endOfEasternHallway);

        this.createDoor(theBreakRoom, "south", corneliusDen);
        this.createDoor(corneliusDen, "north", theBreakRoom);

        this.createDoor(theBreakRoom, "north", sirSeanFortevirsRoom);
        this.createDoor(sirSeanFortevirsRoom, "south", theBreakRoom);

        this.createDoor(sirSeanFortevirsRoom, "north", maximusDen);
        this.createDoor(maximusDen, "south", sirSeanFortevirsRoom);

        this.createDoor(sirSeanFortevirsRoom, "east", sirSeanFortevirsSecretDoor);
        this.createDoor(sirSeanFortevirsSecretDoor, "west", sirSeanFortevirsRoom);

        this.createDoor(sirSeanFortevirsSecretDoor, "east", sirSeanFortevirsSecretRoom);
        this.createDoor(sirSeanFortevirsSecretRoom, "west", sirSeanFortevirsSecretDoor);

        this.createDoor(mainRoom, "north", northernDoor);
        this.createDoor(northernDoor, "south", mainRoom);

        this.createDoor(northernDoor, "north", northernHallway);
        this.createDoor(northernHallway, "south", northernDoor);

        this.createDoor(northernHallway, "west", theRoyalToolRoom);
        this.createDoor(theRoyalToolRoom, "east", northernHallway);

        this.createDoor(northernHallway, "east", theRoyalEquipmentRoom);
        this.createDoor(theRoyalEquipmentRoom, "west", northernHallway);

        this.createDoor(northernHallway, "north", endOfNorthernHallway);
        this.createDoor(endOfNorthernHallway, "south", northernHallway);

        this.createDoor(endOfNorthernHallway, "north", theQueensHiddenRoom);
        this.createDoor(theQueensHiddenRoom, "south", endOfNorthernHallway);

        southernHallway.setPoints(20);
        easternHallway.setPoints(20);
        northernHallway.setPoints(20);
    }
    
    /**
     * A method used to create all the items of the world.
     */
    private void createItems() {
        buildables = new HashMap<String, BuildableItem>();
        
        Item broom = new Item("Broom", "The broom is ratty and old.", 0, 3);
        rooms.get("main room").addItem(broom);
        Item altar = new Item("Altar", "The Altar is in the center of the room. There's a little divot in the center...", 0, 100);
        rooms.get("main room").addItem(altar);
        Container backpack = new Container("Backpack", "This backpack will be useful to carry items.", 0, 0);
        rooms.get("main room").addItem(backpack);
        
        Weapon weakSword = new Weapon("Sword", "This sword seems heavy but useful.", 0, 8, 1);
        rooms.get("sleeping chamber").addItem(weakSword);

        Item bone = new Item("Bone", "This is a skeletons bone, it's broken and shaped like a key.", 0, 2);
        rooms.get("the hallway's end").addItem(bone);
        rooms.get("southern door").getExit("south").setLocked(true);
        rooms.get("southern door").getExit("south").setKey(bone);

        Armor weakArmor = new Armor("Armor", "This armor is heavy and thick.", 0, 10, 15);
        rooms.get("dining chamber").addItem(weakArmor);

        Helmet weakHelmet = new Helmet("Helmet", "This helmet is big and clunky.", 0, 5, 10);
        rooms.get("dining chamber").addItem(weakHelmet);

        Item forkedPainting = new Item("Painting", "This painting is very interesting looking.", 0, 2);
        rooms.get("forked passage").addItem(forkedPainting);
        
        //Create easter egg
        
        Item redKey = new Item("Red Key", "This key is a standard wooden key with three bumps in it.", 5, 1);
        rooms.get("end of forked passage").addItem(redKey);
        
        Item cinderBlock = new Item("Cinderblock", "This cinderblock is about a foot tall.", 0, 10);
        rooms.get("end of forked passage").addItem(cinderBlock);
        redKey.setOnTopOf(cinderBlock);
        
        Weapon hammer = new Weapon("Hammer", "This hammer is very dusty, but seems like it was never used.", 0, 3, 1.5);
        rooms.get("southern door").addItem(hammer);
        
        Food cannedFood = new Food("Canned Food", "This canned food doesn't look that good but it should restore some health...", 0, 2, 25);
        rooms.get("the trapping chamber").addItem(cannedFood);
        
        Item pinkKey = new Item("Pink Key", "This pink key has a few divots in it.", 0, 1);
        rooms.get("equipment room").addItem(pinkKey);
        rooms.get("sir sean fortevir's room").getExit("east").setLocked(true);
        rooms.get("sir sean fortevir's room").getExit("east").setKey(pinkKey);
        
        Item yellowKey = new Item("Yellow Key", "This yellow key has a few divots in it.", 0, 1);
        rooms.get("equipment room").addItem(yellowKey);
        
        Item keyTable = new Item("Table", "This table is very sturdy.", 0, 100);
        rooms.get("equipment room").addItem(keyTable);
        yellowKey.setOnTopOf(keyTable);
        pinkKey.setOnTopOf(keyTable);
        
        Container toolChest = new Container("Chest", "This chest is big, heavy, and being held shut by a rope.", 0, 100);
        rooms.get("hidden tool room").addItem(toolChest);
        Weapon pickaxe = new Weapon("Pickaxe", "This pickaxe looks like it could be useful.", 10, 15, 2);     
        Item blueKey = new Item("Blue Key", "Thiis blue key has a few divots in it.", 0, 1);
        toolChest.addItem(pickaxe);
        toolChest.addItem(blueKey);
        
        BuildableItem superKey = new BuildableItem("Super Key", "This is the combinaion of all the keys.", 0, 3);
        rooms.get("eastern door").getExit("east").setLocked(true);
        rooms.get("eastern door").getExit("east").setKey(superKey);
        buildables.put("Super Key", superKey);
        superKey.addItemNeeded(redKey);
        superKey.addItemNeeded(blueKey);
        superKey.addItemNeeded(yellowKey);
        
        Item bookKey = new Item("Book of Keys", "This old dusty book looks like it's filled with a bunch of old keys. They must not be used for anything too important.", 0, 5);
        rooms.get("end of southern basement").addItem(bookKey);
        rooms.get("the old library").getExit("north").setLocked(true);
        rooms.get("the old library").getExit("north").setKey(bookKey);
        
        Item smallPuzzlePiece = new Item("Small Puzzle Piece", "This looks like a small puzzle piece. About one inch wide.", 0, 1);
        rooms.get("hidden puzzle room").addItem(smallPuzzlePiece);
        
        Armor guardArmor = new Armor("Sleeping Guard Armor", "This is the armor worn by the sleeping guard. It is a little beat up but it is advanced armor.", 0, 15, 25);
        rooms.get("the break room").addItem(guardArmor);
        
        Helmet guardHelmet = new Helmet("Sleeping Guard Helmet", "This is the helmet worn by the sleeping guard. It is in good condition.", 0, 5, 15);
        rooms.get("the break room").addItem(guardHelmet);
        
        Weapon guardSword = new Weapon("Sleeping Guard Sword", "This is the sword used by the sleeping guard. It is a little beat up but it is an advanced sword.", 0, 15, 2);
        rooms.get("the break room").addItem(guardSword);
        
        Food dinnerFood = new Food("The Guards Dinner", "This food looks decently appetizing.", 0, 3, 35);
        rooms.get("sir sean fortevir's room").addItem(dinnerFood);
        
        Item necklace = new Item("Key Necklace", "This is the necklace that was around Maximus's neck, it has a key on it.", 0, 1);
        rooms.get("maximus' den").addItem(necklace);
        
        BuildableItem secretRoomKey = new BuildableItem("Secret Room Key", "This key looks very unlike a key. It must bee for something secret.", 0, 2);
        buildables.put("Secret Room Key", secretRoomKey);
        secretRoomKey.addItemNeeded(bookKey);
        secretRoomKey.addItemNeeded(necklace);
        
        Item mediumPuzzlePiece = new Item("Medium Puzzle Piece", "This puzzle piece looks medium sized. About 2 inches wide", 0, 1);
        rooms.get("maximus' den").addItem(mediumPuzzlePiece);
        
        Item largePuzzlePiece = new Item("Large Puzzle Piece", "This puzzle piece looks rather large. About 4 inces in diameter.", 0, 1);
        rooms.get("sir sean fortevir's secret room").addItem(largePuzzlePiece);
        
        BuildableItem superPuzzlePiece = new BuildableItem("Super Puzzle Piece", "This is a combination of the puzzle pieces.", 0, 3);
        rooms.get("northern door").getExit("north").setLocked(true);
        rooms.get("northern door").getExit("north").setKey(superPuzzlePiece);
        buildables.put("Super Puzzle Piece", superPuzzlePiece);
        superPuzzlePiece.addItemNeeded(smallPuzzlePiece);
        superPuzzlePiece.addItemNeeded(mediumPuzzlePiece);
        superPuzzlePiece.addItemNeeded(largePuzzlePiece);
        
        Armor royalArmor = new Armor("Royal Armor", "This looks like the armor worn by the Royal Guard.", 0, 15, 50);
        rooms.get("the royal equipment room").addItem(royalArmor);
        
        Helmet royalHelmet = new Helmet("Royal Helmet", "This looks like the helmets worn by the Royal Guard.", 0, 5, 25);
        rooms.get("the royal equipment room").addItem(royalHelmet);
        
        Weapon royalSword = new Weapon("Royal Sword", "This looks like a sword used by the Royal Guard.", 0, 15, 2);
        rooms.get("the royal tool room").addItem(royalSword);
        
        BuildableItem ultimateKey = new BuildableItem("Ultimate Key", "This looks like a roayl key.", 0, 2);
        ultimateKey.addItemNeeded(superPuzzlePiece);
        ultimateKey.addItemNeeded(superKey);;
        
        Item gem = new Item("Valentinian Gem", "This is the fabled Valentinian Gem...", 25, 5);
        
        Container queensChest = new Container("Queen's Chest", "This chest at the foot of Queen Isa's bed.", 0, 100);
        rooms.get("the queen's hidden room").addItem(queensChest);
        queensChest.setLocked(true);
        queensChest.setKey(ultimateKey);
        queensChest.addItem(gem);
        
        
    }
    
}
