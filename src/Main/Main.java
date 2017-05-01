package Main;

import controller.mainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

    Stage mainStage,questionsStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
     this.mainStage=primaryStage;
     mainWindow();
    }


    public void mainWindow(){
      try {

          FXMLLoader loader = new FXMLLoader(Main.class.getClass().getResource("/view/mainScreen.fxml"));
          AnchorPane pane = loader.load();

          mainController controller=loader.getController();
          controller.Main(this,mainStage);
          Scene scene=new Scene(pane);
          mainStage.setScene(scene);
          mainStage.setTitle("Expert System");
          mainStage.setResizable(true);
          scene.getStylesheets().add(Main.class.getResource("/style/StyleSheet.css").toExternalForm());
          mainStage.getIcons().addAll(new Image("/src/lee-campbell-86958.jpg"));
          mainStage.show();
      }catch (Exception e){
          e.printStackTrace();
      }
    }


    public void questionsWindow(){
        try {

            FXMLLoader loader = new FXMLLoader(Main.class.getClass().getResource("/view/questionsScreen.fxml"));
            AnchorPane pane = loader.load();
            Scene scene=new Scene(pane);
            questionsStage=new Stage();
            questionsStage.setScene(scene);
            questionsStage.setTitle("Expert System");
            questionsStage.setResizable(true);
            scene.getStylesheets().add(Main.class.getResource("/style/StyleSheet.css").toExternalForm());
              mainStage.getIcons().addAll(new Image("/src/lee-campbell-86958.jpg"));
            questionsStage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
