package by.zborovskaya.task07.control.command;

import by.zborovskaya.task07.entity.BaseComposite;
import by.zborovskaya.task07.entity.CompositeText;
import by.zborovskaya.task07.service.functional.ComponentSorter;
import by.zborovskaya.task07.service.functional.CompositeTextCreator;

public class SortingParagraphsCom implements Command{
    private final String DELIMITER="";

    @Override
    public String execute(String path) {
        CompositeTextCreator creator=new CompositeTextCreator();
        CompositeText compositeText= creator.create(path);
        ComponentSorter sorter=new ComponentSorter();
        BaseComposite newText=sorter.sortParagraphs(compositeText);
        return newText.collect(DELIMITER);
    }
}
