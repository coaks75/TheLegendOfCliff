
/**
 * A class for a weapon.
 *
 * @author Chris Coakley
 * @version 27 April 2018
 */
public class Weapon extends Item implements Equippable{
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

    @Override
    public boolean equip(Player playerValue) {
        boolean answer = false;
        if (playerValue.getNumItemsEquipped() < playerValue.getMaxEquippable()) {
            //playerValue.addOneEquipped();
            answer = true;
        }
        return answer;
    }

    @Override
    public boolean unequip(Player playerValue) {
        //playerValue.minusOneEquipped();
        return true;
    }
}
