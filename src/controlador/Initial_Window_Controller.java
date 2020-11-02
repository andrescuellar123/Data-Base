package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Initial_Window_Controller {

    @FXML
    private TextField tfDatosGenerar;

    @FXML
    private Pane cuadroGenerar;

    @FXML
    private ProgressBar progressBarGenerando;

    @FXML
    private TableView<?> tableViewPersonas;

    @FXML
    private TableColumn<?, ?> tColumnNombrePersona;

    @FXML
    private TableColumn<?, ?> tColumnApellidoPersona;

    @FXML
    void btnActualizarDatosPersona(ActionEvent event) throws IOException {

    	FXMLLoader open1= new FXMLLoader(); 
    	open1.setLocation(Main.class.getResource("/view/Edit_Window.fxml"));
    	Parent root =open1.load();
    	
    	
       	Scene scene1 =new Scene(root);
    	Stage stage1 = new Stage();
    	stage1.setResizable(false);
    	stage1.initModality(Modality.APPLICATION_MODAL);// PARA QUE NO ME PERMITA VOLVER A LA VENTANA ANTERIOR SIN CERRAR LA ACTUAL
    	stage1.setScene(scene1);
    	stage1.setTitle("ACTUALIZAR PERSONAS");
    	stage1.showAndWait(); 
    	
    }

    /**
     * Esta action abre la ventana para agregar una persona
     * @param event
     * @throws IOException
     */
    @FXML
    void btnAgregarPersona(ActionEvent event) throws IOException {

    	FXMLLoader open1= new FXMLLoader(); 
    	open1.setLocation(Main.class.getResource("/view/Add_Window.fxml"));
    	Parent root =open1.load();
    	
    	
       	Scene scene1 =new Scene(root);
    	Stage stage1 = new Stage();
    	stage1.setResizable(false);
    	stage1.initModality(Modality.APPLICATION_MODAL);// PARA QUE NO ME PERMITA VOLVER A LA VENTANA ANTERIOR SIN CERRAR LA ACTUAL
    	stage1.setScene(scene1);
    	stage1.setTitle("AGREGAR PERSONAS");
    	stage1.showAndWait();  
    	
    }

    
    /**
     * Esta action abre la ventana para buscar una persona
     * @param event
     * @throws IOException
     */
    @FXML
    void btnBuscarPersona(ActionEvent event) throws IOException {

    	FXMLLoader open1= new FXMLLoader(); 
    	open1.setLocation(Main.class.getResource("/view/Search_Window.fxml"));
    	Parent root =open1.load();
    	
    	
       	Scene scene1 =new Scene(root);
    	Stage stage1 = new Stage();
    	stage1.setResizable(false);
    	stage1.initModality(Modality.APPLICATION_MODAL);// PARA QUE NO ME PERMITA VOLVER A LA VENTANA ANTERIOR SIN CERRAR LA ACTUAL
    	stage1.setScene(scene1);
    	stage1.setTitle("BUSCAR PERSONAS");
    	stage1.showAndWait();  
    	
    	
    }

    @FXML
    void btnGenerarDatos(ActionEvent event) {

    }

    @FXML
    void btnGuardarDatosGenerados(ActionEvent event) {

    }
    


}
