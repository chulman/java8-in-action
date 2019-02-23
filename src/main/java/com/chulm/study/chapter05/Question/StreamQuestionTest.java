package com.chulm.study.chapter05.Question;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamQuestionTest {
    public static void main(String[] args) {

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");


        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 700),
                new Transaction(mario, 2012, 710),
                new Transaction(alan, 2012, 950)
        );


        // Q-0) 거래자가 근무하는 모든 도시를 중복 없이 나열
        transactions.stream().map(Transaction::getTrader)
                             .map(Trader::getCity)
                             .distinct()
                             .forEach(System.out::println);

        // Q-1) 2011년에 일어난 모든 트랜잭션을 찾아 값을 오름차순으로 정렬
        transactions.stream().filter(transaction -> transaction.getYear()==2011)
                             .sorted(Comparator.comparing(Transaction::getValue))
                             .forEach(System.out::println);

        // Q-2) 캠브리지에 근무하는 모든 거래자를 찾아 이름순으로 정렬
        transactions.stream().map(Transaction::getTrader)
                             .filter(trader -> trader.getCity().equals("Cambridge"))
                             .sorted(Comparator.comparing(Trader::getName))
                             .forEach(System.out::println);

        // Q-3) 모든 거래자의 이름을 알파벳 순으로 정렬해서 반환
        List<String> nameList = transactions.stream().map(Transaction::getTrader)
                                                     .map(Trader::getName)
                                                     .distinct()
                                                     .sorted(Comparator.comparing(String::toString))
                                                     .collect(Collectors.toList());

        nameList.stream().forEach(System.out::println);

        // Q-4) 밀라노에 거래자가 있는지?

        boolean find = transactions.stream().anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
        System.err.println(find);

        // Q-5) 캠브리지에 거주하는 거래자의 모든 트랜잭션값을 출력
        int sum =transactions.stream().filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                                     .map(Transaction::getValue)
                                     .reduce(0,Integer::sum);

        System.err.println(sum);

        // Q-6) 전체 트랜잭션 중 최댓값
        transactions.stream().map(Transaction::getValue)
                             .max(Integer::compareTo).ifPresent(System.out::println);

        // Q-7) 전체 트랜잭션 중 최소값
        transactions.stream().map(Transaction::getValue)
                             .min(Integer::compareTo).ifPresent(System.out::println);


    }
}
