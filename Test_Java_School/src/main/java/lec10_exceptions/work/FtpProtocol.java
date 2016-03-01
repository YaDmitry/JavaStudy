package lec10_exceptions.work;



public class FtpProtocol implements Protocol
{

  private String name;
  private String host;
  private int port;
  private String password;

  public void setName(String name)
  {
    this.name=name;
  }

  public void setHost(String host)
  {
    this.host=host;
  }

  public void setPort(int port)
  {
    this.port=port;
  }

  public void setPassword(String password)
  {
    this.password=password;
  }

  @Override public String getName()
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override public int getPort()
  {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override public String getUser()
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override public String getPassword()
  {
    // TODO Auto-generated method stub
    return null;
  }

}
