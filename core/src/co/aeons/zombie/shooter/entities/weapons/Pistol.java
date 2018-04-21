package co.aeons.zombie.shooter.entities.weapons;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;
import java.util.LinkedList;

import co.aeons.zombie.shooter.entities.bullets.Bullet;
import co.aeons.zombie.shooter.managers.Jukebox;

public class Pistol extends Weapon {

    private static final float RELOAD_TIME = 2.0f;

    public Pistol(float x, float y) {
        super(x, y);
        fireRate = 0.3f;
        texturePath = "weapons/pistol1.png";
        weaponTexture = new Texture(texturePath);
    }

    @Override
    public ArrayList<Bullet> shoot() {
        ArrayList<Bullet> output = new ArrayList<Bullet>();
        if(!isFired){
                output.add(getNewBullet());
                isFired = true;
                playSound();
                fireRate = 0.3f;
        }
        return output;
    }

    @Override
    public void playSound() {
        Jukebox.play("pom");
    }

    @Override
    public Bullet getNewBullet() {
       return new Bullet(this.x, this.y);
    }

}
