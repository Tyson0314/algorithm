/**   
* @Title: DataStreamMedian.java 
* @Package com.tyson.algorithm 
* @Description: TODO 
* @author Tyson
* @date 2018年5月25日 下午4:10:04 
* @version V1.0   
*/
package com.tyson.algorithm;

/**  
* @ClassName: DataStreamMedian  
* @Description: TODO 
* @author Tyson
* @date 2018年5月25日 下午4:10:04  
*    
*/
import java.util.PriorityQueue;
import java.util.Comparator;
public class DataStreamMedian {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(11, new Comparator<Integer>() {
        public int compare(Integer i1, Integer i2) {
            return i2.compareTo(i1);
        }
    });
    int count = 0;
    
    public void Insert(Integer num) {
        count++;
        if((count&0x01) == 1) {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        } else {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }
    }

    public Double GetMedian() {
        if(count == 0)
            return null;
        
        if((count&0x01) == 1)
            return Double.valueOf(maxHeap.peek());
        else {
            return Double.valueOf((maxHeap.peek()+minHeap.peek()))/2;
        }
    }


}
