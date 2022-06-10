package files.service;

import files.model.CurrencyRates;

public interface OpenExchangeRatesService {
    double getCurrencyDif(String currency);
    double getCurrencyValue(CurrencyRates currencyRates, String symbol);

}
