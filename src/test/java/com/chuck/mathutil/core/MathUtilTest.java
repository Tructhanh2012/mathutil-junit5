/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.chuck.mathutil.core;
// import static dành riêng cho những hàm static
// gọi hàm mà bỏ qua tên class
import static com.chuk.mathutil.core.MathUtil.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class MathUtilTest {
    
    //chơi DDT
    //Chuẩn bị bộ data
    public static Object[][] initData() {
        return new Integer[][] {
                  {1, 1},
                  {2, 2},
                  {5, 120},
                  {6, 720}
        };
    }
    
    
    
    @ParameterizedTest
    @MethodSource(value = "initData") //tên hàm cung cấp data, ngầm định thứ tự của các phần tử mảng, map vào tham số hàm
    public void testGetFactorialGivenRightArgReturnsWell(int input, long expected) {
        assertEquals(expected, getFactorial(input)); //30 có bằng 50 ?
    }
    
    //Bắt ngoại lệ khi đưa data sai
    //@Test(expected - tên ngoại lệ.class) JUnit 4, JUnit 5 hok sd v
    
    @Test
    public void testGetFactorialGivenWrongArgThrowException() {
        // sd biểu thức Lambda
        // hàm nhận tham số thứ 2 là 1 obj/có code implement functional interface tên là Excutable(có 1 hàm duy nhất k code) tên là execute()
        
//        Executable exeObject = new Executable() {
//            @Override
//            public void execute() throws Throwable {
//                getFactorial(-5);
//            }
//        };

//        Executable exObject = () -> getFactorial(-5);
        assertThrows(IllegalArgumentException.class, () -> getFactorial(-5));
    }
    
}
