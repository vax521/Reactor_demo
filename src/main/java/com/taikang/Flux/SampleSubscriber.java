package com.taikang.Flux;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

/**
 * Created by xingxf03 on 2018/3/15.
 */
public class SampleSubscriber<T> extends BaseSubscriber<T> {
   public void hookOnSubscribe(Subscription subscription){
       System.out.println("Subscribed");
       request(1);
   }
   public void hookOnNext(T value){
       System.out.println(value);
       request(1);
   }
}
