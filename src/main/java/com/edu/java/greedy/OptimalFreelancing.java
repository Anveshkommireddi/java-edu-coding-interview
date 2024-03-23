package com.edu.java.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OptimalFreelancing {

	public static void main(String[] args) {

		HashMap[] input = new HashMap[3];

		HashMap<String, Integer> job1 = new HashMap<String, Integer>();
		job1.put("deadline", 1);
		job1.put("payment", 1);
		input[0] = job1;

		HashMap<String, Integer> job2 = new HashMap<String, Integer>();
		job2.put("deadline", 2);
		job2.put("payment", 2);
		input[1] = job2;

		HashMap<String, Integer> job3 = new HashMap<String, Integer>();
		job3.put("deadline", 2);
		job3.put("payment", 1);
		input[2] = job3;

		int maxOutput = optimalFreelancing(input);

		System.out.println(maxOutput);
	}

	public static int optimalFreelancing(Map<String, Integer>[] jobs) {
		Comparator<Job> jobPaymentComparator = (job1, job2) -> job2.payment - job1.payment;
		List<Job> jobsList = Arrays.asList(jobs).parallelStream().map(map -> {
			Job job = new Job(map.get("deadline"), map.get("payment"));
			return job;
		}).sorted(jobPaymentComparator).collect(Collectors.toList());
		int result = 0;
		int[] profit = new int[8];
		for (Job job : jobsList) {
			int deadLine = job.deadline;
			for (int i = Math.min(deadLine, 7); i > 0; i--) {
				if (profit[i] == 0) {
					profit[i] = job.payment;
					result += profit[i];
					break;
				}
			}
		}
		return result;
	}

}

class Job {

	int deadline;

	int payment;

	public Job(int deadline, int payment) {
		this.deadline = deadline;
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "Job [deadline=" + deadline + ", payment=" + payment + "]";
	}

}