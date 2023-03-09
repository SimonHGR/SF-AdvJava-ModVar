package usingvar;

import java.io.Serializable;
import java.lang.constant.ConstantDesc;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.stream.IntStream;

public class Examples {
//  private var count = 99; // NOPE not allowed

  public static Map<Map.Entry<String, Long>, Map.Entry<List<String>, Collection<Integer>>> get() {
    return null;
  }
  public static void showStuff(int [] ia) {}
  public static void main(String[] args) {
    var x = 3_000_000_000L;
//    x = "Hello";

//    int [] ia = {1, 2, 3};
    int [] ia = new int[]{1, 2, 3};
    showStuff(ia);
    showStuff(new int[]{1,2,3});
//    showStuff({1,2,3});
//    var ia2 = {1,2,3};
    var ia2 = new int[]{1,2,3};
//    var [] ia2 = new int[]{1,2,3};

    var thing = get();

    var s = IntStream.range(1, 100)
        .boxed()
        .map(i -> "Value is " + i)
        ;
    s.forEach(System.out::println);

    // non-denotable type :)
    var obj = true ? "Hello" : 99;

// NOPE, can't do this
//    <Serializble & Comparable> obj = true ? "Hello" : 99;

//    BiPredicate<String, Long> bpsl = (st, l) -> true;
//    BiPredicate<String, Long> bpsl = (@Deprecated String st, Long l) -> true;
    BiPredicate<String, Long> bpsl = (@Deprecated var st, var l) -> true;
  }
}
