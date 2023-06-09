// // Java Program to create alert of different
// // types and display them

// import javafx.application.Application;
// import javafx.scene.Scene;
// import javafx.scene.control.Button;
// import javafx.scene.layout.*;
// import javafx.event.ActionEvent;
// import javafx.event.EventHandler;
// import javafx.scene.control.*;
// import javafx.stage.Stage;
// import javafx.scene.control.Alert.AlertType;

// public class Alert_1 extends Application {

//     // launch the application
//     public void start(Stage s) {
//         // set title for the stage
//         s.setTitle("creating alerts");

//         // create a button
//         Button b = new Button("Confirmation alert");
//         Button b1 = new Button("error alert");
//         Button b2 = new Button("Information alert");
//         Button b3 = new Button("Warning alert");

//         // create a tile pane
//         TilePane r = new TilePane();

//         // create a alert
//         Alert a = new Alert(AlertType.NONE);

//         // action event
//         EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
//             public void handle(ActionEvent e) {
//                 // set alert type
//                 a.setAlertType(AlertType.CONFIRMATION);

//                 // show the dialog
//                 a.show();
//             }
//         };

//         // action event
//         EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() {
//             public void handle(ActionEvent e) {
//                 // set alert type
//                 a.setAlertType(AlertType.ERROR);

//                 // show the dialog
//                 a.show();
//             }
//         };

//         // action event
//         EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>() {
//             public void handle(ActionEvent e) {
//                 // set alert type
//                 a.setAlertType(AlertType.INFORMATION);

//                 // show the dialog
//                 a.show();
//             }
//         };

//         // action event
//         EventHandler<ActionEvent> event3 = new EventHandler<ActionEvent>() {
//             public void handle(ActionEvent e) {
//                 // set alert type
//                 a.setAlertType(AlertType.WARNING);

//                 // show the dialog
//                 a.show();
//             }
//         };

//         // when button is pressed
//         b.setOnAction(event);
//         b1.setOnAction(event1);
//         b2.setOnAction(event2);
//         b3.setOnAction(event3);

//         // add button
//         r.getChildren().add(b);
//         r.getChildren().add(b1);
//         r.getChildren().add(b2);
//         r.getChildren().add(b3);

//         // create a scene
//         Scene sc = new Scene(r, 200, 200);

//         // set the scene
//         s.setScene(sc);

//         s.show();
//     }

//     public static void main(String args[]) {
//         // launch the application
//         launch(args);
//     }
// }
import java.util.Optional;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ConfirmationAlertExample2 extends Application {

	private Label label;

	private void showConfirmation() {

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Select");
		alert.setHeaderText("Choose the sport you like:");

		ButtonType football = new ButtonType("Football");
		ButtonType badminton = new ButtonType("Badminton");
		ButtonType volleyball = new ButtonType("Volleyball");

		// Remove default ButtonTypes
		alert.getButtonTypes().clear();

		alert.getButtonTypes().addAll(football, badminton, volleyball);

		// option != null.
		Optional<ButtonType> option = alert.showAndWait();

		if (option.get() == null) {
			this.label.setText("No selection!");
		} else if (option.get() == football) {
			this.label.setText("You like Football");
		} else if (option.get() == badminton) {
			this.label.setText("You like Badminton");
		} else if (option.get() == volleyball) {
			this.label.setText("You like Volleyball");
		} else {
			this.label.setText("-");
		}
	}

	@Override
	public void start(Stage stage) {

		VBox root = new VBox();
		root.setPadding(new Insets(10));
		root.setSpacing(10);

		this.label = new Label();

		Button button = new Button("Click here to select a Sport");

		button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				showConfirmation();
			}
		});

		root.getChildren().addAll(button, label);

		Scene scene = new Scene(root, 450, 250);
		stage.setTitle("JavaFX Confirmation Alert (o7planning.org)");
		stage.setScene(scene);

		stage.show();

	}

	public static void main(String args[]) {
		launch(args);
	}

}