package sample;

import java.util.ArrayList;
import java.util.List;

public class Dictionary {
    public List <Word> wordList;
    public List <complexWord> complexWordlist;
    ArrayList <String> list = new ArrayList <String> ();

    public Dictionary ( ) {
        list = new ArrayList <> ( 0 );
        wordList = new ArrayList <> ( 0 );
        complexWordlist = new ArrayList <> ( 0 );
    }

    public String showComplex ( ) {
        String s = "";
        int i = 0;
        for (complexWord cpxWordlist : complexWordlist) {
            if ( i < 10 ) s += cpxWordlist.word_target + "\t|\t" + cpxWordlist.word_explain;
            else break;
            i++;
        }
        return s;
    }

    public void showlist ( ) {
        int i = 1;
        for (Word w : complexWordlist) {
            System.out.println ( i + "\t" + w.word_target + "\t|\t" + w.word_explain );
            i++;
        }
    }


    public void showList ( ) {
        int i = 1;
        for (Word w : wordList) {
            System.out.println ( i + "\t" + w.word_target + "\t|\t" + w.word_explain );
            i++;
        }
    }

    public void remove ( complexWord newcomplexWord ) {
        Word newWord = new Word ( newcomplexWord.word_target , newcomplexWord.word_explain );
        wordList.remove ( newWord );
    }

    public ArrayList addList ( ) {
        while (list.size () != 0) {
            list.remove ( 0 );
        }
        for (Word ss : wordList) {
            list.add ( ss.word_target );
        }
        return list;
    }
}

