package sample;

import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryCommandline extends DictionaryManagement {
    public static DictionaryManagement newDictionaryManagement = new DictionaryManagement ();
    protected final int maxDictionaries = 10;
    protected final int max = 100;
    Scanner in = new Scanner ( System.in );

    DictionaryCommandline ( ) {
        newDictionaryManagement = new DictionaryManagement ();
    }

    public void showAllWords ( ) {
        System.out.println ( "No\t|English\t\t|Vietnamese" );
        for (int i = 0; i < newDictionaryManagement.newDictionary.wordList.size (); i++) {
            System.out.println ( (i + 1) + "\t|" + newDictionaryManagement.newDictionary.wordList.get ( i ).word_target + "\t\t\t\t|" + newDictionaryManagement.newDictionary.wordList.get ( i ).word_explain );
        }
    }

    public void DictionaryBasic ( ) {
        newDictionaryManagement.insertFromCommandline ();
        showAllWords ();
    }

    //them vao file
    public void insertFromFile ( ) {
        Word newWord = new Word ();
        enWord ( newWord );
        newDictionaryManagement.newDictionary.wordList.add ( newWord );
    }

    public void insertFromFileWord ( Word newWord ) {
        newDictionaryManagement.newDictionary.wordList.add ( newWord );
    }

    public void dictionaryAdvanced ( ) {
        insertFromFile ();
        showAllWords ();
        newDictionaryManagement.dictionaryLookup ( "" );
    }
    boolean check(String a, String b){
        int min= a.length ()<b.length ()?a.length ():b.length ();
        for(int i=0;i<min;i++){
            if( a.toLowerCase ().charAt ( i )!= b.toLowerCase ().charAt ( i ))
                return false;
        }
        return true;
    }

    public ArrayList<String> dictionarySearcher ( String s , boolean EV , boolean dictionary ) {
        String words = "";
        String dictionaries = "";
        while (newDictionaryManagement.newDictionary.complexWordlist.size () != 0) {
            newDictionaryManagement.newDictionary.complexWordlist.remove ( 0 );
        }
        if ( EV && s.length () < 0 ) {
            return newDictionaryManagement.newDictionary.addList ();
        }
        boolean[] checkWord = new boolean[newDictionaryManagement.newDictionary.wordList.size ()];
        for (int i = 0; i < newDictionaryManagement.newDictionary.wordList.size (); i++) checkWord[i] = true;
        int i = 0;
        int n = 1;
        int x = 0;
        if ( EV && s.length () >= 1 ) for (Word w : newDictionaryManagement.newDictionary.wordList) {
            if ( w.word_target.toLowerCase ().contains ( s.toLowerCase () )&& check ( s,w.word_target ) ) {
                //System.out.print ( n + "\t" );
                //w.getWord ();
                newDictionaryManagement.newDictionary.complexWordlist
                        .add ( new complexWord ( w.word_target , w.word_explain , w.word_target.length () ) );
                words += w.word_target + " | " + w.word_explain + " \n";
                checkWord[i] = false;
                n++;
                x++;
            }
            i++;
        }
        i = 0;
        if ( !EV && s.length () > 2 ) for (Word w : newDictionaryManagement.newDictionary.wordList) {
            if ( w.word_explain.toLowerCase ().contains ( s.toLowerCase () ) && checkWord[i] ) {
                //System.out.print ( n + "\t" );
                newDictionaryManagement.newDictionary.complexWordlist
                        .add ( new complexWord ( w.word_target , w.word_explain , w.word_explain.length () ) );
                //w.getWord ();
                words += w.word_target + " | " + w.word_explain + " \n";
                n++;
                x++;
            }
            i++;
        }

        //complexWordList.showComplex ();
        for (int m = 0; m < newDictionaryManagement.newDictionary.complexWordlist.size (); m++) {
            for (int v = m; v < newDictionaryManagement.newDictionary.complexWordlist.size (); v++)
                if ( newDictionaryManagement.newDictionary.complexWordlist.get ( m ).p
                        > newDictionaryManagement.newDictionary.complexWordlist.get ( v ).p ) {
                    complexWord newComplexWord = new complexWord ( newDictionaryManagement.newDictionary.complexWordlist.get ( m ).word_target
                            , newDictionaryManagement.newDictionary.complexWordlist.get ( m ).word_explain
                            , newDictionaryManagement.newDictionary.complexWordlist.get ( m ).p );

                    newDictionaryManagement.newDictionary.complexWordlist.get ( m ).word_target
                            = newDictionaryManagement.newDictionary.complexWordlist.get ( v ).word_target;
                    newDictionaryManagement.newDictionary.complexWordlist.get ( m ).word_explain
                            = newDictionaryManagement.newDictionary.complexWordlist.get ( v ).word_explain;
                    newDictionaryManagement.newDictionary.complexWordlist.get ( m ).p
                            = newDictionaryManagement.newDictionary.complexWordlist.get ( v ).p;

                    newDictionaryManagement.newDictionary.complexWordlist.get ( v ).word_target
                            = newComplexWord.word_target;
                    newDictionaryManagement.newDictionary.complexWordlist.get ( v ).word_explain
                            = newComplexWord.word_explain;
                    newDictionaryManagement.newDictionary.complexWordlist.get ( v ).p
                            = newComplexWord.p;
                }
        }
        //newDictionaryManagement.newDictionary.showComplex ();
        int count = 0;
        for (complexWord newComplex : newDictionaryManagement.newDictionary.complexWordlist) {
            if ( count < maxDictionaries )
                dictionaries += newComplex.word_target + "\t|\t" + newComplex.word_explain + "\n";
            else break;
            count++;
        }
        int kk = 0;
        ArrayList <String> list = new ArrayList <String> ( 0 );
        for (complexWord ss : newDictionaryManagement.newDictionary.complexWordlist) {
            list.add ( ss.word_target );
        }
        return list;
    }

    public void deleteS ( String s ) {
        System.out.println ( s );
        for (int i = 0; i < newDictionaryManagement.newDictionary.wordList.size (); i++) {
            if ( newDictionaryManagement.newDictionary.wordList.get ( i ).word_target.equals ( s ) ) {
                newDictionaryManagement.newDictionary.wordList.remove ( i );
            }

        }
        for (int i = 0; i < newDictionaryManagement.newDictionary.wordList.size (); i++) {
            if ( newDictionaryManagement.newDictionary.complexWordlist.get ( i ).word_target.equals ( s ) ) {
                newDictionaryManagement.newDictionary.complexWordlist.remove ( i );
            }
        }
    }
}
