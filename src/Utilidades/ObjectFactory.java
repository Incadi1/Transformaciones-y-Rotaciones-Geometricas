/**
* Descripción de la clase ...
* @author ingrid.carmona@uao.edu.co , Ingrid Carmona Diaz , Código 2150147  
* @author sebastian.carmona@uao.edu.co , Sebastian Carmona , Código 2170266
* @date 21 Septiembre 2018 - Viernes
* @version 8.2
*/
package Utilidades;

import javafx.geometry.Point3D;
import javafx.scene.DepthTest;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Cylinder;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;


public class ObjectFactory
{
    /**
     * Metodo que permite crear los elementos básicos de una escena 3D con el sistema de coordenadas y un
     * objeto centrado en el origen.
     * @param Cubo Objeto gráfico que compone la escena.
     * @return El nodo de la escena
     */
    //<editor-fold defaultstate="collapsed" desc="Metodo :: Node createScene3D(Node cube)">
    public static Node createScene3D(Node Cubo)
    {
        Group Escena3D = new Group();
        Escena3D.setDepthTest(DepthTest.ENABLE);
        Escena3D.getTransforms().addAll(
                new Translate(250, 250),
                new Rotate(180, Rotate.X_AXIS)
        );

        Escena3D.getChildren().add(ObjectFactory.createSystem(100.0));
        
        Escena3D.getChildren().add(Cubo);

        return Escena3D;
    }
    
    
    public static Node createScene3D(Cylinder Cylin)
    {
        Group Escena3D = new Group();
        Escena3D.setDepthTest(DepthTest.ENABLE);
        Escena3D.getTransforms().addAll(
                new Translate(250, 250),
                new Rotate(180, Rotate.X_AXIS)
        );

        Escena3D.getChildren().add(ObjectFactory.createSystem(100.0));
        Escena3D.getChildren().add(Cylin);

        return Escena3D;
    }
    //</editor-fold>

    /**
     * Metodo que permite crear los ejes en el origen del sistemas de coordenadas.
     * @param length longitud de los ejes.
     * @return Nodo del sistema de coordenadas.
     */
    //<editor-fold defaultstate="collapsed" desc="Metodo :: Node createSystem(double)">
    public static Node createSystem(double length)
    {
        Group n = new Group();

        n.getChildren().add(createXAxe(100.0));
        n.getChildren().add(createYAxe(100.0));
        n.getChildren().add(createZAxe(100.0));

        return n;
    }
    //</editor-fold>

    /**
     * Metodo que permite crear una línea que denota el eje X del sistema de coordenadas.
     * @param lenght longitud de la línea.
     * @return Nodo del eje.
     */
    //<editor-fold defaultstate="collapsed" desc="Metodo :: Node createXAxe(double)">
    private static Node createXAxe(double lenght)
    {
        Cylinder axe = new Cylinder(0.5, lenght);

        axe.setRotate(90);
        axe.setTranslateX(lenght / 2);
        axe.setMaterial(new PhongMaterial(Color.RED)); // Material
        axe.setDepthTest(DepthTest.ENABLE);

        return axe;
    }
    //</editor-fold>

    /**
     * Metodo que permite crear una línea que denota el eje Y del sistema de coordenadas.
     * @param lenght longitud de la línea.
     * @return Nodo del eje.
     */
    //<editor-fold defaultstate="collapsed" desc="Metodo :: Node createYAxe(double)">
    private static Node createYAxe(double length)
    {
        Cylinder axe = new Cylinder(0.5, length);

        axe.setTranslateY(length / 2);
        axe.setMaterial(new PhongMaterial(Color.GREEN)); // Material
        axe.setDepthTest(DepthTest.ENABLE);

        return axe;
    }
    //</editor-fold>

    /**
     * Metodo que permite crear una línea que denota el eje Z del sistema de coordenadas.
     * @param lenght longitud de la línea.
     * @return Nodo del eje.
     */
    //<editor-fold defaultstate="collapsed" desc="Metodo :: Node createZAxe(double)">
    private static Node createZAxe(double length)
    {
        Cylinder axe = new Cylinder(0.5, length);

        axe.setTranslateZ(length / 2);
        axe.setRotationAxis(new Point3D(1, 0, 0));
        axe.setRotate(90);
        axe.setMaterial(new PhongMaterial(Color.BLUE)); // Material
        axe.setDepthTest(DepthTest.ENABLE);

        return axe;
    }
    //</editor-fold>
}
