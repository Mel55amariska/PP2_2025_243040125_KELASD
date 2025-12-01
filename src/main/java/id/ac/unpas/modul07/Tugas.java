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
public class Tugas extends JFrame {
    private JTextField txtNama;
    private JTextField txtNilai;
    private JComboBox<String> cmbMatkul;
    private JTable tableData;
    private DefaultTableModel tableModel;
    private JTabbedPane tabbedPane;

    private JPanel createInputPanel() {
        // Menggunakan GridLayout 4 baris, 2 kolom untuk label dan input
        // Baris 1: Nama Siswa
        // Baris 2: Mata Pelajaran
        // Baris 3: Nilai
        // Baris 4: Tombol Simpan/Reset
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // --- Baris 1: Nama Siswa ---
        panel.add(new JLabel("Nama Siswa:"));
        txtNama = new JTextField();
        panel.add(txtNama);
        
        // --- Baris 2: Mata Pelajaran (KOMPONEN HILANG, KINI DITAMBAHKAN) ---
        panel.add(new JLabel("Mata Pelajaran:"));
        String[] matkul = {"Matematika Dasar", "Bahasa Indonesia",
            "Algoritma dan Pemrograman I", "Praktikum Pemrograman II"};
        cmbMatkul = new JComboBox<>(matkul); // Inisialisasi cmbMatkul
        panel.add(cmbMatkul);

        // --- Baris 3: Nilai ---
        panel.add(new JLabel("Nilai (0-100):"));
        txtNilai = new JTextField();
        panel.add(txtNilai);

        // --- Baris 4: Tombol ---
        JButton btnReset = new JButton("Reset Data");
        JButton btnSimpan = new JButton("Simpan Data");

        // Menggunakan FlowLayout.RIGHT agar tombol sejajar dengan input
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(btnReset);
        buttonPanel.add(btnSimpan);

        panel.add(new JLabel("")); // Placeholder di kolom 1 baris 4
        panel.add(buttonPanel);    // ButtonPanel di kolom 2 baris 4

        // Event Handling Tombol Simpan
        btnSimpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prosesSimpan();
            }
        });

        // Event Handling Tombol Reset
        btnReset.addActionListener(e -> {
            txtNama.setText("");
            txtNilai.setText("");
            cmbMatkul.setSelectedIndex(0);
        });
        
        return panel;
    }
    
    // **METHOD createTablePanel() 
    private JPanel createTablePanel() {
        JPanel panel = new JPanel(new BorderLayout());

        // Setup Model Tabel (Kolom)
        String[] kolom = {"Nama Siswa", "Mata Pelajaran", "Nilai", "Grade"};
        tableModel = new DefaultTableModel(kolom, 0);
        tableData = new JTable(tableModel);

        // Membungkus tabel dengan ScrollPane
        JScrollPane scrollPane = new JScrollPane(tableData);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Tombol Hapus 
        JButton btnHapus = new JButton("Hapus Data");

        // Panel untuk menampung tombol Hapus, diletakkan di SOUTH
        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        southPanel.add(btnHapus);
        panel.add(southPanel, BorderLayout.SOUTH);

        // Event Handling Tombol Hapus 
        btnHapus.addActionListener(e -> {
            int selectedRow = tableData.getSelectedRow();

            if (selectedRow >= 0) { 
                // Hapus baris dari model tabel
                tableModel.removeRow(selectedRow);
                JOptionPane.showMessageDialog(this, "Data berhasil dihapus.",
                        "Informasi", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Pilih baris yang akan dihapus.",
                        "Peringatan", JOptionPane.WARNING_MESSAGE);
            }
        });

        return panel;
    }

    // logika validasi dan penyimpanan data
    private void prosesSimpan() {
        String nama = txtNama.getText();
        String matkul = (String) cmbMatkul.getSelectedItem();
        String strNilai = txtNilai.getText();

        // 2. VALIDASI INPUT
        if (nama.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama tidak boleh kosong!",
                    "Error Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validasi minimal 3 karakter
        if (nama.trim().length() < 3) {
            JOptionPane.showMessageDialog(this, "Nama minimal terdiri dari 3 karakter!",
                    "Error Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int nilai;
        try {
            nilai = Integer.parseInt(strNilai);
            if (nilai < 0 || nilai > 100) {
                JOptionPane.showMessageDialog(this, "Nilai harus antara 0 - 100!",
                        "Error Validasi", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Nilai harus berupa angka!",
                    "Error Validasi", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 3. PENENTUAN GRADE
        String grade;
        int nilaiDiskrit = nilai / 10;

        switch (nilaiDiskrit) {
            case 10:
            case 9:
            case 8:
                grade = "A";
                break;
            case 7:
                grade = "AB";
                break;
            case 6:
                grade = "B";
                break;
            case 5:
                grade = "BC";
                break;
            case 4:
                grade = "C";
                break;
            case 3:
                grade = "D";
                break;
            default: // 0 sampai 29
                grade = "E";
                break;
        }

        // 4. SIMPAN DATA
        Object[] dataBaris = {nama, matkul, nilai, grade};
        tableModel.addRow(dataBaris);

        // Reset input fields
        txtNama.setText("");
        txtNilai.setText("");
        cmbMatkul.setSelectedIndex(0);

        JOptionPane.showMessageDialog(this, "Data Berhasil Disimpan!");
        // Pindah ke tab "Daftar Nilai"
        tabbedPane.setSelectedIndex(1);
    }

    public Tugas() {
        setTitle("Aplikasi Manajemen Nilai Siswa");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        tabbedPane = new JTabbedPane();

        JPanel panelInput = createInputPanel();
        tabbedPane.addTab("Input Data", panelInput);

        JPanel panelTabel = createTablePanel();
        tabbedPane.addTab("Daftar Nilai", panelTabel);

        add(tabbedPane);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Tugas().setVisible(true);
        });
    }

}