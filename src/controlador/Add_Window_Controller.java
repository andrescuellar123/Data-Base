package controlador;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Person;
import model.Program;

public class Add_Window_Controller {

    @FXML
    private Text txtCode;

    @FXML
    private TextField txtFieldNombres;

    @FXML
    private TextField txtFieldApellidos;

    @FXML
    private CheckBox checkBoxMasculin;

    @FXML
    private CheckBox checkBoxFem;

    @FXML
    private DatePicker dateNacimiento;

    @FXML
    private TextField tfEstatura;

    @FXML
    private TextField tfNacionality;

    @FXML
    private Button btnSaveUser;

    @FXML
    private ImageView imageViewPhotoPerfil;

    @FXML
    private Button btnUploadImage;

    
    Program program;
    
    @FXML
    void femSelected(ActionEvent event) {
    	checkBoxMasculin.setSelected(false);
    }

    @FXML
    void masSelected(ActionEvent event) {
    	checkBoxFem.setSelected(false);
    }

    @FXML
    void save_User_DataBase(ActionEvent event) {
    	String name=txtFieldNombres.getText().toString();
    	String lastName=txtFieldApellidos.getText().toString();
    	String nacionality=tfNacionality.getText().toString();
    	String sex = (checkBoxMasculin.isSelected())?"M":"F";
    	String photo=" ";
    	LocalDate dateBirth= dateNacimiento.getValue();
    	int height= Integer.parseInt(tfEstatura.getText().toString().trim());
    	int code=program.getArrayListPersons().size()+1;
    	if(name.equals("")||lastName.equals("")||nacionality.equals("")||sex.equals(null)||dateBirth.equals(null)||height==0) {
			Alert alert= new Alert(AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setContentText("Por favor rellena todos los campos.");
			alert.setTitle("LLena todos los campos.");
			alert.showAndWait();
    	}
    	
    	Person p= new Person(name, lastName, nacionality, sex, photo, dateBirth, height, code);
    	
    	program.addPersonTrees(p);
    
		Alert alert= new Alert(AlertType.INFORMATION);
		alert.setHeaderText(null);
		alert.setContentText(name+" "+lastName+" ha sido agregado con el codigo |"+code+"|");
		alert.setTitle("PERSONA AGREGADA ");
		alert.showAndWait();
		
	    Node source = (Node) event.getSource();
	    Stage stage = (Stage) source.getScene().getWindow();
	    stage.close();
    	
    }

    @FXML
    void upload_Image(ActionEvent event) {

    }

	public void initializeAtribute(Program program) {
		this.program=program;
	}

	public Program getProgram() {
		return program;
	}

	


    
}

