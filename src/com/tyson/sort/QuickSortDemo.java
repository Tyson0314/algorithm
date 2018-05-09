/**   
* @Title: demo.java 
* @Package com.tyson.sort 
* @Description: TODO 
* @author Tyson
* @date 2018年4月15日 下午11:16:40 
* @version V1.0   
*/
package com.tyson.sort;

import java.util.Random;

/**  
* @ClassName: demo  
* @Description: TODO 
* @author A18ccms a18ccms_gmail_com  
* @date 2018年4月15日 下午11:16:40  
*    
*/
public class QuickSortDemo <Anytype extends Comparable<? super Anytype>> {
	 /**
     * Quicksort algorithm.
     * @param a an array of Comparable items.
     */
    public static <AnyType extends Comparable<? super AnyType>>
    void quicksort( AnyType [ ] a )
    {
        quicksort( a, 0, a.length - 1 );
    }

    private static final int CUTOFF = 3;

    /**
     * Method to swap to elements in an array.
     * @param a an array of objects.
     * @param index1 the index of the first object.
     * @param index2 the index of the second object.
     */
    public static <AnyType> void swapReferences( AnyType [ ] a, int index1, int index2 )
    {
        AnyType tmp = a[ index1 ];
        a[ index1 ] = a[ index2 ];
        a[ index2 ] = tmp;
    }

    /**
     * Return median of left, center, and right.
     * Order these and hide the pivot.
     */
    private static <AnyType extends Comparable<? super AnyType>>
    AnyType median3( AnyType [ ] a, int left, int right )
    {
        int center = ( left + right ) / 2;
        if( a[ center ].compareTo( a[ left ] ) < 0 )
            swapReferences( a, left, center );
        if( a[ right ].compareTo( a[ left ] ) < 0 )
            swapReferences( a, left, right );
        if( a[ right ].compareTo( a[ center ] ) < 0 )
            swapReferences( a, center, right );

            // Place pivot at position right - 1
        swapReferences( a, center, right - 1 );
        return a[ right - 1 ];
    }

    /**
     * Internal quicksort method that makes recursive calls.
     * Uses median-of-three partitioning and a cutoff of 10.
     * @param a an array of Comparable items.
     * @param left the left-most index of the subarray.
     * @param right the right-most index of the subarray.
     */
    private static <AnyType extends Comparable<? super AnyType>>
    void quicksort( AnyType [ ] a, int left, int right )
    {
        if( left + CUTOFF <= right )
        {
            AnyType pivot = median3( a, left, right );

                // Begin partitioning
            int i = left, j = right - 1;
            for( ; ; )
            {
                while( a[ ++i ].compareTo( pivot ) < 0 ) { }
                while( a[ --j ].compareTo( pivot ) > 0 ) { }
                if( i < j )
                    swapReferences( a, i, j );
                else
                    break;
            }

            swapReferences( a, i, right - 1 );   // Restore pivot

            quicksort( a, left, i - 1 );    // Sort small elements
            quicksort( a, i + 1, right );   // Sort large elements
        }
        else  // Do an insertion sort on the subarray
            insertionSort( a, left, right );
    }

    /**
     * Internal insertion sort routine for subarrays
     * that is used by quicksort.
     * @param a an array of Comparable items.
     * @param left the left-most index of the subarray.
     * @param right the right-most index of the subarray.
     */
    private static <AnyType extends Comparable<? super AnyType>>
    void insertionSort( AnyType [ ] a, int left, int right )
    {
        for( int p = left + 1; p <= right; p++ )
        {
            AnyType tmp = a[ p ];
            int j;

            for( j = p; j > left && tmp.compareTo( a[ j - 1 ] ) < 0; j-- )
                a[ j ] = a[ j - 1 ];
            a[ j ] = tmp;
        }
    }
    
  //折半插入排序 
  //返回数组有序关键字 
  public static int order(int R[], int n)
  {
      int i;
      for(i=0;i<n;++i)
      {
          if(R[i]>R[i+1])return i;    
      }
      return n;
  } 
  //排序 
  public static void half_sort(int R[], int n)
  {
      int i,j,k,s,m,high,temp,t;
      high = order(R,n);
      for(s=high+1;s<n;++s)
      {
          //待插关键字 
          temp = R[s];
          //有序关键字 左右 
          i=0;j=s-1;
          while(i<=j)           //i<j-->i<=j
          {
              //有序的中间关键字 
              m=(i+j)/2;
              //如果关键字的值小于中间值，则右边等于中间关键字 
              if(temp<R[m])j=m-1;
              else i=m+1;    
          }
          //返回关键字插入位置 
          t=i;                  //t=m-->t=i
          //将元素右移，方便待插关键字插入 
          for(k=s-1;k>=i;--k)R[k+1]=R[k];         //k=high-->k=s-1   k>=m-->k>=i
          R[t] = temp;    
      }  
  }


    public static void main(String[] args) {
		final int NUM = 10000;
		Random rand = new Random();
		QuickSortDemo<Integer> d = new QuickSortDemo<Integer>();
		
		int[] arr1 = new int[NUM];
		Integer[] arr = new Integer[NUM];
		for(int i=0;i<NUM;i++) {
			arr[i] = rand.nextInt(NUM);
		}
		for(int i=0;i<NUM;i++) {
			arr1[i] = rand.nextInt(NUM);
		}
		
		/*long startTime = System.currentTimeMillis();
		d.quicksort(arr);
		long endTime = System.currentTimeMillis();*/
		
		long startTime = System.currentTimeMillis();
		half_sort(arr1, NUM);
		long endTime = System.currentTimeMillis();
		
		for(int i=0;i<NUM;i++) {
			//arr1[i] = rand.nextInt(NUM);
			System.out.println(arr1[i] + "  hahaha");
		}
		System.out.println();
		System.out.println(endTime-startTime);
	}
}
