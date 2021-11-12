package com.example.interfacedemo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.*;
import java.util.*;

public class MenuController {

    @FXML
    private Button deleteMonA;

    @FXML
    private TextArea foodMonA;

    @FXML
    private TextField priceMonA;

    @FXML
    private ImageView picMonA;

    @FXML
    private Button deleteTueA;

    @FXML
    private TextArea foodTueA;

    @FXML
    private TextField priceTueA;

    @FXML
    private ImageView picTueA;

    @FXML
    private Button deleteWedA;

    @FXML
    private TextArea foodWedA;

    @FXML
    private TextField priceWedA;

    @FXML
    private ImageView picWedA;

    @FXML
    private Button deleteThuA;

    @FXML
    private TextArea foodWThuA;

    @FXML
    private TextField priceThuA;

    @FXML
    private ImageView picThuA;

    @FXML
    private Button deleteFriA;

    @FXML
    private TextArea foodWFriA;

    @FXML
    private TextField priceFriA;

    @FXML
    private ImageView picFriA;

    @FXML
    private Button deleteMonB;

    @FXML
    private TextArea foodMonB;

    @FXML
    private TextField priceMonB;

    @FXML
    private ImageView picMonB;

    @FXML
    private Button deleteTueB;

    @FXML
    private TextArea foodTueB;

    @FXML
    private TextField priceTueB;

    @FXML
    private ImageView picTueB;

    @FXML
    private Button deleteWedB;

    @FXML
    private TextArea foodWedB;

    @FXML
    private TextField priceWedB;

    @FXML
    private ImageView picWedB;

    @FXML
    private Button deleteThuB;

    @FXML
    private TextArea foodWThuB;

    @FXML
    private TextField priceThuB;

    @FXML
    private ImageView picThuB;

    @FXML
    private Button deleteFriB;

    @FXML
    private TextArea foodWFriB;

    @FXML
    private TextField priceFriB;

    @FXML
    private ImageView picFriB;

    @FXML
    private Button exit;

    String getFood(TextField food){
        return food.getText();
    }

    double getprice(TextField price){
        return Double.parseDouble(price.getText());
    }

    String getPicture(ImageView img) {
    return img.getImage().getUrl();
    }

    @FXML
    void setPicture(MouseEvent event) throws IOException {
        // imageChosser einfügen
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
        Window mainStage = null;
        File selectedFile = fileChooser.showOpenDialog(null);
        Image image = new Image(selectedFile.getAbsolutePath());

        ImageView source = (ImageView) event.getSource();
        FileInputStream input = new FileInputStream("src/main/resources/images/cloudberry.jpg");

        source.setImage(image);
    }

    @FXML
    void deleteMenu(ActionEvent event) {

        // Einfügen der Menüs und tage
       ArrayList<String> name = new ArrayList<>(Arrays.asList("deleteMonA", "deleteMonB", "deleteTueA", "deleteTueB"));
       ArrayList<TextArea> textAreas = new ArrayList<>(Arrays.asList(foodMonA, foodMonA, foodMonA));
       ArrayList<TextField> textFields=new ArrayList<>(Arrays.asList(priceMonA,priceMonA));
       ArrayList<ImageView> ImageViews=new ArrayList<>(Arrays.asList(picMonA,picMonA));
       String id = "deleteMonA";
       int index = name.indexOf(id);
       TextArea refFood = textAreas.get(index);
       TextField refPrice = textFields.get(index);
       ImageView refImage = ImageViews.get(index);

        refFood.setText("");
        refPrice.setText("");
        refImage.setImage(null);
        System.out.println("Called handler deleteMenu()");
    }

    @FXML
    void terminate(ActionEvent event) {
        System.exit(0);
    }

}