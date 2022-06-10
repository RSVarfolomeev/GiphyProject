package files;

import files.controller.MainController;;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MainControllerTest {

    @Autowired
    MainController mainController;

    @Autowired
    private MockMvc mvc;

    @Value("${openexchangerates.app.id}")
    String openExchangeRatesAppId;

    @Value("${giphy.api.key}")
    String giphyApiKey;

    @Test
    public void getGifAndCurrencyController() throws Exception {
        mvc.perform(post("/getGifAndCurrency")
                        .contentType(MediaType.ALL)
                        .accept(MediaType.ALL)
                        .content("RUB")
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("Ok"))
                .andDo(MockMvcResultHandlers.print());
    }
}