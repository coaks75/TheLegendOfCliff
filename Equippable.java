
/**
 * Interface of an equippable item.
 *
 * @author Chris Coakley
 * @version 25 April 2018
 */
public interface Equippable {
    /**
     * A method used to equip something for a player.
     * 
     * @param playerValue The player were equipping this item.
     * @return If it was equipped.
     */
    public abstract boolean equip(Player playerValue);
    
    /**
     * A method used to unequip something
     * 
     * @param playerValue The player were equipping this item.
     * @return If it was unequipped.
     */
    public abstract boolean unequip(Player playerValue);
}
