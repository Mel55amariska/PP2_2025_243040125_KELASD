/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.modul05;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author melam
 */
public class Latihan3 {
    public static void main(String[] args){
        // menjalankan kode GUI di event Dispatch Thread (EDT)
        // Ini adalah praktik terbaik untuk menghindari masalah thread
        // Akan dijelaskan lebih detail nan
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                JFrame frame = new JFrame ("Label dan Tombol") ;
                frame.setSize(400, 300);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                frame.setLayout(new FlowLayout());
                
                JLabel label = new JLabel("Teks Awal");
                JButton button = new JButton("Klik Saya");
                
                // 3. Atur aksi saat tombol close (x) ditekan
                
                button.addActionListener(e -> {
                   label.setText("Tombol berhasil diklik!");
                });
                
                frame.add(label);
                frame.add(button);
                // 4. Buat jendela terlihat
                frame.setVisible(true);
            }
        });
    }
}
