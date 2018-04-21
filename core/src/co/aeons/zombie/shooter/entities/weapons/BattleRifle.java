package co.aeons.zombie.shooter.entities.weapons;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;
import java.util.LinkedList;

import co.aeons.zombie.shooter.entities.bullets.BRBullet;
import co.aeons.zombie.shooter.entities.bullets.Bullet;
import co.aeons.zombie.shooter.managers.Jukebox;

public class BattleRifle extends Weapon {

    private int bulletDelay;

    public BattleRifle(float x, float y) {
        super(x, y);
        fireRate = 0.5f;
        texturePath = "weapons/assault1.png";
        weaponTexture = new Texture(texturePath);
        bulletDelay = 0;
    }

    @Override
    public ArrayList<Bullet> shoot() {
        ArrayList<Bullet> output = new ArrayList<Bullet>();
        if(!isFired){
            for (int i = 0; i < 3; i++) {
                setBulletDelay(i);
                output.add(getNewBullet());
            }
            playSound();
            isFired = true;
            fireRate = 0.5f;
        }
        return output;
    }

    @Override
    public void playSound() {
        Jukebox.play("drrr");
    }

    @Override
    public Bullet getNewBullet() {
        return new BRBullet(this.x, this.y, this.bulletDelay);
    }

    private void setBulletDelay(int bulletDelay) {
        this.bulletDelay = bulletDelay;
    }

}
