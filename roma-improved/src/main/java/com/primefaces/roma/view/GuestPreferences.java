package com.primefaces.roma.view;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class GuestPreferences implements Serializable {

    private String menuMode = "layout-static";

    private String theme = "blue";

    private String menuColor = "layout-menu-light";

    private String topBarColor = "layout-topbar-blue";

    private String logo = "logo-roma-white";

    private String profileMode = "popup";
    
    private boolean orientationRTL;

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getMenuMode() {
        return this.menuMode;
    }

    public void setMenuMode(String menuMode) {
        this.menuMode = menuMode;

        if (this.menuMode.equals("layout-horizontal")) {
            this.profileMode = "popup";
        }
    }

    public String getMenuColor() {
        return this.menuColor;
    }

    public void setMenuColor(String menuColor) {
        this.menuColor = menuColor;
    }

    public String getTopBarColor() {
        return this.topBarColor;
    }

    public void setTopBarColor(String topBarColor, String logo) {
        this.topBarColor = topBarColor;
        this.logo = logo;
    }

    public String getLogo() {
        return this.logo;
    }

    public String getProfileMode() {
        return this.profileMode;
    }

    public void setProfileMode(String profileMode) {
        if (this.menuMode.equals("layout-horizontal")) {
            this.profileMode = "popup";
        }
        else {
            this.profileMode = profileMode;
        }
    }
    
    public boolean isOrientationRTL() {
        return orientationRTL;
    }

    public void setOrientationRTL(boolean orientationRTL) {
        this.orientationRTL = orientationRTL;
    }
}
