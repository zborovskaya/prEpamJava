package by.zborovskaya.task05.service.registrar;

import by.zborovskaya.task05.entity.Cone;
import by.zborovskaya.task05.service.ConeOperation;

import java.util.HashMap;
import java.util.Map;

public class ConeRegistrar {
    ConeOperation coneOperation=new ConeOperation();
    private static ConeRegistrar instance;

    private Map<Integer, double[]> observables = new HashMap<Integer, double[]>();

    public Map<Integer, double[]> getObservables() {
        return observables;
    }

    private ConeRegistrar() { }

    public static ConeRegistrar getInstance() {
        if (instance == null) {
            instance = new ConeRegistrar();
        }
        return instance;
    }

    /**
     * Function add cone id and Square and Volume to registrar
     * @param cone
     */
    public void addCone(Cone cone){
        double volume=coneOperation.calculateVolume(cone);
        double square=coneOperation.calculateSquare(cone);
        observables.put(cone.getId(), new double[]{square, volume});
    }
    /**
     * Function remove cone of registrar
     * @param cone
     */
     public void remove(Cone cone){
         observables.remove(cone.getId());
     }

    /**
     * Function update cone in registrar
     * @param cone
     */
     public void update(Cone cone){
         double volume=coneOperation.calculateVolume(cone);
         double square=coneOperation.calculateSquare(cone);
         observables.replace(cone.getId(), new double[]{square, volume});
     }
}
