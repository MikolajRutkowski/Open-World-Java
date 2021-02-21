package com.company;
import java.awt.EventQueue;
import java.util.Random;
import javax.swing.*;
public class Main {

    public static void main(String[] args) {


       EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

             new MyFrame();
            }

        });

    }
}