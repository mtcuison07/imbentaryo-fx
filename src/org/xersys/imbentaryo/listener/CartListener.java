package org.xersys.imbentaryo.listener;

public interface CartListener {
    public void setCallback(CartCallback foValue);
    public void setData(String fsValue);
    public String getData();
}
