import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class FileManager extends Application {
    private ListView<File> fileListView = new ListView<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("File Manager");

        // Layout and UI elements
        BorderPane root = new BorderPane();
        HBox buttonBar = new HBox(10);

        Button openFolderBtn = new Button("Open Folder");
        Button deleteBtn = new Button("Delete");
        Button createFolderBtn = new Button("New Folder");

        buttonBar.getChildren().addAll(openFolderBtn, deleteBtn, createFolderBtn);
        root.setTop(buttonBar);
        root.setCenter(fileListView);

        // Event Handlers
        openFolderBtn.setOnAction(e -> openFolder(primaryStage));
        deleteBtn.setOnAction(e -> deleteSelectedFile());
        createFolderBtn.setOnAction(e -> createNewFolder());

        // Scene and Stage setup
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void openFolder(Stage stage) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File selectedDirectory = directoryChooser.showDialog(stage);
        if (selectedDirectory != null) {
            updateFileList(selectedDirectory);
        }
    }

    private void updateFileList(File directory) {
        fileListView.getItems().clear();
        File[] files = directory.listFiles();
        if (files != null) {
            fileListView.getItems().addAll(files);
        }
    }

    private void deleteSelectedFile() {
        File selectedFile = fileListView.getSelectionModel().getSelectedItem();
        if (selectedFile != null && selectedFile.delete()) {
            fileListView.getItems().remove(selectedFile);
            showAlert(Alert.AlertType.INFORMATION, "File Deleted", "File deleted successfully!");
        } else {
            showAlert(Alert.AlertType.ERROR, "Error", "Unable to delete the file.");
        }
    }

    private void createNewFolder() {
        File selectedDirectory = fileListView.getSelectionModel().getSelectedItem();
        if (selectedDirectory != null && selectedDirectory.isDirectory()) {
            File newFolder = new File(selectedDirectory, "New Folder");
            if (newFolder.mkdir()) {
                updateFileList(selectedDirectory);
                showAlert(Alert.AlertType.INFORMATION, "Folder Created", "New folder created successfully!");
            } else {
                showAlert(Alert.AlertType.ERROR, "Error", "Unable to create the folder.");
            }
        } else {
            showAlert(Alert.AlertType.ERROR, "Error", "Please select a valid directory.");
        }
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
