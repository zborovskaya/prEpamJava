package by.zborovskaya.task07.entity;

public class CompositeSentence extends BaseComposite {

    public CompositeSentence() {
        super();
    }

    @Override
    public String collect(String del) {
        return super.collect(" ");
    }

    @Override
    public CompositeSentence clone() {
        CompositeSentence composite = new CompositeSentence();
        for (ComponentText component : getListOfChildren()) {
            composite.add(component);
        }
        return composite;
    }
}
