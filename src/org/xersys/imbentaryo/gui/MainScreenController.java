package org.xersys.imbentaryo.gui;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import org.xersys.imbentaryo.gui.handler.ScreenInfo;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import org.json.simple.JSONObject;
import org.xersys.imbentaryo.gui.handler.ControlledScreen;
import org.xersys.imbentaryo.gui.handler.ScreensController;
import org.xersys.kumander.base.Nautilus;
import org.xersys.kumander.util.CommonUtil;

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
    public AnchorPane AnchorPaneMonitor;
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
    @FXML
    private VBox btnbox00;
    @FXML
    private HBox btnbox01;
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
    private FontAwesomeIconView glyph01;
    @FXML
    private FontAwesomeIconView glyph02;
    @FXML
    private FontAwesomeIconView glyph03;
    @FXML
    private FontAwesomeIconView glyph04;
    @FXML
    private FontAwesomeIconView glyph05;
    @FXML
    private FontAwesomeIconView glyph06;
    @FXML
    private FontAwesomeIconView glyph07;
    @FXML
    private FontAwesomeIconView glyph08;
    @FXML
    private FontAwesomeIconView glyph09;
    @FXML
    private FontAwesomeIconView glyph10;
    @FXML
    private FontAwesomeIconView glyph11;
    @FXML
    private FontAwesomeIconView glyph12;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        _screens_controller = new ScreensController();
        _screens_controller.setParentPane(AnchorPaneBody);
        _screens_controller.setParentController(this);
        
        _screens_dashboard_controller = new ScreensController();
        _screens_dashboard_controller.setParentPane(AnchorPaneMonitor);
        _screens_dashboard_controller.setParentController(this);
        
        //keyboard events
        AnchorPaneMain.setOnKeyPressed(this::keyPressed);
        AnchorPaneMain.setOnKeyReleased(this::keyReleased);
        
        initButton();
        initScreen();
    }    
    
    private void loadScreen(ScreenInfo.NAME  foValue){
        JSONObject loJSON = ScreenInfo.get(foValue);
        ControlledScreen instance;
        
        if (loJSON != null){
            instance = (ControlledScreen) CommonUtil.createInstance((String) loJSON.get("controller"));
            instance.setNautilus(_nautilus);
            instance.setParentController(this);
            instance.setScreensController(_screens_controller);
            instance.setDashboardScreensController(_screens_dashboard_controller);
            
            _screens_controller.loadScreen((String) loJSON.get("resource"), instance);
        }
    }
    
    private void initScreen(){
        //load main form and request focus on its button
        loadScreen(ScreenInfo.NAME.POS);
        btn01.requestFocus();
        
        //load the dashboard
        JSONObject loJSON = ScreenInfo.get(ScreenInfo.NAME.DASHBOARD);
        if (loJSON != null) _screens_dashboard_controller.loadScreen((String) loJSON.get("resource"), (ControlledScreen) CommonUtil.createInstance((String) loJSON.get("controller")));          
    }
    
    private void initButton(){
        btn01.setText("Point-of-Sales");
        btn02.setText("Customer Order");
        btn03.setText("Job Order");
        btn04.setText("Purchasing");
        btn05.setText("Wholesale");
        btn06.setText("Inventory");
        btn07.setText("Warehousing");
        btn08.setText("Cash Flow");
        btn09.setText("Reports");
        btn10.setText("");
        btn11.setText("");
        btn12.setText("Close");
        
        btn01.setTooltip(new Tooltip("F1"));
        btn02.setTooltip(new Tooltip("F2"));
        btn03.setTooltip(new Tooltip("F3"));
        btn04.setTooltip(new Tooltip("F4"));
        btn05.setTooltip(new Tooltip("F5"));
        btn06.setTooltip(new Tooltip("F6"));
        btn07.setTooltip(new Tooltip("F7"));
        btn08.setTooltip(new Tooltip("F8"));
        btn09.setTooltip(new Tooltip("F9"));
        //btn10.setTooltip(new Tooltip("F10"));
        //btn11.setTooltip(new Tooltip("F11"));
        btn12.setTooltip(new Tooltip("F12"));
        
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

        glyph01.setVisible(true);
        glyph02.setVisible(true);
        glyph03.setVisible(true);
        glyph04.setVisible(true);
        glyph05.setVisible(true);
        glyph06.setVisible(true);
        glyph07.setVisible(true);
        glyph08.setVisible(true);
        glyph09.setVisible(true);
        glyph10.setVisible(false);
        glyph11.setVisible(false);
        glyph12.setVisible(true);
    }
    
    private void cmdButton_Click(ActionEvent event) {
        String lsButton = ((Button) event.getSource()).getId();
        System.out.println(this.getClass().getSimpleName() + " " + lsButton + " was clicked.");
        
        switch (lsButton){
            case "btn01": //point of sales
                loadScreen(ScreenInfo.NAME.POS);
                break;
            case "btn02": //customer order
                loadScreen(ScreenInfo.NAME.CUSTOMER_ORDER);
                break;
            case "btn03": //job order
                loadScreen(ScreenInfo.NAME.JOB_ORDER);
                break;
            case "btn04": //purchasing
                break;
            case "btn05": //wholesale
                break;
            case "btn06": //inventory
                break;
            case "btn07": //warehousing
                break;
            case "btn08": //cashflow
                break;
            case "btn09": //reports
                break;
            case "btn10":
            case "btn11":
                break;
            case "btn12": //exit
                System.exit(0);
        }
    }
    
    public void keyReleased(KeyEvent event) {
        switch(event.getCode()){
            case F1: //point of sales
                loadScreen(ScreenInfo.NAME.POS);
                break;
            case F2: //customer order
                loadScreen(ScreenInfo.NAME.CUSTOMER_ORDER);
                break;
            case F3: //job order
                loadScreen(ScreenInfo.NAME.JOB_ORDER);
                break;
            case F4: //purchasing
                break;
            case F5: //wholesale
                break;
            case F6: //inventory
                break;
            case F7: //warehousing
                break;
            case F8: //cashflow
                System.exit(0);
                break;
            case F9: //reports
            case F10:
            case F11:
            case F12: //exit                
                System.exit(0);
            case ESCAPE:
                break; 
            case CONTROL:
                _control_pressed = false;
                break;
            case SHIFT:
                _shift_pressed = false;
                break;
            case TAB:
                //_control_pressed = false;
                //_shift_pressed = false;
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
                Node loNode = _screens_controller.getScreen(_screens_controller.getCurrentScreenIndex());
                
                //prevent some window to user prev/fwrd screen
                switch(loNode.getId()){
                    case "PartsInquiry":
                    case "PartsCatalogue":
                    case "PartsCatalogueDetail":
                        System.err.println("Request rejected.");
                        break;
                    default:
                        if (_control_pressed){
                            if (_shift_pressed)
                                _screens_controller.prevScreen();
                            else
                                _screens_controller.fwrdScreen();
                        }   
                }

                break;
        }
    }
    
    private static Nautilus _nautilus;
    private static ScreensController _screens_controller;
    private static ScreensController _screens_dashboard_controller;
    
    private boolean _control_pressed;
    private boolean _shift_pressed;
}