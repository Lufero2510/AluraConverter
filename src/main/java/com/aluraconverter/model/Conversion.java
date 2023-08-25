package com.aluraconverter.model;
/**
 * @version 1.0
 *
 * @author Luis Fernando Garcia
 */
public class Conversion {
    private float currency1;
    private float currency2;
    private float cantidadConvertir;

    public Conversion(){

    }

    public Conversion(float currency1, float currency2, float cantidadConvertir){
        this.currency1 = currency1;
        this.currency2 = currency2;
        this.cantidadConvertir = cantidadConvertir;
    }

    public float conversion(){
        return (this.currency2/this.currency1)*cantidadConvertir;
    }

    public float getCurrency1() {
        return currency1;
    }

    public void setCurrency1(float currency1) {
        this.currency1 = currency1;
    }

    public float getCurrency2() {
        return currency2;
    }

    public void setCurrency2(float currency2) {
        this.currency2 = currency2;
    }
}
