package lec10_exceptions.work;



public class Executor
{

  public static void main(String[] args)
  {
    FtpProtocolBuilder builder=new FtpProtocolBuilder();
    FtpProtocol fp=builder.setName("name").setPassword("password").setHost("host").setPort(1).get();
  }
}