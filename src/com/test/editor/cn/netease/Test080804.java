package com.test.editor.cn.netease;


import java.util.function.Function;

/**
 * @author mafeng
 * @data 2020/8/8
 **/
public class Test080804 {
    public static void main(String[] args) {
        Function<Double, Function<Double, Double>> addTax = taxRate -> price -> price + price * taxRate;
        Function<Double, Double> tc9 = addTax.apply(0.09);
        Double price = tc9.apply(500d);
        System.out.println(price);
    }
}
