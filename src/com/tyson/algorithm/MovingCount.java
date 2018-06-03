/**   
* @Title: MovingCount.java 
* @Package com.tyson.algorithm 
* @Description: TODO 
* @author Tyson
* @date 2018年6月3日 上午10:30:51 
* @version V1.0   
*/
package com.tyson.algorithm;

/**  
* @ClassName: MovingCount  
* @Description: TODO 
* @author Tyson
* @date 2018年6月3日 上午10:30:51  
*    
*/
public class MovingCount {
	public int movingCount(int threshold, int rows, int cols)
    {
        int[] flag = new int[rows*cols];
        
        return movingCountCore(0, 0, rows, cols, flag, threshold);
    }
    
    public int movingCountCore(int i, int j, int rows, int cols, int[] flag, int threshold) {
        if(i<0||i>=rows||j<0||j>=cols
        		||getDigitSum(i)+getDigitSum(j)>threshold||flag[i*cols+j]==1)
            return 0;
        flag[i*cols+j] = 1;
        
        return 1 + movingCountCore(i+1, j, rows, cols, flag, threshold) +
            movingCountCore(i-1, j, rows, cols, flag, threshold) +
            movingCountCore(i, j+1, rows, cols, flag, threshold) +
            movingCountCore(i, j-1, rows, cols, flag, threshold);
    }
    
    public int getDigitSum(int num) {
        int sum = 0;
        
        while(num>0) {
            sum += num%10;	// = --> +=
            num = num/10;
        }
        
        return sum;
    }
    
    public static void main(String[] args) {
		System.out.println(new MovingCount().movingCount(15, 100, 1));
	}
}
