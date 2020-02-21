package com.kemp133.MapEditor;

import com.kemp133.MapEditor.Lang.UILabelLanguageResources;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ResourceBundle;

public class TestClass extends Application {

	ResourceBundle UIText;

	@Override
	public void init() {
		try {
			UIText = new UILabelLanguageResources("res/lang/EN/UILabels.csv", ",");
		} catch (Exception e) {
			e.printStackTrace();
			Platform.exit();
			System.exit(-1);
		}
	}

	@Override
	public void start(Stage stage) {
		final Menu fileMenu    = new Menu(UIText.getString("fileMenu"));
		final Menu optionMenu = new Menu(UIText.getString("optionMenu"));
		final Menu helpMenu    = new Menu(UIText.getString("helpMenu"));

		MenuBar menubar = new MenuBar();
		menubar.getMenus().addAll(fileMenu, optionMenu, helpMenu);

		VBox test = new VBox(menubar);
		GridPane pane = new GridPane();
		pane.setHgap(150);
		pane.setVgap(200);

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
