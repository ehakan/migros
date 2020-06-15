package configs;

public class InternalProps extends AbstractProps
{
    private String username;
    private String password;


    public InternalProps()
    {
        loadConfigProperties("internal_config.properties");

        this.username = configProps.getProperty("user.name");
        this.password = configProps.getProperty("user.password");
    }

    //Getters and Setters


    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}
