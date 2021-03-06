package TEDUpolly;

import javax.swing.*;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author La Petit Project Team
 */
public class WhichPlayerStart extends JFrame {

    /**
     * Creates new form WhichPlayerStart
     */
    DefaultListModel <String> alan= new DefaultListModel();
    ArrayList<String> playerList = new ArrayList<String>();
    public boolean player1Start=false;
    ArrayList <Integer> faceValues= new ArrayList<>();
    
    
    public WhichPlayerStart() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new JPanel();
        Dice = new JButton();
        jLabel1 = new JLabel();
        player_name = new JLabel();
        startGame = new JButton();
        whichPlayer = new JTextField();
        jScrollPane1 = new JScrollPane();
        informationText = new JTextPane();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 42, 165));

        Dice.setText("Dice");
        Dice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DiceActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Player:");

        startGame.setText("Start Game");
        startGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startGameActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(informationText);

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(206, 206, 206)
                                .addComponent(Dice, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(startGame)
                                .addContainerGap(105, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(player_name, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(whichPlayer, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(65, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(player_name, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(whichPlayer, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(startGame, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Dice, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
                                .addGap(60, 60, 60))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    private void DiceActionPerformed(java.awt.event.ActionEvent evt) {
        //Dice
    	TEDUpolly.Dice newDice= new Dice(10,10,10,10);
    	TEDUpolly.Dice newDice2=new Dice(10,10,10,10);
        newDice.ZarAt();//Player1's Dice
        newDice2.ZarAt();//Player2's Dice
        if(faceValues.size() == 0 ){
            int faceValueOf1= newDice.getZarSonucu();
            informationText.setText("The dice that the player "+ Giris.player1+" rolls:"+faceValueOf1);
            faceValues.add(faceValueOf1);

        }
        else {
            int faceValueOf2= newDice2.getZarSonucu();
            informationText.setText("The dice that the player "+Giris.player1 +" rolls:"+faceValues.get(0)+"\n"+"The dice that the player "+Giris.player2+" rolls:"+faceValueOf2);
            alan.addElement("Dice Rolled.");
            if(faceValues.get(0)>faceValueOf2){
                whichPlayer.setText(Giris.player1+" will start.");
                player1Start=true;
                startGame.setEnabled(true);
                Dice.setEnabled(false);
            }else if (faceValues.get(0)<faceValueOf2){
                whichPlayer.setText(Giris.player2+" will start.");

                startGame.setEnabled(true);
                Dice.setEnabled(false);
            }else {
                alan.removeAllElements();
                whichPlayer.setText("The dice rolled evenly. Roll the dice again.");
                faceValues.clear();
            }
        }





    }

    private void startGameActionPerformed(java.awt.event.ActionEvent evt) {
        // Start Game
        if(alan.size()==0){
            JOptionPane.showMessageDialog(null,"Please roll dice first.");
        }else {
            if(player1Start==false){
                playerList.add(Giris.player2);
                playerList.add(Giris.player1);
                Giris.player1=playerList.get(0);
                Giris.player2=playerList.get(1);
                dispose();
                new MonopolyMainTEDUpolly().setVisible(true);
            }else {  dispose();
                new MonopolyMainTEDUpolly().setVisible(true);

            }
        }


    }

    /**
     * @param args the command line arguments
     */


    public static String player1;
    public static String player2;
    // Variables declaration - do not modify
    private JButton Dice;
    private JTextPane informationText;
    private JLabel jLabel1;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JLabel player_name;
    private JButton startGame;
    private JTextField whichPlayer;
    // End of variables declaration
}
