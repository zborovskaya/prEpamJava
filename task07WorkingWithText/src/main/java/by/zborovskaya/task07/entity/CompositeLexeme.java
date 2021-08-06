package by.zborovskaya.task07.entity;

public class CompositeLexeme extends BaseComposite {
    private final  String DELIMITER_LEXEME="";

    public CompositeLexeme() {
        super();
    }

    @Override
    public String collect(String del) {
        return super.collect(DELIMITER_LEXEME);
    }
    @Override
    public CompositeLexeme clone() {
        CompositeLexeme composite = new CompositeLexeme();
        for (ComponentText component : getListOfChildren()) {
            composite.add(component);
        }
        return composite;
    }
}
