
/**
 * Enumeration class CommandEnum - enumeration of the command words.
 *
 * @author Chris Coakley
 * @version 13 March 2018
 */
public enum CommandEnum {
    LOOK("look"),
    GO("go"),
    HELP("help"),
    QUIT("quit"),
    SCORE("score"),
    TURNS("turns"),
    BACK("back"),
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
     */
    public String getText() {
        return text;
    }
}
