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
    private Button exit;

    String getFood(TextField food){
        return food.getText();
    }

    double getprice(TextField price){
        return Double.valueOf(price.getText());
    }

    String getPicture(ImageView img) {
    return img.getImage().getUrl();
    }

    @FXML
    void setPicture(MouseEvent event) throws IOException {
        // imageChosser einfügen
        ImageView source = (ImageView) event.getSource();
        FileInputStream input = new FileInputStream("src/main/resources/images/cloudberry.jpg");
        Image image = new Image(input);
        source.setImage(image);
    }

    @FXML
    void deleteMenu(ActionEvent event) {
       /** TODO idee für die anwendbarkeit auf mehere Menüs anwenden.
        Button source = (Button) event.getSource();
        source.getId();
        String kennung=source.getId().toString();
        System.out.println(kennung);
        Button food=("food"+kennung)**/

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