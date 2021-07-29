package by.zborovskaya.task07.entity;

public class CompositeText extends BaseComposite {

    public CompositeText() {
        super();
    }

    @Override
    public String collect(String del) {
        return "\t"+super.collect("\n\t")+"\n";
    }
}
