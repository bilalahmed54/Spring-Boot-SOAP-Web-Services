package com.bay.consume_soap;

import com.bay.consume_soap.service_client.CountryClient;
import hello.wsdl.GetCountryResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConsumeSoapApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumeSoapApplication.class, args);
    }

    @Bean
    CommandLineRunner lookup(CountryClient quoteClient) {

        return args -> {
            String country = "Poland";

            if (args.length > 0) {
                country = args[0];
            }

            GetCountryResponse response = quoteClient.getCountry(country);
            System.err.println(response.getCountry().getCurrency());
        };
    }
}