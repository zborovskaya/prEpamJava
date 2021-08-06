package by.zborovskaya.task07.entity;

public class CompositeText extends BaseComposite {
    private final  String DELIMiTER_TEXT_FIRST="\n\t";
    private final  String DELIMiTER_TEXT_SECOND="\n";

    public CompositeText() {
        super();
    }

    @Override
    public String collect(String del) {
        return "\t"+super.collect(DELIMiTER_TEXT_FIRST)+DELIMiTER_TEXT_SECOND;
    }
    @Override
    public CompositeText clone() {
        CompositeText composite = new CompositeText();
        for (ComponentText component : getListOfChildren()) {
            composite.add(component);
        }
        return composite;
    }
}
