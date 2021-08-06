package by.zborovskaya.task07.entity;

public class CompositeParagraph extends BaseComposite{
    private final  String DELIMiTER_PARAGRAPH=" ";
    public CompositeParagraph() {
        super();
    }

    @Override
    public String collect(String del) {
        return super.collect(DELIMiTER_PARAGRAPH);
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
