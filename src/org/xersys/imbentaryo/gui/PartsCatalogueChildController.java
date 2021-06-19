package org.xersys.imbentaryo.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.xersys.imbentaryo.listener.PartsCatalogueListener;


public class PartsCatalogueChildController implements Initializable {
    @FXML
    private ImageView image;
    
    @FXML
    private void click(MouseEvent mouseEvent) {
        _listener.onClickListener();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
    public void setData(PartsCatalogueListener foValue){
        _listener = foValue;
    }
    
    PartsCatalogueListener _listener;
}
