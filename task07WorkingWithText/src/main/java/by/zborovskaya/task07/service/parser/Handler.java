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

    /**
     * Parses data
     * @param data
     * @param composite
     */

    public abstract void parse(String data, BaseComposite composite);

    /**
     * Starts the check in the next object or ends the check if we are in
     * last element in the chain.
     */
    protected void parseNext(String data,BaseComposite composite) {
            next.parse(data, composite);
    }

    /**
     * Checks for null the following parser
     * @return
     */

    protected boolean checkNext() {
        return next!=null;
    }



}
