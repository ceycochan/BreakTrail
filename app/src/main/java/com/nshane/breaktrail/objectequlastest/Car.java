package com.nshane.breaktrail.objectequlastest;

/**
 * Created by bryan on 2018-8-18.
 */

public class Car {

    private int batch;

    public Car(int batch) {
        this.batch = batch;
    }


    @Override
    public boolean equals(Object obj) {

        if (obj instanceof Car) {
//            Object obj = new Car(1); // 该行代码被省略 // 向上转型

            Car c = (Car) obj;  // 向下转型
            return batch == c.batch;
        }

        return false;
    }
}
