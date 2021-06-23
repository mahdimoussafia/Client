package client;

import java.rmi.RemoteException;

import webservices.Product;
import webservices.ProductsManagerProxy;
public class ClientWebServices {

	public static void main(String[] args) throws RemoteException  {

		ProductsManagerProxy proxy = new ProductsManagerProxy();

		Product prdct1= new Product((long) 1,"Butter",12.0);
		Product prdct2= new Product((long) 2,"Meat",60.0);
		Product prdct3= new Product((long) 3,"Eggs",1.2);
		
		proxy.addProduct(prdct1);
		proxy.addProduct(prdct2);
		proxy.addProduct(prdct3);
		
		System.out.println("Product's list:");

		for (int i=0; i<proxy.getProducts().length; i++) {
			System.out.println("***********************");
			System.out.println("Product's id:"+proxy.getProducts()[i].getId());
			System.out.println("Product's type:"+proxy.getProducts()[i].getLabel());
			System.out.println("Product's price:"+proxy.getProducts()[i].getPrice());
		}
		System.out.println("********************************************************");
		 
		proxy.deleteProduct(30);
		System.out.println("Product deleted");
		
		System.out.println("Product's list:");
		for (int i=0; i<proxy.getProducts().length; i++) {
			System.out.println("***********************");
			System.out.println("Product's id:"+proxy.getProducts()[i].getId());
			System.out.println("Product's type:"+proxy.getProducts()[i].getLabel());
			System.out.println("Product's price:"+proxy.getProducts()[i].getPrice());
		}
		System.out.println("********************************************************");
	}

}