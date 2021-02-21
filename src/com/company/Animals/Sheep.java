package com.company.Animals;

import java.awt.*;

public class Sheep extends Animal {

    public Sheep(int size){
        super(size);
        this.color = Color.WHITE;
        this.strength = 4;
        this.initiative = 4;
    }
    public Sheep(int x,int y){
        super(x,y);
        this.color = Color.WHITE;
        this.strength = 4;
        this.initiative = 4;
    }
}
