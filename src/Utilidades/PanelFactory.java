/**
* Descripción de la clase ...
* @author ingrid.carmona@uao.edu.co , Ingrid Carmona Diaz , Código 2150147  
* @author sebastian.carmona@uao.edu.co , Sebastian Carmona , Código 2170266
* @date 21 Septiembre 2018 - Viernes
* @version 8.2
*/
package Utilidades;

import Controlador.TransformacionRotacion;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.shape.Cylinder;
import javafx.stage.Stage;


public class PanelFactory {
     /**
     * Crea el panel del control de la aplicación que está en un archivo tipo
     * FXML.
     *
     * @param stage
     * @param Cyl
     * @param box
     * @param box1
     * @return
     * @throws Exception
     */
    //<editor-fold defaultstate="collapsed" desc="Metodo :: Node createControlPanel(Stage, ObjetoGeometrico)">
    public static Node createControlPanel(Stage stage, Cylinder Cyl) throws Exception {
        FXMLLoader myLoader = new FXMLLoader(TransformacionRotacion.class.getResource("/Vista/FXMLDocument.fxml"));
        Parent controles = myLoader.load();
        setUpController((FXMLDocumentController) myLoader.getController(), stage,  Cyl);

        return controles;
    }
    //</editor-fold>

    /**
     * Configuración del panel de control de la aplicacion.
     *
     * @param Controlador
     * @param stage
     * @param box
     */
    //<editor-fold defaultstate="collapsed" desc="Metodo :: void setUpController(FXMLController, Stage, ObjetoGeometrico)">
    private static void setUpController(FXMLDocumentController Controlador, Stage stage, Cylinder Cylinde) {

        Controlador.setObjetoGeometrico5(Cylinde);
        
    }
    //</editor-fold>

}
