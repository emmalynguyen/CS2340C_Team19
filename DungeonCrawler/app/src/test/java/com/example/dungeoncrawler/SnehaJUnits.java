package com.example.dungeoncrawler;

import static org.junit.Assert.assertEquals;

import org.junit.*;
import org.junit.Test;
import static org.junit.Assert.*;

import com.example.dungeoncrawler.models.Player;

import org.junit.Test;

public class SnehaJUnits {
    @Test
    public void checkName() {
        Player newPlayer = Player.getPlayer();
        newPlayer.setName("Sneha");
        assertEquals("Sneha", newPlayer.getName());
    }



}
