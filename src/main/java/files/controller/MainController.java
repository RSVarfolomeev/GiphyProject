package files.controller;


import files.model.FrontAnswerForm;
import files.service.GiphyServiceImpl;
import files.service.OpenExchangeRatesServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class MainController {
    private final OpenExchangeRatesServiceImpl openExchangeRatesService;
    private final GiphyServiceImpl giphyService;

    public MainController(OpenExchangeRatesServiceImpl openExchangeRatesService, GiphyServiceImpl giphyService) {
        this.openExchangeRatesService = openExchangeRatesService;
        this.giphyService = giphyService;
    }

//    http://localhost:8080/getGifAndCurrency
    @PostMapping("/getGifAndCurrency")
    public ResponseEntity<?> getGifAndCurrency(@RequestBody String checkingCurrency) {
        double currencyDif;
        try {
            currencyDif = openExchangeRatesService.getCurrencyDif(checkingCurrency);
        } catch (RuntimeException e) {
            return ResponseEntity.ok(new FrontAnswerForm(checkingCurrency, 0, "-", e.getMessage()));
        }
        String giphyUrl = giphyService.getGif(currencyDif);
        return ResponseEntity.ok(new FrontAnswerForm(checkingCurrency, currencyDif, giphyUrl, "Ok"));
    }
}
