package com.example.javafxrana;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import animatefx.animation.*;

public class Helper {
    private Pane View;
    public void NavRouter(String file, BorderPane pane){
        try {

            View = FXMLLoader.load(getClass().getResource("/com/example/javafxrana/"+file+".fxml"));




            pane.setCenter(View);
            new SlideInRight(pane.getCenter()).play();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
