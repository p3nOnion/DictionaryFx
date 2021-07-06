package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import org.json.simple.parser.ParseException;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static sample.Transtale.*;


public class Main extends Application {


    protected final int maxLayout = 1200;
    protected final int maxIcon = 25;
    protected final int maxWidthMenu = 400;
    protected final int maxHeightMenu = 50;
    StackPane HomePane = new StackPane ();

    Label targetLabel = new Label ();
    Label explainLabel = new Label ();


    BorderPane IndexPane = new BorderPane ();
    VBox menuIndexPane = new VBox ( 20 );
    //revIcon
    Image RIcon = new Image ( "file:rev.png" );
    ImageView revIconA = new ImageView ( RIcon );
    ImageView revIconB = new ImageView ( RIcon );
    ImageView revIconC = new ImageView ( RIcon );

    //DictionaryIcon
    Image DIcon = new Image ( "file:dictionary.png" );
    ImageView DictionaryIcon = new ImageView ( DIcon );

    Image Insert = new Image ( "file:insert.png" );
    ImageView DictionaryIsert = new ImageView ( Insert );

    Image Speak = new Image ( "file:speaking.png" );
    ImageView speakIcona = new ImageView ( Speak );
    ImageView speakIconb = new ImageView ( Speak );

    Image in = new Image ( "file:in.png" );
    ImageView Lookicon = new ImageView ( in );
    //TranslateIcon
    Image TIcon = new Image ( "file:translate.png" );
    ImageView TranslateIcon = new ImageView ( TIcon );
    BorderPane DictionariesPane = new BorderPane ();
    Button revDictionary = new Button ( "" );
    Button nextDictionary = new Button ();
    BorderPane TranslationPane = new BorderPane ();
    Button revTranslation = new Button ();
    Button nextTranslation = new Button ();
    BorderPane LookPane = new BorderPane ();
    Button revLookPane = new Button ();
    Button nextLookPane = new Button ();
    javafx.scene.control.TextField dictionary = new javafx.scene.control.TextField ();
    VBox indexTranslate = new VBox ( 20 );
    Text copyRight = new Text ( "Copyright © By YumSu" );
    Text textDictionary = new Text ( "\t\uD835\uDD07\uD835\uDD26\uD835\uDD20\uD835\uDD31\uD835\uDD26\uD835\uDD2C\uD835\uDD2B\uD835\uDD1E\uD835\uDD2F\uD835\uDD36" );
    Text textTranslation = new Text ( "\t\uD835\uDD17\uD835\uDD2F\uD835\uDD1E\uD835\uDD2B\uD835\uDD30\uD835\uDD29\uD835\uDD1E\uD835\uDD31\uD835\uDD22" );
    Button buttonTranslate = new Button ( "\uD835\uDC2D\uD835\uDC2B\uD835\uDC1A\uD835\uDC27\uD835\uDC2C\uD835\uDC25\uD835\uDC1A\uD835\uDC2D\uD835\uDC1E" );
    HBox insetTitle = new HBox ();
    Button buttonDelete = new Button ( " research " );
    List <HBoxCell> dsa = new ArrayList <> ();
    BorderPane lookDictionary = new BorderPane ();
    Button insertButton = new Button ( "    " );
    Button remoteButton = new Button ( "delete" );
    Button edit = new Button ( "edit" );
    DictionaryCommandline dictionaryCommandline = new DictionaryCommandline ();
    int keyCode = 0;

    public static void main ( String[] args ) {

        launch ( args );
//        DictionaryCommandline newDictionary= new DictionaryCommandline ();
//        newDictionary.newDictionaryManagement.insertFromfile ();
//        System.out.println ( newDictionary.newDictionaryManagement.dictionaryLookup ( "Hello" ));
//        newDictionary.newDictionaryManagement.deWord ( "Hello" );
//        System.out.println ( newDictionary.newDictionaryManagement.dictionaryLookup ( "Hello" ));
        //   connect();
//        HttpResponse <String> response = (HttpResponse <String>) Unirest.get ( "https://microsoft-azure-translation-v1.p.rapidapi.com/Speak?text=Hello%252C%20world!&language=en" )
//                .header ( "x-rapidapi-host" , "microsoft-azure-translation-v1.p.rapidapi.com" )
//                .header ( "x-rapidapi-key" , "9d42241fb9msh01cf1ee91cba250p10a735jsnd140af91fe34" )
//                .asString ();

    }

