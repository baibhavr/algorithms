package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CriticalConnectionMap {

    static Map<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
    static HashSet<List<Integer>> res;
    
    public static void main(String[] args) {
    	List<List<Integer>> connections = new ArrayList<List<Integer>>();
    	int n = testCase1(connections);
    	    	
    	long startTime = System.nanoTime();
//    	List<List<Integer>> result = criticalConnections(n,connections);
    	List<List<Integer>> result = criticalConnectionsTarjan(n,connections);
    	long endTime   = System.nanoTime();
		System.out.println("DFS solution "+(endTime-startTime)/1000+" micros");
    	System.out.println(result);
    }
    
    public static List<List<Integer>> criticalConnectionsTarjan(int n, List<List<Integer>> connections) {
    	readGraph(connections);
    	res = new HashSet<List<Integer>>();
    	
    	dfsTarjan(-1,(int)map.keySet().toArray()[0], new boolean[n], new int[n], new int[n]);
    	return new ArrayList<List<Integer>>(res);
    }
    
    public static void dfsTarjan(int prev, int cur, boolean[] visited, int[] discTime, int[] lowestReachable) {
    	visited[cur] = true;
    	
    	discTime[cur] = (prev>=0 ? discTime[prev]+1:0);
    	lowestReachable[cur] = cur;
    	
//    	System.out.println(cur+" "+discTime[cur]+" "+lowestReachable[cur]);
    	
    	for(int nb:map.get(cur)) {
    		if(nb!=prev) {
    			lowestReachable[cur] = Math.min(lowestReachable[cur],lowestReachable[nb]);
	    		if(!visited[nb]) {
	    			dfsTarjan(cur, nb, visited, discTime, lowestReachable);
	    			if(lowestReachable[cur]<lowestReachable[nb])
	    				res.add(new ArrayList<Integer>(Arrays.asList(cur,nb)));
        			lowestReachable[cur] = Math.min(lowestReachable[cur],lowestReachable[nb]);
	    		}
    		}
    	}
    }
    
    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        res = new HashSet<List<Integer>>();
        HashSet<List<Integer>> processed = new HashSet<List<Integer>>();
        
        for(Map.Entry<Integer,ArrayList<Integer>> node:map.entrySet()){
            int src = node.getKey();
            for(int nb:node.getValue()){
                int left = src<nb ? src:nb;
                int right = src<nb ? nb:src;
                
                List<Integer> edge = new ArrayList<Integer>(Arrays.asList(left,right));
                // Edge processed before
                if(processed.contains(edge))
                    continue;
                processed.add(edge);
                
//                System.out.println(left+" "+right);
                // Check if destination node can be reached from source
                if(!dfsReachable(left,left,right, new HashSet<Integer>(),processed))
//            	if(!bfsReachable2ways(left,right))
                    res.add(edge);
            }
        }
        return new ArrayList<List<Integer>>(res);
    }

    // Timeout, optmized  
    public static boolean dfsReachable(int src,int cur,int dest, HashSet<Integer> visited, HashSet<List<Integer>> processed){
        if(visited.contains(cur))
            return false;
        visited.add(cur);
        
        if(cur==dest)
            return true;
        
        for(int nb:map.get(cur)){
            if(cur==src && nb==dest)
                continue;
            if(dfsReachable(src,nb,dest,visited,processed)){
                // Optimization - if this edge is in the path of DFS and reachable to target
                // Then that means these nodes are also reachable from the other path containing src and dest
                // So nodes in paths are also not critical connections
                int left = cur<nb ? cur:nb;
                int right = cur<nb ? nb:cur;
                List<Integer> edge = new ArrayList<Integer>(Arrays.asList(left,right));
                processed.add(edge);
                return true;
            }
        }
        return false;        
    }
    
    // Timeout    
    public static boolean bfsReachable2ways(int src,int dest){
        Queue<Integer> q1 = new LinkedList<Integer>();
        Queue<Integer> q2 = new LinkedList<Integer>();
        
        q1.add(src);
        q2.add(dest);
        
        HashSet<Integer> bfsVisited1 = new HashSet<Integer>();
        HashSet<Integer> bfsVisited2 = new HashSet<Integer>();
        
        while(q1.size()!=0 && q2.size()!=0){
            // Already visited node
            int cur1 = q1.remove();
            int cur2 = q2.remove();
            bfsVisited1.add(cur1);
            bfsVisited2.add(cur2);
            
            // found the target or both BFS visited same node i.e. they are reachable to eachother
            if(cur1==dest || cur2==src || bfsVisited2.contains(cur1) || bfsVisited1.contains(cur2)) return true; 
            
            for(int nb:map.get(cur1)){
                if(cur1==src && nb==dest) continue;
                if(!bfsVisited1.contains(nb))
                    q1.add(nb);
            }
            
            for(int nb:map.get(cur2)){
                if(cur2==dest && nb==src) continue;
                if(!bfsVisited2.contains(nb))
                    q2.add(nb);
            }
        }
        return false;
    }
    
    // Timeout
    public static boolean bfsReachable(int src,int dest){
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(src);
        HashSet<Integer> bfsVisited = new HashSet<Integer>();

        while(q.size()!=0){
            // Already visited node
            int cur = q.remove();
            bfsVisited.add(cur);
            if(cur==dest) return true; // found the target
            
            for(int nb:map.get(cur)){
                if(cur==src && nb==dest) continue;
                if(!bfsVisited.contains(nb))
                    q.add(nb);
            }
        }
        return false;
    }
    
    public static void readGraph(List<List<Integer>> connections){
        
        for(List<Integer> edge:connections){
            int src = edge.get(0);
            int dest = edge.get(1);
            
            if(!map.containsKey(src)) map.put(src,new ArrayList<Integer>());
            if(!map.containsKey(dest)) map.put(dest,new ArrayList<Integer>());
            
            map.get(src).add(dest);
            map.get(dest).add(src);
        }
    }

    public static int testCase1(List<List<Integer>> connections) {
    	Integer[][] raw_connections = {{0,1},{1,2},{2,0},{1,3}};
    	for(Integer[] edge:raw_connections) 
    		connections.add(new ArrayList<Integer>(Arrays.asList(edge)));
    	return 4;
    }
}
