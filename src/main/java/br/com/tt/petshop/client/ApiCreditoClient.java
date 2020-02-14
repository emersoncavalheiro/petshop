package br.com.tt.petshop.client;

import br.com.tt.petshop.client.dto.SituacaoCreditoDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ApiCreditoClient {

    private RestTemplate restTemplate;
    private String urlCredito;

    public ApiCreditoClient(RestTemplate restTemplate, @Value("${app.creditoAPI.url}") String urlCredito) {
        this.restTemplate = restTemplate;
        this.urlCredito = urlCredito;
    }

    public SituacaoCreditoDto verificaSituacao(String cpf){

        return restTemplate.getForObject(
                "{urlCredito}/credito/{cpf}", SituacaoCreditoDto.class, urlCredito, cpf);

    }
}
