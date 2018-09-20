
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.fxml.FXML;
import javafx.geometry.Point3D;
import javafx.scene.control.MenuButton;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Cylinder;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FXMLDocumentController {
   
    private Stage stage;
    private Slider slider;

    @FXML
    private MenuButton MbAcciones;

    @FXML
    private Pane Panel;
    
    @FXML
    private MenuButton MbAnimar;
    
    @FXML
    private MenuButton MbDetener;

    private Cylinder Cyl;
    private Timeline Time;
    private int ContBoxTras;
    private int ContBoxRot1;
    private int ContBoxRot2;
    private int SignoBoxTras;
    private int SignoBoxRot1;
    private boolean ResetBoxRot1;
    private int SignoBoxRot2;
    private boolean ResetBoxRot2;

    /**
     * Inicializa los elementos del Controller.
     *
     * @param url la ubicacion utilizada para resolver rutas de acceso relativas
     * al objeto raíz o null si no se conoce la ubicacion.
     * @param rb los recursos utilizados para localizar el objeto raíz o null si
     * el objeto raíz no fue localizado.
     */

    public void initialize(URL url, ResourceBundle rb) {
      
        ContBoxTras = -200;
        ContBoxRot1 = 0;
        ContBoxRot2 = 0;
        SignoBoxTras = 0;
        SignoBoxRot1 = 0;
        SignoBoxRot2 = 0;
        ResetBoxRot1 = false;
        ResetBoxRot2 = false;

        Time = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        }));
        Time.setCycleCount(Animation.INDEFINITE);

        Time.play();

    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Pane getPanel() {
        return Panel;
    }

    @FXML
    public void handleDraggedSliderAngle() {
//        resetBoxRot1 = false;
//        bb3.setRotate(slAngle.getValue());        
    }

    /**
     * Activa el proceso de reseteo del cubo bb3.
     */
    @FXML
    public void handleMouseRealeasedSlider() throws InterruptedException {
        ResetBoxRot1 = true;
    }

    /**
     * Rota el cubo bb4 al activarse.
     */
    @FXML
    public void handleDraggedSliderAngle1() {
        ResetBoxRot2 = false;

    }

    /**
     * Activa el proceso de reseteo del cubo bb4.
     */
    @FXML
    public void handleMouseRealeasedSlider1() {
        ResetBoxRot2 = true;
    }

    /**
     * Detiene el timeline y termina la aplicación.
     */
    @FXML
    public void handleButtonTerminar() {
        Time.stop();
        Platform.exit();
    }

    public void setObjetoGeometrico5(Cylinder Cylinde) {
        Cylinde.setTranslateX(200);
        Cylinde.setTranslateY(100);
        Cylinde.setTranslateZ(-250);
        this.Cyl = Cylinde;
        Cylinde.setRotationAxis(new Point3D(-1, -1, 1));
    }
//-------------------------------------
    @FXML
    void BtCubo(ActionEvent event) {

    }

    @FXML
    void BtEsfera(ActionEvent event) {

    }

    @FXML
    void BtCilindro(ActionEvent event) {

    }

    @FXML
    void MbAcciones(ActionEvent event) {

    }

}
