/**
 * 
 * @author:Prakat Tuladhar
 * @version 0.1
 * 
 * GUI for refrigirator
 */

import context.Common;
import context.FreezerContext;
import context.FridgeContext;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import observable.*;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.NumberFormat;

@SuppressWarnings("restriction")
public class GUI extends JFrame {

    private FridgeContext fridgeContext;
    private FreezerContext freezerContext;

    private JLabel fridgeLightStatus = new JLabel("off");
    private JLabel freezerLightStatus = new JLabel("off");
    private JLabel fridgeStatus = new JLabel("idle");
    private JLabel freezerStatus = new JLabel("idle");
    private JLabel fridgeTempStatus;
    private JLabel freezerTempStatus;

    private JFormattedTextField roomTempInput = new JFormattedTextField(NumberFormat.getIntegerInstance());
    private JFormattedTextField fridgeTempInput = new JFormattedTextField(NumberFormat.getIntegerInstance());
    private JFormattedTextField freezerTempInput = new JFormattedTextField(NumberFormat.getIntegerInstance());

    private JButton roomTempButton = new JButton("Set Room Temp");
    private JButton fridgeTempButton = new JButton("Set Fridge Temp");
    private JButton freezerTempButton = new JButton("Set Freezer Temp");
    private JButton openFridge = new JButton("Open Fridge Door");
    private JButton closeFridge = new JButton("Close Fridge Door");
    private JButton openFreezer = new JButton("Open Freezer Door");
    private JButton closeFreezer = new JButton("Close Freezer Door");


    public GUI() throws IOException{
        super("Refrigirator");
        Common.initialize();
        this.fridgeContext = FridgeContext.instance();
        this.freezerContext = FreezerContext.instance();

        JPanel statusArea = new JPanel(new GridLayout(3,2));
        JPanel buttonPanel = new JPanel(new GridLayout(2,2));
        JPanel settingsArea = new JPanel(new GridLayout(3,1));

        JPanel tempPanel=new JPanel(new FlowLayout());
        //init room temp panel
        tempPanel = new JPanel(new FlowLayout());
        tempPanel.add(new JLabel("Room Temperature"));
        roomTempInput.setColumns(4);
        roomTempInput.setValue( Common.getRoomTemp() );
        tempPanel.add(roomTempInput);
        tempPanel.add(roomTempButton);
        settingsArea.add(tempPanel);

        //init fridge temp panel
        tempPanel = new JPanel(new FlowLayout());
        tempPanel.add(new JLabel("Desired Fridge Temparature"));
        fridgeTempInput.setColumns(4);
        fridgeTempInput.setText( String.valueOf( Common.getFridgeHigh() ) );
        tempPanel.add(fridgeTempInput);
        tempPanel.add(fridgeTempButton);
        settingsArea.add(tempPanel);

        //init freezer temp panel
        tempPanel = new JPanel(new FlowLayout());
        tempPanel.add(new JLabel("Desired Freezer Temparature"));
        freezerTempInput.setColumns(4);
        freezerTempInput.setText( String.valueOf( Common.getFreezerHigh() ) );
        tempPanel.add(freezerTempInput);
        tempPanel.add(freezerTempButton);
        settingsArea.add(tempPanel);

        //init buttons
         buttonPanel.add(openFridge);
         buttonPanel.add(closeFridge);
         buttonPanel.add(openFreezer);
         buttonPanel.add(closeFreezer);

         //init status area
        tempPanel = new JPanel(new FlowLayout());
        tempPanel.add(new JLabel("Fridge Light :"));
        tempPanel.add(fridgeLightStatus);
        statusArea.add(tempPanel);

        tempPanel = new JPanel(new FlowLayout());
        tempPanel.add(new JLabel("Freezer Light:"));
        tempPanel.add(freezerLightStatus);
        statusArea.add(tempPanel);

        tempPanel = new JPanel(new FlowLayout());
        tempPanel.add(new JLabel("Fridge Temp: "));
        fridgeTempStatus = new JLabel( String.valueOf( Common.getRoomTemp() ) );
        tempPanel.add(fridgeTempStatus);
        statusArea.add(tempPanel);

        //freezer grid
        tempPanel = new JPanel(new FlowLayout());
        tempPanel.add(new JLabel("Freezer Temp:"));
        freezerTempStatus = new JLabel( String.valueOf( Common.getRoomTemp() ) );
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
        getContentPane().add(buttonPanel);
        getContentPane().add(statusArea);
        initObservers();
        addActionListeners();
        pack();
        setVisible(true);

    }


