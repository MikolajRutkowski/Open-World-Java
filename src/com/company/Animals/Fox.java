package com.company.Animals;

import com.company.Organism;

import java.awt.*;

public class Fox extends Animal {
    public Fox(int size) {
        super(size);
        this.color = new Color(205,87,0);
        this.strength = 3;
        this.initiative = 7;
    }

    public Fox(int x, int y) {
        super(x, y);
        this.color = new Color(205,87,0);
        this.strength = 3;
        this.initiative = 7;
    }
    @Override
    public boolean colision(Organism organism){
        if(organism.getStrength()> getStrength()){
            return false;
        }
        return  true;
    }
}
