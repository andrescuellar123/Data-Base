package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Person;
import model.Program;

public class Initial_Window_Controller implements Initializable{

    @FXML
    private TextField tfDatosGenerar;

    @FXML
    private Pane cuadroGenerar;

    @FXML
    private Pane progressBarPane;

    @FXML
    private ProgressBar progressBarGenerando;

    @FXML
    private TableView<Person> tableViewPersonas;

    @FXML
    private TableColumn<Person, String> tColumnNombrePersona;

    @FXML
    private TableColumn<Person, String> tColumnApellidoPersona;
    
    @FXML
    private TableColumn<Person, Integer> tColumnCodigo;
    
    Program program;
    private ObservableList<Person> personOBS;


    @FXML
    void btnActualizarDatosPersona(ActionEvent event) throws IOException {

    	FXMLLoader open1= new FXMLLoader(); 
    	open1.setLocation(Main.class.getResource("/view/Edit_Window.fxml"));
    	Parent root =open1.load();
    	
    	Edit_Window_Controller control =open1.getController();
    	control.initializeAtribute(program); //Le pasamos las cuentas y los empleados a la ventana principal
    	
       	Scene scene1 =new Scene(root);
    	Stage stage1 = new Stage();
    	stage1.setResizable(false);
    	stage1.initModality(Modality.APPLICATION_MODAL);// PARA QUE NO ME PERMITA VOLVER A LA VENTANA ANTERIOR SIN CERRAR LA ACTUAL
    	stage1.setScene(scene1);
    	stage1.setTitle("ACTUALIZAR PERSONAS");
    	stage1.showAndWait(); 
    	
    	this.program = control.getProgram();
    	tableColumnsPerson();
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
    	
    	Add_Window_Controller control =open1.getController();
    	control.initializeAtribute(program); //Le pasamos las cuentas y los empleados a la ventana principal
    	
       	Scene scene1 =new Scene(root);
    	Stage stage1 = new Stage();
    	stage1.setResizable(false);
    	stage1.initModality(Modality.APPLICATION_MODAL);// PARA QUE NO ME PERMITA VOLVER A LA VENTANA ANTERIOR SIN CERRAR LA ACTUAL
    	stage1.setScene(scene1);
    	stage1.setTitle("AGREGAR PERSONAS");
    	stage1.showAndWait();  
    	
    	this.program = control.getProgram();
    	tableColumnsPerson();
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
    	
    	Search_Window_Controller control =open1.getController();
    	control.initializeAtribute(program); //Le pasamos las cuentas y los empleados a la ventana principal

    	
       	Scene scene1 =new Scene(root);
    	Stage stage1 = new Stage();
    	stage1.setResizable(false);
    	stage1.initModality(Modality.APPLICATION_MODAL);// PARA QUE NO ME PERMITA VOLVER A LA VENTANA ANTERIOR SIN CERRAR LA ACTUAL
    	stage1.setScene(scene1);
    	stage1.setTitle("BUSCAR PERSONAS");
    	stage1.showAndWait();  
    	
    	this.program = control.getProgram();
    	
    }

    @FXML
    void btnGenerarDatos(ActionEvent event) {

    }

    @FXML
    void btnGuardarDatosGenerados(ActionEvent event) {

    }
    
   

    
    //FALTA HACER QUE BUSQUE EL ARCHIVO SERIALIZADO
    @Override
	public void initialize(URL location, ResourceBundle resources) {

		try {
			program = new Program();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	
	}
    

    public void tableColumnsPerson() {
    
      	personOBS = FXCollections.observableArrayList(program.getArrayListPersons());
    	tableViewPersonas.setItems(personOBS);
    	
    	tColumnNombrePersona.setCellValueFactory(new PropertyValueFactory<>("name"));
    	tColumnApellidoPersona.setCellValueFactory(new PropertyValueFactory<>("lastName"));
    	tColumnCodigo.setCellValueFactory(new PropertyValueFactory<>("code"));
    	
  
    }
    
    

}