    //creates observers to do stuff and fire up GUI
    //changes in the variables in context will fire up the onNext function in these observer.
    private void initObservers() {
        //observer for fridgeLight status
        Observer<? super Boolean> observerFridgeLight = new Observer<Boolean>() {
            @Override
            public void onSubscribe(Disposable disposable) {

            }

            @Override
            public void onNext(Boolean t) {
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
            public void onSubscribe(Disposable disposable){

            }

            @Override
            public void onNext(Integer t) {

                fridgeTempStatus.setText(String.valueOf(t));//fires the GUI

            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {

            }
        };
        //observer for fridge status
        Observer<? super Boolean> observerFridgeStatus = new Observer<Boolean>() {
            @Override
            public void onSubscribe(Disposable disposable) {

            }

            @Override
            public void onNext(Boolean aBoolean) {
                    if(aBoolean){
                        fridgeStatus.setText("Cooling");
                    }else {
                        fridgeStatus.setText("Idle");
                    }
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {

            }
        };
        //---------------------------------------------------------------------------
        //observer for freezerLight
        Observer<? super Boolean> observerFreezerLight = new Observer<Boolean>() {
            @Override
            public void onSubscribe(Disposable disposable) {

            }

            @Override
            public void onNext(Boolean aBoolean) {
                if(aBoolean)
                    freezerLightStatus.setText("on");//fires the gui
                else
                    freezerLightStatus.setText("off");
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {

            }
        };
        //observer for freezerTemparature
        Observer<? super Integer> observerFreezerTemparature = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable disposable) {

            }

            @Override
            public void onNext(Integer integer) {
               freezerTempStatus.setText(String.valueOf(integer));
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {

            }
        };
        //observer for freezerStatus
        Observer<? super Boolean> observerFreezerStatus = new Observer<Boolean>() {
            @Override
            public void onSubscribe(Disposable disposable) {

            }

            @Override
            public void onNext(Boolean aBoolean) {
                if(aBoolean){
                   freezerStatus.setText("Cooling");
                }else {
                    freezerStatus.setText("Idle");
                }
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {

            }
        };

        //subscribing to observables/subject in this case
        fridgeContext.getSubjectLight().subscribe(observerFridgeLight);
        fridgeContext.getSubjectTemperature().subscribe(observerFridgeTemparature);
        fridgeContext.getIsCooling().subscribe(observerFridgeStatus);

        freezerContext.getSubjectLight().subscribe(observerFreezerLight);
        freezerContext.getSubjectTemperature().subscribe(observerFreezerTemparature);
        freezerContext.getIsCooling().subscribe(observerFreezerStatus);

    }


    //event listeners
    private void addActionListeners() {
        openFridge.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openFridgeDoor(e);
            }
        });
        closeFridge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeFridgeDoor(e);
            }
        });
        fridgeTempButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	setFridgeTemparature();
            }
        });
        openFreezer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFreezerDoor(e);
            }
        });
        closeFreezer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeFreezerDoor(e);
            }
        });
        freezerTempButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setFreezerTemparature();
            }
        });


    }

    //helper functions
    private void openFridgeDoor(ActionEvent e) {
        fridgeContext.setLight(true);
    	FridgeDoorOpenListenerList.instance().notifyListeners( new DoorOpenEvent(e) );

    }

    private void closeFridgeDoor(ActionEvent e){
        fridgeContext.setLight(false);
    	FridgeDoorCloseListenerList.instance().notifyListeners( new DoorCloseEvent(e) );
    }

    private void setFridgeTemparature(){
    	int newTemperature = Integer.valueOf( fridgeTempInput.getText() );
        if( newTemperature < Common.getFridgeLow() || newTemperature > Common.getFridgeHigh() ) {
            JOptionPane.showMessageDialog(null, "Invalid Fridge temparature. It should be between"+Common.getFridgeLow()+" and "
                    +Common.getFridgeHigh(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            //todo for when desired fridge temp is set
            fridgeContext.setSubjectDesiredTemperature(newTemperature);
            
            // 
        }
    }
    //freezer helper functions
    private void openFreezerDoor(ActionEvent e){
            freezerContext.setLight(true);
        	FreezerDoorOpenListenerList.instance().notifyListeners( new DoorOpenEvent(e) );

    }

    private void closeFreezerDoor(ActionEvent e){
            freezerContext.setLight(false);
        	FreezerDoorCloseListenerList.instance().notifyListeners( new DoorCloseEvent(e) );

    }

    private void setFreezerTemparature(){
    	int newTemperature = Integer.valueOf(freezerTempInput.getText());
        if( newTemperature < Common.getFreezerLow() || newTemperature > Common.getFreezerHigh() ){
            JOptionPane.showMessageDialog(null, "Invalid Freezer temparature. It should be between"+Common.getFreezerLow()+" and "
                            +Common.getFreezerHigh(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }else {
            //todo for when desired freezer temp is set
            freezerContext.setSubjectDesiredTemperature(newTemperature);
        }
    }




}
