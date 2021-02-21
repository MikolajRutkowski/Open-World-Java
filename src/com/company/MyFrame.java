package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.company.Animals.Fox;
import com.company.Animals.Wolf;
import com.company.Animals.Sheep;
import com.company.Animals.Bird;
import com.company.Plants.Toadstool;
import com.company.Plants.Grass;

public  class MyFrame extends JFrame implements ActionListener {
    Organism tablica_of_life_form[] = new Organism[200];
    Organism tablica_towrzenia[] = new Organism[6];
    int c_of_life ;
    MyPanel cotrol_panel;
    JButton new_game, move;
    int move_conter;
    int max;
    public MyFrame() {
        super("Mtrix by Mikolaj Rutkowski 175534");
        c_of_life = 0 ;
        move_conter = 0;

        setLocation(150,100);
        cotrol_panel= new MyPanel();
        setLayout(new FlowLayout());
        add(cotrol_panel);
        max = cotrol_panel.get_World_size();


        new_game = new JButton("Nowa gra");
        move = new JButton("Nastepny ruch");

        add(new_game);
        add(move);


        new_game.addActionListener(this);
        move.addActionListener(this);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        {
        tablica_towrzenia[0] = new Grass(0,0);
        tablica_towrzenia[1] = new Toadstool(0,0);
        tablica_towrzenia[2] = new Wolf(0,0);
        tablica_towrzenia[3] = new Sheep(0,0);
        tablica_towrzenia[4] = new Fox(0,0);
        tablica_towrzenia[5] = new Bird(0,0);}
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object sorce = e.getSource();
        if(sorce== move) {
            if (move_conter >= c_of_life) {
                move_conter = 0;
                number_by_iniciative();
            }
            System.out.println(move_conter);
            int oldx = tablica_of_life_form[move_conter].getX();
            int oldy = tablica_of_life_form[move_conter].getY();

            if (tablica_of_life_form[move_conter].getInitiative() >  0) {
            //for animals
            cotrol_panel.make_clean(oldx, oldy);
            tablica_of_life_form[move_conter].move(max);
            //normal move
            if (cotrol_panel.color_st(tablica_of_life_form[move_conter].getX(), tablica_of_life_form[move_conter].getY(), tablica_of_life_form[move_conter].getColor())) {
            }
            //colision
            else {
                int who = find_colison_one(tablica_of_life_form[move_conter].getX(), tablica_of_life_form[move_conter].getY(), move_conter);
                if(tablica_of_life_form[move_conter].getColor() == tablica_of_life_form[who].getColor()){
                    tablica_of_life_form[move_conter].move(oldx,oldy);
                    cotrol_panel.color_st(tablica_of_life_form[move_conter].getX(), tablica_of_life_form[move_conter].getY(), tablica_of_life_form[move_conter].getColor());
                    add_children(tablica_of_life_form[move_conter]);

                }else {
                    boolean wynik = tablica_of_life_form[move_conter].colision(tablica_of_life_form[who]);
                    if(wynik == false && tablica_of_life_form[move_conter].allive == true){
                        tablica_of_life_form[move_conter].move(oldx,oldy);
                        cotrol_panel.color_st(tablica_of_life_form[move_conter].getX(), tablica_of_life_form[move_conter].getY(), tablica_of_life_form[move_conter].getColor());
                        move_conter++;
                        cotrol_panel.repaint();
                    }else{
                    if (wynik) {
                        int xx =tablica_of_life_form[move_conter].getX();
                        int yy = tablica_of_life_form[move_conter].getY();
                        Color c = tablica_of_life_form[move_conter].getColor();

                        deatch(who);
                        cotrol_panel.color_st(xx,yy ,c );
                        move_conter++;
                    } else {
                        deatch(move_conter);

                    }
                    }
                }

            }
                move_conter++;
        }   else {
                //for plants
                int t = move_conter;
                int maxx = c_of_life;
           for (int i = t; i < maxx; i++){
                if(tablica_of_life_form[move_conter].growth(max)){

                 boolean is_empty = cotrol_panel.color_st(tablica_of_life_form[move_conter].getX(),tablica_of_life_form[move_conter].getY(),tablica_of_life_form[move_conter].getColor());
                 if(is_empty){
                     cotrol_panel.make_clean(oldx,oldy);
                     add_new_organism(tablica_of_life_form[move_conter],oldx,oldy);

                 }
                 else {
                     tablica_of_life_form[move_conter].move(oldx,oldy);
                 }
             }
             else{
                 //nic sie nie dzije, roslina sie nie rozrasta
             }

                move_conter++;
            }
           move_conter = 0;
            }

            cotrol_panel.repaint();
        }
        if(sorce==new_game){
            cotrol_panel.make_clean();
            for (int i = 0 ; i<max; i++){
                tablica_of_life_form[i] = null;
            }
            c_of_life =  0;
            /**/
            add_new_organism(new Sheep(2,2));
            add_new_organism(new Wolf(1,1));
            add_new_organism(new Wolf(2,1));
            add_new_organism(new Wolf(1,3));
            add_new_organism(new Wolf(2,3));
            add_new_organism(new Wolf(max-1,max-1));
            add_new_organism(new Fox(10,2));
            add_new_organism(new Fox(10,3));


            add_new_organism(new Bird(max));
            add_new_organism(new Bird(max));
            add_new_organism(new Grass(max));
            add_new_organism(new Toadstool(max));
            add_new_organism(new Toadstool(max));
            add_new_organism(new Grass(max));
            add_new_organism(new Grass(max));

            number_by_iniciative();
        }

    }
        public void add_new_organism(Organism organism){

        tablica_of_life_form[c_of_life] = organism;
        if(cotrol_panel.color_st(tablica_of_life_form[c_of_life].getX(),tablica_of_life_form[c_of_life].getY(),tablica_of_life_form[c_of_life].getColor())){
            c_of_life++;
        }
        else {tablica_of_life_form[c_of_life] = null;
            System.out.println("NIE MOGOE TU NIC STWORZYC");}


    }

