package com.company.Animals;

import java.awt.*;

public class Wolf extends Animal {
    public Wolf(int size) {
        super(size);
        this.color = Color.darkGray;

        strength = 9;
        initiative = 5;
    }
    public  Wolf(int x, int y){
        super(x, y);
        this.color = Color.darkGray;

        strength = 9;
        initiative = 5;
    }
}
