/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.modul05;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;


/**
 *
 * @author melam
 */
public class Tugas {
     public static void main(String[]args){
        SwingUtilities.invokeLater(new Runnable(){ 
            public void run(){
                JFrame frame = new JFrame("Contoh BorderLayout");
                frame.setSize(400,300);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                frame.setLayout(new BorderLayout());
                
                JLabel label = new JLabel("Label ada di Atas (NORTH)");
                 JButton buttonNorth = new JButton("north");
                JButton buttonSouth = new JButton("Tombol ada di Bawah (SOUTH)");
                 JButton buttonWest = new JButton("west");
                  JButton buttonEast = new JButton("east");
                   JButton buttonCenter = new JButton("center");
                buttonSouth.addActionListener(e ->{
                    label.setText("Tombol di south berhasil diklik!");
                    
                });
                buttonWest.addActionListener(e ->{
                    label.setText("Tombol di west berhasil diklik!");
                    
                });
                buttonEast.addActionListener(e ->{
                    label.setText("Tombol di East berhasil diklik!");
                    
                });
                buttonCenter.addActionListener(e ->{
                    label.setText("Tombol di center berhasil diklik!");
                    
                });
                    frame.add(label, BorderLayout.NORTH);
                    frame.add(buttonSouth, BorderLayout.SOUTH);
                    frame.add(buttonWest, BorderLayout.WEST);
                    frame.add(buttonEast, BorderLayout.EAST);
                    frame.add(buttonCenter, BorderLayout.CENTER);
                    
//                    frame.add(new JButton("WEST"), BorderLayout.WEST);
//                    frame.add(new JButton("EAST"), BorderLayout.EAST);
//                    frame.add(new JButton("CENTER"), BorderLayout.CENTER);
//                    
                    frame.setVisible(true);    
            }
        });
    }
}
