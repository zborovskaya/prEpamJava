package by.zborovskaya.task07.entity;

public class CompositeLexeme extends BaseComposite {

    public CompositeLexeme() {
        super();
    }

    @Override
    public String collect(String del) {
        return super.collect("");
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
