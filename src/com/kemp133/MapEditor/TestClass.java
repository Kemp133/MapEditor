package com.kemp133.MapEditor;

import com.kemp133.MapEditor.Lang.UILabelLanguageResources;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
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
		//region Parent Menu Items
		final Menu fileMenu = new Menu(UIText.getString("fileMenu"));
		final Menu optionMenu = new Menu(UIText.getString("optionMenu"));
		final Menu helpMenu = new Menu(UIText.getString("helpMenu"));
		//endregion

		//region File Menu Items
		final MenuItem fileMenu_new  = new MenuItem(UIText.getString("fileMenu_new"));
		final MenuItem fileMenu_open = new MenuItem(UIText.getString("fileMenu_open"));
		final MenuItem fileMenu_save = new MenuItem(UIText.getString("fileMenu_save"));
		//endregion

		//region Option Menu Items
		final MenuItem optionMenu_settings = new MenuItem(UIText.getString("optionMenu_settings"));
		//endregion

		//region Help Menu Items
		final MenuItem helpMenu_help = new MenuItem(UIText.getString("helpMenu_help"));
		//endregion

		MenuBar menubar = new MenuBar();

		fileMenu.getItems().addAll(fileMenu_new, fileMenu_open, fileMenu_save);
		optionMenu.getItems().addAll(optionMenu_settings);
		helpMenu.getItems().addAll(helpMenu_help);

		menubar.getMenus().addAll(fileMenu, optionMenu, helpMenu);

		BorderPane borderPane = new BorderPane();
		borderPane.setTop(menubar);

		ScrollPane rightMenu = new ScrollPane();
		rightMenu.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
		borderPane.setRight(rightMenu);

		Scene scene = new Scene(borderPane, 800, 600);
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
