package com.company;

import java.awt.*;
import java.util.Random;

public abstract class Organism {

    protected Color color;
    protected int x;
    protected int y;
    protected int strength;
    protected  int initiative;
   protected boolean allive;

    public  Organism(int size){
        Random generator  = new Random();
        int xx = generator.nextInt(size);
        int yy = generator.nextInt(size);
        this.x = xx;
        this.y = yy;
        color = (Color.WHITE);

        strength = 0;
        initiative = 0;
        allive = true;
    }
    public Organism(int x,int y){
        this(1);
        this.x = x;
        this.y = y;

    }



    public int getInitiative() {
        return initiative;
    }

    public int getStrength() {
        return strength;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Color getColor() {
        return color;
    }


    public void move(int size){

        Random r = new Random();
        int oldx = getX();
        int oldy = getY();
        boolean nowy = true;
        int xx = 0;
        int yy= 0 ;
        while(nowy) {
            xx = getX() + r.nextInt(3);
            xx--;
            yy = getY() + r.nextInt(3);
            yy--;
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
        this.x= xx;
        this.y=yy;
    }
    public void move(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void increase_Strech(int h){
        strength = getStrength() + h;
    }
    public boolean colision(Organism organism){
        return  true;
    }
    public boolean Is_allive(){
        return allive;
    }

    public boolean growth(int size){
        return  false;
    }

}
