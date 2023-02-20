package com.arao.challenges.topics.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamExampler {

    public Stream<Integer> returnStream(List<Integer> lista) {
        // filter the pair numbers and get as Stream
        Stream<Integer> intStream = lista.stream().filter(e -> e % 2 == 0);
        // continue intermediate operation of Stream
        intStream = intStream.filter(e -> e > 6);
        // print elements
        intStream.forEach(System.out::println);
        return intStream;
    }

    public Stream<Integer> returnIllegalStreamOperation(List<Integer> lista) {
        // filter the pair numbers and get as Stream
        Stream<Integer> intStream = lista.stream().filter(e -> e % 2 == 0);
        // print elements
        intStream.forEach(System.out::println);
        // continue intermediate operation of Stream
        intStream = intStream.filter(e -> e > 6);
        return intStream;
    }

    public static void main(String[] args) {

        List<Integer> lista = Arrays.asList(1,2,3,4,5,6,8,10);

        Stream<Integer> intStream = lista.stream().filter(e -> e % 2 == 0);

        // this will print reference of Stream<Integer> like
        // java.util.stream.ReferencePipeline$2@7cca494b
        System.out.println(intStream);

        // this will print the elements of Stream<Integer> -> 2,4,6
        // intStream.forEach(System.out::println);

        // this will show IllegalStateException since stream has already been operated upon or closed by
        // foreach terminal operation above
        // var number = intStream.filter(e -> e > 5).findFirst();
        intStream = intStream.filter(e -> e > 6);

//        System.out.println(number);
        intStream.forEach(System.out::println);
    }
}
