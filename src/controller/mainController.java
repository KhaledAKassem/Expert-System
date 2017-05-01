package controller;

import Main.Main;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSpinner;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class mainController implements Initializable {

    @FXML
    private AnchorPane spinnerPane;

    @FXML
    private Label expertLB;

    @FXML
    private ComboBox<String> problemComboBox;

    @FXML
    private GridPane gridPane;

    @FXML
    private Label welcomeLB,descLB,systemLB,toLB,descLB1;


    @FXML
    private JFXButton GoActionButton;



    Stage stage;
    Main main;

    public void Main(Main main,Stage stage) {
        this.main=main;
        this.stage=stage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        problemComboBox.getItems().addAll("Proccessor","Memory","Power Supply","Motherboard","Keyboad","Mouse","Monitor");

        FadeTransition fadeTransition00=new FadeTransition(Duration.seconds(1),spinnerPane);
        fadeTransition00.setFromValue(1);
        fadeTransition00.setToValue(0);
        fadeTransition00.play();

        FadeTransition fadeTransition1=new FadeTransition(Duration.seconds(1),gridPane);
        fadeTransition1.setFromValue(1);
        fadeTransition1.setToValue(0);
        fadeTransition1.play();

        FadeTransition fadeTransition=new FadeTransition(Duration.seconds(1),descLB);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.play();

        TranslateTransition translateTransition=new TranslateTransition(Duration.seconds(1),welcomeLB);
        translateTransition.setToY(-600);
        translateTransition.play();

        TranslateTransition translateTransition1=new TranslateTransition(Duration.seconds(1),toLB);
        translateTransition1.setToY(-600);
        translateTransition1.play();

        TranslateTransition translateTransition2=new TranslateTransition(Duration.seconds(1),expertLB);
        translateTransition2.setToY(-600);
        translateTransition2.play();

        TranslateTransition translateTransition3=new TranslateTransition(Duration.seconds(1),systemLB);
        translateTransition3.setToY(-600);
        translateTransition3.play();


        TranslateTransition translateTransition00=new TranslateTransition(Duration.seconds(1),welcomeLB);
        translateTransition00.setToY(0);
        translateTransition00.play();
        translateTransition00.setOnFinished(event -> {

            TranslateTransition translateTransition11=new TranslateTransition(Duration.seconds(0.5),toLB);
            translateTransition11.setToY(0);
            translateTransition11.play();

            translateTransition11.setOnFinished(event1 -> {
                TranslateTransition translateTransition22=new TranslateTransition(Duration.seconds(0.5),expertLB);
                translateTransition22.setToY(0);
                translateTransition22.play();
                translateTransition22.setOnFinished(event2 -> {
                    TranslateTransition translateTransition33=new TranslateTransition(Duration.seconds(0.5),systemLB);
                    translateTransition33.setToY(0);
                    translateTransition33.play();

                    translateTransition33.setOnFinished(event3 -> {
                        FadeTransition fadeTransition11=new FadeTransition(Duration.seconds(0.5),descLB);
                        fadeTransition11.setFromValue(0);
                        fadeTransition11.setToValue(1);
                        fadeTransition11.play();

                        fadeTransition11.setOnFinished(event4 -> {
                            FadeTransition fadeTransition10=new FadeTransition(Duration.seconds(0.5),gridPane);
                            fadeTransition10.setFromValue(0);
                            fadeTransition10.setToValue(1);
                            fadeTransition10.play();
                        });
                    });
                });
            });

        });

    }


    @FXML
    void GoAction(ActionEvent event) {
        FadeTransition fadeTransition00=new FadeTransition(Duration.seconds(0.5),spinnerPane);
        fadeTransition00.setFromValue(0);
        fadeTransition00.setToValue(1);
        fadeTransition00.play();

        FadeTransition fadeTransition100=new FadeTransition(Duration.seconds(5),spinnerPane);
        fadeTransition100.setFromValue(1);
        fadeTransition100.setToValue(1);
        fadeTransition100.play();
        fadeTransition100.setOnFinished(event1 -> {
            main.questionsWindow();
        });


    }


}
