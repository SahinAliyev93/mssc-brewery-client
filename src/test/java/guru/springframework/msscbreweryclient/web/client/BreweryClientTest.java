package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient breweryClient;

    @Autowired
    BreweryClientProperties breweryClientProperties;

    @Test
    void getBeerById() {
        BeerDto beerDto   = breweryClient.getBeerById(UUID.randomUUID());
        assertNotNull(beerDto);
    }

    @Test
    void testSaveNewBeer() {
        BeerDto beerDto = BeerDto.builder()
                .beerName("Galaxy Cat")
                .beerStyle("Pale Ale")
                .upc(123456789012L)
                .build();

        URI uri = breweryClient.saveNewBeer(beerDto);
        assertNotNull(uri);
    }

    @Test
    void testUpdateBeer() {
        BeerDto beerDto = BeerDto.builder()
                .beerName("Galaxy Cat")
                .beerStyle("Pale Ale")
                .upc(123456789012L)
                .build();

        UUID beerId = UUID.randomUUID();
        breweryClient.UpdateBeer(beerId, beerDto);

        // Assuming the update doesn't return anything, we can just check if it completes without exception
        assertDoesNotThrow(() -> breweryClient.UpdateBeer(beerId, beerDto));
    }
    @Test
    void testDeleteBeer() {
        UUID beerId = UUID.randomUUID();
        breweryClient.deleteBeerById(beerId);

        // Assuming the delete doesn't return anything, we can just check if it completes without exception
        assertDoesNotThrow(() -> breweryClient.deleteBeerById(beerId));
    }

    @Test
    void testCustomerById() {
        // Assuming you have a valid customer ID
        UUID customerId = UUID.randomUUID();
        CustomerDto customerDto = breweryClient.getCustomerById(customerId);
        assertNotNull(customerDto);
    }

    @Test
    void testSaveNewCustomer() {
        CustomerDto customerDto = CustomerDto.builder()
                .name("John Doe")
                .build();

        CustomerDto customerDto1 = breweryClient.saveNewCustomer(customerDto);
        assertNotNull(customerDto1);
    }

    @Test
    void testUpdateCustomer() {
        CustomerDto customerDto = CustomerDto.builder()
                .name("Jane Doe")
                .build();

        UUID customerId = UUID.randomUUID();
        breweryClient.UpdateCustomer(customerId, customerDto);

        // Assuming the update doesn't return anything, we can just check if it completes without exception
        assertDoesNotThrow(() -> breweryClient.UpdateCustomer(customerId, customerDto));
    }

    @Test
    void testDeleteCustomer() {
        UUID customerId = UUID.randomUUID();
        breweryClient.deleteCustomer(customerId);

        // Assuming the delete doesn't return anything, we can just check if it completes without exception
        assertDoesNotThrow(() -> breweryClient.deleteCustomer(customerId));
    }
}