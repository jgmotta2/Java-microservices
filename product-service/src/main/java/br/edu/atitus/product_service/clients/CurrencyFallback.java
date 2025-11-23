package br.edu.atitus.product_service.clients;

import org.springframework.stereotype.Component;

@Component
public class CurrencyFallback implements CurrencyClient {

    @Override
    public CurrencyResponse getCurrency(double value, String source, String target) {
        CurrencyResponse response = new CurrencyResponse();
        response.setConvertedValue(value);
        response.setSource(source);
        response.setTarget(target);
        response.setConversionRate(1.0);
        response.setEnviroment("Fallback - Serviço Indisponível");
        return response;
    }
}