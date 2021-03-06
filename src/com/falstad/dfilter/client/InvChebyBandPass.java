package com.falstad.dfilter.client;

public class InvChebyBandPass extends InvChebyFilterType {
    int select() {
        int s = selectBandPass();
        selectCheby(s++);
        return s;
    }
    void setup() {
        setupBandPass();
        setupCheby(3);
    }
    void getPole(int i, Complex c1) { getBandPassPole(i, c1); }
    void getZero(int i, Complex c1) {
        getChebyZero(i/2, c1, pi*.5);
        bandPassXform(i, c1);
    }
    int getPoleCount() { return n*2; }
    int getZeroCount() { return n*2; }
    void getInfo(String x[]) {
        x[0] = "Inv Cheby (IIR), " + getPoleCount() + "-pole";
        getInfoBandPass(x, this instanceof InvChebyBandStop);
        getInfoCheby(x);
    }
}
