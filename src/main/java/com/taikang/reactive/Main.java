package com.taikang.reactive;



import io.reactivex.Observable;
import java.util.concurrent.TimeUnit;

public class Main {

    public static Observable<TempInfo> getTemperature(String town){

        return Observable.create(
                emitter-> Observable.interval(1, TimeUnit.SECONDS).subscribe(i->{
            if(!emitter.isDisposed()){
                 if(i >= 5){
                     emitter.onComplete();
                 }
            }else {
                try{
                    emitter.onNext(TempInfo.fetch(town));
                }catch (Exception e){
                    emitter.onError(e);
                }
            }
        }));
    }

    public static void main(String[] args) {
        Observable<TempInfo> observable = getTemperature("New York");
        observable.blockingSubscribe(new TempObserver());
    }
}
