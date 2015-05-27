package trab3;

import java.util.Calendar;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LibrarySystem extends Application {

    public static void main(String args[]) {
	launch(args);
	//commit pro geo
    }

	@Override
    public void start(Stage primaryStage) throws Exception {
	Biblioteca library = new Biblioteca();
	String bookFile = "books.csv";
	String userFile = "users.csv";
	String rentFile = "rents.csv";

	library.updateLib(bookFile, userFile, rentFile);

	StackPane root = new StackPane();
	Scene scene = new Scene(root, 400, 100);
	HBox hbGetDate = new HBox();
	TextField textGetDate = new TextField();
	Button btGetDate = new Button();
	
	btGetDate.setText("Enter");

	Text tGetDate = new Text();
	tGetDate.setText("Entre com a data para simular o sistema (yyyy/mm/dd) : ");
	Label lb = new Label();

	btGetDate.setOnAction(new EventHandler<ActionEvent>() {
	    @Override
	    public void handle(ActionEvent e) {

		lb.setText(textGetDate.getText());
	    }

	});
	
	String dateStr = lb.getText();
	String[] dates = dateStr.split("/");
	Calendar day = Calendar.getInstance();
	day.set(Integer.parseInt(dates[0]), Integer.parseInt(dates[1]), Integer.parseInt(dates[2]));
	
	
	VBox vbGetDate = new VBox();
	hbGetDate.getChildren().add(textGetDate);
	hbGetDate.getChildren().add(btGetDate);

	vbGetDate.getChildren().add(tGetDate);
	vbGetDate.getChildren().add(hbGetDate);

	root.getChildren().add(vbGetDate);

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
