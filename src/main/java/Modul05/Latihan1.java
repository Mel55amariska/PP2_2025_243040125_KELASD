/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modul05;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author melam
 */
public class Latihan1 {
    public static void main(String[] args){
        // menjalankan kode GUI di event Dispatch Thread (EDT)
        // Ini adalah praktik terbaik untuk menghindari masalah thread
        // Akan dijelaskan lebih detail nanti
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                // 1. buat objek JFrame
                JFrame frame = new JFrame ("Jendela Pertamaku") ;
                
                // 2. Atur ukuran jendela (lebar 400, tinggi 300)
                frame.setSize(400, 300);
                
                // 3. Atur aksi saat tombol close (x) ditekan
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                // 4. Buat jendela terlihat
                frame.setVisible(true);
            }
        });
    }
    
}
