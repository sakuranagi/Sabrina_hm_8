package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;

public class Thor extends Hero {

    public Thor(int health, int damage, String name) {
        super(health, damage, SuperAbility.STUN_BOSS, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int stunned = 7;
        int stunnedChance = RPG_Game.random.nextInt(17);
        if (stunnedChance == stunned){
            for (int i = 0; i < heroes.length; i++) {
                heroes[i].setHealth(heroes[i].getHealth() + boss.getDamage());
            }
            System.out.println("Thor stunned boss");
        }


    }

}
