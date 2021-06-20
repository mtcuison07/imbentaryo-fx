package org.xersys.imbentaryo.gui.handler;

import org.xersys.imbentaryo.gui.MainScreenController;
import org.xurpas.kumander.base.Nautilus;

public interface ControlledScreen {
    public void setNautilus(Nautilus foValue);
    public void setParentController(MainScreenController foValue);
    public void setScreensController(ScreensController foValue);
    public void setDashboardScreensController(ScreensController foValue);
}
