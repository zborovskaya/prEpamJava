package by.zborovskaya.task07.entity;

public class CompositeWord extends BaseComposite {

    public CompositeWord() {
        super();
    }

    @Override
    public String collect(String del) {
        return super.collect("");
    }

    @Override
    public CompositeWord clone() {
        CompositeWord composite = new CompositeWord();
        for (ComponentText component : getListOfChildren()) {
            composite.add(component);
        }
        return composite;
    }
}
