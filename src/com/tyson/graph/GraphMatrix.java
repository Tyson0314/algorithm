package com.tyson.graph;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphMatrix {
	private ArrayList<Integer> vertexList;
	private int[][] edges;
	private int edgesNum;
	
	public GraphMatrix(int n) {
		edges = new int[n][n];
		edgesNum = 0;
		vertexList = new ArrayList<Integer>(n);
	}
	
	public void insertVertex(int vertex) {
		vertexList.add(vertex);
	}
	
	public void insertVertex(int[] vertexes) {
		for(int i=0;i<vertexes.length;i++) {
			vertexList.add(vertexes[i]);
		}
	}
	
	public void insertEdge(int i, int j, int weight) {
		if(i<0||j<0||i>=vertexList.size()||j>=vertexList.size()) {
			return;
		}
		
		edges[i][j] = weight;
		edgesNum++;
	}
	
	public int getVertexNum() {
		return vertexList.size();
	}
	
	//得到第一个邻接节点的下标
	public int getFirstNeighbor(int index) {
		for(int i=0;i<vertexList.size();i++) {
			if(edges[index][i]>0) {
				return i;
			}
		}
		return -1;
	}
	
	//得到第k个邻接节点的下一个节点的下标
	public int getNextNeighbor(int index, int k) {
		for(int i=k+1;i<vertexList.size();i++) {
			if(edges[index][i]>0) 
				return i;
		}
		return -1;
	}
	
	private void DFS(boolean[] isVisited, int i) {
		if(isVisited[i] == false) {
			System.out.print(vertexList.get(i) + "-->");
			//标记为已访问
			isVisited[i] = true;
			int index = getFirstNeighbor(i);
			while(index != -1) {
				if(isVisited[index] == false) {
					DFS(isVisited, index);
				}
				index = getNextNeighbor(i, index);
			} 
		}
		System.out.println();
	}
	
	public void DFS() {
		boolean[] isVisited = new boolean[vertexList.size()];
		
		for(int j=0;j<vertexList.size();j++) {
			isVisited[j] = false;
		}
		for(int i=0;i<vertexList.size();i++) {
			if(isVisited[i] == false)
				DFS(isVisited, i);
		}
	}
	
	public void BFS() {
		boolean isVisited[] = new boolean[vertexList.size()];
		for(int i=0;i<vertexList.size();i++) {
			isVisited[i] = false;
		}
		
		for(int j=0;j<vertexList.size();j++) {
			BFS(isVisited, j);
		}
	}
	
	/*private void BFS(boolean[] isVisited, int index) {
		
		if(isVisited[index] == true)
			return;
		
		Stack<Integer> s = new Stack<>();
		s.push(index);
		
		while(!s.isEmpty()) {
			index = s.pop();
			if(isVisited[index] == false) {
				System.out.print(vertexList.get(index) + "-->");
				isVisited[index] = true;
				
				int neighbor = getFirstNeighbor(index);
				while(index != -1) {
					s.push(index);
					index = getNextNeighbor(index, neighbor);
				}
			}
		}
	}*/
	
	private void BFS(boolean[] isVisited, int index) {
		if(isVisited[index] == true)
			return;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(index);
		
		while(!queue.isEmpty()) {
			index = queue.poll();
			if(isVisited[index] == false) {
				System.out.print(vertexList.get(index) + "-->");
				isVisited[index] = true;
				
				int neighbor = getFirstNeighbor(index);
				
				while(neighbor != -1) {
					queue.offer(neighbor);
					neighbor = getNextNeighbor(index, neighbor);
					System.out.print(" put ");
				}
				System.out.println();
			}
		}
	}


    public static void main(String args[]){
    	GraphMatrix g = new GraphMatrix(5);
    	
    	int[] vertexes = {1, 2, 3, 4, 5};
    	
    	g.insertVertex(vertexes);
    	
    	g.insertEdge(0, 1, 1);
    	g.insertEdge(0, 2, 1);
    	g.insertEdge(0, 3, 1);
    	g.insertEdge(1, 3, 1);
    	g.insertEdge(2, 3, 1);
	
    	g.BFS();
    }
}