package app.scoreboard.service;

import javafx.application.Platform;
import app.scoreboard.config.StyleConfig;
import app.scoreboard.model.ServerData;
import app.scoreboard.ui.ScoreBoardView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Servicio que actualiza los datos del scoreboard automáticamente
 *
 * Por ahora genera datos de prueba. En el futuro se conectará a:
 * - Minecraft mods (Forge/Fabric)
 * - API REST del servidor
 * - Logs del servidor
 */
public class DataUpdater {

    private final ServerData serverData;
    private final ScoreBoardView scoreboardView;
    private Timer updateTimer;
    private final Random random = new Random();

    // Datos de prueba
    private final String[] serverNames = {"Lobby", "SkyWars-1", "BedWars-2", "Survival", "Creative"};
    private final String[] gameModes = {"Lobby", "SkyWars Solo", "BedWars 4v4", "Survival", "Creative"};
    private final String[] ranks = {"Default", "VIP", "VIP+", "MVP", "MVP+", "Admin"};

    public DataUpdater(ServerData serverData, ScoreBoardView scoreboardView) {
        this.serverData = serverData;
        this.scoreboardView = scoreboardView;
    }

    /**
     * Inicia las actualizaciones automáticas
     */
    public void startAutoUpdate() {
        if (updateTimer != null) {
            updateTimer.cancel();
        }

        updateTimer = new Timer(true); // Daemon thread
        updateTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                updateData();
            }
        }, 0, StyleConfig.UPDATE_INTERVAL_MS);

        System.out.println("✓ Actualizaciones automáticas iniciadas (cada " +
                StyleConfig.UPDATE_INTERVAL_MS / 1000 + " segundos)");
    }

    /**
     * Detiene las actualizaciones automáticas
     */
    public void stopAutoUpdate() {
        if (updateTimer != null) {
            updateTimer.cancel();
            updateTimer = null;
            System.out.println("✓ Actualizaciones automáticas detenidas");
        }
    }

    /**
     * Actualiza los datos del servidor
     * Por ahora genera datos aleatorios para pruebas
     */
    private void updateData() {
        // Simular obtención de datos
        // TODO: Reemplazar con llamadas reales a la API o mod de Minecraft

        String playerName = "Player" + random.nextInt(1000);
        int coins = random.nextInt(10000);
        int level = random.nextInt(100) + 1;
        String rank = ranks[random.nextInt(ranks.length)];

        int serverIndex = random.nextInt(serverNames.length);
        String serverName = serverNames[serverIndex];
        String gameMode = gameModes[serverIndex];
        int playersOnline = random.nextInt(500) + 1;

        // Actualizar el modelo en el hilo de JavaFX
        Platform.runLater(() -> {
            serverData.updateAll(
                    playerName,
                    coins,
                    level,
                    rank,
                    serverName,
                    playersOnline,
                    gameMode
            );

            scoreboardView.refresh();

            System.out.println("✓ Datos actualizados: " + playerName +
                    " | Server: " + serverName +
                    " | Players: " + playersOnline);
        });
    }

    /**
     * Actualiza los datos manualmente (sin esperar al timer)
     */
    public void forceUpdate() {
        updateData();
    }

    /**
     * Conecta con el servidor de Minecraft
     * TODO: Implementar conexión real
     */
    public void connectToMinecraft() {
        System.out.println("⚠ Conexión a Minecraft aún no implementada");
        System.out.println("  Opciones futuras:");
        System.out.println("  1. Mod de Forge/Fabric que envíe datos vía WebSocket");
        System.out.println("  2. API REST del servidor de Hyteria");
        System.out.println("  3. Parseo de logs del cliente");
    }
}