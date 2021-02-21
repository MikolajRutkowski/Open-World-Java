package com.company.Plants;

public class Grass extends Plant {
    public Grass(int size) {
        super(size);
        this.chanse_to_growth = 6;
    }

    public Grass(int x, int y) {
        super(x, y);
        this.chanse_to_growth = 6;
    }
}
