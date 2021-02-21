package com.company.Animals;

import com.company.Organism;

import java.awt.*;
import java.util.Random;

public class Animal extends Organism {


    public Animal(int size) {
        super(size);
        this.color = new Color(139,69,19);

        strength = 1;
        initiative = 1;
    }
        public Animal(int x, int y){
            super(x, y);

            strength = 1;
            initiative = 1;
        }



        @Override
        public boolean colision(Organism organism){
        System.out.println("Kolizja na polu");
        System.out.println(getX() );
        System.out.println(getY() );
        System.out.println("Siła 1 : ");
        System.out.println(getStrength());
            System.out.println("Siła 2 : ");
            System.out.println(organism.getStrength());


           if(organism.getStrength() > getStrength()){
               allive = false;
               return false;
           }
        return true;

        }
    }

