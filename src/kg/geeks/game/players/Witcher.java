package kg.geeks.game.players;

public class Witcher extends Hero{

    public Witcher(int health,  String name) {
        super(health, 0, SuperAbility.DIE_AND_SAVE_LIFE, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {

        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() <= 0 && this.getHealth() > 0 ){
                heroes[i].setHealth(this.getHealth());
                this.setHealth(0);
                System.out.println("Witcher " + this.getName() + " dead and save " + heroes[i].getName());
            }
        }
    }
}
