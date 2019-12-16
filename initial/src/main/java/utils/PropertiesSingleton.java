package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesSingleton
{
    private static PropertiesSingleton singleton;

    private Properties url;
    private Properties client_id;

    public synchronized static PropertiesSingleton getInstance()
    {
        if (singleton == null)
            singleton = new PropertiesSingleton();

        return singleton;
    }
    @Override
    protected synchronized Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }

    public synchronized void readUrlProperties()
    {
        if(this.url == null)
        {
            try (InputStream input = new FileInputStream(Contants.URL_NAME_FILE))
            {
                this.url = new Properties();
                this.url.load(input);

            } catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }

    }

    public synchronized void readClientIdProperties()
    {
        if(this.client_id == null)
        {
            try (InputStream input = new FileInputStream(Contants.CLIENT_ID_NAME_FILE))
            {
                this.client_id = new Properties();
                this.client_id.load(input);

            } catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }

    }

    public synchronized Properties getUrlProperties()
    {
        return this.url;
    }

    public synchronized Properties getClientIdProperties()
    {
        return this.client_id;
    }
    
}
