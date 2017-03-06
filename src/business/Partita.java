package business;

import application.CampoController;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Partita {
	
	static private int numGiocate;
	static private int vittorieP1;
	static private int vittorieP2;
	static private int actualGiocata;
	static private PlayableElement mossaP1;
	static private PlayableElement mossaP2;
	static private TipoGiocatori P1;
	static private TipoGiocatori P2;
	static private Stage theStage;
	static private CampoController theController;
	
	public static PlayableElement randomizeChoice(){
		PlayableElement result = null;
		int random=(int)(Math.random()*100%3);
		switch(random){
		case(0):
			result=Sasso.getInstance();
			break;
		case(1):
			result=Carta.getInstance();
			break;
		case(2):
			result=Forbice.getInstance();
			break;
		}
		return result;
	}

	public static int getNumGiocate() {
		return numGiocate;
	}

	public static void setNumGiocate(int numGiocate) {
		Partita.numGiocate = numGiocate;
	}

	public static int getVittorieP1() {
		return vittorieP1;
	}

	public static void setVittorieP1(int vittorieP1) {
		Partita.vittorieP1 = vittorieP1;
	}

	public static int getVittorieP2() {
		return vittorieP2;
	}

	public static void setVittorieP2(int vittorieP2) {
		Partita.vittorieP2 = vittorieP2;
	}

	public static TipoGiocatori getP1() {
		return P1;
	}

	public static void setP1(TipoGiocatori p1) {
		P1 = p1;
	}

	public static TipoGiocatori getP2() {
		return P2;
	}

	public static void setP2(TipoGiocatori p2) {
		P2 = p2;
	}

	public static Stage getTheStage() {
		return theStage;
	}

	public static void setTheStage(Stage theStage) {
		Partita.theStage = theStage;
	}

	public static int getActualGiocata() {
		return actualGiocata;
	}

	public static void setActualGiocata(int actualGiocata) {
		Partita.actualGiocata = actualGiocata;
	}

	public static CampoController getTheController() {
		return theController;
	}

	public static void setTheController(CampoController theController) {
		Partita.theController = theController;
	}

	public static PlayableElement getMossaP1() {
		return mossaP1;
	}

	public static void setMossaP1(PlayableElement mossaP1) {
		Partita.mossaP1 = mossaP1;
	}

	public static PlayableElement getMossaP2() {
		return mossaP2;
	}

	public static void setMossaP2(PlayableElement mossaP2) {
		Partita.mossaP2 = mossaP2;
	}
	
	public static void proceed(){
		if(Partita.getP2() == TipoGiocatori.PC){
			Partita.setMossaP2(Partita.randomizeChoice());
			try {
				Thread.sleep(700);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Partita.setMossaP1(Partita.randomizeChoice());
		String messaggio=null;
		messaggio=theController.getP1Name() + ":\t" + getMossaP1() + "\n";
		messaggio+=theController.getP2Name() + ":\t" + getMossaP2() + "\n";
		int esito=Partita.getMossaP1().result(Partita.getMossaP2());
		switch(esito){
		case -1:
			Partita.vittorieP2++;
			messaggio+="VINCE " + theController.getP2Name();
			break;
		case 1:
			Partita.vittorieP1++;
			messaggio+="VINCE " + theController.getP1Name();
			break;
		case 0:
			messaggio+="PARITA'";
			break;
		}
		giveFeedback(messaggio);
		Partita.actualGiocata++;
		Partita.getTheController().refreshCampo();
	}
	
	private static void giveFeedback(String message){
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText(null);
		alert.setContentText(message);

		alert.showAndWait();
	}
	
}
