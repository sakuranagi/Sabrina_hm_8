package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;

public class Boss extends GameEntity {
    private SuperAbility defence;

    public Boss(int health, int damage, String name) {
        super(health, damage, name);
    }

    public SuperAbility getDefence() {
        return defence;
    }

    public void setDefence(SuperAbility defence) {
        this.defence = defence;
    }

    public void chooseDefence(Hero[] heroes) {
//        SuperAbility[] values = SuperAbility.values();
//        int index = RPG_Game.random.nextInt(values.length);
//        this.defence = values[index];
        int randomDefence = RPG_Game.random.nextInt(heroes.length);
        Hero hero = heroes[randomDefence];
        if (hero.getHealth() <= 0) {
            this.chooseDefence(heroes);
        } else {
            this.setDefence(hero.getAbility());
        }


    }

    public void attack(Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                if (heroes[i] instanceof Berserk && heroes[i].getAbility() != this.defence) {
                    int blocked;
                    if (RPG_Game.random.nextBoolean()) {
                        blocked = this.getDamage() / 2;
                    } else {
                        blocked = this.getDamage() / 5;
                    }
                    ((Berserk) heroes[i]).setBlockedDamage(blocked);
                    heroes[i].setHealth(heroes[i].getHealth() - (this.getDamage() - blocked));
                } else {
                    heroes[i].setHealth(heroes[i].getHealth() - this.getDamage());
                }
            }
        }
    }

    @Override
    public String toString() {
        return "BOSS " + super.toString() + " DEFENCE:" + this.defence + "\n";
    }
}