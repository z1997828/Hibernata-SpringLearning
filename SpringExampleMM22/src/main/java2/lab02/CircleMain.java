package lab02;
/*
	請以Spring框架的風格來重新設計CircleMain.java。請在組態檔內定義需要受Spring IoC容器
	控管的Java物件。請將相關的程式與組態檔都寫在套件lab02.xml之下。

      改寫步驟 : 
   0. 將lab02.Circle.java與lab02.CircleMain.java複製到lab02.xml套件下。
   1. 設計一個介面: lab02.xml.Shape，其內定義一個方法:
      public abstract double getArea();
      
      lab02.xml.Circle類別必須實作此介面。
      
   2. 新建組態檔 ，使用<Bean>定義lab02.xml.Circle類別，經由<property>傳入數值到
      lab02.xml.Circle類別的實例變數radius內 。
                   
   3. 修改main方法，建立Spring IoC容器後，經由它的getBean()來取得 IoC容器控管的Java物件，
             然後印出該物件的面積。
 
 */
public class CircleMain {
    public static void main(String args[]) {
       	Circle c = new Circle();
       	c.setRadius(10);
       	System.out.println("半徑為" + c.getRadius() + "之圓的面積為: " + c.getArea());
    }
}
