/**
 * En esta clase se inicializan las variables y los contadores, 
 * Creamos los objetos con cada uno de sus respectivos parametros, es decir, 
 * el tamaño, la rotación y traslación de cada uno de ellos ,
 * se le asigna la luz a cada objeto y el material y textura respectiva a cada una 
 * de ellas, se agregua al root la scene3D como un hijo y se le  agrega al root el controlPanel,
 * se crea una escena con su respectiva camara.
 *
 * @author ingrid.carmona@uao.edu.co , Ingrid Carmona Diaz , Código 2150147
 * @author sebastian.carmona@uao.edu.co , Sebastian Carmona , Código 2170266
 * @date 21 Septiembre 2018 - Viernes
 * @version 8.2
 */
package Controlador;

import Utilidades.ObjectFactory;
import Utilidades.PanelFactory; 
import javafx.application.Application;
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

public class TransformacionRotacion extends Application {

    private Box Cubo;
    private Cylinder Cyl;
    private Sphere Sph;


    int contTraslacion = 0;
    int sigTraslacion = 0;
    int sigRotacion = 0;
    int angulo = 360;

    int conTraslascion = -100;
    int Sigtraslacion = 0;

/**
* Se inicializan los objetos geometricos con sus respectivas translaciones y rotaciones 
* @param stage. //recibe parametros de lectura 
método.
*/
    @Override
    public void start(Stage stage) throws Exception {

        //material
        double lado = 100;
        int n = 100;
        Cyl = new Cylinder(100, 100);
        Cyl.setTranslateX((Math.random() * n) + 2);
        Cyl.setTranslateY((Math.random() * n) + 2);
        Cyl.setTranslateZ((Math.random() * n) + 2);

        Cyl.setRotationAxis(new Point3D(-1, -1, 1));
        Cyl.setVisible(false);


        //Creacion de la esfera y tiempo de rotación y traslación
        Sph = new Sphere(100);
        Sph.setTranslateX(100);
        Sph.setTranslateY(-100);
        Sph.setTranslateZ(0);
        Sph.setRotationAxis(new Point3D(0, 1, 0));
        Sph.setVisible(false);

        //Creacion del cubo y tiempo de rotacion 
        Cubo = new Box(50, 50, 50);
        Cubo.setTranslateX(20);
        Cubo.setTranslateY(0);
        Cubo.setTranslateZ(250);
        Cubo.setRotationAxis(new Point3D(1, 1, 1));
        Cubo.setVisible(false);

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

        //-------------HIJOS DEL ROOT--------------------------
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

/**

* @param args. // De cada uno de los parámetros que recibe el
método.
*/
    public static void main(String[] args) {
        launch(args);
    }

}