    public StackPane createContent ( ArrayList <String> e ) {
        StackPane layout = new StackPane ();
        List <HBoxCell> list = new ArrayList <> ();
        while (list.size () != 0) {
            list.remove ( 0 );
        }
        for (int i = 0; i < e.size (); i++) {
            HBoxCell newHBoxCell = new HBoxCell ( e.get ( i ).toString () );
            list.add ( newHBoxCell );
            dsa.add ( newHBoxCell );
        }
        layout.setMinSize ( 550 , 300 );
        ListView <HBoxCell> listView = new ListView <HBoxCell> ();
        ObservableList <HBoxCell> myObservableList = FXCollections.observableList ( list );
        listView.setItems ( myObservableList );

        layout.getChildren ().add ( listView );
        return layout;
    }

    public void speak ( String word , String ev ) {
        try {
            URL url = new URL ( "https://translate.google.com/translate_tts?ie=UTF-8&tl=" + ev + "&client=tw-ob&q=" + word );
            HttpURLConnection conn = (HttpURLConnection) url.openConnection ();
            conn.setRequestProperty ( "User-Agent" , "Mozilla/5.0" );
            InputStream audio = new BufferedInputStream ( conn.getInputStream () );
            new Player ( audio ).play ();
        } catch (JavaLayerException | IOException e) {
            e.printStackTrace ();
        }
    }

    public BorderPane createGridPane ( Label target , Label explain ) {
        BorderPane look = new BorderPane ();
        Look newLook = new Look ( revLookPane , target , explain , remoteButton , edit );
        //Button text= new Button("");

        look.setCenter ( newLook );
        return look;
    }

