package Controlador;

/**
 * Descripción de la clase ...
 *
 * @author ingrid.carmona@uao.edu.co , Ingrid Carmona Diaz , Código 2150147
 * @author sebastian.carmona@uao.edu.co , Sebastian Carmona , Código 2170266
 * @date 21 Septiembre 2018 - Viernes
 * @version 8.2
 */
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point3D;
import javafx.scene.control.MenuButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;

public class FXMLDocumentController extends TransformacionRotacion implements Initializable{

    private Stage stage;

    @FXML
    private MenuButton MbAcciones;

    @FXML
    private Pane Panel;

    @FXML
    private MenuButton MbAnimar;

    @FXML
    private MenuButton MbDetener;

    private Box Cubo;
    private Cylinder Cyl;
    private Sphere Sph;
    private Timeline time;
    private RotateTransition rot;
    public Timeline tm;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Pane getPanel() {
        return Panel;
    }

    public void setObjetoGeometricoCyl(Cylinder Cyl) {
        this.Cyl = Cyl;
    }

    public void setObjetoGeometricoBox(Box Cubo) {
        this.Cubo = Cubo;
    }

    public void setObjetoGeometrico(Sphere Sph) {
        this.Sph = Sph;
    }

//-------------------------------------
    @FXML
    public void BtEsfera(ActionEvent event) {
//Mostrar el esfera en pantalla y emppieza a girar
        TraslacionEsfera();
    }
    @FXML
    public void TraslacionEsfera() {
       Sph.setVisible(true);
        tm.play();
    }

    public void limite() {
        
        if (conTraslascion == -100) {
            Sigtraslacion = 1;
        } else if (conTraslascion == 300) {
            Sigtraslacion = -1;
        }
        Sph.setTranslateX(conTraslascion);
        conTraslascion += Sigtraslacion;
    }

    @FXML
    public void BtCubo(ActionEvent event) {
        //Mostrar el cubo en pantalla
    }

    @FXML
    public void BtCilindro(MouseEvent event) {
        //Empieze a aparecer aleatorio cuando es presionado
    }
    //--------------------------------

    @FXML
    public void MbAcciones(ActionEvent event) {

    }

    //-------- Cubo-----
    @FXML
    public void MbAnimar(ActionEvent event) {
        rot = new RotateTransition(Duration.seconds(3), Cubo);
        rot.setCycleCount(Animation.INDEFINITE);
        rot.setFromAngle(360);
        rot.setToAngle(-360);
        rot.setAxis(new Point3D(Math.random(), 1, Math.random()));
        rot.play();
    }

    @FXML
    public void MbDetener(ActionEvent event) {
        rot.stop();
    }

    //---------------------
    @FXML
    public void MbarInfo(ActionEvent event) {

        JOptionPane.showMessageDialog(null, "Dar click en las figuras para empezar a dar el moviemiento/n" + " en el caso de el boton cubo en acciones se da click/n "
                + "animar para empezar a generar el movimiento");
    }

    @FXML
    public void MbarCreadores(ActionEvent event) {
        JOptionPane.showMessageDialog(null, "Sebastian Carmona " + "Ingrid Carmona Diaz");
    }

    @FXML
    public void MbarOpciones(ActionEvent event) {
        MbarLimpiar(event);
        MbarSalir(event);
    }

    @FXML
    public void MbarLimpiar(ActionEvent event) { // DUDA
        double w = Panel.getWidth();
        double h = Panel.getHeight();

    }

    /**
     * Detiene el timeline y termina la aplicación.
     */
    @FXML
    public void MbarSalir(ActionEvent event) {
        System.exit(0);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //    Panel = Pane.getPoint3D();
        double w = Panel.getWidth();
        double h = Panel.getHeight();
        tm = new Timeline(new KeyFrame(Duration.seconds(0.01), (ActionEvent event) -> {
            limite();
            
        }));
        tm.setCycleCount(Animation.INDEFINITE);
        
    }

}
