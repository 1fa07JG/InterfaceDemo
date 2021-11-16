package com.example.interfacedemo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.IntStream;

public class MenuController {

    @FXML
    private Button deleteMonA;

    @FXML
    private TextArea txtAreaFoodMonA;

    @FXML
    private TextField priceMonA;

    @FXML
    private ImageView picMonA;

    @FXML
    private Button deleteTueA;

    @FXML
    private TextArea txtAreaFoodTueA;

    @FXML
    private TextField priceTueA;

    @FXML
    private ImageView picTueA;

    @FXML
    private Button deleteWedA;

    @FXML
    private TextArea txtAreaFoodWedA;

    @FXML
    private TextField priceWedA;

    @FXML
    private ImageView picWedA;

    @FXML
    private Button deleteThuA;

    @FXML
    private TextArea txtAreaFoodThuA;

    @FXML
    private TextField priceThuA;

    @FXML
    private ImageView picThuA;

    @FXML
    private Button deleteFriA;

    @FXML
    private TextArea txtAreaFoodFriA;

    @FXML
    private TextField priceFriA;

    @FXML
    private ImageView picFriA;

    @FXML
    private Button deleteMonB;

    @FXML
    private TextArea txtAreaFoodMonB;

    @FXML
    private TextField priceMonB;

    @FXML
    private ImageView picMonB;

    @FXML
    private Button deleteTueB;

    @FXML
    private TextArea txtAreaFoodTueB;

    @FXML
    private TextField priceTueB;

    @FXML
    private ImageView picTueB;

    @FXML
    private Button deleteWedB;

    @FXML
    private TextArea txtAreaFoodWedB;

    @FXML
    private TextField priceWedB;

    @FXML
    private ImageView picWedB;

    @FXML
    private Button deleteThuB;

    @FXML
    private TextArea txtAreaFoodThuB;

    @FXML
    private TextField priceThuB;

    @FXML
    private ImageView picThuB;

    @FXML
    private Button deleteFriB;

    @FXML
    private TextArea txtAreaFoodFriB;

    @FXML
    private TextField priceFriB;

    @FXML
    private ImageView picFriB;

    @FXML
    private Button exit;

    @FXML
    private Label message;

    @FXML
    private DatePicker date;

    public MenuController() {
    }

    @FXML
    private Button verify;

    @FXML
    void getWeek(InputMethodEvent event) {

        DatePicker datePicker= ((DatePicker) event.getSource());
        LocalDate date = datePicker.getValue();
        System.out.println(date);
    }

    @FXML
    void getWhite(KeyEvent event) {
        TextArea t= ((TextArea) event.getSource());
        t.getStylesheets().remove("/style.css");
                System.out.println("called get white");
    }


    @FXML
    void checkInput(ActionEvent event) {
        ArrayList<TextArea> textAreas = new ArrayList<>(Arrays.asList(txtAreaFoodMonA, txtAreaFoodMonB, txtAreaFoodTueA, txtAreaFoodTueB, txtAreaFoodWedA, txtAreaFoodWedB, txtAreaFoodThuA,
                txtAreaFoodThuB, txtAreaFoodFriA, txtAreaFoodFriB));
        int failure= 0;
        for (TextArea t : textAreas) {


            if (t.getText().equals("")) {
                t.getStylesheets().add(("/style.css"));

                System.out.println(t.getStyle());
                failure++;
                System.out.println("mindestens eine Speise hat keinen Namen ");
            }
        }
        IntStream.range(0, textAreas.size()).filter(i -> Objects.equals(textAreas.get(i).getText(), "")).forEach(i -> {
            //failure.set(failure.get() + 1);

        });
        switch ((failure)) {
            case 0 -> message.setText("");
            case 1 -> message.setText("Eine Speise hat keinen Namen ");
            default -> message.setText(failure + " Speisen haben keinen Namen ");
        }

    }
    //}

    String getFood(TextField food) {
        return food.getText();
    }

    double getPrice(TextField price) {
        return Double.parseDouble(price.getText());
    }

    String getPicture(ImageView img) {
        return img.getImage().getUrl();
    }

    @FXML
    void setPicture(MouseEvent event) throws IOException {
        // imageChooser einfügen
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Food Picture");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
        File selectedFile = fileChooser.showOpenDialog(null);
        FileInputStream file = new FileInputStream(selectedFile);
        Image image = new Image(file);

        ImageView source = (ImageView) event.getSource();

        source.setImage(image);
    }

    @FXML
    void deleteMenu(ActionEvent event) throws FileNotFoundException {

        ArrayList<String> name = new ArrayList<>(Arrays.asList("deleteMonA", "deleteMonB", "deleteTueA", "deleteTueB", "deleteWedA", "deleteWedB"
                , "deleteThuA", "deleteThuB", "deleteFriA", "deleteFriB"));
        ArrayList<TextArea> textAreas = new ArrayList<>(Arrays.asList(txtAreaFoodMonA, txtAreaFoodMonB, txtAreaFoodTueA, txtAreaFoodTueB, txtAreaFoodWedA, txtAreaFoodWedB, txtAreaFoodThuA,
                txtAreaFoodThuB, txtAreaFoodFriA, txtAreaFoodFriB));
        ArrayList<TextField> textFields = new ArrayList<>(Arrays.asList(priceMonA, priceMonB, priceTueA, priceTueB, priceWedA, priceWedB,
                priceThuA, priceThuB, priceFriA, priceFriB));
        ArrayList<ImageView> ImageViews = new ArrayList<>(Arrays.asList(picMonA, picMonB, picTueA, picTueB, picWedA, picWedB, picThuA
                , picThuB, picFriA, picFriB));
        Button b = (Button) event.getSource();
        String id = b.getId();

        int index = name.indexOf(id);
        TextArea refFood = textAreas.get(index);
        TextField refPrice = textFields.get(index);
        ImageView refImage = ImageViews.get(index);

        refFood.setText("");
        refPrice.setText("");
        FileInputStream input = new FileInputStream("src/main/resources/images/keinBild.png");
        Image noImage = new Image(input);
        refImage.setImage(noImage);
        System.out.println("Called handler deleteMenu()");
    }

    @FXML
    void terminate() {
        System.exit(0);
    }

}