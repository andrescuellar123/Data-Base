package controlador;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

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

    @FXML
    void femSelected(ActionEvent event) {

    }

    @FXML
    void masSelected(ActionEvent event) {

    }

    @FXML
    void save_User_DataBase(ActionEvent event) {

    }

    @FXML
    void upload_Image(ActionEvent event) {

    }


    
}

