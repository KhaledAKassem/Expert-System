package controller;

import com.jfoenix.controls.JFXCheckBox;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import model.recycleViewModel;
import org.kairos.components.RippleViewRow;
import org.kairos.layouts.RecyclerView;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.CountDownLatch;

/**
 * Created by mohamed on 5/1/2017.
 */
public class questionController implements Initializable {

    @FXML
    private Label messageLB;

    @FXML
    private AnchorPane alertPane;

    @FXML
    private RecyclerView<recycleViewModel> recycleView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        alertPane.setVisible(false);
        ScaleTransition scaleTransition=new ScaleTransition(Duration.seconds(1),alertPane);
        scaleTransition.setToX(0);
        scaleTransition.setToY(0);
        scaleTransition.play();




        recycleView.setAdapter(new Adapter());
        recycleView.getItems().addAll(new recycleViewModel(),new recycleViewModel(),new recycleViewModel(),new recycleViewModel(),new recycleViewModel(),new recycleViewModel(),new recycleViewModel(),new recycleViewModel(),new recycleViewModel(),new recycleViewModel(),new recycleViewModel());

    }


    @FXML
    void OkAction(ActionEvent event) {
        ScaleTransition scaleTransition=new ScaleTransition(Duration.seconds(0.6),alertPane);
        scaleTransition.setToX(0);
        scaleTransition.setToY(0);
        scaleTransition.play();
        scaleTransition.setOnFinished(event1 -> {
            alertPane.setVisible(false);
        });

    }

    @FXML
    void submitAction(ActionEvent event) {
        alertPane.setVisible(true);

        ScaleTransition scaleTransition1=new ScaleTransition(Duration.seconds(0.6),alertPane);
        scaleTransition1.setByX(1);
        scaleTransition1.setByY(1);
        scaleTransition1.play();
    }


    public  class Adapter extends RecyclerView.Adapter<Adapter.Holder> {

        @Override
        public RecyclerView.ViewRow call(ListView listView) {
            return new RippleViewRow(this);
        }

        @Override
        public Holder onCreateViewHolder(FXMLLoader fxmlLoader) {
            fxmlLoader.setLocation(questionController.class.getResource("/view/cardView.fxml"));
            Holder holder = new Holder(fxmlLoader);

            return holder;

        }


        @Override
        public void onBindViewHolder(Holder holder, Object o) {

         recycleViewModel recycleViewModel = (recycleViewModel) o;

        }

        public class Holder extends RecyclerView.ViewHolder {

            @FXML
            private JFXCheckBox noCheckBox;

            @FXML
            private Label questionLB;

            @FXML
            private JFXCheckBox yesCheckBox;


            public Holder(FXMLLoader loader) {
                super(loader);
            }


        }
    }



}
