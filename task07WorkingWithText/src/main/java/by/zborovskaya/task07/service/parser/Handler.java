package by.zborovskaya.task07.service.parser;

import by.zborovskaya.task07.entity.BaseComposite;

abstract public class Handler {
    private Handler next;

    public Handler() {
        this.next = null;
    }

    public Handler(Handler handler) {
        this.next = handler;
    }

    public abstract void parse(String data, BaseComposite composite);

    /**
     * Запускает проверку в следующем объекте или завершает проверку, если мы в
     * последнем элементе цепи.
     */
    protected void parseNext(String data,BaseComposite composite) {
            next.parse(data, composite);
    }

    protected boolean checkNext() {
        return next!=null;
    }



}
