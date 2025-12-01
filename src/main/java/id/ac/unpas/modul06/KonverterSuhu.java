/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.modul06;

import javax.swing.*;
import java.awt.*;
import java.awt.FlowLayout;
import java.awt.event.*;
/**
 
 * @author melam
 */
public class KonverterSuhu {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Konverter Suhu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new FlowLayout());
       
        JLabel lblCelcius = new JLabel("Celcius:");
        JTextField txtCelcius = new JTextField(10);
        JButton btnKonversi = new JButton("Konversi");
        JLabel lblFahrenheit = new JLabel("Fahrenheit:");
        JLabel lblHasil = new JLabel("-");

        frame.add(lblCelcius);
        frame.add(txtCelcius);
        frame.add(btnKonversi);
        frame.add(lblFahrenheit);
        frame.add(lblHasil);

        btnKonversi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double celcius = Double.parseDouble(txtCelcius.getText());
                    double fahrenheit = (celcius * 9 / 5) + 32;
                    lblHasil.setText(String.format("%.2f °F", fahrenheit));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Masukkan angka yang valid!",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.setVisible(true);
    }
}
    

