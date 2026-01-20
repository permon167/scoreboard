package app.scoreboard.config;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * Configuración de estilos y constantes visuales del Scoreboard
 */
public class StyleConfig {

    // Dimensiones del scoreboard
    public static final double SCOREBOARD_WIDTH = 300;
    public static final double SCOREBOARD_HEIGHT = 400;

    // Colores
    public static final Color BACKGROUND_COLOR = Color.rgb(0, 0, 0, 0.7);
    public static final Color HEADER_COLOR = Color.rgb(255, 170, 0); // Naranja/dorado
    public static final Color TEXT_COLOR = Color.WHITE;
    public static final Color SEPARATOR_COLOR = Color.rgb(100, 100, 100);

    // Fuentes
    public static final Font HEADER_FONT = Font.font("Minecraft", FontWeight.BOLD, 20);
    public static final Font TITLE_FONT = Font.font("Minecraft", FontWeight.BOLD, 14);
    public static final Font DATA_FONT = Font.font("Minecraft", FontWeight.NORMAL, 12);

    // Espaciado
    public static final double PADDING = 10;
    public static final double SPACING = 8;
    public static final double LINE_HEIGHT = 20;

    // Bordes y esquinas
    public static final double CORNER_RADIUS = 10;
    public static final double BORDER_WIDTH = 2;

    // Actualización
    public static final long UPDATE_INTERVAL_MS = 5000; // 5 segundos

    private StyleConfig() {
        // Clase de utilidad, no instanciable
    }
}