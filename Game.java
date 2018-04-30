
/**
 * This class is the main class of the "Campus of Kings" application.
 * "Campus of Kings" is a very simple, text based adventure game. Users can walk
 * around some scenery. That's all. It should really be extended to make it more
 * interesting!
 * 
 * This game class creates and initializes all the others: it creates all rooms,
 * creates the parser and starts the game. It also evaluates and executes the
 * commands that the parser returns.
 * 
 * @author Maria Jump
 * @author Chris Coakley
 * @version 2015.02.01
 */

public class Game {
    /** The world where the game takes place. */
    private World world;
    /** The The score the player currently has. */
    private int score;
    /** The turns the player has taken. */
    private int turnCounter;
    /** The character controlled by the player. */
    private Player player;

    /**
     * Create the game and initialize its internal map.
     */
    public Game() {
        world = new World();
        score = 0;
        turnCounter = -1;
        // set the starting room
        player = new Player(world.getRoom("Main Room"));
    }

    /**
     * Main play routine. Loops until end of play.
     */
    public void play() {
        printWelcome();

        // Enter the main game loop. Here we repeatedly read commands and
        // execute them until the game is over.
        boolean wantToQuit = false;
        while (!wantToQuit) {
            Command command = Reader.getCommand();
            turnCounter++;
            wantToQuit = processCommand(command);
            // other stuff that needs to happen every turn can be added here.
        }
        printGoodbye();
    }

    ///////////////////////////////////////////////////////////////////////////
    // Helper methods for processing the commands

