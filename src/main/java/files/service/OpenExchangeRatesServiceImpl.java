package files.service;

import files.feign.OpenExchangeRatesClient;
import files.model.CurrencyRates;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Locale;


@Service
public class OpenExchangeRatesServiceImpl implements OpenExchangeRatesService {

    private final OpenExchangeRatesClient openExchangeRatesClient;


    public OpenExchangeRatesServiceImpl(OpenExchangeRatesClient openExchangeRatesClient) {
        this.openExchangeRatesClient = openExchangeRatesClient;
    }

    @Override
    public double getCurrencyDif(String checkingCurrency) throws RuntimeException {
        checkingCurrency = checkingCurrency.toUpperCase(Locale.ROOT);
        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(1);
            double currencyToday = getCurrencyValue(openExchangeRatesClient.getCurrency(today.toString(),
                    checkingCurrency), checkingCurrency);
            double currencyYesterday = getCurrencyValue(openExchangeRatesClient.getCurrency(yesterday.toString(),
                    checkingCurrency), checkingCurrency);
            return currencyToday - currencyYesterday;
    }

    @Override
    public double getCurrencyValue(CurrencyRates currency, String checkingCurrency) throws RuntimeException {
        try {
            return currency.getRates().get(checkingCurrency);
        } catch (Exception e) {
            throw new RuntimeException("Connection to https://openexchangerates.org/ is lost, problems" +
                    " with currencies data or your currency is incorrect");
        }
    }
}
