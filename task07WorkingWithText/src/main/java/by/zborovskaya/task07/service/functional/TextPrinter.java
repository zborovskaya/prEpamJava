package by.zborovskaya.task07.service.functional;

import by.zborovskaya.task07.entity.ComponentText;

/**
 * print text
 */
public class TextPrinter {
    public void print(ComponentText componentText){
        System.out.println(componentText.collect(""));
    }
}
