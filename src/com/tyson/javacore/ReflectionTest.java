/**   
* @Title: ReflectionTest.java 
* @Package com.tyson.javacore 
* @Description: TODO 
* @author Tyson
* @date 2018年5月3日 下午1:15:08 
* @version V1.0   
*/
package com.tyson.javacore;

/**  
* @ClassName: ReflectionTest  
* @Description: TODO 
* @author Tyson
* @date 2018年5月3日 下午1:15:08  
*    
*/
public class ReflectionTest {
	public static void main(String[] args) throws ClassNotFoundException {
        // 不会初始化静态块
        Class clazz1 = Base.class;
        System.out.println("------");
        // 会初始化
        Class clazz2 = Class.forName("com.tyson.javacore.Base");
    }
}

class Base {
    static int num = 1;
    
    static {
        System.out.println("Base " + num);
    }
}
