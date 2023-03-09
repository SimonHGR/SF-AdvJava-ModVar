package client;

import apackage.MyServiceIF;

import java.lang.reflect.Field;
import java.util.ServiceLoader;

//Commmand-line options:
//compilation:
//   -d where to put output
//   --module-path (or -p) where modules can be found
//   --module-source-path (no shorthand) where to find source for modules
//               "./part/path/*/src/main/java" * is replaced with module-name
//   --module (or -m) one or more module names to compile.
//            IF MULTIPLE, must be comma separated list, with NO SPACES
//
//javac -d modules --module-path modules --module-source-path "./*/src/main/java/" --module my.client.module

// execution:
// --module (-p) <module-name>/<fqcn> for main method :)
//
//    2021  java --module-path modules --module my.client.module/client.Client


/*
  in regular classpath operation:
    public is "anywhere in the running JVM"

  module system can distinguish "free for all" from "free for all MY code"

 */
public class Client {
  public static void main(String[] args) throws Throwable {
    System.out.println(apackage.Provider.providerMessage);

//    System.out.println(nonpublic.Stuff.getMessage());
    // split package tricks don't work any more...
//    System.out.println(nonpublic.BreakIt.getTheMessage());
    //
//    System.setSecurityManager(new SecurityException());
    Class<?> cl = apackage.Provider.class;
    Field f = cl.getDeclaredField("secretMessage");
    f.setAccessible(true);
    Object fieldValue = f.get(null);
    System.out.println("private field contains " + fieldValue);

    ServiceLoader<MyServiceIF> loader = ServiceLoader.load(MyServiceIF.class);
    for (MyServiceIF srv : loader) {
      System.out.println("Implementation found: " + srv.getClass());
      System.out.println("Service message is " + srv.getMessage());
    }
    System.out.println("That's all folks!");
  }
}
