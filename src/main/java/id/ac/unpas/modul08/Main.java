/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.modul08;

import id.ac.unpas.modul08.controller.PersegiPanjangController;
import id.ac.unpas.modul08.model.PersegiPanjangModel;
import id.ac.unpas.modul08.view.PersegiPanjangView;

/**
 *
 * @author melam
 */
public class Main {
    public static void main(String[] args) {
        
        PersegiPanjangModel model = new PersegiPanjangModel();
        
        PersegiPanjangView view = new PersegiPanjangView();
        
        PersegiPanjangController controller = new PersegiPanjangController(model, view);
        
        view.setVisible(true);
    }
}
