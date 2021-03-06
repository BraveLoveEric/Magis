package com.magis.app.test;

import com.magis.app.Main;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class ExamResultPage {

    private VBox vBox;
    private Button button;

    //F, D, C, B, A, A+ Perfect
    private static String[] colors = {"#f44336", "#f57c00", "#d4e157", "#9ccc65", "#36c246", "#00c853"};

    public ExamResultPage(Double grade) {
        vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);

        StackPane topGrade = new StackPane();
        topGrade.setPadding(new Insets(50,0,50,0));

        Circle circle = new Circle();
        circle.setRadius(85);
        circle.getStyleClass().add("drop-shadow");
        circle.setFill(Paint.valueOf(calculateColor(grade)));

        Text gradeText = new Text(grade.toString() + "%");
        gradeText.getStyleClass().add("grade-text");

        topGrade.getChildren().addAll(circle, gradeText);

        button = new Button("Click to view your results.");
        button.setOnMouseEntered(e -> Main.scene.setCursor(Cursor.HAND));
        button.setOnMouseExited(e -> Main.scene.setCursor(Cursor.DEFAULT));
        button.getStyleClass().addAll("grade-main-text", "drop-shadow");
        button.setStyle("-fx-background-color: " + calculateColor(grade));

        vBox.getChildren().addAll(topGrade, button);
    }

    public VBox getvBox() {
        return vBox;
    }

    public Button getButton() {
        return button;
    }

    /**
     * Return a grade color from the array of hex colors
     * @param grade the student's score
     * @return a hex color in string format
     */
    public static String calculateColor(Double grade) {
        /*
        Examples:

        95 is the grade
        (int) 95 / 10 = 9
        9 - 5 = 4;
        colors[4] = green

        32 is the grade
        (int) 32 / 10 = 3;
        3 - 5 = -2
        max(-2, 0) = 0
        colors[0] = red

         */
        int index = (int) (grade / 10) - 5;
        index = Integer.max(index, 0);
        return colors[index];
    }
}
