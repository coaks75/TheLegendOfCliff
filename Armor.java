
/**
 * An item that shields the player from attacks.
 *
 * @author Chris Coakley
 * @version 1 May 2018
 */
public class Armor extends Item implements Equippable{
    /** A field for the shield this gives the player. */
    private double shieldValue;
    
    /**
     * Constructor for the shiel class.
     * 
     * @param nameValue The name of an item.
     * @param descriptionValue The description of an item.
     * @param pointsValue The points associated with an item.
     * @param weightValue he weight of an item.
     */
    public Armor (String nameValue, String descriptionValue, int pointsValue, double weightValue, double shieldValueValue) {
        super(nameValue, descriptionValue, pointsValue, weightValue);
        shieldValue = shieldValueValue;
    }
    
    /**
     * Accessor for the shield Value
     * 
     * @return the value of the shield.
     */
    public double getShieldValue() {
        return shieldValue;
    }
    
    /**
     * Mutator method for the shield value.
     * 
     * @param The shield being added.
     */
    public void setShieldValue(double shieldValueValue) {
        shieldValue += shieldValueValue;
    }
    
    @Override
    public String equip(Player playerValue) {
        String answer = "";
        if (playerValue.getArmorEquipped() == null) {
            playerValue.setArmorEquipped(this);
            answer = "You equipped " + this.getName();
            playerValue.addShield(this.getShieldValue());
        }
        else {
            answer = "Woah, you can't equip " + this.getName() + " if you already have other armor equipped.";
        }
        return answer;
    }
    
    @Override
    public String unequip(Player playerValue) {
        playerValue.setArmorEquipped(null);
        String answer = "You unequipped " + this.getName();
        return answer;
    }
}
