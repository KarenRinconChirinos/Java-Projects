package com.nikki.java8.lambda;

import com.nikki.java8.lambda.models.Usuario;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class EjemploPredicate {
    public static void main(String[] args) {
        Predicate<Integer> test = num -> num > 10;
        boolean res =  test.test(8);
        System.out.println("res = " + res);
        
        Predicate<String> test1 = role -> role.equals("ROLE_ADMIN");
        System.out.println(test1.test("ROLE-A"));

        BiPredicate<String, String> test2 = (a,b) -> a.equals(b);
        System.out.println(test2.test("marco", "jaime"));

        BiPredicate<String, String> test3 = String::equals;
        System.out.println(test3.test("marco", "jaime"));

        BiPredicate<Integer, Integer> test4 = (a,b) -> a > b;
        boolean res4 = test4.test(2,5);
        System.out.println("res4 = " + res4);

        Usuario a = new Usuario();
        Usuario b = new Usuario();
        a.setNombre("mari");
        b.setNombre("armando");
        BiPredicate<Usuario,Usuario> test5 = (userA,userB) -> userA.getNombre().equals(userB.getNombre());
        System.out.println("test5.test(a,b) = " + test5.test(a,b));

    }
}