    /**
     * Given a command, process (that is: execute) the command.
     * 
     * @param command
     *            The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) {
        boolean wantToQuit = false;

        if (command.isUnknown()) {
            Writer.println("I don't know what you mean...");
        } else {

            CommandEnum commandWord = command.getCommandWord();
            switch (commandWord) {
                case HELP:
                printHelp();
                break;
                case GO:
                goRoom(command);
                break;
                case QUIT:
                wantToQuit = quit(command);
                break;
                case LOOK:
                look();
                break;
                case SCORE:
                Writer.println("Your current score is " + score);
                break;
                case TURNS:
                Writer.println("The current number of turns you've taken are " + turnCounter);
                break;
                case BACK:
                player.setRoom(player.getPreviousRoom());
                Writer.println(player.getRoom().toString());
                break;
                case STATUS:
                Writer.println("Your current score is " + score);
                Writer.println("The current number of turns you've taken are " + turnCounter);
                Writer.println(player.getRoom().toString());
                break;
                case INVENTORY:
                inventory();
                break;
                case DROP:
                drop(command);
                break;
                case EXAMINE:
                examine(command);
                break;
                case TAKE:
                take(command);
                break;
                case LOCK:
                lock(command);
                break;
                case UNLOCK:
                unlock(command);
                break;
                case PACK:
                pack(command);
                break;
                case UNPACK:
                unpack(command);
                break;
                case EAT:
                eat(command);
                break;
                default:
                Writer.println(commandWord + " is not implemented yet!");
                break;
            }
        }
        return wantToQuit;
    }

    ///////////////////////////////////////////////////////////////////////////
    // Helper methods for implementing all of the commands.
    // It helps if you organize these in alphabetical order.

    /**
     * Try to go to one direction. If there is an exit, enter the new room,
     * otherwise print an error message.
     * 
     * @param command
     *            The command to be processed.
     */
    private void goRoom(Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            Writer.println("Go where?");
        } 
        else {
            String direction = command.getRestOfLine();

            // Try to leave current.
            Door doorway = null;

            doorway = player.getRoom().getExit(direction);

            if (doorway == null) {
                Writer.println("There is no door!");
            }
            else if (doorway.isLocked()) {
                Writer.println("Door is locked");
            }
            else {
                Room newRoom = doorway.getDestination();
                player.setRoom(newRoom);
                int pointsUsing = newRoom.getPoints();
                score += pointsUsing;
                printLocationInformation();
            }
        }
    }

    /**
     * Print out the closing message for the player.
     */
    private void printGoodbye() {
        Writer.println("It looks like your Legend of Cliff will end here.");
        Writer.println("You have earned " + score + " points in " + turnCounter + " turns.");
        Writer.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out some help information. Here we print some stupid, cryptic
     * message and a list of the command words.
     */
    private void printHelp() {
        Writer.println("You are lost. You are alone. You wander");
        Writer.println("     around the caverns of the");
        Writer.println("         Castle of Isa.");
        Writer.println();
        Writer.println("Your command words are:");
        Writer.println("     " + CommandWords.getCommandString());
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome() {
        Writer.println();
        Writer.println("You fall through a trap after taking the gem!");
        Writer.println("You fall into a dark room, you can't see anyhting it's so dark.");
        Writer.println("You light the lantern on your backpack.");
        Writer.println();
        printLocationInformation();
    }

    /**
     * Prints out the current location and exits.
     */
    private void printLocationInformation() {
        Writer.println(player.getRoom().toString());
    }

    /**
     * "Quit" was entered. Check the rest of the command to see whether we
     * really quit the game.
     *
     * @param command
     *            The command to be processed.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) {
        boolean wantToQuit = true;
        if (command.hasSecondWord()) {
            Writer.println("Quit what?");
            wantToQuit = false;
        }
        return wantToQuit;
    }

    /**
     * Prints out the location information.
     */
    private void look() {
        printLocationInformation();
    }

    /**
     * A method used to drop an item.
     * 
     * @param commandValue The command to be processed.
     */
    private void drop(Command commandValue) {
        String inventory = player.getInventory();
        if (commandValue.hasSecondWord() == false) {
            Writer.println("Which item?");
        }
        else if (inventory.contains(commandValue.getRestOfLine().toLowerCase()) == false) {
            Writer.println("You don't have that!");
        }
        else {
            Item itemValue = player.getItem(commandValue.getRestOfLine());
            player.removeItem(commandValue.getRestOfLine());
            player.getRoom().addItem(itemValue);
            Writer.println("You dropped the " + itemValue.getName() + ".");
        }
    }

    /**
     * A method used to examine an item.
     * 
     * @param commandValue The command to be processed.
     */
    private void examine(Command commandValue) {
        String inventory = player.getInventory();
        if (commandValue.hasSecondWord() == false) {
            Writer.println("Which item?");
        }
        else if ((inventory.contains(commandValue.getRestOfLine()) == false) && (player.getRoom().getItem(commandValue.getRestOfLine()) == null)) {
            Writer.println("No such item exists.");
        }
        else{
            Item itemValue = null;
            if (inventory.contains(commandValue.getRestOfLine()) ) {
                itemValue = player.getItem(commandValue.getRestOfLine());
            }
            else {
                itemValue = player.getRoom().getItem(commandValue.getRestOfLine());
            }
            if (itemValue instanceof Container) {
                Container using = (Container)itemValue;
                Writer.println(using.toString());
            }
            else {
                Writer.println(itemValue.toString());
            }
        }
    }

    /**
     * A method used to list the items in the inventory.
     */
    private void inventory() {
        Writer.println(player.getInventory());
    }

    /**
     * A method used to take an item.
     * 
     * @param commandValue The command to be processed.
     */
    private void take(Command commandValue) {
        String inventory = player.getInventory();
        String word = null;
        Item itemValue = null;
        boolean hasWord = false;
        if (!commandValue.hasSecondWord()) {
            Writer.println("Take what?");
        }
        else {
            itemValue = player.getRoom().getItem(commandValue.getRestOfLine());
            word = commandValue.getRestOfLine();
            hasWord = true;
        }
        if (hasWord) {
            if (player.getRoom().getItem(word) == null) {
                Writer.println("No such item in the room.");
            }
            else if (itemValue.getWeight() > player.getMaxWeight()) {
                Writer.println("Item is too heavy to lift.");
            }
            else if (player.getRoom().getItem(itemValue.getName()) != null && player.canAdd(itemValue) == false) {
                Writer.println("Carrying too much.");
            }
            else {
                player.getRoom().removeItem(itemValue.getName());
                player.addToInventory(itemValue);
                Writer.println("You took the " + itemValue.getName() + ".");
            }
        }
    }

    /**
     * A method used to lock a something.
     * 
     * @param commandValue The command to be processed.
     */
    private void lock(Command commandValue) {
        boolean hasWord = false;
        String secondWord = null;
        boolean isDoor = false;
        boolean isContainer = false;
        Lockable thing = null;
        String keyCommand = null;
        boolean canLock = false;
        String inventory = player.getInventory();
        if (!commandValue.hasSecondWord()) {
            Writer.println("Lock what?");
        }
        else {
            hasWord = true;
            secondWord = commandValue.getRestOfLine();
        }
        if (hasWord) {
            if (player.getRoom().getExit(secondWord) != null) {
                isDoor = true;
                thing = player.getRoom().getExit(secondWord);
            }
            else if (player.getRoom().getItem(secondWord) != null) {
                if (player.getRoom().getItem(secondWord) instanceof Container) {
                    Container using = (Container)player.getRoom().getItem(secondWord);
                    thing = using;
                    isContainer = true;
                }
                else {
                    Writer.println(secondWord + " is not a container.");
                }
            }
            else if (player.getItem(secondWord) != null) {
                if (player.getItem(secondWord) instanceof Container) {
                    Container using = (Container)player.getItem(secondWord);
                    thing = using;
                    isContainer = true;
                }
                else {
                    Writer.println(secondWord + " is not a container.");
                }
            }
            else {
                Writer.println("Can't find " + secondWord + ".");
            }
        }
        if (isDoor || isContainer) {
            if (thing.isLocked()) {
                Writer.println(secondWord + " is already locked.");
            }
            else if (thing.getKey() == null) {
                Writer.println(secondWord + " cannot be locked.");
            }
            else {
                canLock = true;
                Writer.println("What would you like to unlock this with?");
                keyCommand = Reader.getResponse();
            }
        }
        if (canLock) {
            if (!(inventory.contains(keyCommand))) {
                Writer.println("You do not have that key.");
            }
            else if ((!thing.getKey().getName().equalsIgnoreCase(keyCommand))) {
                Writer.println("Wrong key.");
            }
            else  {
                thing.setLocked(true);
                Writer.println("You locked the door.");
            }
        }
    }

    /**
     * A method used to unlock a something.
     * 
     * @param commandValue The command to be processed.
     */
    private void unlock(Command commandValue) {
        boolean hasWord = false;
        boolean isDoor = false;
        boolean isContainer = false;
        Lockable thing = null;
        String secondWord = null;
        String keyCommand = null;
        boolean canUnlock = false;
        String inventory = player.getInventory();
        if (!commandValue.hasSecondWord()) {
            Writer.println("Unlock what?");
        }
        else {
            hasWord = true;
            secondWord = commandValue.getRestOfLine();
        }
        if (hasWord) {
            if (player.getRoom().getExit(secondWord) != null) {
                isDoor = true;
                thing = player.getRoom().getExit(secondWord);
            }
            else if (player.getRoom().getItem(secondWord) != null) {
                if (player.getRoom().getItem(secondWord) instanceof Container) {
                    Container using = (Container)player.getRoom().getItem(secondWord);
                    thing = using;
                    isContainer = true;
                }
                else {
                    Writer.println(secondWord + " is not a container.");
                }
            }
            else if (player.getItem(secondWord) != null) {
                if (player.getItem(secondWord) instanceof Container) {
                    Container using = (Container)player.getItem(secondWord);
                    thing = using;
                    isContainer = true;
                }
                else {
                    Writer.println(secondWord + " is not a container.");
                }
            }
            else {
                Writer.println("Can't find " + secondWord + ".");
            }
        }
        if (isDoor || isContainer) {
            if (!thing.isLocked()) {
                Writer.println(secondWord + " is already unlocked.");
            }
            else {
                canUnlock = true;
                Writer.println("What would you like to unlock " + secondWord + " with.");
                keyCommand = Reader.getResponse();
            }
        }
        if (canUnlock) {
            if (!(inventory.contains(keyCommand))) {
                Writer.println("You don't have that.");
            }
            else if (!(thing.getKey().getName().equalsIgnoreCase(keyCommand))) {
                Writer.println("That key doesn't seem to work on this door...");
            }
            else {
                thing.setLocked(false);
                Writer.println("You have unlocked " + secondWord + ".");
            }
        }
    }

    /**
     * A helper method used to pack a container.
     * 
     * @param commandValue The command to be processed.
     */
    private void pack(Command commandValue) {
        boolean hasWord = false;
        String itemName = null;
        Item toPack = null;
        String containerUsing = null;
        Item packing = null;
        boolean isContainer = false;
        boolean canPack = false;
        boolean exists = false;
        if (!commandValue.hasSecondWord()) {
            Writer.println("Pack what?");
        }
        else {
            hasWord = true;
            itemName = commandValue.getRestOfLine();
            toPack = player.getRoom().getItem(itemName);
        }
        if (hasWord) {
            if (toPack == null && !(player.getInventory().contains(itemName))) {
                Writer.println("You don't have that.");
            }
            else if (player.getRoom().getItem(itemName) != null && toPack.getWeight() > player.getMaxWeight()) {
                Writer.println(player.getRoom().getItem(itemName).getName() + " is too heavy."); 
            }
            else {
                canPack = true;
                Writer.println("What would you like to put this in?");
                containerUsing = Reader.getResponse();
            }
        }
        if (canPack) {
            if (player.getRoom().getItem(containerUsing) == null && !(player.getInventory().contains(containerUsing))) {
                Writer.println("Hmm, it doesn't look like you can see that container around here.");
            }
            else {
                if (player.getRoom().getItem(containerUsing) != null) {
                    packing = player.getRoom().getItem(containerUsing);
                    exists = true;
                }
                else if (player.getItem(containerUsing) != null){
                    packing = player.getItem(containerUsing);
                    exists = true;
                }
            }
        }
        if (exists) {
            if (!(packing instanceof Container)) {
                Writer.println("That isn't a container.\n" + packing.toString());
            }
            else {
                isContainer = true;
            }
        }
        if (isContainer) {
            Container using = (Container)packing;
            if (using.isLocked()) {
                Writer.println(using.getName() + " is locked.");
            }
            else if (!(player.canAdd(player.getRoom().getItem(itemName)))) {
                Writer.println("You're carrying too much already!");
            }
            else {
                if (player.getRoom().getItem(itemName) != null) {
                    toPack = player.getRoom().getItem(itemName);
                    player.getRoom().removeItem(itemName);
                }
                else {
                    toPack = player.getItem(itemName);
                    player.removeItem(itemName);
                }
                using.addItem(toPack);
                Writer.println("You packed " + toPack.getName());
            }
        }
    }

    /**
     * A method used to unpack a container.
     * 
     * @param commandValue The command to be processed.
     */
    private void unpack(Command commandValue) {
        boolean hasWord = false;
        String containerName = null;
        Item unpacking = null;
        Item toUnpack = null;
        String toUnpackName = null;
        boolean exists = false;
        boolean isContainer = false;
        if (!commandValue.hasSecondWord()) {
            Writer.println("Unpack what?");
        }
        else {
            hasWord = true;
            containerName = commandValue.getRestOfLine();
        }
        if (hasWord) {
            if (player.getRoom().getItem(containerName) == null && !(player.getInventory().contains(containerName))) {
                Writer.println("Hmmm, don't see that here...");
            }
            else {
                if (player.getRoom().getItem(containerName) != null) {
                    unpacking = player.getRoom().getItem(containerName);
                    exists = true;
                }
                else if (player.getItem(containerName) != null){
                    unpacking = player.getItem(containerName);
                    exists = true;
                }
            }
        }
        if (exists) {
            if (unpacking instanceof Container) {
                Writer.println("Woah buddy, thats not a container.");
            }
            else {
                Container using = (Container)unpacking;
                if (!using.isLocked()) {
                    Writer.println(using.getName() + " is locked.");
                }
                else {
                    Writer.println("What would you like to unpack from this?");
                    Writer.println(using.getName() + " contains: \n\t" + using.toString());
                    toUnpackName = Reader.getResponse();
                    isContainer = true;
                }
            }
        }
        if (isContainer) {
            Container using = (Container)unpacking;
            if(using.getItem(toUnpackName) == null) {
                Writer.println("That's odd... That item isn't in the container.");
            }
            else if (!(player.canAdd(using.getItem(toUnpackName)))) {
                Writer.println("Oh boy, you're carrying too much already to hold this.");
            }
            else {
                player.addToInventory(using.getItem(toUnpackName));
                Writer.println("You unpacked " + using.getItem(toUnpackName).getName() + " from " + using.getName());
                using.removeItem(toUnpackName);
            }
        }
    }

    /** 
     * A method used to eat food
     * 
     * @param commandValue The command to be processed 
     */
    private void eat(Command commandValue) {
        String foodName = null;
        boolean hasWord = false;
        Item theFood = null;
        Edible thing = null;
        boolean exists = false;
        if (!commandValue.hasSecondWord()) {
            Writer.println("Eat what?");
        }
        else {
            hasWord = true;
            foodName = commandValue.getRestOfLine();
        }
        if (hasWord) {
            if (player.getRoom().getItem(foodName) == null && player.getInventory().contains(foodName)) {
                Writer.println("Hmmm, don't see that here...");
            }
            else {
                if (player.getRoom().getItem(foodName) != null) {
                    theFood = player.getRoom().getItem(foodName);
                    exists = true;
                }
                else if (player.getItem(foodName) != null){
                    theFood = player.getItem(foodName);
                    exists = true;
                }
            }
        }
        if (exists) {
            if (!(theFood instanceof Edible)) {
                Writer.println("This doesn't look like it would taste good...");
            }
            else {
                thing = (Edible)theFood;
                Writer.println("You ate " + foodName + " and gained " + thing.getHealthGained() + " health.");
                player.setHealth(thing.getHealthGained());
            }
        }
    }

    /**
     * A method used to equip an item
     * 
     * @param commandvalue The command we are looking to process
     */
    private void equip(Command commandValue) {
        boolean hasWord = false;
        String itemName = null;
        boolean exists = false;
        Item equipping = null;
        boolean canHold = false;
        boolean inRoom = false;
        if(!commandValue.hasSecondWord()) {
            Writer.println("Equip what?");
        }
        else {
            hasWord = true;
            itemName = commandValue.getRestOfLine();
        }
        if (hasWord) {
            if (player.getRoom().getItem(itemName) == null && !(player.getInventory().contains(itemName))) {
                Writer.println("Hmmmm, don't see that here...");
            }
            else if (player.getRoom().getItem(itemName) != null) {
                equipping = player.getRoom().getItem(itemName);
                inRoom = true;
                exists = true;
            }
            else {
                equipping = player.getItem(itemName);
                exists = true;
                canHold = true;
            }
        }
        if (exists) {
            if (equipping instanceof Weapon) {
                Weapon using = (Weapon)equipping;
                if (inRoom) {
                    if (!player.canAdd(using)) {
                        Writer.println("You're already carrying too much.");
                    }
                    else {
                        canHold = true;
                    }
                }
                if (canHold) {
                    if (!using.equip(player)) {
                        Writer.println("Woah, you don't have that many hands...");
                    }
                    else {
                        Writer.println("You have " + using.getName() + " equipped.");
                        using.equip(player);
                    }
                }
            }
            else {
                Writer.println("You can't equip " + equipping.getName() + ".");
            }
        }
    }

    /**
     * A method used to hit a target.
     * 
     * @param commandValue The command to be processed.
     */
    private void hit(Command commandValue) {
        boolean hasWord = false;
        String targetName = null;
        Item target = null;
        String weaponName = null;
        Item weapon = null;

        if (!commandValue.hasSecondWord()) {
            Writer.println("Hit what?");
        }
        else {
            hasWord = false;
            targetName = commandValue.getRestOfLine();
        }
        if (hasWord) {
            if (player.getRoom().getItem(targetName) == null) {
                Writer.println(targetName + " is not here.");
            }
            else {
                target = player.getRoom().getItem(targetName);
            }
        }
        if (target != null) {
            Writer.println("What would you like to hit " + targetName + " with?");
            weaponName = Reader.getResponse();
        }
        //not completed yet
    }

    /**
     * A method used to place an item on top of something.
     * 
     * @param commandValue The command to be processed.
     */
    private void place (Command commandValue) {
        boolean hasWord = false;
        String itemName = null;
        Item itemValue = null;
        Item beingPlacedOn = null;
        String beingPlacedOnName = null;
        boolean itemExists = false;

        if (!commandValue.hasSecondWord()) {
            Writer.println("Place what?");
        }
        else {
            hasWord = true;
            itemName = commandValue.getRestOfLine();
        }
        if (hasWord) {
            if (player.getItem(itemName) == null) {
                Writer.println("You do not have " + itemName);
            }
            else {
                itemValue = player.getItem(itemName);
                Writer.println("What would you like to place this on?");
                beingPlacedOnName = Reader.getResponse();
                beingPlacedOn = player.getRoom().getItem(beingPlacedOnName);
                itemExists = true;
            }
        }
        if (itemExists) {
            if (player.getRoom().getItem(beingPlacedOnName) == null) {
                Writer.println(beingPlacedOnName + " is not here.");
            }
            else {
                beingPlacedOn.setOnTopOf(itemValue);
                Writer.println("You placed " + itemName + " on top of " + beingPlacedOnName + ".");
            }
        }
    }
}
