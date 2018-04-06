/*
@aurthor:Prakat Tuladhar
GUI for refrigirator
 */

import State.FreezerState;
import State.FridgeState;
import State.RoomState;
import Threads.FridgeCompressor;
import com.sun.org.apache.xpath.internal.operations.Bool;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.functions.Action;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class GUI extends JFrame {

    private FridgeState fridgeState;
    private JLabel fridgeLightStatus=new JLabel("off");
    private JLabel freezerLightStatus=new JLabel("off");
    private JLabel fridgeStatus=new JLabel("idle");
    private JLabel freezerStatus=new JLabel("idle");
    private JLabel fridgeTempStatus=new JLabel(String.valueOf(RoomState.getInstance().getRoomTemp()));
    private JLabel freezerTempStatus=new JLabel(String.valueOf(RoomState.getInstance().getRoomTemp()));

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

    public GUI(FridgeState fridgeState){
        super("Refrigirator");
        this.fridgeState=fridgeState;

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
        tempPanel.add(new JLabel("Fridge Temp: "));
        tempPanel.add(fridgeTempStatus);
        statusArea.add(tempPanel);

        //freezer grid
        tempPanel=new JPanel(new FlowLayout());
        tempPanel.add(new JLabel("Freezer Temp:"));
        tempPanel.add(freezerTempStatus);
        statusArea.add(tempPanel);

        tempPanel=new JPanel(new FlowLayout());
        tempPanel.add(new JLabel("Fridge Status:"));
        tempPanel.add(fridgeStatus);
        statusArea.add(tempPanel);

        tempPanel=new JPanel(new FlowLayout());
        tempPanel.add(new JLabel("Freezer Status:"));
        tempPanel.add(freezerStatus);
        statusArea.add(tempPanel);

        //init main Frame
        getContentPane().setLayout(new GridLayout(3,1));
        getContentPane().add(settingsArea);
        getContentPane().add(buttonsAndShit);
        getContentPane().add(statusArea);
        initObservers();
        addActionListeners();
        pack();
        setVisible(true);
    }


    //creates observers to do stuff
    private void initObservers() {
        //observer for fridgeLight status
        Observer<? super Boolean> observerFridgeLight = new Observer<Boolean>() {
            @Override
            public void onSubscribe(Disposable disposable) {

            }

            @Override
            public void onNext(Boolean t) {
                System.out.println("From observable"+t);
                if(t)
                    fridgeLightStatus.setText("on");//fires the gui
                else
                    fridgeLightStatus.setText("off");
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {

            }
        };

        //observer for fridgeTemparature
        Observer<? super Integer> observerFridgeTemparature = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable disposable) {

            }

            @Override
            public void onNext(Integer t) {
                System.out.println("From observable temparature"+t);
                fridgeTempStatus.setText(String.valueOf(t));//fires the GUI

            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {

            }
        };

        //subscribing to observables/subject in this case
        fridgeState.getSubjectLight().subscribe(observerFridgeLight);
        fridgeState.getSubjectTemparature().subscribe(observerFridgeTemparature);
    }


    //event listeners
    private void addActionListeners() {
        openFridge.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openFridgeDoor();
            }
        });
        closeFridge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeFridgeDoor();
            }
        });
        fridgeTempButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setFridgeTemparature();
            }
        });

    }

    //helper functions
    private void openFridgeDoor() {
        fridgeState.setLight(true);
    }
    private void closeFridgeDoor(){
        fridgeState.setLight(false);
    }
    private void setFridgeTemparature(){
            fridgeState.getSubjectTemparature().onNext(Integer.valueOf(fridgeTempInput.getText()));
    }


}
