package com.edu.java.merge.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class EmployeeFreeTime {

	public static void main(String[] args) {
		List<List<Interval>> schedule = Arrays.asList(
				Arrays.asList(new Interval(1, 3), new Interval(6, 9), new Interval(10, 11)),
				Arrays.asList(new Interval(3, 4), new Interval(7, 12)),
				Arrays.asList(new Interval(1, 3), new Interval(7, 10)), Arrays.asList(new Interval(1, 4)),
				Arrays.asList(new Interval(7, 10), new Interval(11, 12)));
		List<Interval> result = employeeFreeTime(schedule);
		System.out.println(result.size());
		System.out.println(result);
	}

	public static List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
		List<Interval> ans = new ArrayList<Interval>();
		PriorityQueue<EmpCaledner> pq = new PriorityQueue<>(
				(empCal1, empCal2) -> empCal1.getInterval().getStart() == empCal2.getInterval().getStart()
						? empCal1.getInterval().getEnd() == empCal2.getInterval().getEnd()
								? empCal1.getEmpIdx() - empCal2.getEmpIdx()
								: empCal1.getInterval().getEnd() - empCal2.getInterval().getEnd()
						: empCal1.getInterval().getStart() - empCal2.getInterval().getStart());
		int prevIntervalMax = Integer.MAX_VALUE;
		for (int empIdx = 0; empIdx < schedule.size(); empIdx++) {
			List<Interval> empIntervalList = schedule.get(empIdx);
			if (null != empIntervalList && !empIntervalList.isEmpty()) {
				int intervalIdx = 0;
				Interval currInterval = empIntervalList.get(intervalIdx);
				prevIntervalMax = Math.min(prevIntervalMax, currInterval.getStart());
				pq.offer(new EmpCaledner(currInterval, empIdx, intervalIdx));
			}
		}
		while (!pq.isEmpty()) {
			EmpCaledner empCal = pq.poll();
			Interval currInterval = empCal.getInterval();
			int currEmpIdx = empCal.getEmpIdx();
			int currIntervalIdx = empCal.getIntervalIdx();
			if (currInterval.getStart() <= prevIntervalMax) {
				prevIntervalMax = Math.max(prevIntervalMax, currInterval.getEnd());
			} else {
				ans.add(new Interval(prevIntervalMax, currInterval.getStart()));
				prevIntervalMax = currInterval.getEnd();
			}
			List<Interval> currIntervals = schedule.get(currEmpIdx);
			if (currIntervalIdx + 1 < currIntervals.size()) {
				pq.offer(new EmpCaledner(currIntervals.get(currIntervalIdx + 1), currEmpIdx, currIntervalIdx + 1));
			}
		}
		return ans;
	}
}

class EmpCaledner {

	private Interval interval;

	private int empIdx;

	private int intervalIdx;

	public EmpCaledner(Interval interval, int empIdx, int intervalIdx) {
		this.interval = interval;
		this.empIdx = empIdx;
		this.intervalIdx = intervalIdx;
	}

	public Interval getInterval() {
		return interval;
	}

	public void setInterval(Interval interval) {
		this.interval = interval;
	}

	public int getEmpIdx() {
		return empIdx;
	}

	public void setEmpIdx(int empIdx) {
		this.empIdx = empIdx;
	}

	public int getIntervalIdx() {
		return intervalIdx;
	}

	public void setIntervalIdx(int intervalIdx) {
		this.intervalIdx = intervalIdx;
	}

	@Override
	public String toString() {
		return "EmpCaledner [interval=" + interval + ", empIdx=" + empIdx + ", intervalIdx=" + intervalIdx + "]";
	}

}
