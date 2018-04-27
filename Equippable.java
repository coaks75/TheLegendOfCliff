
/**
 * Interface of an equippable item.
 *
 * @author Chris Coakley
 * @version 25 April 2018
 */
public interface Equippable {
    /**
     * A method which says if you can equip an item.
     */
    public abstract void makeEquippable();
    
    /**
     * A method to get if the item is equippable or not.
     */
    public abstract boolean isEquippable();
}
