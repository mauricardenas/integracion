package com.grupogtd.integration.sicret.jsd.ws.dto;

import java.io.Serializable;

/**
 * Ejemplo, representa una fecha
 */
public class PruebaDTO implements Serializable
{
    private String pruebaData;

    public String getPruebaData() {
        return pruebaData;
    }

    public void setPruebaData(String pruebaData) {
        this.pruebaData = pruebaData;
    }

    @Override
    public String toString() {
        return "PruebaDTO{" +
                "pruebaData='" + pruebaData + '\'' +
                '}';
    }
}
