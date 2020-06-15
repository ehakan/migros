package configs;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AbstractProps
{
    public Properties configProps = new Properties();

    public void loadConfigProperties(String configFile)
    {
        InputStream in = ClassLoader.getSystemResourceAsStream(configFile);

        try
        {
            configProps.load(in);
        }
        catch (IOException e)
        {
            //TODO
        }
    }
}
