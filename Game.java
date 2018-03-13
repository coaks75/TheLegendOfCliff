
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

            String commandWord = command.getCommandWord();
            switch (commandWord) {
                case "help":
                    printHelp();
                    break;
                case "go":
                    goRoom(command);
                    break;
                case "quit":
                    wantToQuit = quit(command);
                    break;
                case "look":
                    look();
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
        } else {
            String direction = command.getRestOfLine();

            // Try to leave current.
            Door doorway = null;

            doorway = player.getRoom().getExit(direction);

            if (doorway == null) {
                Writer.println("There is no door!");
            } else {
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
        Writer.println("I hope you weren't too bored here on the Campus of Kings!");
        Writer.println("You have earned " + score + " points in " + turnCounter + " turns.");
        Writer.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out some help information. Here we print some stupid, cryptic
     * message and a list of the command words.
     */
    private void printHelp() {
        Writer.println("You are lost. You are alone. You wander");
        Writer.println("around the caverns of the");
        Writer.println("Castle of Isa.");
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
}
