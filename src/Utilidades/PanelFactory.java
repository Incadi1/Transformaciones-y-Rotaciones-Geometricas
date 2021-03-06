/**
 * Es en donde se crea el panel de control y se inicializa el controles
 *
 * @author ingrid.carmona@uao.edu.co , Ingrid Carmona Diaz , Código 2150147
 * @author sebastian.carmona@uao.edu.co , Sebastian Carmona , Código 2170266
 * @date 21 Septiembre 2018 - Viernes
 * @version 8.2
 */
package Utilidades;

import Controlador.FXMLDocumentController;
import Controlador.TransformacionRotacion;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Sphere;
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
    public static Node createControlPanel(Stage stage, Cylinder Cyl, Box Cubo, Sphere Sph) throws Exception {
        FXMLLoader myLoader = new FXMLLoader(TransformacionRotacion.class.getResource("/Vista/FXMLDocument.fxml"));
        Parent controles = myLoader.load();
        setUpController((FXMLDocumentController) myLoader.getController(), stage, Cyl, Cubo, Sph);

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
    private static void setUpController(FXMLDocumentController Controlador, Stage stage, Cylinder Cyl, Box Cubo, Sphere Sph) {

        Controlador.setObjetoGeometricoCyl(Cyl);
        Controlador.setObjetoGeometricoBox(Cubo);
        Controlador.setObjetoGeometrico(Sph);
    }
    //</editor-fold>

}
