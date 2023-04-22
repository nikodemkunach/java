package com.company;

public class Zawodnik {
    private String imie;
    private int predkoscMinimalna;
    private int predkoscMaksymalna;
    private int pokonanaOdleglosc;

    public Zawodnik(int pokonanaOdleglosc){
        this.pokonanaOdleglosc = 0;
    }

    public Zawodnik(String imie, int predkoscMinimalna, int predkoscMaksymalna) {
        this.imie = imie;
        this.predkoscMaksymalna = predkoscMaksymalna;
        this.predkoscMinimalna = predkoscMinimalna;
    }

    public void przedstawSie(String imie, int predkoscMinimalna, int predkoscMaksymalna) {
        System.out.println("Jestem " + imie + "biegam z predkoscia " + predkoscMinimalna + "-" + predkoscMaksymalna + "km/h");
    }

    public void biegnij(int pokonanaOdleglosc){
    }
}
