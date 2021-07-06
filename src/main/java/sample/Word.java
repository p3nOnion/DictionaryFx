package sample;

public class Word {
    String word_target;
    String word_explain;

    public Word ( String word_target , String word_explain ) {
        this.word_target = word_target;
        this.word_explain = word_explain;
    }

    public Word ( Word newWord ) {
        this.word_target = newWord.word_target;
        this.word_explain = newWord.word_explain;
    }

    public Word ( ) {
        word_explain = "";
        word_target = "";
    }

    public String getWord_target ( ) {
        return word_target;
    }

    public void setWord_target ( String word_target ) {
        this.word_target = word_target;
    }

    public void setWord_explain ( String word_explain ) {
        this.word_explain = word_explain;
    }

    public void setWord ( Word word ) {
        this.word_target = word.word_target;
        this.word_explain = word.word_explain;
    }

    public void getWord ( ) {
        System.out.println ( word_target + " \t|\t" + word_explain );
    }
}
