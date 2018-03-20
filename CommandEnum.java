
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
    STATUS("status");

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
