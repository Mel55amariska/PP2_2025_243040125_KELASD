/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.modul06;

import javax.swing.*;
import java.awt.*;
/**
 *
 * @author melam
 */
public class KalkulatorSederhana {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Kalkulator Sederhana");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,400);
        frame.setLayout(new BorderLayout(10,10));
        
        JTextField display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        frame.add(display, BorderLayout.NORTH);
        
        JPanel panelTombol = new JPanel();
        panelTombol.setLayout(new GridLayout(4, 4, 5,5));
        
        String[] tombol = {
            "7","8","9","/",
            "4","5","6","*",
            "1","2","3","-",
            "0",".","=","+",
        };
        
        for (String text : tombol){
            JButton btn = new JButton(text);
            btn.setFont(new Font("Arial", Font.PLAIN, 18));
            panelTombol.add(btn);
        }   
        frame.add(panelTombol, BorderLayout.CENTER);
        frame.setVisible(true);
        }   
}