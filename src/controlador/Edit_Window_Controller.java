package controlador;

import java.time.LocalDate;
import java.util.ArrayList;
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
import javafx.stage.Stage;
import model.Person;
import model.Program;

public class Edit_Window_Controller {

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
    private TextField tfNacionality,textFieldSearchbyCode;

    @FXML
    private Button btnSaveUser;

    @FXML
    private Button btnDelteUser;

    @FXML
    private Button btnSearchUserByCode;
    
    Program program;

    
    
    @FXML
    void delete_person(ActionEvent event) {
    	
    	if(!txtFieldNombres.equals("")) {
    		int code=Integer.parseInt(textFieldSearchbyCode.getText().toString().trim());
    		String name=txtFieldNombres.getText().toString().trim();
    		String lastName=txtFieldApellidos.getText().toString().trim();
    		String nameLastName=name+" "+lastName;
    				
        	program.getAvlNames().delete(name);
        	program.getAvlLastNames().delete(lastName);
        	program.getAvlNamesLastNames().delete(nameLastName);
        	program.getAvlCode().delete(code);
        	
        	program.deleteInArrayByCode(code);
        	
        	boolean nameb = false;
        	boolean lastnameb =false;
        	for(int i=0;i<program.getAutocomplete().size();i++) {
        		
        		if(program.getAutocomplete().get(i).equals(name)&&nameb==false) {
        			program.getAutocomplete().remove(i);
        			nameb=true;
        			
          		}
        		if(program.getAutocomplete().get(i).equals(lastName)&&lastnameb==false) {
        			program.getAutocomplete().remove(i);
        			lastnameb=true;
          		}
        	}

    	}
    	
	    Node source = (Node) event.getSource();
	    Stage stage = (Stage) source.getScene().getWindow();
	    stage.close();
    }
    


    @FXML
    void femSelected(ActionEvent event) {
    	checkBoxMasculin.setSelected(false);
    }

    @FXML
    void masSelected(ActionEvent event) {
    	checkBoxFem.setSelected(false);
    }

    
    @FXML
    void save_User_DataBase(ActionEvent event) throws Exception{
    	
		int inputCode=Integer.parseInt(textFieldSearchbyCode.getText().toString());
		String name=txtFieldNombres.getText().toString().trim();
		String lastName=txtFieldApellidos.getText().toString();
		String nacionality=tfNacionality.getText().toString();
		
		Person p=program.getAvlCode().search(inputCode);

		p.setName(name);
		p.setLastName(lastName);
		p.setNacionality(nacionality);
    	p.setSex((checkBoxMasculin.isSelected())?"M":"F");
    	p.setDateBirth(dateNacimiento.getValue());
    	int height= Integer.parseInt(tfEstatura.getText().toString().trim());
    	p.setHeight(height);
    	
    	program.getAvlNames().delete(name);
    	program.getAvlNames().insert(name, p);
    	
    	program.getAvlLastNames().delete(lastName);
    	program.getAvlLastNames().insert(lastName, p);
    	
    	program.getAvlNamesLastNames().delete(name+" "+lastName);
    	program.getAvlNamesLastNames().insert(name+" "+lastName, p);
    	
    	int d=program.searchInArrayByCode(inputCode);
    	program.getArrayListPersons().remove(d);
    	program.getArrayListPersons().add(p);
    	
	    Node source = (Node) event.getSource();
	    Stage stage = (Stage) source.getScene().getWindow();
	    stage.close();
    }

    @FXML
    void search_person_edit(ActionEvent event) {

    	int inputCode=0;
		try {
			inputCode=Integer.parseInt(textFieldSearchbyCode.getText().toString().trim());
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
			Alert alert= new Alert(AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setContentText("No se ha encontrado la persona con los datos ingresados.");
			alert.setTitle("Lo lamentamos");
			alert.showAndWait();		
			}
    	
    }


	private void llenarDatosBuscado(Person p) {
		txtFieldNombres.setText(p.getName().toString());
		txtFieldApellidos.setText(p.getLastName().toString());
		if(p.getSex().equals("F")) {
			checkBoxFem.setSelected(true);
		}else {
			checkBoxMasculin.setSelected(true);
		}
		dateNacimiento.setValue(p.getDateBirth());
		tfEstatura.setText(p.getHeight()+"");
		tfNacionality.setText(p.getNacionality());

	}

	public void initializeAtribute(Program program) {
		this.program=program;
	}

	public Program getProgram() {
		return program;
	}

    

    

}
