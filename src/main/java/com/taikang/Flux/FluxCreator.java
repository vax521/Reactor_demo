package com.taikang.Flux;

import reactor.core.publisher.Flux;

/**
 * Created by xingxf03 on 2018/3/15.
 */
public class FluxCreator {

   public static  void main(String[] args){
       Flux<Integer> ints = Flux.range(1,3);
       ints.subscribe(System.out::println);
     /*  Flux<Integer> ints = Flux.range(1, 4)
               .map(i -> {
                   if (i <= 3) return i;
                   throw new RuntimeException("Got to 4");
               });
       ints.subscribe(i -> System.out.println(i),
               error -> System.err.println("Error: " + error));

       Flux<Integer> intErr = Flux.range(1,4);
        intErr.subscribe(i->System.out.println(i),
                error->System.out.println("Error "+error),
                ()->{ System.out.print("Done"); }
                );*/

       SampleSubscriber<Integer> ss = new SampleSubscriber<>();

       Flux<Integer> inters = Flux.range(1, 4);
         inters.subscribe(System.out::println,
               error -> System.err.println("Error " + error),
               () -> System.out.println("Done"),
               s -> ss.request(10));
      // inters.subscribe(ss);


       Flux<String> alphabet = Flux.just(-1, 30, 13, 9, 20)
               .handle((i, sink) -> {
                   String letter = alphabet(i);
                   if (letter != null)
                       sink.next(letter);
               });

       alphabet.subscribe(System.out::println);
   }

    @org.jetbrains.annotations.Contract(pure = true)
    public static String alphabet(int letterNumber) {
        if (letterNumber < 1 || letterNumber > 26) {
            return null;
        }
        int letterIndexAscii = 'A' + letterNumber - 1;
        return "" + (char) letterIndexAscii;
    }
}
