package com.company.Plants;

import java.awt.*;
import java.util.Random;

public class Toadstool extends Plant {
    public Toadstool(int size) {
        super(size);
        this.color = new Color(200,0,0);
        this.chanse_to_growth = 3;
        this.strength = 2;
    }

    public Toadstool(int x, int y) {
        super(x, y);
        this.color = new Color(200,0,0);
        this.chanse_to_growth = 3;
        this.strength = 2;
    }
    @Override
    public boolean growth(int size){
        Random r = new Random();
        int chanse = r.nextInt(10);

        if(chanse < chanse_to_growth){
            increase_Strech(2);
            move(size);
            return  true;
        }
        return false;
    }
}
