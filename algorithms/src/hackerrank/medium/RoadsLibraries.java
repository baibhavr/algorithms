package hackerrank.medium;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Result {

	/*
	 * Complete the 'roadsAndLibraries' function below.
	 * https://www.hackerrank.com/challenges/torque-and-development/ The function is
	 * expected to return a LONG_INTEGER. The function accepts following parameters:
	 * 1. INTEGER n 2. INTEGER c_lib 3. INTEGER c_road 4. 2D_INTEGER_ARRAY cities
	 */
	static int edges;

	public static long roadsAndLibraries(int n, int c_lib, int c_road, List<List<Integer>> cities) {

		if(c_lib<=c_road || cities.size()==0)
            return (long) n*c_lib;
        
        edges = 0;
        // Build graph
        List<Integer>[] graph = new ArrayList[n+1];
        for(int i=1;i<=n;i++)
            graph[i] = new ArrayList<Integer>();
        for(List<Integer> edge:cities){
            graph[edge.get(0)].add(edge.get(1));
            graph[edge.get(1)].add(edge.get(0));
        }
        
        // Final minimal spanning trees, BFS
        int components = 0;
        boolean[] visited = new boolean[n+1];
        for(int i=1;i<=n;i++)
            if(!visited[i]){
                components++;
                MST(graph,visited,i);
            }
        long answer = (long) components*c_lib+(long) edges*c_road;
        return answer;
	}

	static void MST(List<Integer>[] graph, boolean[] visited, int cur) {

		visited[cur] = true;
		for (int nb : graph[cur])
			if (!visited[nb]) {
				edges++;
				MST(graph, visited, nb);
			}
	}
}

public class RoadsLibraries {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int q = Integer.parseInt(bufferedReader.readLine().trim());

		IntStream.range(0, q).forEach(qItr -> {
			try {
				String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

				int n = Integer.parseInt(firstMultipleInput[0]);

				int m = Integer.parseInt(firstMultipleInput[1]);

				int c_lib = Integer.parseInt(firstMultipleInput[2]);

				int c_road = Integer.parseInt(firstMultipleInput[3]);

				List<List<Integer>> cities = new ArrayList<>();

				IntStream.range(0, m).forEach(i -> {
					try {
						cities.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
								.map(Integer::parseInt).collect(toList()));
					} catch (IOException ex) {
						throw new RuntimeException(ex);
					}
				});

				long result = Result.roadsAndLibraries(n, c_lib, c_road, cities);

				bufferedWriter.write(String.valueOf(result));
				bufferedWriter.newLine();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		bufferedReader.close();
		bufferedWriter.close();
	}
}
