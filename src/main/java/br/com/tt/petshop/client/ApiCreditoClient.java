package br.com.tt.petshop.client;

import br.com.tt.petshop.client.dto.SituacaoCreditoDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ApiCreditoClient {

    private RestTemplate restTemplate;

    public ApiCreditoClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public SituacaoCreditoDto verificaSituacao(String cpf){

        return restTemplate.getForObject(
                "https://imersao-credito-api.herokuapp.com/credito/{cpf}", SituacaoCreditoDto.class, cpf);

    }
}
