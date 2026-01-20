package app.scoreboard.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.shape.Line;
import app.scoreboard.config.StyleConfig;
import app.scoreboard.model.ServerData;

/**
 * Vista del Scoreboard
 * Construye y actualiza la interfaz gráfica
 */
public class ScoreBoardView {

    private final ServerData serverData;
    private VBox mainContainer;

    // Labels que se actualizarán dinámicamente
    private Label playerNameLabel;
    private Label coinsLabel;
    private Label levelLabel;
    private Label rankLabel;
    private Label serverNameLabel;
    private Label playersOnlineLabel;
    private Label gameModeLabel;
    private Label statusLabel;

    public ScoreBoardView(ServerData serverData) {
        this.serverData = serverData;
    }

    /**
     * Construye el scoreboard completo
     */
    public VBox buildScoreboard() {
        mainContainer = new VBox(StyleConfig.SPACING);
        mainContainer.setAlignment(Pos.TOP_CENTER);
        mainContainer.setPadding(new Insets(StyleConfig.PADDING));
        mainContainer.setStyle(
                "-fx-background-color: rgba(0, 0, 0, 0.7);" +
                        "-fx-background-radius: " + StyleConfig.CORNER_RADIUS + ";" +
                        "-fx-border-color: rgba(255, 170, 0, 0.5);" +
                        "-fx-border-width: " + StyleConfig.BORDER_WIDTH + ";" +
                        "-fx-border-radius: " + StyleConfig.CORNER_RADIUS + ";"
        );

        // Agregar secciones
        mainContainer.getChildren().addAll(
                buildHeader(),
                createSeparator(),
                buildPlayerSection(),
                createSeparator(),
                buildServerSection(),
                createSeparator(),
                buildStatusSection()
        );

        // Binding de datos con la UI
        setupBindings();

        return mainContainer;
    }

    /**
     * Construye el header del scoreboard
     */
    private VBox buildHeader() {
        VBox header = new VBox(5);
        header.setAlignment(Pos.CENTER);

        Label title = new Label("HYTERIA NETWORK");
        title.setFont(StyleConfig.HEADER_FONT);
        title.setTextFill(StyleConfig.HEADER_COLOR);

        header.getChildren().add(title);
        return header;
    }

    /**
     * Construye la sección de información del jugador
     */
    private VBox buildPlayerSection() {
        VBox section = new VBox(StyleConfig.SPACING);
        section.setAlignment(Pos.CENTER_LEFT);

        Label sectionTitle = createSectionTitle("JUGADOR");

        playerNameLabel = createDataLabel("Nombre: Player");
        rankLabel = createDataLabel("Rango: Default");
        levelLabel = createDataLabel("Nivel: 1");
        coinsLabel = createDataLabel("Monedas: 0");

        section.getChildren().addAll(
                sectionTitle,
                playerNameLabel,
                rankLabel,
                levelLabel,
                coinsLabel
        );

        return section;
    }

    /**
     * Construye la sección de información del servidor
     */
    private VBox buildServerSection() {
        VBox section = new VBox(StyleConfig.SPACING);
        section.setAlignment(Pos.CENTER_LEFT);

        Label sectionTitle = createSectionTitle("SERVIDOR");

        serverNameLabel = createDataLabel("Servidor: Lobby");
        gameModeLabel = createDataLabel("Modo: ---");
        playersOnlineLabel = createDataLabel("Jugadores: 0");

        section.getChildren().addAll(
                sectionTitle,
                serverNameLabel,
                gameModeLabel,
                playersOnlineLabel
        );

        return section;
    }

    /**
     * Construye la sección de estado
     */
    private VBox buildStatusSection() {
        VBox section = new VBox(5);
        section.setAlignment(Pos.CENTER);

        statusLabel = createDataLabel("● Desconectado");
        statusLabel.setStyle("-fx-text-fill: #ff5555;");

        section.getChildren().add(statusLabel);
        return section;
    }

    /**
     * Crea un título de sección
     */
    private Label createSectionTitle(String text) {
        Label label = new Label(text);
        label.setFont(StyleConfig.TITLE_FONT);
        label.setTextFill(StyleConfig.HEADER_COLOR);
        return label;
    }

    /**
     * Crea un label de datos
     */
    private Label createDataLabel(String text) {
        Label label = new Label(text);
        label.setFont(StyleConfig.DATA_FONT);
        label.setTextFill(StyleConfig.TEXT_COLOR);
        return label;
    }

    /**
     * Crea una línea separadora
     */
    private Line createSeparator() {
        Line line = new Line(0, 0, StyleConfig.SCOREBOARD_WIDTH - (StyleConfig.PADDING * 2), 0);
        line.setStroke(StyleConfig.SEPARATOR_COLOR);
        line.setStrokeWidth(1);
        return line;
    }

    /**
     * Configura los bindings entre el modelo y la vista
     */
    private void setupBindings() {
        // Player data bindings
        serverData.playerNameProperty().addListener((obs, old, newVal) ->
                playerNameLabel.setText("Nombre: " + newVal)
        );

        serverData.coinsProperty().addListener((obs, old, newVal) ->
                coinsLabel.setText("Monedas: " + newVal.intValue())
        );

        serverData.levelProperty().addListener((obs, old, newVal) ->
                levelLabel.setText("Nivel: " + newVal.intValue())
        );

        serverData.rankProperty().addListener((obs, old, newVal) ->
                rankLabel.setText("Rango: " + newVal)
        );

        // Server data bindings
        serverData.serverNameProperty().addListener((obs, old, newVal) ->
                serverNameLabel.setText("Servidor: " + newVal)
        );

        serverData.playersOnlineProperty().addListener((obs, old, newVal) ->
                playersOnlineLabel.setText("Jugadores: " + newVal.intValue())
        );

        serverData.gameModeProperty().addListener((obs, old, newVal) ->
                gameModeLabel.setText("Modo: " + newVal)
        );

        // Connection status binding
        serverData.connectedProperty().addListener((obs, old, newVal) -> {
            if (newVal) {
                statusLabel.setText("● Conectado");
                statusLabel.setStyle("-fx-text-fill: #55ff55;");
            } else {
                statusLabel.setText("● Desconectado");
                statusLabel.setStyle("-fx-text-fill: #ff5555;");
            }
        });
    }

    /**
     * Refresca la vista (útil para actualizaciones manuales)
     */
    public void refresh() {
        // Los bindings ya actualizan automáticamente la UI
        // Este método existe por si se necesita alguna actualización adicional
    }
}