package com.nshane.breaktrail.objectequlastest;

/**
 * Created by bryan on 2018-8-18.
 */

public class BigCar extends Car {

    int count;

    public BigCar(int batch,int count) {
        super(batch);
        this.count  = count;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof BigCar){
            BigCar bigCar = (BigCar) obj;
            return super.equals(bigCar) && count == bigCar.count;
        }

        return false;


    }
}
