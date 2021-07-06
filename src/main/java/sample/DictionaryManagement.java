package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DictionaryManagement {
    Dictionary newDictionary;

    DictionaryManagement ( ) {
        newDictionary = new Dictionary ();
    }

    //them tu dien
    public void insertFromCommandline ( ) {
        Scanner in = new Scanner ( System.in );
        int n = in.nextInt ();
        for (int i = 0; i < n; i++) {
            Word newWord = new Word ();
            enWord ( newWord );
            newDictionary.wordList.add ( newWord );
        }
    }

    //doc file
    public void insertFromfile ( ) throws FileNotFoundException {
        File file = new File ( "Word.txt" );
        try (Scanner sc = new Scanner ( file )) {
            String content;
            while (sc.hasNextLine ()) {
                content = sc.nextLine ();
                String[] words = content.split ( "\t" );
                newDictionary.wordList.add ( new Word ( words[0] , words[1] ) );
            }
        }
        //file.close();
    }

    //tim kiem
    public String dictionaryLookup ( String en ) {
        for (Word word : newDictionary.wordList) {
            if ( word.word_target.equals ( en ) ) {
                return word.word_explain;
            }
        }
        return "";
    }

    //sua tu dien
    public void reWord ( String target , String explain , String a , String b ) {
        Word word = new Word ( target , explain );
        Word newWord = new Word ( a , b );
        for (int i = 0; i < newDictionary.wordList.size (); i++) {
            if ( word.word_target.equals ( newDictionary.wordList.get ( i ).word_target ) ) {
                System.out.println ( 1 );
                newDictionary.wordList.get ( i ).setWord ( newWord );
            }
        }
    }

    //xoa tu tien
    public void deWord ( String s ) {
        Scanner in = new Scanner ( System.in );
        Dictionary list = new Dictionary ();
        //String s = in.nextLine ();
        boolean[] checkWord = new boolean[newDictionary.wordList.size ()];
        for (int i = 0; i < newDictionary.wordList.size (); i++) checkWord[i] = true;
        int i = 0;
        for (Word w : newDictionary.wordList) {
            if ( w.word_target.toLowerCase ().contains ( s.toLowerCase () ) ) {
                list.wordList.add ( w );
                checkWord[i] = false;
            }
            i++;
        }
        i = 0;
        for (Word w : newDictionary.wordList) {
            if ( w.word_explain.toLowerCase ().contains ( s.toLowerCase () ) && checkWord[i] ) {
                list.wordList.add ( w );
            }
            i++;
        }
        //list.showList ();
        int a;
        //System.out.print ( "xóa từ thứ : " );
        a = 1;
        newDictionary.wordList.remove ( list.wordList.get ( a - 1 ) );
    }

    //nhap tu dien
    public void enWord ( Word newWord ) {
        Scanner in = new Scanner ( System.in );
        newWord.word_target = in.nextLine ();
        newWord.word_explain = in.nextLine ();
    }

    public void insertFromFx ( Word newWord ) {
        newDictionary.wordList.add ( newWord );
    }

    public boolean checkWord ( String s1 ) {
        for (Word s : newDictionary.wordList) {
            if ( s.word_target.equals ( s1 ) ) return false;
        }
        return true;
    }

    public void Delete ( String s ) {
        for (int i = 0; i < newDictionary.wordList.size (); i++) {
            if ( newDictionary.wordList.get ( i ).word_target.equals ( s ) ) {
                newDictionary.wordList.remove ( i );

            }
            if ( newDictionary.complexWordlist.get ( i ).word_target.equals ( s ) ) {
                newDictionary.complexWordlist.remove ( i );
            }
        }
    }
}

