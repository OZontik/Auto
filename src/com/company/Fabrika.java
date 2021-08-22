package com.company;

public class Fabrika {

    private Autosalon autosalon;

    public Fabrika(Autosalon autosalon) {
        this.autosalon = autosalon;
    }

    public synchronized void releaseCar() {
        autosalon.getCars().add(new Car());
        System.out.println("Производитель " + Thread.currentThread().getName() + " выпустил 1 авто");
        notify();
    }

    public synchronized Car sellCar() {
        System.out.println(" Покупатель " + Thread.currentThread().getName() + " зашел в автосалон");
        while (autosalon.getCars().size() == 0) {
            System.out.println("Машин нет");
            try {
                wait();
            } catch (InterruptedException e) {
                return null;
            }
            System.out.println("Покупатель " + Thread.currentThread().getName() + "  уехал на новеньком авто");
            autosalon.setSalesPlan();
        }
        return autosalon.getCars().remove(autosalon.getCars().size() - 1);
    }

}
