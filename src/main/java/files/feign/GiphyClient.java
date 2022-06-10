package files.feign;

import files.model.giphy.Data;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "giphy-client", url = "${giphy.url}")
public interface GiphyClient {

    @RequestMapping(method = RequestMethod.GET, value ="/random?api_key=${giphy.api.key}&tag={tag}")
    Data getGif(@PathVariable String tag);
}
