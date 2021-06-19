package org.xersys.imbentaryo.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import org.json.simple.JSONObject;
import org.xersys.imbentaryo.gui.handler.ControlledScreen;
import org.xersys.imbentaryo.gui.handler.ScreenInfo;
import org.xersys.imbentaryo.gui.handler.ScreensController;
import org.xurpas.kumander.base.Nautilus;
import org.xurpas.kumander.util.CommonUtil;

public class JobOrderController implements Initializable, ControlledScreen{
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
    
    private void initButton(){
        btn01.setText("F1\nConfirm JO");
        btn02.setText("F2\nNew JO");
        btn03.setText("F3\nCustomer Order");
        btn04.setText("F4\nSales Order");
        btn05.setText("F5\nParts Catalogue");
        btn06.setText("F6\nParts Inquiy");
        btn07.setText("F7\nReports");
        btn08.setText("F8\nClose");
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
    }
    
    private void cmdButton_Click(ActionEvent event) {
        String lsButton = ((Button) event.getSource()).getId();
        System.out.println(this.getClass().getSimpleName() + " " + lsButton + " was clicked.");
        
        JSONObject loJSON;
        
        switch (lsButton){
            case "btn01": //confirm JO
                System.out.println("Confirm transaction.");
                break;
            case "btn02": //new JO
                System.out.println("Add new transaction.");
                break;
            case "btn03": //customer order
                loJSON = ScreenInfo.get(ScreenInfo.NAME.CUSTOMER_ORDER);
                
                if (loJSON != null) _screens_controller.loadScreen((String) loJSON.get("resource"), (ControlledScreen) CommonUtil.createInstance((String) loJSON.get("controller")));
                break;
            case "btn04":
                loJSON = ScreenInfo.get(ScreenInfo.NAME.SALES_ORDER);
                
                if (loJSON != null) _screens_controller.loadScreen((String) loJSON.get("resource"), (ControlledScreen) CommonUtil.createInstance((String) loJSON.get("controller")));
                break;
            case "btn05":
                loJSON = ScreenInfo.get(ScreenInfo.NAME.PARTS_CATALOGUE);
                
                if (loJSON != null) _screens_controller.loadScreen((String) loJSON.get("resource"), (ControlledScreen) CommonUtil.createInstance((String) loJSON.get("controller")));
                break;
            case "btn06":
                loJSON = ScreenInfo.get(ScreenInfo.NAME.PARTS_INQUIRY);
                
                if (loJSON != null) _screens_controller.loadScreen((String) loJSON.get("resource"), (ControlledScreen) CommonUtil.createInstance((String) loJSON.get("controller"))); 
                break;
            case "btn07": //reports
                break;
            case "btn08": //close
                System.exit(0);
                break;
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
                System.out.println("Confirm transaction.");
                break;
            case F2:
                System.out.println("Add new transaction.");
                break;
            case F3:
                loJSON = ScreenInfo.get(ScreenInfo.NAME.CUSTOMER_ORDER);
                
                if (loJSON != null) _screens_controller.loadScreen((String) loJSON.get("resource"), (ControlledScreen) CommonUtil.createInstance((String) loJSON.get("controller")));
                
                break;
            case F4:
                loJSON = ScreenInfo.get(ScreenInfo.NAME.SALES_ORDER);
                
                if (loJSON != null) _screens_controller.loadScreen((String) loJSON.get("resource"), (ControlledScreen) CommonUtil.createInstance((String) loJSON.get("controller")));
                break;
            case F5:
                loJSON = ScreenInfo.get(ScreenInfo.NAME.PARTS_CATALOGUE);
                
                if (loJSON != null) _screens_controller.loadScreen((String) loJSON.get("resource"), (ControlledScreen) CommonUtil.createInstance((String) loJSON.get("controller")));
                break;
            case F6:
                loJSON = ScreenInfo.get(ScreenInfo.NAME.PARTS_INQUIRY);
                
                if (loJSON != null) _screens_controller.loadScreen((String) loJSON.get("resource"), (ControlledScreen) CommonUtil.createInstance((String) loJSON.get("controller")));
                break;
            case F7:
                break;
            case F8:
                System.exit(0);
                break;
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
    
    public void keyPressed(KeyEvent event) {
        switch(event.getCode()){
            case CONTROL:
                _control_pressed = true;
                break; 
            case SHIFT:
                _shift_pressed = true;
                break;
            case TAB:
                if (_control_pressed){
                    if (_shift_pressed)
                        _screens_controller.prevScreen();
                    else
                        _screens_controller.fwrdScreen();
                }
                break;
        }
    }
    
    Nautilus _nautilus;
    MainScreenController _main_screen_controller;
    ScreensController _screens_controller;
    
    boolean _control_pressed;
    boolean _shift_pressed;
}
