package co.aeons.zombie.shooter.entities.weapons;

import java.util.ArrayList;
import java.util.LinkedList;

import co.aeons.zombie.shooter.entities.bullets.Bullet;
import co.aeons.zombie.shooter.entities.bullets.ShotgunBullet;
import co.aeons.zombie.shooter.managers.Jukebox;

public class Shotgun extends Weapon{

    private int pelletCount;

    public Shotgun(float x, float y) {
        super(x, y);

        fireRate = 0.7f;
        pelletCount = 24;
        texturePath = "weapons/shotgun1.png";
    }

    @Override
    public ArrayList<Bullet> shoot() {
        ArrayList<Bullet> output = new ArrayList<Bullet>();
        if(!isFired) {
            for (int i = 0; i < pelletCount; i++) {
                output.add(getNewBullet());
            }
            playSound();
            isFired = true;
            fireRate = 0.7f;
        }
        return output;
    }

    @Override
    public void playSound() {
        Jukebox.play("skrra");
    }

    @Override
    public Bullet getNewBullet() {
        return new ShotgunBullet(x, y);
    }
}
