package lab00.spring.xml.solution;

import java.util.Collection;

public interface ILottery {

	// setter，性質名稱為lowerBound
	void setLowerBound(int lowerBound);

	// setter，性質名稱為upperBound
	void setUpperBound(int upperBound);

	// setter，性質名稱為ballNumber
	void setBallNumber(int ballNumber);

	Collection<Integer> getLuckyNumbers();

}