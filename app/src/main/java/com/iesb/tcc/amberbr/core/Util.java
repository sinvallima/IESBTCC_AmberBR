package com.iesb.tcc.amberbr.core;

import com.iesb.tcc.amberbr.entity.Localizacao;

/**
 * Criado por Sinvas em 09/02/2017.
 */

public class Util {

    private Util(){

    }

    /*
    Calcula a distância em metros entre uma coordenada passada e a coordenada atual
     */
    public static double CalculaDistanciaLocalizacao(Localizacao ponto, Localizacao atual){
        return distanciaEmMetros(ponto.getLatitude(),
                                 ponto.getLongitude(),
                                 atual.getLatitude(),
                                 atual.getLongitude());

    }

    private static double distanciaEmMetros(double lat1, double lon1, double lat2, double lon2) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        dist = dist * 1.609344 * 1000;

        return (dist);
    }

    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private static double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }
}
