package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;


@Component
public class BreweryClient {

    public static final String BEER_PATH_V1 = "/api/v1/beer";
    public static final  String CUSTOMER_PATH_V1 = "/api/v1/customer";
    private final RestTemplate restTemplate;
    private final BreweryClientProperties properties;



    public BreweryClient(RestTemplateBuilder builder, BreweryClientProperties properties) {
        this.restTemplate = builder.build();
        this.properties = properties;
    }

    public BeerDto getBeerById(UUID id) {
       return restTemplate.getForObject(properties.getApihost()+BEER_PATH_V1 + "/"+ id,BeerDto.class);
    }
    public URI saveNewBeer(BeerDto beerDto) {
        return restTemplate.postForLocation(properties.getApihost()+BEER_PATH_V1, beerDto);
    }

    public void UpdateBeer(UUID beerId, BeerDto beerDto) {
        restTemplate.put(properties.getApihost()+BEER_PATH_V1 + "/" + beerId, beerDto);
    }

    public void deleteBeerById(UUID beerId) {var x =4;
            restTemplate.delete(properties.getApihost()+BEER_PATH_V1 + "/" + beerId);
    }

    public CustomerDto getCustomerById(UUID customerId) {
        return restTemplate.getForObject(properties.getApihost()+CUSTOMER_PATH_V1 + "/"+ customerId,CustomerDto.class);
    }

    public CustomerDto saveNewCustomer(CustomerDto customerDto) {
        return restTemplate.postForObject(properties.getApihost()+CUSTOMER_PATH_V1, customerDto, CustomerDto.class);
    }
    public void UpdateCustomer(UUID customerId, CustomerDto customerDto) {
         restTemplate.put(properties.getApihost()+CUSTOMER_PATH_V1 + "/" + customerId,customerDto);

    }
    public void deleteCustomer(UUID customerId) {
        restTemplate.delete(properties.getApihost()+CUSTOMER_PATH_V1 + "/" + customerId);
    }
}
