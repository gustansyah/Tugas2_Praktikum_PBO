package com.gustansyah.javaswing;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class HalamanUtama extends JFrame {
     private String username; // Tambahkan variabel username
    private JTextField panjangField;
    private JTextField lebarField;
    private JTextField tinggiField;
    private JLabel luasText;
    private JLabel kelilingText;
    private JLabel volumeText;
    private JLabel luasPermukaanText;

    public HalamanUtama(String username) {
        this.username = username;
        setTitle("Halaman Utama");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 1));
        
        JPanel mPanel = new JPanel();
        
        mPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        mPanel.setLayout(new GridLayout(12, 1,10,10));
        add(mPanel);

        JLabel welcomeLabel = new JLabel("Welcome, Mr./Mrs." + username);
        welcomeLabel.setFont(welcomeLabel.getFont().deriveFont(24.0f));
        mPanel.add(welcomeLabel);
        
        JLabel instructionLabel = new JLabel("Tentukan panjang, lebar, dan tinggi untuk menghitung balok");
        mPanel.add(instructionLabel);
        
        JLabel panjangLabel = new JLabel("Panjang");
        JLabel lebarLabel = new JLabel("Lebar");
        JLabel tinggiLabel = new JLabel("Tinggi");
        panjangField = new JTextField();
        lebarField = new JTextField();
        tinggiField = new JTextField();
        
        JPanel panjangPanel = new JPanel();
        panjangPanel.setLayout(new GridLayout(1,2));
        mPanel.add(panjangPanel);
        
        JPanel lebarPanel = new JPanel();
        lebarPanel.setLayout(new GridLayout(1,2));
        mPanel.add(lebarPanel);
        
        JPanel tinggiPanel = new JPanel();
        tinggiPanel.setLayout(new GridLayout(1,2));
        mPanel.add(tinggiPanel);
        
        panjangPanel.add(panjangLabel);
        panjangPanel.add(panjangField);
        lebarPanel.add(lebarLabel);
        lebarPanel.add(lebarField);
        tinggiPanel.add(tinggiLabel);
        tinggiPanel.add(tinggiField);
        
        JButton hitungButton = new JButton("Hitung");
        JButton resetButton = new JButton("Reset");
        
        hitungButton.addActionListener((ActionEvent e) -> {
            if (validateFields()) {
                hitungHasil();
            } else {
                JOptionPane.showMessageDialog(this, "Panjang, lebar, dan tinggi harus diisi dengan angka!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        resetButton.addActionListener((ActionEvent e) -> {
            resetNilai();
        });
        
        mPanel.add(hitungButton);
        mPanel.add(resetButton);
        
        JLabel hasilLabel = new JLabel("Hasil");
        hasilLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mPanel.add(hasilLabel);
        
        JPanel luasPanel = new JPanel();
        luasPanel.setLayout(new GridLayout(1,2));
        mPanel.add(luasPanel);
        
        JPanel kelilingPanel = new JPanel();
        kelilingPanel.setLayout(new GridLayout(1,2));
        mPanel.add(kelilingPanel);
        
        JPanel volumePanel = new JPanel();
        volumePanel.setLayout(new GridLayout(1,2));
        mPanel.add(volumePanel);
        
        JPanel luasPermukaanPanel = new JPanel();
        luasPermukaanPanel.setLayout(new GridLayout(1,2));
        mPanel.add(luasPermukaanPanel);
        
        JLabel luasLabel = new JLabel("Luas Persegi (Panjang)");
        JLabel kelilingLabel = new JLabel("Keliling Persegi (Panjang)");
        JLabel volumeLabel = new JLabel("Volume Balok");
        JLabel luasPermukaanLabel = new JLabel("Luas Permukaan Balok");
        luasText = new JLabel("0");
        kelilingText = new JLabel("0");
        volumeText = new JLabel("0");
        luasPermukaanText = new JLabel("0");
        
        luasPanel.add(luasLabel);
        luasPanel.add(luasText);
        kelilingPanel.add(kelilingLabel);
        kelilingPanel.add(kelilingText); 
        volumePanel.add(volumeLabel);
        volumePanel.add(volumeText);
        luasPermukaanPanel.add(luasPermukaanLabel);
        luasPermukaanPanel.add(luasPermukaanText);
    }
    
    // validasi field
    private boolean validateFields() {
        try {
            double panjang = Double.parseDouble(panjangField.getText());
            double lebar = Double.parseDouble(lebarField.getText());
            double tinggi = Double.parseDouble(tinggiField.getText());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void hitungHasil() {
        double panjang = Double.parseDouble(panjangField.getText());
        double lebar = Double.parseDouble(lebarField.getText());
        double tinggi = Double.parseDouble(tinggiField.getText());
        
        double luas = panjang * lebar;
        double keliling = 2 * (panjang + lebar);
        double volume = panjang * lebar * tinggi;
        double luasPermukaan = 2 * ((panjang * lebar) + (panjang * tinggi) + (lebar * tinggi));
        
        luasText.setText(Double.toString(luas));
        kelilingText.setText(Double.toString(keliling));
        volumeText.setText(Double.toString(volume));
        luasPermukaanText.setText(Double.toString(luasPermukaan));
    }

    private void resetNilai() {
        panjangField.setText("");
        lebarField.setText("");
        tinggiField.setText("");
        luasText.setText("");
        kelilingText.setText("");
        volumeText.setText("");
        luasPermukaanText.setText("");
    }

   
}