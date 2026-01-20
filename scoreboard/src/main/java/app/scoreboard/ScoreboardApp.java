package app.scoreboard;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import app.scoreboard.config.StyleConfig;
import app.scoreboard.model.ServerData;
import app.scoreboard.service.DataUpdater;
import app.scoreboard.ui.ScoreBoardView;

/**
 * Aplicación principal del Scoreboard de Hyteria Network
 *
 * Esta clase coordina todos los componentes:
 * - ServerData: Almacena los datos
 * - ScoreBoardView: Construye la interfaz
 * - DataUpdater: Actualiza los datos automáticamente
 */
public class ScoreboardApp extends Application {

    private ServerData serverData;
    private ScoreBoardView scoreBoardView;
    private DataUpdater dataUpdater;

    @Override
    public void start(Stage primaryStage) {
        // 1. Crear el modelo de datos
        serverData = new ServerData();

        // 2. Crear la vista
        scoreBoardView = new ScoreBoardView(serverData);

        // 3. Crear el servicio de actualización
        dataUpdater = new DataUpdater(serverData, scoreBoardView);

        // 4. Configurar la ventana
        setupWindow(primaryStage);

        // 5. Crear la escena con la vista
        Scene scene = new Scene(
                scoreBoardView.buildScoreboard(),
                StyleConfig.SCOREBOARD_WIDTH,
                StyleConfig.SCOREBOARD_HEIGHT
        );
        scene.setFill(Color.TRANSPARENT);

        // 6. Mostrar la ventana
        primaryStage.setScene(scene);
        primaryStage.show();

        // 7. Iniciar actualizaciones automáticas
        dataUpdater.startAutoUpdate();
    }

    /**
     * Configura las propiedades de la ventana
     */
    private void setupWindow(Stage stage) {
        stage.setTitle("Hyteria Network Scoreboard");
        stage.initStyle(StageStyle.DECORATED); // Cambiar a UNDECORATED para overlay transparente
        stage.setAlwaysOnTop(true);
        stage.setResizable(false);
    }

    @Override
    public void stop() {
        // Detener actualizaciones al cerrar
        if (dataUpdater != null) {
            dataUpdater.stopAutoUpdate();
        }
    }

    /**
     * Punto de entrada de la aplicación
     */
    public static void main(String[] args) {
        launch(args);
    }
}