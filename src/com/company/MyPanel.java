package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.geom.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MyPanel extends JPanel {
    Rectangle2D[][] tab = new Rectangle2D[20][20];
    int max = 20;
    Color[][] colors_tab = new Color[20][20];
    Color base = Color.GRAY;

    public MyPanel() {

        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(500,500));//wielkośc w którym rysujemy okna

      start();

    }





    void start(){
        for (int i = 0 ; i < 20 ; i++){
            for (int x = 0 ; x < 20 ; x++ ){
                tab[x][i] = new Rectangle2D.Double(x*20,i*20,20,20);
                colors_tab[x][i] = base ;
            }
        }
    }

    boolean color_st(int x,int y,Color color){
        if(colors_tab[x][y] == base ){
        colors_tab[x][y] = color;
        repaint();
        return  true;}
        return  false;

    }
    void make_clean(){
        for (int i = 0 ;i<max ;i++){
            for (int j = 0 ;j<max ;j++){
            colors_tab[i][j] = Color.GRAY;
            }
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for (int y = 0 ; y < max ; y++){
            for (int x = 0 ; x < max ; x++ ){
                g2d.setColor(colors_tab[x][y]);
                g2d.fill(tab[x][y]);
                g2d.setColor(Color.BLACK);
                g2d.draw(tab[x][y]);

            }
        }

    }
    int get_World_size(){
        return  max;
    }

    void make_clean(int x,int y){
        colors_tab[x][y] = base;
    }
    boolean is_free(int x, int y ){
        if(colors_tab[x][y]== base){
            return  true;
        }
        return false;
    }
}
