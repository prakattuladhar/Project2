/*
@aurthor:Prakat Tuladhar
GUI for refrigirator
 */

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.text.NumberFormat;
import java.util.Formatter;

public class GUI extends JFrame{

    private JLabel fridgeLightStatus=new JLabel("off");
    private JLabel freezerLightStatus=new JLabel("off");
    private JLabel fridgeStatus=new JLabel("idle");
    private JLabel freezerStatus=new JLabel("idle");
    private JLabel fridgeTempStatus=new JLabel("70");
    private JLabel freezerTempStatus=new JLabel("70");

    private JFormattedTextField roomTempInput=new JFormattedTextField(NumberFormat.getIntegerInstance());
    private JFormattedTextField fridgeTempInput=new JFormattedTextField(NumberFormat.getIntegerInstance());
    private JFormattedTextField freezerTempInput=new JFormattedTextField(NumberFormat.getIntegerInstance());

    private JButton roomTempButton=new JButton("Set Room Temp");
    private JButton fridgeTempButton=new JButton("Set Fridge Temp");
    private JButton freezerTempButton=new JButton("Set Freezer Temp");

    private JButton openFridge=new JButton("Open Fridge Door");
    private JButton closeFridge=new JButton("Close Fridge Door");
    private JButton openFreezer=new JButton("Open Freezer Door");
    private JButton closeFreezer=new JButton("Close Freezer Door");

    public GUI(){
        super("Refrigirator");

        JPanel statusArea=new JPanel(new GridLayout(3,2));
        JPanel buttonsAndShit=new JPanel(new GridLayout(2,2));
        JPanel settingsArea=new JPanel(new GridLayout(3,1));

        JPanel tempPanel=new JPanel(new FlowLayout());
        //init room temp apnel
        tempPanel=new JPanel(new FlowLayout());
        tempPanel.add(new JLabel("Room Temprature"));
        roomTempInput.setColumns(4);
        tempPanel.add(roomTempInput);
        tempPanel.add(roomTempButton);
        settingsArea.add(tempPanel);

        //init fridge temp panel
        tempPanel=new JPanel(new FlowLayout());
        tempPanel.add(new JLabel("Desired Fridge Temparature"));
        fridgeTempInput.setColumns(4);
        tempPanel.add(fridgeTempInput);
        tempPanel.add(fridgeTempButton);
        settingsArea.add(tempPanel);

        //init freezer temp panel
        tempPanel=new JPanel(new FlowLayout());
        tempPanel.add(new JLabel("Desired Freezer Temparature"));
        freezerTempInput.setColumns(4);
        tempPanel.add(freezerTempInput);
        tempPanel.add(freezerTempButton);
        settingsArea.add(tempPanel);

        //init buttons and shit
         buttonsAndShit.add(openFridge);
         buttonsAndShit.add(closeFridge);
         buttonsAndShit.add(openFreezer);
         buttonsAndShit.add(closeFreezer);

         //init status area
        tempPanel=new JPanel(new FlowLayout());
        tempPanel.add(new JLabel("Fridge Light :"));
        tempPanel.add(fridgeLightStatus);
        statusArea.add(tempPanel);

        tempPanel=new JPanel(new FlowLayout());
        tempPanel.add(new JLabel("Freezer Light:"));
        tempPanel.add(freezerLightStatus);
        statusArea.add(tempPanel);

        tempPanel=new JPanel(new FlowLayout());
        tempPanel.add(new JLabel("Fridge Temp"));
        tempPanel.add(fridgeTempStatus);
        statusArea.add(tempPanel);

        //freezer grid
        tempPanel=new JPanel(new FlowLayout());
        tempPanel.add(new JLabel("Freezer Temp :"));
        tempPanel.add(freezerTempStatus);
        statusArea.add(tempPanel);

        tempPanel=new JPanel(new FlowLayout());
        tempPanel.add(new JLabel("Fridge Status :"));
        tempPanel.add(fridgeStatus);
        statusArea.add(tempPanel);

        tempPanel=new JPanel(new FlowLayout());
        tempPanel.add(new JLabel("Freezer Status"));
        tempPanel.add(freezerStatus);
        statusArea.add(tempPanel);

        //init main Frame
        getContentPane().setLayout(new GridLayout(3,1));
        getContentPane().add(settingsArea);
        getContentPane().add(buttonsAndShit);
        getContentPane().add(statusArea);

        pack();
        setVisible(true);
    }
}