    @Override
    public void start ( Stage primaryStage ) throws FileNotFoundException {
        revDictionary.setGraphic ( revIconB );
        revLookPane.setGraphic ( revIconC );
        primaryStage.show ();
        primaryStage.setScene ( new Scene ( HomePane , maxLayout , (double) maxLayout / 1.6 ) );
        primaryStage.getIcons ().add ( new Image ( "file:icon.png" ) );
        primaryStage.setTitle ( "₵Ø₱Ⱨ₳₦ɄɆ₮(\"19020235\")" );
        primaryStage.setY ( 30 );
        primaryStage.setX ( 180 );
        dictionaryCommandline.newDictionaryManagement.insertFromfile ();


        HomePane.setStyle ( "-fx-base: #b6e7c9;-fx-font-size:15" );
        HomePane.getChildren ().add ( IndexPane );
        //copyRight
        copyRight.setTextAlignment ( TextAlignment.JUSTIFY );
        copyRight.setFont ( Font.font ( 10 ) );
        //buttontranslate
        buttonTranslate.setAlignment ( Pos.CENTER );
        //texttrans
        textTranslation.setFont ( Font.font ( 35 ) );
        textDictionary.setFont ( Font.font ( 35 ) );
        //revIcon
        revIconA.setFitWidth ( maxIcon );
        revIconA.setFitHeight ( maxIcon );
        revIconB.setFitWidth ( maxIcon );
        revIconB.setFitHeight ( maxIcon );

        revIconC.setFitWidth ( maxIcon );
        revIconC.setFitHeight ( maxIcon );


        //dictionaryIcon

        DictionaryIcon.setFitWidth ( maxWidthMenu );
        DictionaryIcon.setFitHeight ( maxHeightMenu );

        //translationIcon
        TranslateIcon.setFitWidth ( maxWidthMenu );
        TranslateIcon.setFitHeight ( maxHeightMenu );

        //setDictionary
        nextDictionary.setGraphic ( DictionaryIcon );

        //setTranslation
        nextTranslation.setGraphic ( TranslateIcon );
        revTranslation.setGraphic ( revIconA );

        //setLookPane
        nextLookPane.setText ( "Lookup" );
        //revLookPane.setGraphic ( revIcon );

        //setIndexPane
        menuIndexPane.getChildren ().addAll ( nextTranslation , nextDictionary );
        //Setting the top, bottom, center, right and left nodes to the IndexPane
        menuIndexPane.setAlignment ( Pos.CENTER );
        menuIndexPane.setPadding ( new Insets ( 100 , 100 , 100 , 100 ) );

        //IndexPane.setTop ( new javafx.scene.control.TextField ( "" ) );
        IndexPane.setBottom ( copyRight );
        //IndexPane.setLeft ( new javafx.scene.control.TextField ( "" ));
        //IndexPane.setRight ( new javafx.scene.control.TextField ( "" ) );
        IndexPane.setCenter ( menuIndexPane );

        //Setting the top, bottom, center, right and left nodes to the DictionaryPane

        HBox menuDictionary = new HBox ();
        menuDictionary.setMaxWidth ( 900 );
        textDictionary.setTextAlignment ( TextAlignment.CENTER );
        menuDictionary.getChildren ().addAll ( revTranslation , textDictionary );
        insetTitle.getChildren ().add ( revDictionary );
        DictionariesPane.setTop ( menuDictionary );

        DictionariesPane.setBottom ( copyRight );

        //DictionariesPane.setLeft ( new javafx.scene.control.TextField ( "Left" ) );
        //DictionariesPane.setRight ( new javafx.scene.control.TextField ( "Right" ) );
        VBox menuDic = new VBox ( 40 );
        //menuDic.setPadding ( new Insets ( 100,0,100,0 ) );
        //revDictionary.setGraphic ( revIcon );
        menuDic.setAlignment ( Pos.CENTER );
        menuDic.setMaxWidth ( 480 );
        menuDic.setMinWidth ( 450 );
        StackPane listStack = new StackPane ();
        listStack.setMaxWidth ( 460 );
        listStack.setMinWidth ( 450 );
        HBox insertStack = new HBox ( 10 );
        dictionary.setMinHeight ( 40 );
        insertStack.getChildren ().addAll ( dictionary , insertButton );
        insertStack.setMaxWidth ( 480 );
        insertButton.setPadding ( new Insets ( 0 , 0 , 0 , 10 ) );
        insertButton.setMaxWidth ( 5 );
        insertButton.setMinWidth ( 5 );
        insertButton.setMaxHeight ( 1 );
        insertButton.setGraphic ( DictionaryIsert );
        dictionary.setMinWidth ( 400 );
        menuDic.setMinWidth ( 500 );
        menuDic.getChildren ().addAll ( insertStack , listStack );

        //AtomicReference <GridPane> listDic= new AtomicReference <> ( new GridPane () );
        //menuDic.setPadding ( new Insets ( 0 , 0 , 0 , 0 ) );
        dictionary.setPromptText ( "\uD835\uDE0B\uD835\uDE2A\uD835\uDE24\uD835\uDE35\uD835\uDE2A\uD835\uDE30\uD835\uDE2F\uD835\uDE22\uD835\uDE33\uD835\uDE3A" );
        dictionary.setStyle ( "-fx-text-alignment:center" );
        //TextFields.bindAutoCompletion (dictionary,dictionaryCommandline.newDictionaryManagement.newDictionary.wordList);

        //remoteButtons
        remoteButton.setAlignment ( Pos.CENTER_LEFT );
        remoteButton.setLayoutX ( 400 );

        //layout.setStyle("-fx-background-color: BEIGE");
        DictionariesPane.setCenter ( menuDic );

        //Setting the top, bottom, center, right and left nodes to the TranslationPane

        indexTranslate.setAlignment ( Pos.CENTER );
        indexTranslate.setPadding ( new Insets ( 50 , 50 , 50 , 200 ) );
        TextArea en = new TextArea ();
        TextArea vi = new TextArea ();
        VBox translate = new VBox ( 50 );

        HBox menuB = new HBox ( 50 );
        Button a = new Button ();
        a.setGraphic ( speakIcona );
        a.setOnAction ( event -> {
            speak ( encodeValue ( en.getText () ) , "en" );
        } );
        Button b = new Button ();
        b.setOnAction ( event -> {
            speak ( encodeValue ( vi.getText () ) , "vi" );
        } );
        b.setGraphic ( speakIconb );
        menuB.setAlignment ( Pos.CENTER );
        menuB.getChildren ().addAll ( a , b );
        en.setPromptText ( "English" );
        en.setMinSize ( 300 , 400 );
        en.setMaxSize ( 800 , 400 );

        vi.setPromptText ( "Vietnamese" );
        vi.setMinSize ( 300 , 400 );
        vi.setMaxSize ( 800 , 400 );
        HBox menuText = new HBox ( 50 );
        menuText.getChildren ().addAll ( en , vi );
        indexTranslate.getChildren ().addAll ( menuB , menuText );
        HBox menuTrans = new HBox ();
        revTranslation.setAlignment ( Pos.TOP_LEFT );
        textTranslation.setTextAlignment ( TextAlignment.CENTER );
        menuTrans.getChildren ().addAll ( revDictionary , textTranslation );
        TranslationPane.setTop ( menuTrans );

        TranslationPane.setBottom ( copyRight );
        //TranslationPane.setLeft ( new javafx.scene.control.TextField ( "Left" ) );
        VBox menuTranslation = new VBox ( 30 );
        menuTranslation.setPadding ( new Insets ( 150 , 40 , 0 , 0 ) );
        menuTranslation.getChildren ().addAll ( buttonTranslate );
        TranslationPane.setRight ( menuTranslation );
        TranslationPane.setCenter ( indexTranslate );

        //Setting the top, bottom, center, right and left nodes to the LookPane


        LookPane.setMinSize ( 800 , 200 );
        LookPane.setTop ( revLookPane );
        //revDictionary

        revDictionary.setOnAction ( event -> {
            en.setText ( "" );
            vi.setText ( "" );
            HomePane.getChildren ().removeAll ( IndexPane , TranslationPane , DictionariesPane , LookPane );
            HomePane.getChildren ().add ( IndexPane );
        } );
        //revTranslation
        revTranslation.setOnAction ( event -> {
            dictionary.setText ( "" );
            HomePane.getChildren ().removeAll ( IndexPane , TranslationPane , DictionariesPane , LookPane );
            HomePane.getChildren ().add ( IndexPane );
        } );
        //revLookPane
        revLookPane.setOnAction ( event -> {
            HomePane.getChildren ().removeAll ( IndexPane , TranslationPane , DictionariesPane , LookPane );
            HomePane.getChildren ().add ( DictionariesPane );
        } );
        //nextTranslation
        nextTranslation.setOnAction ( event -> {
            HomePane.getChildren ().removeAll ( IndexPane , TranslationPane , DictionariesPane , LookPane );
            HomePane.getChildren ().add ( TranslationPane );

        } );
        //nextDictionary
        nextDictionary.setOnAction ( event -> {
            HomePane.getChildren ().removeAll ( IndexPane , TranslationPane , DictionariesPane , LookPane );
            HomePane.getChildren ().add ( DictionariesPane );
        } );
        //nextLookPane
        nextLookPane.setOnAction ( event -> {
            HomePane.getChildren ().removeAll ( IndexPane , TranslationPane , DictionariesPane , LookPane );
            HomePane.getChildren ().add ( LookPane );
        } );


        buttonTranslate.setOnMouseClicked ( event -> {
            menuTranslation.getChildren ().addAll ( buttonDelete );

            if ( event.getSource () == buttonTranslate ) {
                if ( en.getText ().length () == 0 && vi.getText ().length () == 0 ) {
                    en.setText ( "" );
                    vi.setText ( "" );

                } else if ( en.getText ().length () != 0 && vi.getText ().length () != 0 ) {
                    try {
                        vi.setText ( translate ( encodeValue ( en.getText () ) , "vi" , "en" ) );
                    } catch (ParseException e) {
                        e.printStackTrace ();
                    }
                } else {
                    if ( en.getText () != null && vi.getText ().length () == 0 ) {
                        try {
                            en.setText ( deString ( en.getText () ) );
                            vi.setText ( translate ( encodeValue ( en.getText () ) , "vi" , "en" ) );
                        } catch (ParseException e) {
                            e.printStackTrace ();
                        }
                    }

                    if ( vi.getText () != null && en.getText ().length () == 0 ) {
                        try {
                            vi.setText ( deString ( vi.getText () ) );
                            en.setText ( translate ( encodeValue ( vi.getText () ) , "en" , "vi" ) );
                        } catch (ParseException e) {
                            e.printStackTrace ();
                        }
                    }
                }
            }

        } );
        buttonDelete.setOnAction ( event -> {
            if ( event.getSource () == buttonDelete ) {
                en.setText ( "" );
                vi.setText ( "" );
            }
            menuTranslation.getChildren ().remove ( buttonDelete );
        } );

        edit.setOnAction ( e -> {
            BorderPane put = new BorderPane ();
            VBox cowl = new VBox ( 50 );
            javafx.scene.control.TextField insertEn = new javafx.scene.control.TextField ();
            insertEn.setPromptText ( "English" );
            insertEn.setText ( dsa.get ( keyCode ).label.getText () );
            javafx.scene.control.TextField insertVi = new javafx.scene.control.TextField ();
            insertVi.setPromptText ( "Vietnamese" );
            insertVi.setText ( dictionaryCommandline.newDictionaryManagement.dictionaryLookup ( dsa.get ( keyCode ).label.getText () ) );
            cowl.setAlignment ( Pos.CENTER );
            cowl.setPadding ( new Insets ( 200 , 250 , 100 , 250 ) );
            insertEn.setMinWidth ( 300 );
            insertVi.setMinWidth ( 300 );
            insertEn.setMaxWidth ( 400 );
            insertVi.setMaxWidth ( 400 );
            put.setStyle ( "-fx-base: #2E8B57;-fx-font-size:15" );
            cowl.setStyle ( "-fx-background-color:#D3D3D3" );
            HBox row = new HBox ( 50 );
            row.setAlignment ( Pos.CENTER );

            Button saveButton = new Button ( "Save" );
            Button notSave = new Button ( "Not Save" );
            row.getChildren ().addAll ( notSave , saveButton );
            cowl.getChildren ().addAll ( insertEn , insertVi , row );
            put.setCenter ( cowl );
            HomePane.getChildren ().add ( put );

            saveButton.setOnAction ( s -> {
                dictionaryCommandline.newDictionaryManagement.reWord ( dsa.get ( keyCode ).label.getText ()
                        , dictionaryCommandline.newDictionaryManagement.dictionaryLookup ( dsa.get ( keyCode ).label.getText () )
                        , insertEn.getText () , insertVi.getText () );

                targetLabel.setText ( insertEn.getText () );
                explainLabel.setText ( insertVi.getText () );
                HomePane.getChildren ().remove ( put );
            } );
            notSave.setOnAction ( n -> {
                HomePane.getChildren ().remove ( put );
            } );
        } );

        insertButton.setOnAction ( i -> {
            if ( dictionaryCommandline.newDictionaryManagement.checkWord ( dictionary.getText () ) ) {
                BorderPane put = new BorderPane ();
                VBox cowl = new VBox ( 50 );
                javafx.scene.control.TextField insertEn = new javafx.scene.control.TextField ();
                insertEn.setPromptText ( "English" );
                insertEn.setText ( dictionary.getText () );
                javafx.scene.control.TextField insertVi = new javafx.scene.control.TextField ();
                insertVi.setPromptText ( "Vietnamese" );
                cowl.setAlignment ( Pos.CENTER );
                cowl.setPadding ( new Insets ( 200 , 250 , 100 , 250 ) );
                insertEn.setMinWidth ( 300 );
                insertVi.setMinWidth ( 300 );
                insertEn.setMaxWidth ( 400 );
                insertVi.setMaxWidth ( 400 );
                put.setStyle ( "-fx-base: #2E8B57;-fx-font-size:15" );
                cowl.setStyle ( "-fx-background-color:#D3D3D3" );
                HBox row = new HBox ( 50 );
                row.setAlignment ( Pos.CENTER );

                Button saveButton = new Button ( "Save" );
                Button notSave = new Button ( "Not Save" );
                row.getChildren ().addAll ( notSave , saveButton );
                cowl.getChildren ().addAll ( insertEn , insertVi , row );
                put.setCenter ( cowl );
                HomePane.getChildren ().add ( put );
                saveButton.setOnAction ( s -> {
                    Word newWord = new Word ( insertEn.getText () , insertVi.getText () );
                    dictionaryCommandline.newDictionaryManagement.insertFromFx ( newWord );
                    HomePane.getChildren ().remove ( put );

                } );
                notSave.setOnAction ( n -> {
                    HomePane.getChildren ().remove ( put );
                } );
            }
        } );
        dictionary.setOnAction ( i -> {
            targetLabel.setText ( dsa.get ( 0 ).label.getText () );
            explainLabel.setText ( dictionaryCommandline.newDictionaryManagement.dictionaryLookup ( dsa.get ( 0 ).label.getText () ) );

            lookDictionary = createGridPane ( targetLabel , explainLabel );
            HomePane.getChildren ().removeAll ( IndexPane , TranslationPane , DictionariesPane , lookDictionary );
            lookDictionary.getChildren ().removeAll ( targetLabel , explainLabel );
            HomePane.getChildren ().add ( lookDictionary );
            revLookPane.setOnAction ( r -> {
                HomePane.getChildren ().removeAll ( IndexPane , TranslationPane , DictionariesPane , lookDictionary );
                HomePane.getChildren ().add ( DictionariesPane );
            } );
        } );


        dictionary.setOnKeyTyped ( keyEvent -> {
            //for(int i=0;i<dictionaryCommandline.dictionarySearcher ( dictionary.getText () , true , true ).size ();i++)

            StackPane listDic = new StackPane ();
            listStack.getChildren ().remove ( listDic );
            while (dsa.size () != 0) dsa.remove ( 0 );
            listDic = createContent ( dictionaryCommandline.dictionarySearcher ( dictionary.getText () , true , true ) );
            listStack.getChildren ().add ( listDic );
            listDic.setMaxWidth ( 400 );
            nextLookPane.setGraphic ( Lookicon );
            // System.out.println ( dictionaryCommandline.dictionarySearcher ( dictionary.getText () , true , true ) );
            for (int i = 0; i < dictionaryCommandline.dictionarySearcher ( dictionary.getText () , true , true ).size () && i < 100; i++) {
                int finalI = i;
                dsa.get ( finalI ).getVoice ().setOnAction ( v -> {
                    speak ( dsa.get ( finalI ).label.getText () , "en" );
                } );
                dsa.get ( finalI ).button.setOnAction ( e -> {
                    // noi
                    //
                    keyCode = finalI;
                    remoteButton.setMinWidth ( 30 );
                    targetLabel.setText ( dsa.get ( finalI ).label.getText () );
                    explainLabel.setText ( dictionaryCommandline.newDictionaryManagement.dictionaryLookup ( dsa.get ( finalI ).label.getText () ) );

                    lookDictionary = createGridPane ( targetLabel , explainLabel );
                    HomePane.getChildren ().removeAll ( IndexPane , TranslationPane , DictionariesPane , lookDictionary );
                    lookDictionary.getChildren ().removeAll ( targetLabel , explainLabel , remoteButton );
                    HomePane.getChildren ().add ( lookDictionary );
                    revLookPane.setOnAction ( r -> {
                        HomePane.getChildren ().removeAll ( IndexPane , TranslationPane , DictionariesPane , lookDictionary );
                        HomePane.getChildren ().add ( DictionariesPane );
                    } );
                    remoteButton.setOnAction ( d -> {
                        BorderPane xnDelete = new BorderPane ();
                        xnDelete.setStyle ( "-fx-base: #2E8B57;-fx-font-size:15;-fx-background-color:#D3D3D3" );
                        HBox row = new HBox ( 50 );
                        row.setAlignment ( Pos.CENTER );
                        Button delete = new Button ( "OK" );
                        Button notDelete = new Button ( "NO" );
                        row.getChildren ().addAll ( notDelete , delete );
                        xnDelete.setCenter ( row );
                        HomePane.getChildren ().add ( xnDelete );

                        delete.setOnAction ( s -> {
                            Word ss = new Word ( dsa.get ( finalI ).label.getText () , dictionaryCommandline.newDictionaryManagement.dictionaryLookup ( dsa.get ( finalI ).label.getText () ) );
                            //ss.getWord ();
                            //dsa.remove (finalI);
                            dictionaryCommandline.newDictionaryManagement.deWord ( dsa.get ( finalI ).label.getText () );
                            HomePane.getChildren ().removeAll ( xnDelete , IndexPane , TranslationPane , DictionariesPane , lookDictionary , LookPane );
                            dictionary.setText ( "" );
                            HomePane.getChildren ().add ( DictionariesPane );
                            HomePane.getChildren ().remove ( xnDelete );
                        } );

                        notDelete.setOnAction ( n -> {
                            HomePane.getChildren ().remove ( xnDelete );
                        } );
                    } );
                } );
            }
        } );
    }
}
