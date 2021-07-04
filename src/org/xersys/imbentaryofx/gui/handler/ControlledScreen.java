package org.xersys.imbentaryofx.gui.handler;

import org.xersys.imbentaryofx.gui.MainScreenController;
import org.xersys.kumander.base.Nautilus;

public interface ControlledScreen {
    public void setNautilus(Nautilus foValue);
    public void setParentController(MainScreenController foValue);
    public void setScreensController(ScreensController foValue);
    public void setDashboardScreensController(ScreensController foValue);
}
