
package Main;

import javafx.application.*;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.text.*;
import javafx.scene.input.KeyCode;


public class rgba2kotlin extends Application {
private static TextField textConvert;

    
    @Override
    public void start(Stage stage) {
        Pane layout = new Pane();
        Scene scene = new Scene(layout);
        
        TextField textField = new TextField();
        double getWidth = Screen.getPrimary().getBounds().getWidth();
        double getHeight = Screen.getPrimary().getBounds().getHeight();
        
        textField.prefWidthProperty().bind(layout.widthProperty().multiply(0.8));
        textField.prefHeightProperty().bind(layout.heightProperty().multiply(0.3));
        textField.layoutXProperty().bind(layout.widthProperty().multiply(0.1));
        textField.layoutYProperty().bind(layout.heightProperty().multiply(0.2));
        textField.setStyle("-fx-border-color:black;" +
                           "-fx-border-width:1px;" +
                           "-fx-border-radius:6px;" +
                           "-fx-background-color:transparent;"
        );
        Font font = Font.loadFont(getClass().getResourceAsStream("/Font/myFont3Italic.ttf"), getWidth * 0.009);
        textField.setFont(font);
        
        textConvert = new TextField();  
        textConvert.prefWidthProperty().bind(layout.widthProperty().multiply(0.8));
        textConvert.prefHeightProperty().bind(layout.heightProperty().multiply(0.3));
        textConvert.layoutXProperty().bind(layout.widthProperty().multiply(0.1));
        textConvert.layoutYProperty().bind(layout.heightProperty().multiply(0.5));
        
        textConvert.setStyle(
                           "-fx-background-color:transparent;");
        
 
        textConvert.setAlignment(Pos.CENTER);
        textConvert.setEditable(false);
        


                textField.setOnKeyPressed(e -> {
                if (e.getCode() == KeyCode.ENTER) {
                String text = textField.getText();
                if (text.startsWith("rgba(") && text.length() > 6) {
                    
                    String inside = text.substring(5,text.length() -1 );
                    
                   String[] parts = inside.split(",");
                   if (parts.length < 4) {
                       Platform.runLater(() -> textConvert.setText("RGBA Format is not valid"));
                       return;
                               }
            
                   double alpha = Double.parseDouble(parts[3]);
                   int hasilAlpha = (int)(alpha * 255);
                   if (hasilAlpha > 255) {
                   Platform.runLater(() -> textConvert.setText("invalid alpha value"));
                   return;
                   }
                   Platform.runLater(() -> textConvert.setText("Color(" + "red = " + parts[0] + ", green =" + parts[1] + ", blue =" +parts[2] + ", alpha = " + hasilAlpha + ")" ));
                    System.out.println(text);


                };
                
                    
                }


                });

            
        
        
        layout.getChildren().addAll(textField,textConvert);
        
        stage.setTitle("rgba2kotlin v1.0.0");
        stage.setScene(scene);
        stage.setHeight(getHeight * 0.2);
        stage.setWidth(getHeight * 0.4);
        stage.setResizable(false);
        
        stage.show();
        
    }
    
    public static void main(String[] args) {
        launch();
    }
    
}
