package net.byteexception.netcode.lobby.config;


/**
 * Config Layout Manager
 *
 *@author Mike
 *
 */


public  abstract class LobbyConfig {

    protected HotbarLayout layout;
    protected int defaultLevel;

    public LobbyConfig() {
        this.layout = new HotbarLayout();
        this.defaultLevel = 0;

        initialize();
    }

    public abstract void initialize();


    public HotbarLayout getLayout() {
        return layout;
    }

    public int getDefaultLevel() {
        return defaultLevel;
    }
}
