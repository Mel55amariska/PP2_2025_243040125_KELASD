/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.modul08.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author melam
 */
public class PersegiPanjangView extends JFrame {
   private JTextField txtPanjang = new JTextField(10);
   private JTextField txtLebar = new JTextField(10);
   private JLabel lblHasilLuas = new JLabel("-");
   private JLabel lblHasilKeliling = new JLabel("-");
   private JButton btnHitung = new JButton("Hitung Luas");
   private JButton btnReset = new JButton("Reset");
   
   public PersegiPanjangView() {
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setSize(300, 300);
       this.setLayout(new GridLayout(5, 2, 10,10));
       this.setTitle("MVC Kalkulator");
       
       this.add(new JLabel("Panjang"));
       this.add(txtPanjang);
       this.add(new JLabel("Lebar"));
       this.add(txtLebar);
       this.add(new JLabel("Hasil Luas"));
       this.add(lblHasilLuas);
       this.add(new JLabel("Hasil Keliling"));
       this.add(lblHasilKeliling);
       this.add(btnHitung);
       this.add(btnReset);
   }
   
   public double getPanjang() {
       return Double.parseDouble(txtPanjang.getText());
   }
   
   public double getLebar() {
       return Double.parseDouble(txtLebar.getText());
   }
   
   public void setHasilLuas(double hasil) {
       lblHasilLuas.setText(String.valueOf(hasil));
   }
   
   public void setHasilKeliling(double hasil) {
       lblHasilKeliling.setText(String.valueOf(hasil));
   }
   
    public void clearInput() {
        txtPanjang.setText("");
        txtLebar.setText("");
        lblHasilLuas.setText("-");
        lblHasilKeliling.setText("-");
        txtPanjang.requestFocus();
        
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
   public void tampilkanPesanError(String pesan){
       JOptionPane.showMessageDialog(this, pesan);
   }
   
   public void addHitungListener(ActionListener listener){
       btnHitung.addActionListener(listener);
   }
   
   public void addResetListener(ActionListener listener){
       btnReset.addActionListener(listener);
   }
}
