package by.zborovskaya.task07.entity;

import java.util.ArrayList;
import java.util.Objects;

abstract public class BaseComposite implements ComponentText{
    private ArrayList<ComponentText> components;
    protected BaseComposite(){
        this.components=new ArrayList<>();
    }

    public void add(ComponentText component){
        components.add(component);
    }

    public void remove(ComponentText component){
        components.remove(component);
    }

    public ComponentText getChild(int index) {
        return components.get(index);
    }


    public ArrayList<ComponentText> getListOfChildren(){return components;}

    public abstract BaseComposite clone();

    /**
     * The function collects text
     * @param del
     * @return
     */

    @Override
    public String collect(String del) {
        int length=components.size()-1;
        String str="";
        for(int i=0; i<length;i++){
            str+=(components.get(i).collect(del)+del);
        }
        str+=components.get(length).collect(del);
        return str;
    }

    @Override
    public String toString() {
        return "BaseComposite{" +
                "components=" + components +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseComposite)) {
            return false;
        }
        BaseComposite that = (BaseComposite) o;
        for(int i=0; i<components.size();i++){
            if(components.get(i).equals(that.components.get(i))==false) {
                return false;
            }
        }
       return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(components);
    }
}

