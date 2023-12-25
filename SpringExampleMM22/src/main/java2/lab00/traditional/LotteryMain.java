package lab00.traditional;

public class LotteryMain {

	public static void main(String[] args) {
		LotteryService  service = new LotteryService();
		service.setBallNumber(6);
		service.setLowerBound(1);
		service.setUpperBound(49);
		System.out.println(service.getLuckyNumbers());
	}
}
