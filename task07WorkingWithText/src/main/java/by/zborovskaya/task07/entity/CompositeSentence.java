package by.zborovskaya.task07.entity;

public class CompositeSentence extends BaseComposite {

    public CompositeSentence() {
        super();
    }

    @Override
    public String collect(String del) {
        return super.collect(" ");
    }
}
