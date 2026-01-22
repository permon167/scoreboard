# 🎮 Hytalia Network – Scoreboard JavaFX

Scoreboard en tiempo real para **Hytalia Network**, desarrollado en **Java + JavaFX**. Muestra información dinámica del jugador y del servidor, con actualización automática cada 5 segundos. Pensado como base para una futura integración real con un servidor Minecraft.

---

## ▶️ Compilar y Ejecutar

### Requisitos
- **Java JDK 17+**
- **JavaFX**
- **Maven** (recomendado)

### Ejecutar con Maven
```bash
mvn clean javafx:run 
````

## 🏗️ Estructura del Proyecto

```text
app.scoreboard/
├── ScoreboardApp.java
│   └── Controlador principal de la aplicación JavaFX
│
├── model/
│   └── ServerData.java
│       └── Modelo de datos observable (JavaFX Properties)
│
├── ui/
│   └── ScoreboardView.java
│       └── Construcción y gestión de la interfaz gráfica
│
├── service/
│   └── DataUpdater.java
│       └── Servicio de actualización periódica de datos
│
└── config/
    └── StyleConfig.java
        └── Configuración centralizada de estilos y constantes
