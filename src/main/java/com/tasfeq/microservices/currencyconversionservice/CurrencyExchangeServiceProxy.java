package com.tasfeq.microservices.currencyconversionservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="currency-exchange-service", url="localhost:8000") [v1]
//@FeignClient(name="currency-exchange-service") // load distribution. no port is specified [v2]
@FeignClient(name="netflix-zuul-api-gateway-server") // setting up Feign for Zuul API Gateway [v3]
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

	//@GetMapping("/currency-exchange/from/{from}/to/{to}") 
	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}") //setting up Zuul API Gateway URI 
	public CurrencyConversionBean retrieveExchangeValue(
			@PathVariable("from") String from, 
			@PathVariable("to") String to
			);
}
