package com.wbz.system;

import org.apache.ibatis.javassist.expr.Instanceof;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Formatter;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=SystemApplication.class)
public class MyTest {

    public double num = 3.555555f;

    @Test
    public void BigDecimal(){
        BigDecimal bd = new BigDecimal(num);
        bd = bd.setScale(4, RoundingMode.HALF_UP);
        System.out.println(bd.getClass());
        System.out.println(bd);
        num = bd.doubleValue();
    }
    @Test
    public void testDecimalFormat(){
        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.HALF_UP);
        System.out.println(df.format(num));
        System.out.println(df.format(num).getClass());
        num = Double.parseDouble(df.format(num));
    }

    @Test
    public void testFormatter(){
        Formatter format = new Formatter().format("%.2f", num);
        num = Double.parseDouble(String.valueOf(format));
        System.out.println(num);
    }

    @Test
    public void testStringFormat(){
        String format = String.format("%.2f", num);
        System.out.println(format.getClass());
        System.out.println(Double.parseDouble(format));
    }
}
