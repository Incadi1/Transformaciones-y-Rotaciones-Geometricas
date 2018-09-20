/**
* Descripción de la clase ...
* @author ingrid.carmona@uao.edu.co , Ingrid Carmona Diaz , Código 2150147  
* @author sebastian.carmona@uao.edu.co , Sebastian Carmona , Código 2170266
* @date 21 Septiembre 2018 - Viernes
* @version 8.2
*/
package Controlador;

import Utilidades.ObjectFactory;
import Utilidades.PanelFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.AmbientLight;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Cylinder;
import javafx.stage.Stage;


public class TransformacionRotacion extends Application {
    
    Cylinder Cyl;
    
    @Override
    public void start(Stage stage) throws Exception {
        
         //creación del cubo
        double lado = 100;
        Cyl = new Cylinder(200, 200);
            //material
        Image imageDiffuseAjedrez = new Image(getClass().getResource("/Texturas/Cubo.jpg").toExternalForm());
       
        
        PhongMaterial material5 = new PhongMaterial();
        material5.setBumpMap(imageDiffuseAjedrez);
        material5.setDiffuseMap(imageDiffuseAjedrez);
           
        Cyl.setMaterial(material5);
        
        Node controlPanel = PanelFactory.createControlPanel(stage, Cyl);
        
        Node scene3D5 = ObjectFactory.createScene3D(Cyl);

        
    
        AmbientLight luz = new AmbientLight();     //luces (cree un AmbientLight)
        Group root = new Group();                          //Group
        root.getChildren().add(controlPanel);           //agregue al root la scene3D como un hijo
        root.getChildren().add(scene3D5);               //agregue al root el controlPanel como un hijo
        root.getChildren().add(luz);                         //agregue al root la luz como un hijo
       
        
        
        Scene scene = new Scene(root);

        //Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.getScene().setCamera(new PerspectiveCamera());
        stage.setResizable(false);
        stage.setTitle("Rotacion General");
        stage.show();
    }

   
    public static void main(String[] args) {
        launch(args);
    }
    
}
