package com.example.dungeoncrawler;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import com.example.dungeoncrawler.models.Player;
import com.example.dungeoncrawler.viewmodels.MoveDown;
import com.example.dungeoncrawler.viewmodels.MoveLeft;
import com.example.dungeoncrawler.viewmodels.MoveRight;
import com.example.dungeoncrawler.viewmodels.MoveUp;
import com.example.dungeoncrawler.viewmodels.Observer;
import com.example.dungeoncrawler.viewmodels.OverarchingViewmodel;

public class Sprint3Tests implements Observer {

    private int observe;

    @Before
    public void setup() {
        new OverarchingViewmodel();
        observe = 0;
    }

    @Test //Sneha Test Sprint 3
    public void checkDifficultyHard() {
        Player newPlayer = Player.getPlayer();
        newPlayer.setDifficulty(3);
        assertEquals(3, newPlayer.getDifficulty());
    }
    @Test //Sneha Test Sprint 3
    public void checkDefaultName() {
        Player newPlayer = Player.getPlayer();
        assertEquals("Name should be null", null, newPlayer.getName());
    }

    @Test // Cole Test Sprint 3
    public void moveOutOfBoundsLeftRight() {
        new OverarchingViewmodel();
        OverarchingViewmodel.setPlayerX(0);
        MoveLeft moveLeft = new MoveLeft();
        OverarchingViewmodel.setMovementStrategy(moveLeft);
        OverarchingViewmodel.move(10);
        assertEquals(0, OverarchingViewmodel.getPlayerX());

        OverarchingViewmodel.setPlayerX(20000);
        MoveRight moveRight = new MoveRight();
        OverarchingViewmodel.setMovementStrategy(moveRight);
        OverarchingViewmodel.move(10);
        assertEquals(20000, OverarchingViewmodel.getPlayerX());
    }
    @Test // Cole Test Sprint 3
    public void moveOutOfBoundsUpDown() {
        OverarchingViewmodel.setPlayerY(30000);
        MoveDown moveDown = new MoveDown();
        OverarchingViewmodel.setMovementStrategy(moveDown);
        OverarchingViewmodel.move(10);
        assertEquals(30000, OverarchingViewmodel.getPlayerY());

        OverarchingViewmodel.setPlayerY(20);
        MoveUp moveUp = new MoveUp();
        OverarchingViewmodel.setMovementStrategy(moveUp);
        OverarchingViewmodel.move(10);
        assertEquals(20, OverarchingViewmodel.getPlayerY());
    }

    @Test // Emmaly Test Sprint 3
    public void checkHealthHard() {
        Player newPlayer = Player.getPlayer();
        newPlayer.setHealth(50);
        assertEquals(50, newPlayer.getHealth());
    }

    @Test // Emmaly Test Sprint 3
    public void checkSprite() {
        Player newPlayer = Player.getPlayer();
        newPlayer.setSprite(250);
        assertEquals(250, newPlayer.getSprite());
    }

    @Test // Parul Test Sprint 3
    public void observerCheckX() {
        OverarchingViewmodel.setObserver(this);
        int count = observe;
        OverarchingViewmodel.setPlayerX(10);
        assertEquals(count + 1, observe);
    }
    @Test // Parul Test Sprint 3
    public void observerCheckY() {
        OverarchingViewmodel.setObserver(this);
        int count = observe;
        OverarchingViewmodel.setPlayerY(10);
        assertEquals(count + 1, observe);
    }

    @Test // Tanavi Test Sprint 3
    public void movementClassLeftRight() {
        OverarchingViewmodel.setPlayerX(900);
        MoveRight moveRight = new MoveRight();
        OverarchingViewmodel.setMovementStrategy(moveRight);
        OverarchingViewmodel.move(10);
        assertEquals(910, OverarchingViewmodel.getPlayerX());

        MoveLeft moveLeft = new MoveLeft();
        OverarchingViewmodel.setMovementStrategy(moveLeft);
        OverarchingViewmodel.move(10);


        assertEquals(900, OverarchingViewmodel.getPlayerX());
    }
    @Test // Tanavi Test Sprint 3
    public void movementClassUpDown() {
        OverarchingViewmodel.setPlayerY(320);
        MoveDown moveDown = new MoveDown();
        OverarchingViewmodel.setMovementStrategy(moveDown);
        OverarchingViewmodel.move(10);
        assertEquals(330, OverarchingViewmodel.getPlayerY());

        MoveUp moveUp = new MoveUp();
        OverarchingViewmodel.setMovementStrategy(moveUp);
        OverarchingViewmodel.move(10);
        assertEquals(320, OverarchingViewmodel.getPlayerY());
    }


    @Override
    public void update() {
        observe += 1;
    }
}
