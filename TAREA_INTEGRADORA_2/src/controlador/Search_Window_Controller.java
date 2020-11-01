package controlador;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Search_Window_Controller implements Initializable {

    @FXML
    private TextField txtFieldBusqueda;

    @FXML
    private Button btnSearchUser;

    @FXML
    private ComboBox<String> cbParametros;

    @FXML
    private Text tfNombre;

    @FXML
    private Text tfApellido;

    @FXML
    private Text tfCodigo;

    @FXML
    private Text tfNacimiento;

    @FXML
    private Text tfGenero;

    @FXML
    private Text tfEstatura;

    @FXML
    private Text tfNacionalidad;

    @FXML
    void search_User(ActionEvent event) {

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

}
