package com.example.javafxjdbc.gui;

import com.example.javafxjdbc.Application;
import com.example.javafxjdbc.DepartmentListController;
import com.example.javafxjdbc.gui.util.Alerts;
import com.example.javafxjdbc.model.services.DepartmentService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

public class MainViewController implements Initializable {

    @FXML
    private MenuItem menuItemSeller;

    @FXML
    private MenuItem menuItemDepartment;

    @FXML
    private MenuItem menuItemAbout;

    @FXML
    public void onMenuItemSellerAction() {
        System.out.println("onMenuItemSellerAction");
    }
    @FXML
    public void onMenuItemDepartmentAction() {
        loadView("DepartmentList.fxml", (DepartmentListController controller) -> {
            controller.setDepartmentService(new DepartmentService());
            controller.updateTableView();
        });
    }
    @FXML
    public void onMenuItemAboutAction() {
        loadView("About.fxml", x -> {});
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    private synchronized <T> void loadView(String absoluteName, Consumer<T> initializingAction) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource(absoluteName));
            VBox newVBox = fxmlLoader.load();

            Scene scene = Application.getScene();
            VBox mainVbox = (VBox) ((ScrollPane)scene.getRoot()).getContent();

            Node mainMenu = mainVbox.getChildren().get(0);
            mainVbox.getChildren().clear();

            mainVbox.getChildren().add(mainMenu);
            mainVbox.getChildren().addAll(newVBox.getChildren());

            DepartmentListController controller = fxmlLoader.getController();
            controller.setDepartmentService(new DepartmentService());
            controller.updateTableView();

//            T controller = fxmlLoader.getController();
//            initializingAction.accept(controller);
        }
        catch (IOException e) {
            Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

}