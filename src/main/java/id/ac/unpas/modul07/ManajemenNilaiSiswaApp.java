package id.ac.unpas.modul07;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author melam
 */
public class ManajemenNilaiSiswaApp extends JFrame{
    
    private JTextField txtNama;
    private JTextField txtNilai;
    private JComboBox<String> cmbMatkul;
    private JTable tableData;
    private DefaultTableModel tableModel;
    private JTabbedPane tabbedPane;

private JPanel createInputPanel(){
    // Perbaikan: Menambahkan spasi setelah koma pada GridLayout constructor
    JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10)); // Dihilangkan trailing comma jika ada
    panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    
    panel.add(new JLabel("Nama Siswa:"));
    txtNama = new JTextField();
    panel.add(txtNama);
    
    
    panel.add(new JLabel("Mata Pelajaran:"));
    String[] matkul = {"Matematika Dasar","Bahasa Indonesia",
        "Alogoritma dan Pemrograman I","Praktikum Pemrograman II" };
    cmbMatkul = new JComboBox<>(matkul);
    panel.add(cmbMatkul);
    
    panel.add(new JLabel("Nilai (0-100:"));
    txtNilai = new JTextField();
    panel.add(txtNilai);
    
JButton btnSimpan = new JButton("Simpan Data");
panel.add(new JLabel(""));
panel.add(btnSimpan);

btnSimpan.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent e) {
        prosesSimpan();
    }
});

return panel;
}
private JPanel createTablePanel() {
    // *** BARIS YANG DIPERBAIKI: Menambahkan spasi antara 'new' dan 'JPanel' ***
    JPanel panel = new JPanel(new BorderLayout());
    
    String[] kolom = {"Nama Siswa", "Mata Pelajaran", "Nilai", "Grade"};
    tableModel = new DefaultTableModel(kolom, 0);
    tableData = new JTable(tableModel);
    
    JScrollPane scrollPane = new JScrollPane(tableData);
    panel.add(scrollPane, BorderLayout.CENTER);
    
    return panel;
}

//logika validasi dan penyimpanan data this
private void prosesSimpan(){
    String nama = txtNama.getText();
    String matkul = (String) cmbMatkul.getSelectedItem();
    String strNilai = txtNilai.getText();
    
    if (nama.trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Nama tidak boleh kosong!",
                "Error Validasi",JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    int nilai;
    try{
        nilai = Integer.parseInt(strNilai);
        if (nilai < 0 || nilai > 100){
            JOptionPane.showMessageDialog(this, "Nilai harus antara 0 - 100!",
                    "Error Validasi", JOptionPane.WARNING_MESSAGE);
            return;
        }
    }catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Nilai harus berupa angka!",
                "Error Validasi", JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    String grade;
    if (nilai >= 80) grade="A";
    else if (nilai >= 70) grade="AB";
    else if (nilai >= 60) grade="B";
    else if (nilai >= 50) grade="BC";
    else if (nilai >= 40) grade="C";
    // *** LOGIKA GRADE DIPERBAIKI: Baris ini (nilai >= 70) tidak akan pernah tercapai ***
    // *** karena sudah di-handle oleh 'else if (nilai >= 70) grade="AB";' di atas. ***
    // *** Asumsi: Seharusnya grade D diberikan untuk rentang di bawah 40, di atas 0. ***
    // else if (nilai >= 70) grade="D"; // Baris yang salah di kode asli
    else if (nilai >= 0) grade="D"; // Perbaikan sementara jika D di bawah C
    else grade ="E"; // Nilai di bawah 0 (walaupun sudah dicegah validasi)
    
    // Asumsi perbaikan umum untuk grade D dan E agar urut:
    /*
    String grade;
    if (nilai >= 80) grade="A";
    else if (nilai >= 70) grade="AB";
    else if (nilai >= 60) grade="B";
    else if (nilai >= 50) grade="BC";
    else if (nilai >= 40) grade="C";
    else if (nilai >= 30) grade="D"; // Misalnya 30-39
    else grade ="E"; // Di bawah 30
    */
    
    Object[] dataBaris = {nama, matkul, nilai, grade};
    tableModel.addRow(dataBaris);
    
    txtNama.setText("");
    txtNilai.setText("");
    cmbMatkul.setSelectedIndex(0);
    
    JOptionPane.showMessageDialog(this, "Data Berhasil Disimpan!");
    tabbedPane.setSelectedIndex(1);
}

public ManajemenNilaiSiswaApp() {
    setTitle("Aplikasi Manajemen Nilai Siswa");
    setSize(500,400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    
    tabbedPane = new JTabbedPane();
    
    JPanel panelInput = createInputPanel();
    tabbedPane.addTab("Input Data", panelInput);
    
    JPanel panelTabel = createTablePanel();
    tabbedPane.addTab("Daftar Nilai", panelTabel);
    
    add(tabbedPane);
    }
    
public static void main(String[] args){
    SwingUtilities.invokeLater(() -> {
        new ManajemenNilaiSiswaApp().setVisible(true);
    } );
}
}