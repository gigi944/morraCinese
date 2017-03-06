package application;

import business.Carta;
import business.Forbice;
import business.Partita;
import business.Sasso;
import business.TipoGiocatori;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CampoController {

	@FXML
	private Button buttonSassoP2;

	@FXML
	private Button buttonCartaP2;

	@FXML
	private Button buttonForbiceP2;

	@FXML
	private Label labelPlayer1;

	@FXML
	private Label labelPlayer2;

	@FXML
	private Button buttonSassoP1;

	@FXML
	private Button buttonCartaP1;

	@FXML
	private Button buttonForbiceP1;

	@FXML
	private Label labelGiocata;
	
	@FXML
    private Label labelEsito;

	@FXML
	void actionCartaP1(ActionEvent event) {
		//Partita.setMossaP1(Carta.getInstance());
	}

	@FXML
	void actionCartaP2(ActionEvent event) {
		Partita.setMossaP2(Carta.getInstance());
		this.buttonCartaP2.setDisable(true);
		this.buttonForbiceP2.setDisable(true);
		this.buttonSassoP2.setDisable(true);
		try {
			Thread.sleep(700);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Partita.proceed();
	}

	@FXML
	void actionForbiceP1(ActionEvent event) {
		//Partita.setMossaP1(Forbice.getInstance());

	}

	@FXML
	void actionForbiceP2(ActionEvent event) {
		Partita.setMossaP2(Forbice.getInstance());
		this.buttonCartaP2.setDisable(true);
		this.buttonForbiceP2.setDisable(true);
		this.buttonSassoP2.setDisable(true);
		try {
			Thread.sleep(700);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Partita.proceed();
	}

	@FXML
	void actionSassoP1(ActionEvent event) {
		//Partita.setMossaP1(Sasso.getInstance());

	}

	@FXML
	void actionSassoP2(ActionEvent event) {
		Partita.setMossaP2(Sasso.getInstance());
		this.buttonCartaP2.setDisable(true);
		this.buttonForbiceP2.setDisable(true);
		this.buttonSassoP2.setDisable(true);
		try {
			Thread.sleep(700);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Partita.proceed();
	}

	public void refreshCampo() {
		if(Partita.getActualGiocata()>Partita.getNumGiocate()){
			String esito=null;
			if(Partita.getVittorieP1()>Partita.getVittorieP2())
				esito="Ha vinto " + this.labelPlayer1.getText() + " con " + Partita.getVittorieP1() + " vittorie";
			else if(Partita.getVittorieP1()<Partita.getVittorieP2())
				esito="Ha vinto " + this.labelPlayer2.getText() + " con " + Partita.getVittorieP2() + " vittorie";
			else
				esito="Non ha vinto nessuno, pareggio.";
			this.labelEsito.setText(esito);
			return;
		}
		String player = null;
		boolean versusCPU=false;
		if (Partita.getP2() == TipoGiocatori.PC){
			player = "CPU - 2";
			versusCPU=true;
		}
		else
			player = "Player";
		this.labelPlayer1.setText("CPU - 1");
		this.labelPlayer2.setText(player);
		this.labelGiocata.setText("Giocata " + Partita.getActualGiocata() + " di " + Partita.getNumGiocate());
		
		this.buttonCartaP1.setDisable(true);
		this.buttonForbiceP1.setDisable(true);
		this.buttonSassoP1.setDisable(true);
		
		this.buttonCartaP2.setDisable(versusCPU);
		this.buttonForbiceP2.setDisable(versusCPU);
		this.buttonSassoP2.setDisable(versusCPU);
		
		if(versusCPU)
			Partita.proceed();
		
	}
	
	public String getP1Name(){
		return this.labelPlayer1.getText();
	}

	
	public String getP2Name(){
		return this.labelPlayer2.getText();
	}

}
