package com.company;

import java.util.ArrayList;
import java.util.List;

public class Autosalon {

    private static int ALLAUTO = 10;
    private static final int TIME_PROUCTION = 3000;
    private static final int TIME_SELL = 2000;


    Fabrika fabrika = new Fabrika(this);

    private List<Car> cars = new ArrayList<>();

    public List<Car> getCars() {
        return cars;
    }


    public void sellCar() {
        while (!Thread.currentThread().isInterrupted()) {
            if (ALLAUTO == 0) {
                break;
            }
            fabrika.sellCar();
            try {
                Thread.sleep(TIME_SELL);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public void carIsReady() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(TIME_PROUCTION);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (ALLAUTO == 0) {
                break;
            }
            fabrika.releaseCar();
        }
    }

    public static void setSalesPlan() {
        ALLAUTO -= 1;
    }
}
