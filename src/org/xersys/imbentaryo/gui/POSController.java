package org.xersys.imbentaryo.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import org.json.simple.JSONObject;
import org.xersys.imbentaryo.gui.handler.ControlledScreen;
import org.xersys.imbentaryo.gui.handler.ScreenInfo;
import org.xersys.imbentaryo.gui.handler.ScreensController;
import org.xersys.kumander.base.Nautilus;
import org.xersys.kumander.util.CommonUtil;

public class POSController implements Initializable, ControlledScreen{
    @FXML
    private AnchorPane AnchorMain;
    
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
    
    private void loadScreen(ScreenInfo.NAME  foValue){
        JSONObject loJSON = ScreenInfo.get(foValue);
        ControlledScreen instance;
        
        if (loJSON != null){
            instance = (ControlledScreen) CommonUtil.createInstance((String) loJSON.get("controller"));
            instance.setNautilus(_nautilus);
            instance.setParentController(_main_screen_controller);
            instance.setScreensController(_screens_controller);
            instance.setDashboardScreensController(_screens_dashboard_controller);
            
            _screens_controller.loadScreen((String) loJSON.get("resource"), instance);
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
                loadScreen(ScreenInfo.NAME.CUSTOMER_ORDER);
                break;
            case F4:
                loadScreen(ScreenInfo.NAME.JOB_ORDER);
                break;
            case F5:
                loadScreen(ScreenInfo.NAME.PARTS_CATALOGUE);
                break;
            case F6:
                loadScreen(ScreenInfo.NAME.PARTS_INQUIRY);
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
    
    private Nautilus _nautilus;
    private MainScreenController _main_screen_controller;
    private ScreensController _screens_controller;
    private ScreensController _screens_dashboard_controller;
    
    private boolean _control_pressed;
    private boolean _shift_pressed;
}
