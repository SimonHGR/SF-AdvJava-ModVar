package nonpublic;

import apackage.MyServiceIF;

public class Stuff implements MyServiceIF {

  static String getAMessage() {
    return "This is a default access method...";
  }

  @Override
  public String getMessage() {
    return "This is a service method message";
  }
}
