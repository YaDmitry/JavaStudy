package lec10_exceptions.work;

public class FtpProtocolBuilder
{
  private FtpProtocol ftpProtocol;

  public FtpProtocolBuilder()
  {
    ftpProtocol=new FtpProtocol();
  }

  public FtpProtocolBuilder setName(String name)
  {
    ftpProtocol.setName(name);
    return this;
  }

  public FtpProtocolBuilder setPassword(String name)
  {
    ftpProtocol.setPassword(name);
    return this;
  }

  public FtpProtocolBuilder setHost(String name)
  {
    ftpProtocol.setHost(name);
    return this;
  }

  public FtpProtocolBuilder setPort(int name)
  {
    ftpProtocol.setPort(name);
    return this;
  }

  public FtpProtocol get()
  {
    return ftpProtocol;
  }

}
