package lab05;
/*
	改寫lab02，但以註釋的方式來定義Bean元件。
        請將相關的程式與組態檔寫在套件lab07.anno之下。
        改寫步驟 : 請參考Lab02與Lab05

 */
public class CircleMain {
    public static void main(String args[]) {
       	Circle c = new Circle();
       	c.setRadius(10);
       	System.out.println("半徑為" + c.getRadius() + "之圓的面積為: " + c.getArea());
    }
}
