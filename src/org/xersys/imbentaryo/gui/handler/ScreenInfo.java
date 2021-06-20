package org.xersys.imbentaryo.gui.handler;

import org.json.simple.JSONObject;

public class ScreenInfo {
    public static final String RESOURCE_URL = "../";
    public static final String CONTROLLER_URL = "org.xersys.imbentaryo.gui.";
    
    public enum NAME{
        JOB_ORDER,
        PARTS_INQUIRY,
        PARTS_CATALOGUE,
        POS,
        CUSTOMER_ORDER,
        DASHBOARD,
        CART
    }
    
    public static JSONObject get(NAME foModule){
        JSONObject loJSON = new JSONObject();
        
        switch (foModule){
            case JOB_ORDER:
                loJSON.put("resource", RESOURCE_URL + "JobOrder.fxml");
                loJSON.put("controller", CONTROLLER_URL + "JobOrderController");
                return loJSON;
            case PARTS_INQUIRY:
                loJSON.put("resource", RESOURCE_URL + "PartsInquiry.fxml");
                loJSON.put("controller", CONTROLLER_URL + "PartsInquiryController");
                return loJSON;
            case PARTS_CATALOGUE:
                loJSON.put("resource", RESOURCE_URL + "PartsCatalogue.fxml");
                loJSON.put("controller", CONTROLLER_URL + "PartsCatalogueController");
                return loJSON;
            case POS:
                loJSON.put("resource", RESOURCE_URL + "POS.fxml");
                loJSON.put("controller", CONTROLLER_URL + "POSController");
                return loJSON;
            case CUSTOMER_ORDER:
                loJSON.put("resource", RESOURCE_URL + "CustomerOrder.fxml");
                loJSON.put("controller", CONTROLLER_URL + "CustomerOrderController");
                return loJSON;
            case DASHBOARD:
                loJSON.put("resource", RESOURCE_URL + "Dashboard.fxml");
                loJSON.put("controller", CONTROLLER_URL + "DashboardController");
                return loJSON;
            case CART:
                loJSON.put("resource", RESOURCE_URL + "Cart.fxml");
                loJSON.put("controller", CONTROLLER_URL + "CartController");
                return loJSON;
        }
        
        return null;
    }
    
}
