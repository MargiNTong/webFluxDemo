import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.net.URL;

public class Test01 {
    @Test
    public void showLog4j(){
        URL resource = Thread.currentThread().getContextClassLoader().getResource("log4j2.properties");
        System.out.println(resource);
        final Logger logger = LogManager.getLogger(getClass());
        logger.info("Hello world");
    }
}
