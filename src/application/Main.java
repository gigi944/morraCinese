package application;
	
import business.Partita;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Partita.setTheStage(primaryStage);
			FXMLLoader loader=new FXMLLoader(getClass().getResource("Campo.fxml"));
			GridPane root = (GridPane)loader.load();
			Partita.setTheController(loader.getController());
			Scene scene = new Scene(root,800,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			GridPane selection = (GridPane)FXMLLoader.load(getClass().getResource("Selezione.fxml"));
			Scene selectionScene = new Scene(selection);
			Stage selectionStage=new Stage();
			selectionStage.initOwner(primaryStage);
			selectionStage.initModality(Modality.WINDOW_MODAL);
			selectionStage.setScene(selectionScene);
			selectionStage.sizeToScene();
			selectionStage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
