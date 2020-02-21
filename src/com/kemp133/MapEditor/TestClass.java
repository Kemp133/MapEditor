package com.kemp133.MapEditor;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TestClass extends Application {

	@Override
	public void init() {

	}

	@Override
	public void start(Stage stage) {
		final Menu fileMenu    = new Menu("File");
		final Menu optionsMenu = new Menu("Options");
		final Menu helpMenu    = new Menu("Help");

		MenuBar menubar = new MenuBar();
		menubar.getMenus().addAll(fileMenu, optionsMenu, helpMenu);

		VBox test = new VBox(menubar);

		Scene scene = new Scene(test, 800, 600);
		stage.setTitle("Map Editor");
		stage.setResizable(false);
		stage.setMaxHeight(600);
		stage.setMaxWidth(800);

		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
