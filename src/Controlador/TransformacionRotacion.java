/**
 * Descripción de la clase ...
 *
 * @author ingrid.carmona@uao.edu.co , Ingrid Carmona Diaz , Código 2150147
 * @author sebastian.carmona@uao.edu.co , Sebastian Carmona , Código 2170266
 * @date 21 Septiembre 2018 - Viernes
 * @version 8.2
 */
package Controlador;

import Utilidades.ObjectFactory;
import Utilidades.PanelFactory;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Point3D;
import javafx.scene.AmbientLight;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TransformacionRotacion extends Application {

    private Box Cubo;
    private Cylinder Cyl;
    private Sphere Sph;

    private Timeline time;

    int contTraslacion = 0;
    int sigTraslacion = 0;
    int sigRotacion = 0;
    int angulo = 360;

    int conTraslascion = -100;
    int Sigtraslacion = 0;
    
    public Timeline tm;

    @Override
    public void start(Stage stage) throws Exception {

        //creación del Cilindro 
        double lado = 100;
        Cyl = new Cylinder(200, 200);
        Cyl.setTranslateX(200);
        Cyl.setTranslateY(100);
        Cyl.setTranslateZ(-250);
        Cyl.setRotationAxis(new Point3D(-1, -1, 1));
        //material

        //Creacion de la esfera y tiempo de rotación
        Sph = new Sphere(100);
        Sph.setTranslateX(100);
        Sph.setTranslateY(-100);
        Sph.setTranslateZ(0);
        Sph.setRotationAxis(new Point3D(0, 1, 0));
        Sph.setVisible(false);
        

        //Creacion del cubo y tiempo de rotacion 
        Cubo = new Box(50, 50, 50);
        Cubo.setTranslateX(0);
        Cubo.setTranslateY(0);
        Cubo.setTranslateZ(0);
        Cubo.setRotationAxis(new Point3D(1, 0, 0));


        //-----TEXTURAS PARA EL CUBO-------
        Image TexturasCubo = new Image(getClass().getResource("/Texturas/Cubo.jpg").toExternalForm());
        PhongMaterial material5 = new PhongMaterial();
        material5.setBumpMap(TexturasCubo);
        material5.setDiffuseMap(TexturasCubo);
        Cubo.setMaterial(material5);

        //-----TEXTURAS PARA EL CILINDRO-------
        Image TexturasCylinder = new Image(getClass().getResource("/Texturas/Cilindro.png").toExternalForm());
        PhongMaterial material6 = new PhongMaterial();
        material6.setBumpMap(TexturasCylinder);
        material6.setDiffuseMap(TexturasCylinder);
        Cyl.setMaterial(material6);

        //-----TEXTURAS PARA ELA ESFERA-------
        Image TexturasSphere = new Image(getClass().getResource("/Texturas/Esfera.png").toExternalForm());
        PhongMaterial material7 = new PhongMaterial();
        material7.setBumpMap(TexturasSphere);
        material7.setDiffuseMap(TexturasSphere);
        Sph.setMaterial(material7);

        Node controlPanel = PanelFactory.createControlPanel(stage, Cyl, Cubo, Sph);

        Node scene3D5 = ObjectFactory.createScene3D(Cubo);
        Node scene3D6 = ObjectFactory.createScene3D(Sph);
        Node scene3D7 = ObjectFactory.createScene3D(Cyl);

//-----------------CREA LAS LUCES Y SE AGREGAN LOS HIJIOS --------------------
        AmbientLight luz = new AmbientLight(Color.WHITE);     //luces (cree un AmbientLight)
        Group root = new Group();                          //Group
        root.getChildren().add(controlPanel);           //agregue al root la scene3D como un hijo
        root.getChildren().add(scene3D5);               //agregue al root el controlPanel como un hijo
        root.getChildren().add(scene3D6);               //agregue al root el controlPanel como un hijo
        root.getChildren().add(scene3D7);               //agregue al root el controlPanel como un hijo
        root.getChildren().add(luz);                         //agregue al root la luz como un hijo
//----------------------------------------------------------------------------

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.getScene().setCamera(new PerspectiveCamera());
        stage.setResizable(false);
        stage.setTitle("Rotacion General");
        stage.show();

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

    public static void main(String[] args) {
        launch(args);
    }

}
