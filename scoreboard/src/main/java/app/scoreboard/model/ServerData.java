package app.scoreboard.model;

import javafx.beans.property.*;

/**
 * Modelo de datos del servidor
 * Usa JavaFX Properties para binding automático con la UI
 */
public class ServerData {

    // Información del jugador
    private final StringProperty playerName = new SimpleStringProperty("Player");
    private final IntegerProperty coins = new SimpleIntegerProperty(0);
    private final IntegerProperty level = new SimpleIntegerProperty(1);
    private final StringProperty rank = new SimpleStringProperty("Default");

    // Información del servidor
    private final StringProperty serverName = new SimpleStringProperty("Lobby");
    private final IntegerProperty playersOnline = new SimpleIntegerProperty(0);
    private final StringProperty gameMode = new SimpleStringProperty("---");

    // Estado de conexión
    private final BooleanProperty connected = new SimpleBooleanProperty(false);

    // Constructor
    public ServerData() {
        // Valores por defecto ya están asignados arriba
    }

    // Getters y Setters para playerName
    public String getPlayerName() {
        return playerName.get();
    }

    public void setPlayerName(String playerName) {
        this.playerName.set(playerName);
    }

    public StringProperty playerNameProperty() {
        return playerName;
    }

    // Getters y Setters para coins
    public int getCoins() {
        return coins.get();
    }

    public void setCoins(int coins) {
        this.coins.set(coins);
    }

    public IntegerProperty coinsProperty() {
        return coins;
    }

    // Getters y Setters para level
    public int getLevel() {
        return level.get();
    }

    public void setLevel(int level) {
        this.level.set(level);
    }

    public IntegerProperty levelProperty() {
        return level;
    }

    // Getters y Setters para rank
    public String getRank() {
        return rank.get();
    }

    public void setRank(String rank) {
        this.rank.set(rank);
    }

    public StringProperty rankProperty() {
        return rank;
    }

    // Getters y Setters para serverName
    public String getServerName() {
        return serverName.get();
    }

    public void setServerName(String serverName) {
        this.serverName.set(serverName);
    }

    public StringProperty serverNameProperty() {
        return serverName;
    }

    // Getters y Setters para playersOnline
    public int getPlayersOnline() {
        return playersOnline.get();
    }

    public void setPlayersOnline(int playersOnline) {
        this.playersOnline.set(playersOnline);
    }

    public IntegerProperty playersOnlineProperty() {
        return playersOnline;
    }

    // Getters y Setters para gameMode
    public String getGameMode() {
        return gameMode.get();
    }

    public void setGameMode(String gameMode) {
        this.gameMode.set(gameMode);
    }

    public StringProperty gameModeProperty() {
        return gameMode;
    }

    // Getters y Setters para connected
    public boolean isConnected() {
        return connected.get();
    }

    public void setConnected(boolean connected) {
        this.connected.set(connected);
    }

    public BooleanProperty connectedProperty() {
        return connected;
    }

    /**
     * Actualiza todos los datos a la vez
     */
    public void updateAll(String playerName, int coins, int level, String rank,
                          String serverName, int playersOnline, String gameMode) {
        setPlayerName(playerName);
        setCoins(coins);
        setLevel(level);
        setRank(rank);
        setServerName(serverName);
        setPlayersOnline(playersOnline);
        setGameMode(gameMode);
        setConnected(true);
    }

    /**
     * Reinicia los datos a valores por defecto
     */
    public void reset() {
        setPlayerName("Player");
        setCoins(0);
        setLevel(1);
        setRank("Default");
        setServerName("Lobby");
        setPlayersOnline(0);
        setGameMode("---");
        setConnected(false);
    }
}