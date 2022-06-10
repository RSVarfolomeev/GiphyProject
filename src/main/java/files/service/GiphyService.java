package files.service;

import files.model.giphy.Data;

public interface GiphyService {
    String getGif(double currencyDif);
    String getGifUrl(Data data);
}
