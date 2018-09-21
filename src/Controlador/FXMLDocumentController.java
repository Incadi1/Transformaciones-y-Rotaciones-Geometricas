/**
 * En esta clase se llama a el stage y a los objetos geometricos y los parametros que estan en la interfaz
 * Se le asignan los valores a los botones , a la esfera se le hace un limite de los parametros hasta donde va a llegar
 * en la coordenada X y se inicializa un timeline
 *
 * @author ingrid.carmona@uao.edu.co , Ingrid Carmona Diaz , Código 2150147
 * @author sebastian.carmona@uao.edu.co , Sebastian Carmona , Código 2170266
 * @date 21 Septiembre 2018 - Viernes
 * @version 8.2
 */
package Controlador;

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
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FXMLDocumentController extends TransformacionRotacion implements Initializable {

    private Stage stage;

    @FXML
    private MenuButton MbAcciones;

    @FXML
    private MenuButton MbAnimar;

    @FXML
    private MenuButton MbDetener;

    @FXML
    private MenuBar MbarOpciones;

    @FXML
    private Pane Panel;

    private Box Cubo;
    private Cylinder Cyl;
    private Sphere Sph;
    private RotateTransition rot;
    public Timeline tm;

    /**
     *
     * @param stage. método.
     * @return devuelve el Panel
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Pane getPanel() {
        return Panel;
    }
    //----------------------------------------------

    /**
     * Envia los objetoa a Panel Factory
     *
     * @param Cyl, Cubo, sph. // Crea un objeto geometrico de cada uno método.
     * @return Cyl, Cubo, Sph
     */
    public void setObjetoGeometricoCyl(Cylinder Cyl) {
        this.Cyl = Cyl;
    }

    public void setObjetoGeometricoBox(Box Cubo) {
        this.Cubo = Cubo;
    }

    public void setObjetoGeometrico(Sphere Sph) {
        this.Sph = Sph;
    }

//------------------------------------------------
    /**
     * Es el boton de la esfera que inicializa el metodo
     *
     * @param event. // Recibe el evento de traslación
     * @return TraslacionEsfera.
     */
    @FXML
    public void BtEsfera(ActionEvent event) {
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
//-----------------------------------------------

    /**
     * El boton establece la visibilidad del cubo
     *
     * @param event. // Recibe el evento de visibilidad
     * @return objeto visible
     */
    @FXML
    public void BtCubo(ActionEvent event) {
        Cubo.setVisible(true);
    }
    //---------------------------------------------

    /**
     * El boton establece la visibilidad del cilindro y a su vez traslada
     * aleatoriamente al mismo
     *
     * @param event. // Recibe el evento de traslación aleatoria
     * @return objeto visible y la translacion
     */
    //Genera 1,0,1
    @FXML
    public void BtCilindro(ActionEvent event) {
//Staticos para que no se reinicien los parametros y los guardes
        int n = 100;

        Cyl.setTranslateX((Math.random() * n) + 2);
        Cyl.setTranslateY((Math.random() * n) + 2);
        Cyl.setTranslateZ((Math.random() * n) + 2);
        Cyl.setRotationAxis(new Point3D(-1, -1, 1));
        Cyl.setVisible(true);
    }

    //--------------------------------
    @FXML
    public void MbAcciones(ActionEvent event) {
    }

   //---------------------------------
    /**
     * El Menu bar inicializa la animacion del cubo 
     * @param event. // Recibe el evento de animar el cubo
     * @return animación
     */

    @FXML
    public void MbAnimar(ActionEvent event) {
        rot = new RotateTransition(Duration.seconds(3), Cubo);
        rot.setCycleCount(Animation.INDEFINITE);
        rot.setFromAngle(360);
        rot.setToAngle(-360);
        rot.setAxis(new Point3D(Math.random(), 1, Math.random()));
        rot.play();
    }
    
    /**
* El Menu bar detiene el metodo del proceso de animación
* @param event. // Recibe el evento de detener la animacion del cubo
* @return el parametro de detencion del cubo 
*/

    @FXML
    public void MbDetener(ActionEvent event) {
        rot.stop();
    }
//----------------------------------------------
/**
* El Menu bar opciones despliega el boton de salir 
* @param event. // Recibe el evento de finalizar aplicativo 
* @return salir
*/
    @FXML
    public void MbarOpciones(ActionEvent event) {
        MbarSalir(event);
    }

    @FXML
    public void MbarSalir(ActionEvent event) {
        System.exit(0);
    }
//--------------------------------------------------
/**
* Se inicializa la componente del  timeline 
* @param url, rb. // Recibe el evento del timeline 
* @return timeline
*/
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tm = new Timeline(new KeyFrame(Duration.seconds(0.01), (ActionEvent event) -> {
            limite();

        }));
        tm.setCycleCount(Animation.INDEFINITE);

    }

}
