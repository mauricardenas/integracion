package com.grupogtd.integration.sicret.jsd.ws.response;

import com.grupogtd.integration.sicret.jsd.ws.dto.PruebaDTO;

import java.io.Serializable;

public class GetCurrentDateResponse implements Serializable
{
    private PruebaDTO pruebaDTO;

    public PruebaDTO getPruebaDTO() {
        return pruebaDTO;
    }

    public void setPruebaDTO(PruebaDTO pruebaDTO) {
        this.pruebaDTO = pruebaDTO;
    }

    @Override
    public String toString() {
        return "GetCurrentDateResponse{" +
                "pruebaDTO=" + pruebaDTO +
                '}';
    }
}