        public void add_new_organism(Organism organism,int x,int y){
        for (int i = 0; i < 6; i++){
            if(organism.getColor() == tablica_towrzenia[i].getColor()){
                tablica_of_life_form[c_of_life] = tablica_towrzenia[i];
                tablica_of_life_form[c_of_life].move(x,y);
                cotrol_panel.color_st(tablica_of_life_form[c_of_life].getX(),tablica_of_life_form[c_of_life].getY(),tablica_of_life_form[c_of_life].getColor());
                c_of_life++;

            }
        }

        }
        int find_colison_one(int x, int y, int not_him){
            for (int i = 0 ;i <= c_of_life ; i++){
                if(tablica_of_life_form[i].getX()==x && tablica_of_life_form[i].getY()==y && i != not_him){
                    return i;
                }
            }
            return 0;
        }

        void deatch(int who){
        cotrol_panel.make_clean(tablica_of_life_form[who].getX(),tablica_of_life_form[who].getY());
        tablica_of_life_form[who] = null;
        for (int i = who ; i+1 < c_of_life;i++){
            tablica_of_life_form[i] = tablica_of_life_form[i+1];
        }
        c_of_life--;
        }

        void number_by_iniciative(){
        for (int i = 0 ; i<c_of_life; i++){
            for (int j = 0 ; j<c_of_life -1; j++){
                if(tablica_of_life_form[j].getInitiative() < tablica_of_life_form[j+1].getInitiative()){
                    Organism k = tablica_of_life_form[j];
                    tablica_of_life_form[j] = tablica_of_life_form[j+1];
                    tablica_of_life_form[j+1] = k;
                }
            }
        }
        }

        void add_children(Organism parent){
        int x = parent.getX();
        int y= parent.getY();
            x--;
            y--;
            if(x < 0){
                x=max-1;
            }
            if(y < 0){
                y=max-1;
            }
            boolean przerwa = false;
            for (int i = 0;i<3;i++){
                x = parent.getX();

                x--;

                if(x < 0){
                    x=max-1;
                }
               if(przerwa){break;}
                for (int j = 0;j<3;j++){
                    x = x +j;
                    y = y+i;
                    if(x>= max){
                        x=0;
                    }
                    if(y>= max){
                        y=0;
                    }
                    if(cotrol_panel.is_free(x,y)){
                        przerwa = true;
                        break;
                    }

                }
            }
            if(przerwa){
                    System.out.print("Oto nowe zwierze na polu:");
                System.out.print(x);
                System.out.print(" ");
                System.out.println(y);
                add_new_organism(parent,x,y);
                cotrol_panel.repaint();
            }


        }
}