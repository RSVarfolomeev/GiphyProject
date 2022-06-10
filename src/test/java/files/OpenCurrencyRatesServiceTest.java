package files;

import files.feign.OpenExchangeRatesClient;
import files.model.CurrencyRates;
import files.service.OpenExchangeRatesServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.HashMap;
import java.util.Map;


@SpringBootTest(classes = OpenExchangeRatesServiceImpl.class)
public class OpenCurrencyRatesServiceTest {

    @Autowired
    OpenExchangeRatesServiceImpl openExchangeRatesService;

    @MockBean
    private OpenExchangeRatesClient openExchangeRatesClient;

    @Test
    void getCurrencyDifTest() {
        Map<String, Double> map = new HashMap<>();
        CurrencyRates currencyRates = new CurrencyRates("Usage subject to terms: https://openexchangerates.org/terms",
                "https://openexchangerates.org/license", 1654837159, "USD", map);
        Mockito.doReturn(currencyRates)
                .when(openExchangeRatesClient)
                .getCurrency(Mockito.any(), Mockito.any());
        try {
            openExchangeRatesService.getCurrencyDif("rub");
            Assertions.fail("Expected RuntimeException");
        } catch (RuntimeException exception) {
            Assertions.assertEquals("Connection to https://openexchangerates.org/ is lost, problems" +
            " with currencies data or your currency is incorrect", exception.getMessage());
        }
    }
}
