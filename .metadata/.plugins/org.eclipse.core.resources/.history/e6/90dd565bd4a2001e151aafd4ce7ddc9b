package lab00.traditional;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

public class LotteryService {
	private int lowerBound;
	private int upperBound;
	private int ballNumber;

	public LotteryService() {
	}

	// setter，性質名稱為lowerBound
	public void setLowerBound(int lowerBound) {
		this.lowerBound = lowerBound;
	}

	// setter，性質名稱為upperBound
	public void setUpperBound(int upperBound) {
		this.upperBound = upperBound;
	}

	// setter，性質名稱為ballNumber
	public void setBallNumber(int ballNumber) {
		this.ballNumber = ballNumber;
	}

	public Collection<Integer> getLuckyNumbers() {
		Set<Integer> set = new TreeSet<Integer>();
		while (set.size() < ballNumber) {
			int num = (int) (Math.random() * (upperBound - lowerBound + 1)) + lowerBound;
			set.add(num);
		}
		return set;
	}
}
