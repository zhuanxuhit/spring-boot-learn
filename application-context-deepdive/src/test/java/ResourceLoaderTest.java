import org.junit.Test;
import org.springframework.core.io.*;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;


public class ResourceLoaderTest {
    @Test(expected = FileNotFoundException.class)
    public void defaultResourceLoader() throws Exception {
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource fakeResource = resourceLoader.getResource("~/fake.txt");
        assertTrue(fakeResource instanceof ClassPathResource);
        assertFalse(fakeResource.exists());

        Resource urlResource1 = resourceLoader.getResource("file:~/spring-test/README");
        assertTrue(urlResource1 instanceof UrlResource);

        Resource urlResource2 = resourceLoader.getResource("http://www.baidu.com");
        assertTrue(urlResource2 instanceof UrlResource);

        // file not found
        fakeResource.getFile();

        urlResource2.getFile();

    }
}
