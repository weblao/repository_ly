package com.myself;

import com.myself.pojo.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;


/**
 * @author laoying@talkweb.com.cn
 * @date 2023/3/20
 * @apiNote
 */
@Slf4j
@RequiredArgsConstructor
public class StartTest {


    public static void main(String[] args) {
        String name = null;
        String opt = Optional.ofNullable(name).orElse(createNewStr());
        System.out.println(opt);
        String opt2 = Optional.ofNullable(name).orElseGet(StartTest::createNewStr);
        System.out.println(opt2);
        String opt3 = Optional.ofNullable(name).orElseGet(() -> createNewStr());
        System.out.println(opt3);

    }

    private static String createNewStr() {
        log.info("createNewStr");
        return "aaaa()";
    }

    @Test
    public void mapOptionalTest(){
//        User user = new User("zhANG",88);
        User user = User.builder().userName("张三").userAge(888).build();
        Optional<String> userOptal = Optional.ofNullable(user).map(User::getUserName);
        log.info("userOptal: "+userOptal.get());
        Optional<String> mapOptal = Optional.ofNullable(user).map(s ->s.getUserName());
        log.info("mapOptal: "+mapOptal.get());
        Optional<String> flatOptal = Optional.ofNullable(user).flatMap(this::getName);
        log.info("flatOptal: "+flatOptal.get());
    }

    private Optional<String> getName(User user){
        return Optional.ofNullable(user).map(s ->s.getUserName());
    }

    @Test
    public void Test01(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        // Predicate<Integer> predicate = n -> true
        // n 是一个参数传递到 Predicate 接口的 test 方法
        // n 如果存在则 test 方法返回 true
        System.out.println("输出所有数据:");
        // 传递参数 n
        eval(list, n->true);
        // Predicate<Integer> predicate1 = n -> n%2 == 0
        // n 是一个参数传递到 Predicate 接口的 test 方法
        // 如果 n%2 为 0 test 方法返回 true
        System.out.println("输出所有偶数:");
        eval(list, n-> n%2 == 0 );

        Consumer<Integer> square = x -> System.out.println("平方计算："+ x * x);
        square.accept(2);
        //当前值
        Consumer<Integer> consumer1 = x -> System.out.println("当前值 : " + x);
        //相加
        Consumer<Integer> consumer2 = x -> { System.out.println("相加 : " + (x + x)); };
        //相乘
        Consumer<Integer> consumer3 = x -> System.out.println("相乘 : " + x * x);
        //andThen拼接
        consumer1.andThen(consumer2).andThen(consumer3).accept(10);
    }

    public static void eval(List<Integer> list, Predicate<Integer> predicate) {
        for(Integer n: list) {
            if(predicate.test(n)) {
                System.out.println(n + " ");
            }
        }
    }



}
