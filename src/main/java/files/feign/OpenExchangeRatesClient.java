package files.feign;

import files.model.CurrencyRates;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "openExchangeRates-client", url = "${openexchangerates.url}")
public interface OpenExchangeRatesClient {

    @RequestMapping(method = RequestMethod.GET, value ="/{date}.json?app_id=${openexchangerates.app.id}&symbols={symbol}")
    CurrencyRates getCurrency(@PathVariable String date, @PathVariable String symbol);
}
