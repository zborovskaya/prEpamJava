package by.zborovskaya.task07.service.functional;

import by.zborovskaya.task07.entity.*;

import java.util.Comparator;
import java.util.List;

public class ComponentSorter {
    /**
     * Sorts paragraphs by number of sentences.
     * @param textComposite
     * @return sorted text
     */

    public BaseComposite sortParagraphs( BaseComposite textComposite)  {

        BaseComposite textClone = textComposite.clone();

        List<ComponentText> paragraphs = textClone.getListOfChildren();

        paragraphs.sort(Comparator.comparingInt(paragraph -> paragraph.getListOfChildren().size()));

        return textClone;
    }

    /**
     * Sort words by length in each sentence.
     * @param textComposite
     * @return sorted text
     */

    public BaseComposite sortWordsInSentences(BaseComposite textComposite) {

        BaseComposite textClone = textComposite.clone();

        List<ComponentText> paragraphs = textClone.getListOfChildren();
        for (ComponentText paragraph : paragraphs) {
            List<ComponentText> sentences = paragraph.getListOfChildren();
            for (ComponentText sentence : sentences) {
                List<ComponentText> lexemes = sentence.getListOfChildren();
                lexemes.sort(Comparator.comparingInt(lexeme -> lexeme.getListOfChildren().get(0)
                        .getListOfChildren().size()));
            }
        }
        return textClone;
    }

    /**
     * Sort lexemes in the text in descending order of the number of occurrences of a given character,
     * and in case of equality, alphabetically.
     * @param textComposite
     * @param symbol
     * @return sorted text
     */

    public BaseComposite sortLexemesInText(CompositeText textComposite, char symbol){
        TextOfLexemes textOfLexemes=new TextOfLexemes();
        textOfLexemes.fill(textComposite);
        Comparator<ComponentText> comp=Comparator.comparingInt(lexeme->{
                    int count=0;
                    for(ComponentText word:lexeme.getListOfChildren()){
                        for(ComponentText sym:word.getListOfChildren()){
                            LeafChar s=(LeafChar)sym;
                            if(s.getSymbol()==symbol){
                                count++;
                            }
                        }
                    }
                    return count;
                });
        textOfLexemes.getListOfChildren().sort(comp.reversed().thenComparing((firstLexeme,secondLexeme)->{
            String first=firstLexeme.collect("").toLowerCase();
            String second=secondLexeme.collect("").toLowerCase();
            return  first.compareTo(second);}));
        return textOfLexemes;
    }
}
