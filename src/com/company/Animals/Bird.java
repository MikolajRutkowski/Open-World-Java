package com.company.Animals;

import java.awt.*;
import java.util.Random;
//Birds can fly on all world
public class Bird extends Animal {
    public Bird(int size) {
        super(size);
        this.color= Color.BLUE;
        strength = 2;
        this.initiative = 10;
    }

    public Bird(int x, int y) {
        super(x, y);
        this.color= Color.BLUE;
        strength = 2;
        this.initiative = 10;
    }
    @Override
    public void move(int size){
        Random r = new Random();
        int oldx = getX();
        int oldy = getY();
        boolean nowy = true;
        int xx = 0;
        int yy= 0 ;
        while(nowy) {
            xx =  r.nextInt(size );

            yy =  r.nextInt(size);

            if (xx >= size) {
                xx = 0;
            }
            if (xx < 0) {
                xx = size - 1;
            }

            if (yy >= size) {
                yy = 0;
            }
            if (yy < 0) {
                yy = size - 1;
            }
            if(xx!= oldx || yy != oldy){
                nowy = false;
            }
        }
        x= xx;
        y=yy;

    }
}
