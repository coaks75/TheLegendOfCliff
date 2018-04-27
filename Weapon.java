
/**
 * A class for a weapon.
 *
 * @author Chris Coakley
 * @version 27 April 2018
 */
public class Weapon extends Item{
    /** A field for the damage this weapon does. */
    private int damageDone;
    
    /**
     * Constructor for the weapon class.
     * 
     * @param nameValue The name of an item.
     * @param descriptionValue The description of an item.
     * @param pointsValue The points associated with an item.
     * @param weightValue he weight of an item.
     */
    public Weapon (String nameValue, String descriptionValue, int pointsValue, double weightValue, int damageDoneValue) {
        super(nameValue, descriptionValue, pointsValue, weightValue);
        damageDone = damageDoneValue;
        
    }
}
