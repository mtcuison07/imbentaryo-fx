package org.xersys.imbentaryo.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import org.json.simple.JSONObject;
import org.xersys.imbentaryo.gui.handler.ControlledScreen;
import org.xersys.imbentaryo.gui.handler.ScreenInfo;
import org.xersys.imbentaryo.gui.handler.ScreensController;
import org.xersys.imbentaryo.listener.PartsCatalogueListener;
import org.xurpas.kumander.base.Nautilus;
import org.xurpas.kumander.util.CommonUtil;

public class PartsCatalogueController implements Initializable, ControlledScreen{
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
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
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
        //initialize grid
        initGrid();
        
        JSONObject loJSON = ScreenInfo.get(ScreenInfo.NAME.CART);
                
        if (loJSON != null) _screens_dashboard_controller.loadScreen((String) loJSON.get("resource"), (ControlledScreen) CommonUtil.createInstance((String) loJSON.get("controller")));
        
        displayImages();
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
        btn01.setText("F1 - Exit Window");
        btn02.setText("");
        btn03.setText("");
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
        
        //adjust the width of dashboard/cart pane
        _main_screen_controller.AnchorPaneMonitor.setPrefWidth(440.00);
    }
    
    private void cmdButton_Click(ActionEvent event) {
        String lsButton = ((Button) event.getSource()).getId();
        System.out.println(this.getClass().getSimpleName() + " " + lsButton + " was clicked.");
        
        JSONObject loJSON;
        
        switch (lsButton){
            case "btn01": //exit window
                _screens_dashboard_controller.unloadScreen(_screens_dashboard_controller.getCurrentScreenIndex());
                _screens_controller.unloadScreen(_screens_controller.getCurrentScreenIndex());
                break;
            case "btn02":
            case "btn03":
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
                _screens_dashboard_controller.unloadScreen(_screens_dashboard_controller.getCurrentScreenIndex());
                _screens_controller.unloadScreen(_screens_controller.getCurrentScreenIndex());
                break;
            case F2:
            case F3:
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
    
    private void initGrid(){
        grid.getChildren().clear();
        
        if (Double.valueOf(System.getProperty("system.screen.width")) >= 1920.0) //1920 x 1080
            _max_grid_column = 3;
        else if (Double.valueOf(System.getProperty("system.screen.width")) >= 1366.0) //1366 x 768
            _max_grid_column = 2;
        else
            _max_grid_column = 1;
        
    }
    
    private void displayImages(){
        _listener = new PartsCatalogueListener() {
            @Override
            public void onClickListener() {
                PartsCatalogueDetailController instance = new PartsCatalogueDetailController();
                instance.setData();
                instance.setNautilus(_nautilus);
                instance.setParentController(_main_screen_controller);
                instance.setScreensController(_screens_controller);
                instance.setDashboardScreensController(_screens_dashboard_controller);
                
                _screens_controller.loadScreen("../PartsCatalogueDetail.fxml", (ControlledScreen) instance);
                
            }
        };
        
        int column = 0;
        int row = 1;
        
        try {
            for (int i = 0; i < 9; i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("PartsCatalogueChild.fxml"));
                
                PartsCatalogueChildController controller = new PartsCatalogueChildController();
                controller.setData(_listener);
                
                fxmlLoader.setController(controller);
                
                AnchorPane anchorPane = fxmlLoader.load();

                if (column == _max_grid_column) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(5));
            }
        } catch (IOException e) {
            e.printStackTrace();
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