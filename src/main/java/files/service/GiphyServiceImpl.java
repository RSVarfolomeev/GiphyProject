package files.service;

import files.feign.GiphyClient;
import files.model.giphy.Data;
import org.springframework.stereotype.Service;


@Service
public class GiphyServiceImpl implements GiphyService {

    private final GiphyClient giphyClient;

    public GiphyServiceImpl(GiphyClient giphyClient) {
        this.giphyClient = giphyClient;
    }

    @Override
    public String getGif(double currencyDif) {
        String giphyUrl;
        if (currencyDif <= 0) {
            giphyUrl = getGifUrl(giphyClient.getGif("rich"));
        } else {
            giphyUrl = getGifUrl(giphyClient.getGif("broke"));
        }
        return giphyUrl;
    }

    @Override
    public String getGifUrl(Data data) {
        return data.getGif().getImages().getDownsized().getUrl();
    }
}
