package files;

import files.feign.GiphyClient;
import files.model.giphy.Data;
import files.model.giphy.Downsized;
import files.model.giphy.Gif;
import files.model.giphy.Images;
import files.service.GiphyServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


@SpringBootTest(classes = GiphyServiceImpl.class)
public class GiphyServiceTest {

    @Autowired
    GiphyServiceImpl giphyService;

    @MockBean
    private GiphyClient giphyClient;
    @MockBean
    private Downsized downsized;
    @MockBean
    private Data data;
    @MockBean
    private Images images;
    @MockBean
    private Gif gif;

    @Test
    void getGiphyTest() {
        Mockito.doReturn("https://media3.giphy.com/media/S8Ni8O7iuUTLy/giphy-preview.mp4?cid=bc7cf79df0137bec5c885e492c1d7d5e64b32bf038a72b32&rid=giphy-preview.mp4&ct=g")
                .when(downsized)
               .getUrl();
        Mockito.doReturn(downsized)
                .when(images)
                .getDownsized();
        Mockito.doReturn(images)
                .when(gif)
                .getImages();
        Mockito.doReturn(gif)
                .when(data)
                .getGif();
        Mockito.doReturn(data)
                .when(giphyClient)
                .getGif(Mockito.any());

        Assertions.assertTrue(giphyService.getGif(2).contains("giphy"));
    }
}
