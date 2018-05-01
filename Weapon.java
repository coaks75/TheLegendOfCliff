
/**
 * A class for a weapon.
 *
 * @author Chris Coakley
 * @version 27 April 2018
 */
public class Weapon extends Item implements Equippable{
    /** A field for the damage this weapon does. */
    private double damageFactor;

    /**
     * Constructor for the weapon class.
     * 
     * @param nameValue The name of an item.
     * @param descriptionValue The description of an item.
     * @param pointsValue The points associated with an item.
     * @param weightValue he weight of an item.
     */
    public Weapon (String nameValue, String descriptionValue, int pointsValue, double weightValue, double damageFactorValue) {
        super(nameValue, descriptionValue, pointsValue, weightValue);
        damageFactor = damageFactorValue;
    }
    
    /**
     * Accessor method for the damage factor.
     * 
     * @return The damage factor of this weapon.
     */
    public double getDamageFactor() {
        return damageFactor;
    }

    @Override
    public String equip(Player playerValue) {
        String answer = "";
        if (playerValue.canEquip()) {
            playerValue.addEquipped(this);
            answer = "You equipped " + this.getName();
        }
        else {
            answer = "Woah, you don't have enough hands to equip " + this.getName();
        }
        return answer;
    }

    @Override
    public String unequip(Player playerValue) {
        playerValue.minusEquipped(this);
        String answer = "You unequipped " + this.getName();
        return answer;
    }
}
