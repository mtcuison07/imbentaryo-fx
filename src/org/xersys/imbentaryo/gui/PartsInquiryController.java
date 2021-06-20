package org.xersys.imbentaryo.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.json.simple.JSONObject;
import org.xersys.imbentaryo.gui.handler.ControlledScreen;
import org.xersys.imbentaryo.gui.handler.ScreenInfo;
import org.xersys.imbentaryo.gui.handler.ScreensController;
import org.xersys.imbentaryo.listener.PartsCatalogueListener;
import org.xurpas.kumander.base.Nautilus;
import org.xurpas.kumander.util.CommonUtil;

public class PartsInquiryController implements Initializable, ControlledScreen{
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
        AnchorMain.setOnKeyReleased(this::keyReleased);
        
        //initialize buttons
        initButton();
        
        JSONObject loJSON = ScreenInfo.get(ScreenInfo.NAME.CART);
                
        if (loJSON != null) _screens_dashboard_controller.loadScreen((String) loJSON.get("resource"), (ControlledScreen) CommonUtil.createInstance((String) loJSON.get("controller")));
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
    
    private void initButton(){
        btn01.setText("F1 - Send To CO");
        btn02.setText("F2 - Send To SO");
        btn03.setText("F3 - Exit Window");
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
            case "btn01": //send to customer order
                System.out.println("Send to customer order");
                break;
            case "btn02": //send to sales order
                System.out.println("Send to sales order");
                break;
            case "btn03": //close
                _screens_dashboard_controller.unloadScreen(_screens_dashboard_controller.getCurrentScreenIndex());
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
    
    public void keyReleased(KeyEvent event) {
        JSONObject loJSON;
        
        switch(event.getCode()){
            case F1:
                System.out.println("Send to customer order");
                break;
            case F2:
                System.out.println("Send to sales order");
                break;
            case F3:
                _screens_dashboard_controller.unloadScreen(_screens_dashboard_controller.getCurrentScreenIndex());
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
        }
    }
    
    private Nautilus _nautilus;
    private MainScreenController _main_screen_controller;
    private ScreensController _screens_controller;
    private ScreensController _screens_dashboard_controller;
    private PartsCatalogueListener _listener;
    
    private boolean _control_pressed;
    private boolean _shift_pressed;
    
    private int _max_grid_column;
}