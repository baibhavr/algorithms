package hackerrank.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class RunningMedia {
	/*
	 * Complete the 'runningMedian' function below.
	 * https://www.hackerrank.com/challenges/find-the-running-median The function is
	 * expected to return a DOUBLE_ARRAY. The function accepts INTEGER_ARRAY a as
	 * parameter.
	 */
	public static List<Double> runningMedian(List<Integer> a) {

		List<Double> answer = new ArrayList<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((b, c) -> c.compareTo(b));
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		for (int num : a) {

			if (maxHeap.size() != 0 && num <= maxHeap.peek())
				maxHeap.add(num);
			else
				minHeap.add(num);

			// The Move
			while (maxHeap.size() - minHeap.size() > 1)
				minHeap.add(maxHeap.remove());
			while (minHeap.size() > maxHeap.size())
				maxHeap.add(minHeap.remove());

			if (maxHeap.size() == minHeap.size())
				answer.add((maxHeap.peek() + minHeap.peek()) / 2.0);
			else
				answer.add(maxHeap.peek() * 1.0);
		}
		return answer;
	}
}
