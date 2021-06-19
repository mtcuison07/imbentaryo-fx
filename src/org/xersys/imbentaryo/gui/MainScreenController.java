package org.xersys.imbentaryo.gui;

import org.xersys.imbentaryo.gui.handler.ScreenInfo;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import org.json.simple.JSONObject;
import org.xersys.imbentaryo.gui.handler.ControlledScreen;
import org.xersys.imbentaryo.gui.handler.ScreensController;
import org.xurpas.kumander.util.CommonUtil;

public class MainScreenController implements Initializable {
    @FXML
    private AnchorPane AnchorPaneMain;
    @FXML
    private StackPane StackPaneBody;
    @FXML
    private AnchorPane AnchorPaneHeader;
    @FXML
    private AnchorPane AnchorPaneFooter;
    @FXML
    private AnchorPane AnchorPaneMonitor;
    @FXML
    public AnchorPane AnchorPaneBody;
    @FXML
    private Label lblDate;
    @FXML
    private Label lblCompany;
    @FXML
    private Label lblUser;
    @FXML
    private Label lblDate1;
    @FXML
    private Label lblCompany1;
    @FXML
    private Label lblUser1;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        _screens_controller = new ScreensController();
        _screens_controller.setParentPane(AnchorPaneBody);
        _screens_controller.setParentController(this);
        
        _screens_dashboard_controller = new ScreensController();
        _screens_dashboard_controller.setParentPane(AnchorPaneMonitor);
        _screens_dashboard_controller.setParentController(this);
        
        //load the first screen based on the user credential
        //or screen to load will be based on the system configudation
        //load Job Order form temporarilly
        JSONObject loJSON = ScreenInfo.get(ScreenInfo.NAME.JOB_ORDER);
                
        if (loJSON != null) _screens_controller.loadScreen((String) loJSON.get("resource"), (ControlledScreen) CommonUtil.createInstance((String) loJSON.get("controller")));  
        
        loJSON = ScreenInfo.get(ScreenInfo.NAME.DASHBOARD);
                
        //load the dashboard
        if (loJSON != null) _screens_dashboard_controller.loadScreen((String) loJSON.get("resource"), (ControlledScreen) CommonUtil.createInstance((String) loJSON.get("controller")));  
    }    
    
    private static ScreensController _screens_controller;
    private static ScreensController _screens_dashboard_controller;
}
