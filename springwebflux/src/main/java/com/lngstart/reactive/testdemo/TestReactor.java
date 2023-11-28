package com.lngstart.reactive.testdemo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author lngstart
 * @date 2023/11/27
 */
public class TestReactor {
    public static void main(String[] args) {
        //just()：创建Flux序列，并声明数据流，
        Flux<Integer> integerFlux = Flux.just(1, 2, 3, 4);//整形
        //subscribe()：订阅Flux序列，只有进行订阅后才回触发数据流，不订阅就什么都不会发生
        integerFlux.subscribe(System.out::println);

        Flux<String> stringFlux = Flux.just("hello", "world");//字符串
        stringFlux.subscribe(System.out::println);

        //fromArray(),fromIterable()和fromStream()：可以从一个数组、Iterable 对象或Stream 对象中创建Flux序列
        Integer[] array = {1,2,3,4};
        Flux.fromArray(array).subscribe(System.out::println);

        List<Integer> integers = Arrays.asList(array);
        Flux.fromIterable(integers).subscribe(System.out::println);

        Stream<Integer> stream = integers.stream();
        Flux.fromStream(stream).subscribe(System.out::println);

        Flux ints = Flux.range(1, 4);
        Flux seq1 = Flux.just("bole1", "bole2", "bole3");
        List iterable = Arrays.asList("bole_01", "bole_02", "bole_03");
        Flux seq2 = Flux.fromIterable(iterable);
        seq2.subscribe(i -> System.out.println(i));

        Mono data = Mono.just("bole");
        Mono noData = Mono.empty();
        data.subscribe(i -> System.out.println(i));
    }
}
