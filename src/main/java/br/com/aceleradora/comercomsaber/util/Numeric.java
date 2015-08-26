package br.com.aceleradora.comercomsaber.util;

import java.text.DecimalFormat;

public class Numeric {

    public static String formataNumeroDuasCasasDecimais(Double valor){
        DecimalFormat formatoDecimalDuasCasas = new DecimalFormat("0.00");
        String valorNumericoFormato = formatoDecimalDuasCasas.format(valor);
        return valorNumericoFormato.replace(",",".");
    }

    public static boolean isNumeric(String valor){
        try{
            double numero = Double.parseDouble(valor);
            return true;
        }catch(Exception ex) {
            return false;
        }
    }
}
