package ch01.traditional.model;

public class Master { 					// 飼養Dog寵物的Master類別
	Cat kitty;
	

	public Master() {
		this.kitty = new Cat("kitty"); 	// 緊密耦合
	}

	public void keepPet() {
		kitty.sleep();
		kitty.catchMouse();
	}
}

//public class Master { 					// 飼養Dog寵物的Master類別
//	Cat cat;
//
//	public Master() {
//		this.cat = new Cat("凱蒂貓"); 	// 緊密耦合
//	}
//
//	public void keepPet() {
//		cat.sleep();
//		cat.catchMouse();
//	}
//}
