package com.company.Plants;

import com.company.Organism;

import java.awt.*;
import java.util.Random;

public class Plant extends Organism {
    protected int chanse_to_growth;
    public Plant(int size) {
        super(size);
        this.color = Color.GREEN;
        this.strength= 0;
        this.initiative = 0;
        this.chanse_to_growth = 1;
    }

    public Plant(int x, int y) {
        super(x, y);
        this.color = Color.GREEN;
        this.strength= 0;
        this.initiative = 0;
        this.chanse_to_growth = 1;
    }
    @Override
    public boolean growth(int size){
        Random r = new Random();
        int chanse = r.nextInt(10);

        if(chanse < chanse_to_growth){
            move(size);
            return  true;
        }
        return false;
    }
}
