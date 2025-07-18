package guru.springframework.msscbreweryclient.web.client;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "sfg.brewery", ignoreUnknownFields = false)
public class BreweryClientProperties {

    private final String apihost;

    public BreweryClientProperties(String apihost) {
        this.apihost = apihost;
    }

    public String getApihost() {
        return apihost;
    }
}
