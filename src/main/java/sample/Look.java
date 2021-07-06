package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class Look extends BorderPane {
    public Look ( Button rev , Label target , Label explaint , Button remote , Button edit ) {
        super ();
        //Button test = new Button("test");
        this.setTop ( rev );
        HBox menus = new HBox ( 30 );
        menus.setAlignment ( Pos.CENTER );
        //explaint.setPadding ( new Insets ( 0 , 0 , 0 , 100 ) );
        menus.setPadding ( new Insets ( 0 , 100 , 0 , 0 ) );
        this.setRight ( menus );
        target.setFont ( Font.font ( 20 ) );
        explaint.setFont ( Font.font ( 20 ) );
        menus.getChildren ().addAll ( remote , edit );
        VBox menu = new VBox ( 10 );
        VBox tudien = new VBox ( 30 );
        tudien.getChildren ().addAll ( target , explaint );
        menu.setMinWidth ( 450 );
        menu.getChildren ().add ( tudien );
        menu.setAlignment ( Pos.CENTER );
        menu.setPadding ( new Insets ( 50 , 200 , 50 , 300 ) );
        tudien.setMinWidth ( 450 );
        this.setCenter ( menu );
    }
}
