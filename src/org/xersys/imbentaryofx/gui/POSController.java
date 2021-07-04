package org.xersys.imbentaryofx.gui;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.json.simple.JSONObject;
import org.xersys.imbentaryofx.gui.handler.ControlledScreen;
import org.xersys.imbentaryofx.gui.handler.ScreenInfo;
import org.xersys.imbentaryofx.gui.handler.ScreensController;
import org.xersys.kumander.base.Nautilus;
import org.xersys.kumander.util.CommonUtil;

public class POSController implements Initializable, ControlledScreen{
    @FXML
    private AnchorPane AnchorMain;
    @FXML
    private VBox btnbox00;
    @FXML
    private HBox btnbox01;
    @FXML
    private Button btn01;
    @FXML
    private FontAwesomeIconView glyph01;
    @FXML
    private Button btn02;
    @FXML
    private FontAwesomeIconView glyph02;
    @FXML
    private Button btn03;
    @FXML
    private FontAwesomeIconView glyph03;
    @FXML
    private Button btn04;
    @FXML
    private FontAwesomeIconView glyph04;
    @FXML
    private Button btn05;
    @FXML
    private FontAwesomeIconView glyph05;
    @FXML
    private Button btn06;
    @FXML
    private FontAwesomeIconView glyph06;
    @FXML
    private Button btn07;
    @FXML
    private FontAwesomeIconView glyph07;
    @FXML
    private Button btn08;
    @FXML
    private FontAwesomeIconView glyph08;
    @FXML
    private Button btn09;
    @FXML
    private FontAwesomeIconView glyph09;
    @FXML
    private Button btn10;
    @FXML
    private FontAwesomeIconView glyph10;
    @FXML
    private Button btn11;
    @FXML
    private FontAwesomeIconView glyph11;
    @FXML
    private Button btn12;
    @FXML
    private FontAwesomeIconView glyph12;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {        
        //set the main anchor pane fit the size of its parent anchor pane
        AnchorMain.setTopAnchor(AnchorMain, 0.0);
        AnchorMain.setBottomAnchor(AnchorMain, 0.0);
        AnchorMain.setLeftAnchor(AnchorMain, 0.0);
        AnchorMain.setRightAnchor(AnchorMain, 0.0);   
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
    
    private void cmdButton_Click(ActionEvent event) {
        String lsButton = ((Button) event.getSource()).getId();
        System.out.println(this.getClass().getSimpleName() + " " + lsButton + " was clicked.");
        
        switch (lsButton){
            case "btn01":
                break;
            case "btn02":
                break;
            case "btn03":
                break;
            case "btn04":
                break;
            case "btn05":
                break;
            case "btn06":
                break;
            case "btn07":
                break;
            case "btn08":
                break;
            case "btn09":
                break;
            case "btn10":
                break;
            case "btn11":
                break;
            case "btn12": //exit
                break;
        }
    }
    
    public void keyReleased(KeyEvent event) {
        switch(event.getCode()){
            case F1:
                break;
            case F2: 
                break;
            case F3:
                break;
            case F4:
                break;
            case F5: 
                break;
            case F6:
                break;
            case F7:
                break;
            case F8: 
                break;
            case F9:
                break;
            case F10:
                break;
            case F11:
                break;
            case F12: 
                break;

        }
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
    
    private Nautilus _nautilus;
    private MainScreenController _main_screen_controller;
    private ScreensController _screens_controller;
    private ScreensController _screens_dashboard_controller;
}
