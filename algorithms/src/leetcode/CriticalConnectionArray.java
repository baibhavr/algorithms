package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author baibhav <baibhavr@gmail.com>
 * 8:06:12 PM Apr 27, 2021
 * Uses Tarjan's algorithm to find bridge(Critical Connections)
 */
public class CriticalConnectionArray {

    static List<Integer>[] graph;
    static HashSet<List<Integer>> res = new HashSet<List<Integer>>();
    
    public static void main(String[] args) {
    	List<List<Integer>> connections = new ArrayList<List<Integer>>();
    	int n = testCase1(connections);
    	long startTime = System.nanoTime();
    	List<List<Integer>> result = criticalConnectionsTarjan(n,connections);
    	long endTime   = System.nanoTime();
		System.out.println("DFS solution "+(endTime-startTime)/1000+" micros");
    	System.out.println(result);
    }
    
    public static List<List<Integer>> criticalConnectionsTarjan(int n, List<List<Integer>> connections) {
		readGraph(n,connections);
		dfsTarjan(-1,0,new int[1],new int[n], new int[n]);
		return new ArrayList<List<Integer>>(res);
    }
    
    /**
     * Finds Critical Connections(bridges) in 1 DFS by searching for loops
     * Time Complexity O(V+E)
     * @param prev
     * @param cur
     * @param discTime			Discovery Time of each node starting from 1
     * @param lowestReach	Lowest reachable node(IDs) from the current node
     */
    public static void dfsTarjan(int prev, int cur, int[] timer, int[] discTime, int[] lowestReach) {
    	
    	discTime[cur] = lowestReach[cur] = timer[0]++;
    	
    	for(int nb:graph[cur]) {
    		if(nb==prev) continue;

    		if(discTime[nb]==0) {
    			dfsTarjan(cur,nb,timer,discTime,lowestReach);
    			
    			if(lowestReach[nb]>discTime[cur])	// if neighbor's lowestReach is greater than discoveryTime of cur
    												// it means neighbor was not able to find path to nodes before cur
    				res.add(Arrays.asList(cur,nb));	// therefore, this is a critical connection
    		}
    		lowestReach[cur] = Math.min(lowestReach[cur], lowestReach[nb]);
    	}    	
    }
    
    /**
     * Read the edge lists to make a graph
     * @param connections
     */
    public static void readGraph(int n,List<List<Integer>> connections){
        
    	graph = new ArrayList[n];
    	for(int i=0;i<n;i++)
    		graph[i] = new ArrayList<Integer>();
    	
    	for(List<Integer> edge:connections) {
    		graph[edge.get(0)].add(edge.get(1));
    		graph[edge.get(1)].add(edge.get(0));
    	}
    }

    public static int testCase1(List<List<Integer>> connections) {
    	Integer[][] raw_connections = {{0,1},{1,2},{2,0},{1,3}};
    	for(Integer[] edge:raw_connections) 
    		connections.add(new ArrayList<Integer>(Arrays.asList(edge)));
    	return 4;
    }
}
