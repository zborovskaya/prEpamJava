package by.zborovskaya.task07.entity;

public class CompositeParagraph extends BaseComposite{
    public CompositeParagraph() {
        super();
    }

    @Override
    public String collect(String del) {
        return super.collect(" ");
    }

    @Override
    public CompositeParagraph clone() {
        CompositeParagraph composite = new CompositeParagraph();
        for (ComponentText component : getListOfChildren()) {
            composite.add(component);
        }
        return composite;
    }
}
