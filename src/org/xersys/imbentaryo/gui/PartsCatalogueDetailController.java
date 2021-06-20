/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xersys.imbentaryo.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.json.simple.JSONObject;
import org.xersys.imbentaryo.gui.handler.ControlledScreen;
import org.xersys.imbentaryo.gui.handler.ScreensController;
import org.xurpas.kumander.base.Nautilus;

/**
 * FXML Controller class
 *
 * @author Mac
 */
public class PartsCatalogueDetailController implements Initializable, ControlledScreen{

    @FXML
    private AnchorPane AnchorMain;
    @FXML
    private Button btn01;
    @FXML
    private Button btn02;
    @FXML
    private Button btn03;
    @FXML
    private Button btn04;
    @FXML
    private Button btn05;
    @FXML
    private Button btn06;
    @FXML
    private Button btn07;
    @FXML
    private Button btn08;
    @FXML
    private Button btn09;
    @FXML
    private Button btn10;
    @FXML
    private Button btn11;
    @FXML
    private Button btn12;
    @FXML
    private ImageView image;
    @FXML
    private VBox btnbox00;
    @FXML
    private HBox btnbox01;
    @FXML
    private HBox btnbox02;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //set the main anchor pane fit the size of its parent anchor pane
        AnchorMain.setTopAnchor(AnchorMain, 0.0);
        AnchorMain.setBottomAnchor(AnchorMain, 0.0);
        AnchorMain.setLeftAnchor(AnchorMain, 0.0);
        AnchorMain.setRightAnchor(AnchorMain, 0.0);
        
        //keyboard events
        AnchorMain.setOnKeyPressed(this::keyPressed);
        AnchorMain.setOnKeyReleased(this::keyReleased);
        
        //initialize buttons
        initButton();
    }    

    @Override
    public void setNautilus(Nautilus foValue) {
        _nautilus = foValue;
    }

    @Override
    public void setParentController(MainScreenController foValue) {
        _main_screen_controller = foValue;
    }
    
    @Override
    public void setScreensController(ScreensController foValue) {
        _screens_controller = foValue;
    }
    
    @Override
    public void setDashboardScreensController(ScreensController foValue) {
        _screens_dashboard_controller = foValue;
    }
    
    public void setData(){
    
    }
    
    private void initButton(){
        btn01.setText("F1 - Send to SO");
        btn02.setText("F1 - Send to CO");
        btn03.setText("F3 - Back");
        btn04.setText("");
        btn05.setText("");
        btn06.setText("");
        btn07.setText("");
        btn08.setText("");
        btn09.setText("");
        btn10.setText("");
        btn11.setText("");
        btn12.setText("");
        
        //Set action event handler for the buttons
        btn01.setOnAction(this::cmdButton_Click);
        btn02.setOnAction(this::cmdButton_Click);
        btn03.setOnAction(this::cmdButton_Click);
        btn04.setOnAction(this::cmdButton_Click);
        btn05.setOnAction(this::cmdButton_Click);
        btn06.setOnAction(this::cmdButton_Click);
        btn07.setOnAction(this::cmdButton_Click);
        btn08.setOnAction(this::cmdButton_Click);
        btn09.setOnAction(this::cmdButton_Click);
        btn10.setOnAction(this::cmdButton_Click);
        btn11.setOnAction(this::cmdButton_Click);
        btn12.setOnAction(this::cmdButton_Click);
        
        if (btn06.getText().isEmpty()){
            btnbox00.setPrefHeight(btnbox00.getPrefHeight() / 2);
            btnbox00.setPadding(new Insets(0, 0, 0, 0));
            btnbox02.setPadding(new Insets(0, 0, 0, 0));
            btnbox02.getChildren().clear();
            btnbox02.setPrefHeight(0);
        }
    }
    
    private void cmdButton_Click(ActionEvent event) {
        String lsButton = ((Button) event.getSource()).getId();
        System.out.println(this.getClass().getSimpleName() + " " + lsButton + " was clicked.");
        
        JSONObject loJSON;
        
        switch (lsButton){
            case "btn01":
            case "btn02":
            case "btn03": //back
                _screens_controller.unloadScreen(_screens_controller.getCurrentScreenIndex());
                break;
            case "btn04":
            case "btn05":
            case "btn06":
            case "btn07":
            case "btn08":
            case "btn09":
            case "btn10":
            case "btn11":
            case "btn12":
        }
    }
    
    private void keyReleased(KeyEvent event) {
        JSONObject loJSON;
        
        switch(event.getCode()){
            case F1:
            case F2:
            case F3:
                _screens_controller.unloadScreen(_screens_controller.getCurrentScreenIndex());
                break;
            case F4:
            case F5:
            case F6:
            case F7:
            case F8:
            case F9:
            case F10:
            case F11:
            case F12:
            case ESCAPE:
                break; 
            case CONTROL:
                _control_pressed = false;
                break;
            case SHIFT:
                _shift_pressed = false;
                break;
            case TAB:
                _control_pressed = false;
                _shift_pressed = false;
                break;
        }
    }
    
    private void keyPressed(KeyEvent event) {
        switch(event.getCode()){
            case CONTROL:
                _control_pressed = true;
                break; 
            case SHIFT:
                _shift_pressed = true;
                break;
            case TAB:
                if (_control_pressed) if (_shift_pressed) _screens_controller.unloadScreen(_screens_controller.getCurrentScreenIndex());
                break;
        }
    }
    
    private Nautilus _nautilus;
    private MainScreenController _main_screen_controller;
    private ScreensController _screens_controller;
    ScreensController _screens_dashboard_controller;
    
    private boolean _control_pressed;
    private boolean _shift_pressed;    

    
}
