
/**
 * A class built for monsters.
 *
 * @author Chris Coakley
 * @version 30 April 2018
 */
public class Monster {
    /** A field for the name of the monster. */
    private String name;
    /** A field for the health this monster has. */
    private double health;
    /** A field for the damage done. */
    private double damageDone;
    /** A field for the hit probability. */
    private double hitProbability;

    /**
     * Constructor for the monster class.
     * 
     * @param nameValue The name of the monster.
     * @param healthValue The health this monster has.
     * @param damageDone The health this monster will do per hit.
     * @param hitProbability The hit probability for this specific monster.
     */
    public Monster(String nameValue, double healthValue, double damageDoneValue, double hitProbabilityValue) {
        name = nameValue;
        health = healthValue;
        damageDone = damageDoneValue;
        hitProbability = hitProbabilityValue;
    }

    /**
     * Accessor method for the name.
     * 
     * @return The name of this monster.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Accessor for the health of the monster.
     * 
     * @return The health the monster currently has.
     */
    public double getHealth() {
        return health;
    }
    
    /**
     * Mutator method for the health of the monster.
     * 
     * @param healthValue The health being added.
     */
    public void setHealth(double healthValue) {
        health += healthValue;
    }
    
    /**
     * Accessor method for the damage done
     * 
     * @return The damage done per hit.
     */
    public double getDamageDone() {
        return damageDone;
    }
    
    /**
     * Accessor method for the hit probability
     * 
     * @return The hit probability of this monster.
     */
    public double getHitProbability() {
        return hitProbability;
    }

}
