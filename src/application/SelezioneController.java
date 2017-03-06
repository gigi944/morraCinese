package application;

import java.net.URL;
import java.util.ResourceBundle;

import business.MyValueFactory;
import business.Partita;
import business.TipoGiocatori;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class SelezioneController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonOK;

    @FXML
    private RadioButton radioPlayerVsPC;

    @FXML
    private ToggleGroup players;

    @FXML
    private RadioButton radioPcVsPc;

    @FXML
    private Spinner<Integer> spinnerGiocate;

    @FXML
    void initialize() {
    	//spinnerGiocate.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 7));
    	MyValueFactory mvf=new MyValueFactory();
    	mvf.setValue(1);
    	spinnerGiocate.setValueFactory(mvf);
    }
    
    @FXML
    void actionOK(ActionEvent event) {
    	Partita.setNumGiocate(this.spinnerGiocate.getValue());
    	Partita.setVittorieP1(0);
    	Partita.setVittorieP2(0);
    	Partita.setActualGiocata(1);
    	Partita.setP1(TipoGiocatori.PC);
    	if(this.radioPlayerVsPC.isSelected())
    		Partita.setP2(TipoGiocatori.Player);
    	else
    		Partita.setP2(TipoGiocatori.PC);
    	Node node= (Node)event.getSource();
    	Stage stage=(Stage) node.getScene().getWindow();
    	stage.close();
    	Partita.getTheController().refreshCampo();
    }
}
