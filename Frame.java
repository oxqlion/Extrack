/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alp_oop_try1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.border.Border;

public class Frame extends JFrame {

    public void frame(int saldo) {
        JLabel label = new JLabel("Total Saldo Anda : " + saldo);
        label.setBounds(25, 25, 200, 25);

        setLayout(null);
        add(label);

        setTitle("Extrack");
        setSize(1000, 500);
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void createButton(String text, int space) {
        JButton walletButton = new JButton(text);
        walletButton.setBounds(25, space, 100, 25);

        walletButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameHistory();
            }
        });

        add(walletButton);
        setVisible(true);
    }

    public void frameHistory() {
        JInternalFrame historyFrame = new JInternalFrame(("History Keuangan"), true, true, true, true); //true" utk tombol close dll di bagian atas

        historyFrame.setVisible(true);
        historyFrame.setSize(700, 500);
        add(historyFrame);
        historyFrame.moveToFront();
    }

    public void addGreenColumn(int space) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date = new Date();

        JLabel label = new JLabel(dateFormat.format(date));

        label.setBounds(230, space, 300, 25);
        Border border = BorderFactory.createLineBorder(Color.green.darker(), 1);
        label.setBorder(border);
        label.setOpaque(true);
        label.setBackground(Color.white);

        add(label);
    }

    public void addRedColumn(int space) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date = new Date();

        JLabel label = new JLabel(dateFormat.format(date));
        label.setBounds(230, space, 300, 25);
        Border border = BorderFactory.createLineBorder(Color.red.darker(), 1);
        label.setBorder(border);
        label.setOpaque(true);
        label.setBackground(Color.white);

        add(label);
    }

    public void inputUser(int space) {
        JTextField tf = new JTextField();
        tf.setBounds(230, space, 200, 25);

        Border raisedbevel, loweredbevel;
        raisedbevel = BorderFactory.createRaisedBevelBorder();
        loweredbevel = BorderFactory.createLoweredBevelBorder();

        Border compound;
        compound = BorderFactory.createCompoundBorder(raisedbevel, loweredbevel);
        tf.setBorder(compound);

        add(tf);
    }
    
    public void plusButton(int space){
        JButton walletButton = new JButton("Pemasukan");
        walletButton.setBounds(230, space, 130, 25);
        walletButton.setBackground(Color.green.brighter());
        
        walletButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //tambah data
            }
        });

        add(walletButton);
        setVisible(true);
    }
    
    public void minButton(int space){
        JButton walletButton = new JButton("Pengeluaran");
        walletButton.setBounds(370, space, 130, 25);
        walletButton.setBackground(Color.red.brighter());
        
        walletButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //tambah data
            }
        });

        add(walletButton);
        setVisible(true);
    }

}
