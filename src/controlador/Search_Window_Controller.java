package controlador;

import java.awt.ScrollPane;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import org.controlsfx.control.textfield.TextFields;

import com.sun.javafx.scene.control.skin.TextFieldSkin;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.DragEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;
import model.Person;
import model.Program;
import structure.AVLTree;

public class Search_Window_Controller implements Initializable {

    @FXML
    private TextField txtFieldBusqueda;

    @FXML
    private Button btnSearchUser;

    @FXML
    private ComboBox<String> cbParametros;

    @FXML
    private Text tNombre;

    @FXML
    private Text tApellido;

    @FXML
    private Text tCodigo;

    @FXML
    private Text tNacimiento;

    @FXML
    private Text tGenero;

    @FXML
    private Text tEstatura;

    @FXML
    private Text tNacionalidad;
 
    
    Program program;
    
    @FXML
    void characterAddedForSearch(KeyEvent event) {
    	
    }
    


    

    
    @FXML
    void search_User(ActionEvent event) {
    	String parameter = cbParametros.getSelectionModel().getSelectedItem();
    	String inputString = txtFieldBusqueda.getText().toString().trim();
    	int inputCode = 0;
    	
    	
    	if(parameter==null) {
			Alert alert= new Alert(AlertType.INFORMATION);
			alert.setHeaderText(null);
			alert.setContentText("Por favor elige un parámetro de busqueda.");
			alert.setTitle("Elige un parámetro.");
			alert.showAndWait();
    	}else {
    	
    	switch (parameter) {
		case "NOMBRE":
			Person pNombre = program.getAvlNames().search(inputString);
			
			if(pNombre!=null) {
				llenarDatosBuscado(pNombre);
			}else {
				notFoundAlert();
			}
			break;
			
		case "APELLIDO":
			Person pApellido = program.getAvlLastNames().search(inputString);
		

			if(pApellido!=null) {
				llenarDatosBuscado(pApellido);
			}else {
				notFoundAlert();
			}
			
			break;
			
		case "NOMBRE Y APELLIDO":
			Person pApellidoNombre =program.getAvlNamesLastNames().search(inputString);
			

			
			if(pApellidoNombre!=null) {
				llenarDatosBuscado(pApellidoNombre);
			}else {
				notFoundAlert();
			}
			break;
			
		case "CODIGO":
			try {
				inputCode=Integer.parseInt(inputString);
			}catch (Exception e) {
				Alert alert= new Alert(AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setContentText("Por favor ingresa un valor numerico.");
				alert.setTitle("Lo lamentamos");
				alert.showAndWait();
			}
			Person pCode=program.getAvlCode().search(inputCode);
			if(pCode!=null) {
				llenarDatosBuscado(pCode);
			}else {
				notFoundAlert();
			}
			break;

		}
    	
    	}
    	
    }
    
    
    private void notFoundAlert() {
		Alert alert= new Alert(AlertType.ERROR);
		alert.setHeaderText(null);
		alert.setContentText("No se ha encontrado la persona con los datos ingresados.");
		alert.setTitle("Lo lamentamos");
		alert.showAndWait();
    }
    
    
    private void llenarDatosBuscado(Person p) {
    		tNombre.setText("Nombre: "+p.getName());
    		tApellido.setText("Apellido: "+p.getLastName());
    		tCodigo.setText("Código: "+p.getCode()+"");
    		tEstatura.setText("Estatura: "+p.getHeight()+" cm");
    		tGenero.setText("Género: "+p.getSex());
    		tNacionalidad.setText("Nacionalidad: "+p.getNacionality());
    		tNacimiento.setText("Nacimiento: "+p.getDateBirth());
    	
    	
    }
    
	/**
	 * Este método llena el ComboBox con las opciones para BUSCAR.
	 */
	public void agregarParametrosBuscar() {
		
		List<String> parametros=new ArrayList<String>();
		ObservableList<String> te;
		parametros.add("NOMBRE");
		parametros.add("APELLIDO");
		parametros.add("NOMBRE Y APELLIDO");
		parametros.add("CODIGO");
		te=FXCollections.observableArrayList(parametros);
		cbParametros.setItems(te);
	}
	
	
	

    /**
     * Inicializa la ventana con el ComboBox ya lleno.
     */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		agregarParametrosBuscar();
		

	}

	public void initializeAtribute(Program program) {
		
		this.program=program;

		String parameter = cbParametros.getSelectionModel().getSelectedItem();

		TextFields.bindAutoCompletion(txtFieldBusqueda, program.autoCompleteName(txtFieldBusqueda.getText()));	


		
	}

	public Program getProgram() {
		return program;
	}

	
	
	
}
