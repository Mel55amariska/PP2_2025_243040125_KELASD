/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.modul05;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;



/**
 *
 * @author melam
 */
public class Latihan2 {
    public static void main(String[] args){
        // menjalankan kode GUI di event Dispatch Thread (EDT)
        // Ini adalah praktik terbaik untuk menghindari masalah thread
        // Akan dijelaskan lebih detail nan
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                // 1. buat objek JFrame
                JFrame frame = new JFrame ("Jendela dengan Label") ;
                frame.setSize(400, 300);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                JLabel label = new JLabel("Ini adalah JLabel.");
                
                // 3. Atur aksi saat tombol close (x) ditekan
                
                frame.add(label);
                // 4. Buat jendela terlihat
                frame.setVisible(true);
            }
        });
    }
}
