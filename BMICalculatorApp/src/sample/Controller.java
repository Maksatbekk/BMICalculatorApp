package sample;
import javafx.application.Application;

import javafx.stage.Stage;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import javafx.scene.control.TextField;


public class Controller {
    @FXML
    private TextField WeightTextField;

    @FXML
    private TextField HeightTextField;

    @FXML
    private TextField BMITextField;

    @FXML
    private ImageView image_view;

    @FXML
    private TextField Info;


    Image image = new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTGYtCKM4pEbeJMwvZPgwMJz6ikkKq5zN-fLlhCBv0sv8B_k7g5" , 120, 120, false, false);
    Image norm = new Image("https://www.normal.eu/media/1311/normal_logo_sort.png" ,120, 120, false, false);
    Image under = new Image("https://f4.bcbits.com/img/a2257530062_10.jpg", 120, 120, false, false);
    Image obese = new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTViakMgM66tGQ9-U8OqawSFTY3ULWfJ_3Bvsdp0hF2AkP1pxJ0", 120, 120, false, false);
    Image overw = new Image("https://c8.alamy.com/comp/GJFJ77/health-concept-black-text-overweight-under-the-piece-of-torn-paper-GJFJ77.jpg", 120, 120, false, false);

    @FXML
    void calculateButtonPressed(ActionEvent event) {

        try {
            Double Weight = new Double(WeightTextField.getText());
            Double Height = new Double(HeightTextField.getText());
            Double BMI = (Weight) / Math.pow(Height, 2);


            if (BMI<=18.5) {
                Info.setText("Underweight");
                image_view.setImage(under);
            } else if (18.5 < BMI && BMI <=24.9) {
                Info.setText("Normal");
                image_view.setImage(norm);
            } else if (25.0 <= BMI && BMI <= 29.9) {
                Info.setText("Overweight");
                image_view.setImage(overw);
            } else {
                Info.setText("Obese");
                image_view.setImage(obese);
            }

            BMITextField.setText(BMI.toString());
        }catch (NumberFormatException ex){
            WeightTextField.setText("Enter your kilo!");
            WeightTextField.selectAll();
            HeightTextField.setText("Enter your height");
            HeightTextField.selectAll();
            WeightTextField.requestFocus();
            HeightTextField.requestFocus();
        }
    }

}