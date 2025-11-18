import java.util.ArrayList;

/**
 * Class which stores enemy creatures.
 *
 * @author Mark Osborne
 * @version ver1.0.0
 */

public class Enemies
{

    private ArrayList<EnemyCreature> aliveEnemyCreatures;
    private ArrayList<EnemyCreature> deadEnemyCreatures;

    /**
     * Default constructor which creates the object of the class Enemies.
     *
     */
    public Enemies()
    {
        aliveEnemyCreatures = new ArrayList<EnemyCreature>();
        deadEnemyCreatures = new ArrayList<EnemyCreature>();
    }   

    /**
     * Method to check death of enemy creature and move their list to 
     * the dead list if so.
     *
     * @param   thisCreature  The enemy creature to check as an EnemyCreature. 
     * @return          The death (if it occurred) of the enemy creature as a string.
     */
    public String checkEnemyCreatureDeath(EnemyCreature thisCreature)
    {
        String result = "";
        if (thisCreature.getDamagePoints() >= 10)
        {
            thisCreature.setIsAlive(false);
            result += thisCreature.getFullName() + " is dead.\n";
            deadEnemyCreatures.add(thisCreature);
            aliveEnemyCreatures.remove(thisCreature);
        }
        return result;
    }

    /**
     * Method to display details of the enemy creatures.
     *
     * @return          List of alive enemy creatures as a string.
     */
    public String displayEnemy()
    {
        String output = "The Enemy consists of:\n";
        String EnemyList = "";
        if (!aliveEnemyCreatures.isEmpty())
        {
            for (Creature enemyCreature:aliveEnemyCreatures)
            {
                EnemyList += "\t" + enemyCreature.getFullName();
            }
        }
        if (EnemyList == "")
            EnemyList = "Nobody?!";
        output += "\n" + EnemyList;
        return output;
    }

    /**
     * Accessor Method to return alive enemy creatures.
     *
     * @return          Alive enemy creatures as an ArrayList.
     */
    public ArrayList<EnemyCreature> getAliveEnemyCreatures()
    {
        return this.aliveEnemyCreatures;
    }

    /**
     * Accessor Method to return dead enemy creatures.
     *
     * @return          Dead enemy creatures as an ArrayList.
     */
    public ArrayList<EnemyCreature> getDeadEnemyCreatures()
    {
        return this.deadEnemyCreatures;
    }

    /**
     * Method to return enemy creature at a particular game location.
     *
     * @param   gameLocation  The game location to check for an enemy
     *                  creature as a GameLocation
     * @return          The enemy creature at the game location if any 
     *                  as an EnemyCreature.
     */
    public EnemyCreature getEnemyCreatureAtLocation(GameLocation gameLocation)
    {
        for (EnemyCreature enemyCreature:aliveEnemyCreatures)
            {
                if (enemyCreature.getGameLocation() == gameLocation)
                    return enemyCreature;
            }
        for (EnemyCreature enemyCreature:deadEnemyCreatures)
            {
                if (enemyCreature.getGameLocation() == gameLocation)
                    return enemyCreature;
            }
        return EnemyCreature.nobody;
    }

    /**
     * Method to search for an enemy creature by its full name.
     *
     * @param   fullName  The name of the enemy creature being searched
     *                    as a string.
     * @return          The enemy creature being searched as an EnemyCreature.
     */
    public EnemyCreature getEnemyCreatureByFullName(String fullName)
    {
        for (EnemyCreature enemyCreature:aliveEnemyCreatures)
            {
                if (enemyCreature.getFullName().equals(fullName))
                    return enemyCreature;
            }
        for (EnemyCreature enemyCreature:deadEnemyCreatures)
            {
                if (enemyCreature.getFullName().equals(fullName))
                    return enemyCreature;
            }
        return EnemyCreature.nobody;
    }

    /**
     * Method to return list of alive enemy creatures as menu options.
     *
     * @return          List of alive enemy creatures as string array.
     */
    public String[] getMenuOptionsAliveEnemy()
    {
        String[] result = new String[this.aliveEnemyCreatures.size()];
        for (int index = 0; index < this.aliveEnemyCreatures.size(); index++)
        {
            result[index] = this.aliveEnemyCreatures.get(index).getFullName();
        }
        return result;
    }

    /**
     * Method to determine if new enemy creature created at game location.
     *
     * @param   gameLocation  Location to create new creature as GameLocation.
     * @return          Result of determination as a string.
     */
    public String rollToCreateEnemyCreature(GameLocation gameLocation)
    {
        String creature = "No creature";

        int rollForEnemy = (int)(Math.random() * 100) + 1;

        boolean enemyCreatureIsHere = rollForEnemy <= 75;

        if (enemyCreatureIsHere)
        {
            int rollForCreatureType = (int)(Math.random() * 3) + 1;
            String creatureType = GameConstants.TYPE_ORC;

            switch (rollForCreatureType)
            {
                case 1:  creatureType = GameConstants.TYPE_ORC;
                    break;
                case 2:  creatureType = GameConstants.TYPE_GOBLIN;
                    break;
                case 3:  creatureType = GameConstants.TYPE_TROLL;
            }
                
            EnemyCreature enemyCreature = new EnemyCreature(
                creatureType,
                gameLocation);
            aliveEnemyCreatures.add(enemyCreature);
            creature = enemyCreature.getFullName();
        }
        return creature;
    }

}
