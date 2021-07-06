package sample;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class HBoxCell extends HBox {
    Image Speak = new Image ( "file:speaking.png" );
    ImageView speakIcon = new ImageView ( Speak );
    Image Out = new Image ( "file:output.png" );
    ImageView out = new ImageView ( Out );

    Label label = new Label ();
    Button button = new Button ();
    Button voice = new Button ();
    HBox buttonH = new HBox ( 5 );

    HBoxCell ( String labelText ) {
        super ();
        buttonH.getChildren ().addAll ( button , voice );
        label.setMaxWidth ( 500 );
        label.setMinWidth ( 430 );
        label.setText ( labelText );
        button.setAlignment ( Pos.CENTER_LEFT );
        button.setMinSize ( 30 , 20 );
        button.setGraphic ( out );
        voice.setAlignment ( Pos.CENTER_RIGHT );
        voice.setGraphic ( speakIcon );
        HBox.setHgrow ( label , Priority.ALWAYS );
        label.setMaxWidth ( 400 );
        this.getChildren ().addAll ( label , buttonH );
    }

    public Button getButton ( ) {
        return this.button;
    }

    public Label getLabel ( ) {
        return this.label;
    }

    public Button getVoice ( ) {
        return voice;
    }
}
