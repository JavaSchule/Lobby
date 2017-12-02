package net.byteexception.netcode.lobby.user;

import net.byteexception.netcode.lobby.LobbyPlugin;

import javax.swing.text.Document;
import java.io.Serializable;
import java.util.UUID;

/**
 *
 *@author Mike
 */
public class LobbySettings implements Serializable {

    private VisibilityLevel visibilityLevel;

    public LobbySettings() {
        this(VisibilityLevel.ALL);
    }

    public LobbySettings(VisibilityLevel visibilityLevel) {
        this.visibilityLevel = visibilityLevel;
    }

    public VisibilityLevel getVisibilityLevel() {
        return visibilityLevel;
    }

    public void setVisibilityLevel(VisibilityLevel visibilityLevel) {
        this.visibilityLevel = visibilityLevel;
    }


}
