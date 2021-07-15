package by.zborovskaya.demotheads.ex21_theadPhaser;

import java.util.concurrent.Phaser;

class PhaseThread implements Runnable{

    Phaser phaser;
    String name;

    PhaseThread(Phaser p, String n){

        this.phaser=p;
        this.name=n;
        phaser.register();
    }
    public void run(){

        int i=0;
        System.out.println(name + " выполняет фазу " + phaser.getPhase());
        i++;
        System.out.println(i++);
        phaser.arriveAndAwaitAdvance(); // сообщаем, что первая фаза достигнута
        i=0;
        System.out.println(name + " выполняет фазу " + phaser.getPhase());
        i++;
        System.out.println(i++);
        phaser.arriveAndAwaitAdvance(); // сообщаем, что вторая фаза достигнута

        i=0;
        System.out.println(name + " выполняет фазу " + phaser.getPhase());
        i++;
        System.out.println(i++);
        phaser.arriveAndDeregister(); // сообщаем о завершении фаз и удаляем с регистрации объекты
    }
}
