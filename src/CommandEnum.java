
/**
 * Enumeration class CommandEnum - enumeration of the command words.
 *
 * @author Chris Coakley
 * @version 13 March 2018
 */
public enum CommandEnum {
    /**A command to look. */
    LOOK("look"),
    /** A command to go in a direction. */
    GO("go"),
    /** A command for help. */
    HELP("help"),
    /** A command to quit. */
    QUIT("quit"),
    /** A command to get the score. */
    SCORE("score"),
    /** A command to get the turns. */
    TURNS("turns"),
    /** A command to go back. */
    BACK("back"),
    /** A command to get your status. */
    STATUS("status"),
    /** A command to examine something. */
    EXAMINE("examine"),
    /** A command to take an item. */
    TAKE("take"),
    /** A command to drop an item. */
    DROP("drop"),
    /** A command to get a list of the inventory items. */
    INVENTORY("inventory"),
    /** A command to lock a door. */
    LOCK("lock"),
    /** A command to unlock a door. */
    UNLOCK("unlock"),
    /** A command to pack a container. */
    PACK("pack"),
    /** A command to unpack a container. */
    UNPACK("unpack"),
    /** A command to eat food. */
    EAT("eat"),
    /** A command used to equip something. */
    EQUIP("equip"),
    /** A command to unequip something. */
    UNEQUIP("unequip"),
    /** A command use to build something. */
    BUILD("build"),
    /** A command used to dismantle something. */
    DISMANTLE("dismantle"),
    /** A command to hit something. */
    HIT("hit"),
    /** A cheat code command for full health and shield. */
    ISABELLA("isabella");
    
    /** A field for the text that would be entered by the person playing the game.*/
    private final String text;

    /**
     * Constructor for the enum class.
     * 
     * @param textValue The text entered by the player.
     */
    private CommandEnum(String textValue) {
        text = textValue;
    }
    
    /**
     * A method used to get the text that would be entered by the person playing the game.
     * 
     * @return The text.
     */
    public String getText() {
        return text;
    }
}
