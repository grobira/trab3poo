package trab3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class LibrarySystem extends Application{

	public static void main(String args[]){
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Biblioteca library = new Biblioteca();
		String bookFile = "books.cvs";
		String userFile = "users.cvs";
		String rentFile = "rents.cvs";
		
		library.updateLib(bookFile, userFile, rentFile);
		
		 StackPane root = new StackPane();
	     Scene scene = new Scene(root, 600, 600);
	     HBox hbGetDate = new HBox();
	     TextField textGetDate = new TextField();
	     Button btGetDate = new Button();
	     hbGetDate.getChildren().add(textGetDate);
	     hbGetDate.getChildren().add(btGetDate);
	     btGetDate.setText("Enter");
	     
	     btGetDate.setOnAction(event ->{
               System.out.println("elidio babaca");
              });
	     root.getChildren().add(hbGetDate);
	     
	     
	     
	     //Scene scene1 = new Scene(root, 600, 600);
	     Button btCadastro = new Button();
	     Button btListar = new Button();
	     btCadastro.setText("Realizar novo cadastro");
	     btListar.setText("Listar cadastros");    
	     
	     primaryStage.setScene(scene);
	     primaryStage.setTitle("Library System");
	     primaryStage.show();
		
	}

}
