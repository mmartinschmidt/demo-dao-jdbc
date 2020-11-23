package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		 
		//Department obj = new Department(1, "Books");
		//System.out.println(obj);

		//Department obj = new Department(1, "Books");
		//Seller seller = new Seller(21, "Bob", "bob@gmail.com", new Date(), 3000.0, obj);
		//SellerDao sellerDao = DaoFactory.createSellerDao();
		//System.out.println(seller);
		
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		//////////////////////////////////////////////////////////////
		System.out.println("==== Teste 1: seller findById ====");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
        //////////////////////////////////////////////////////////////
		System.out.println("\n==== Teste 2: seller findByDepartment ====");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list ) {
			System.out.println(obj);
		}
        //////////////////////////////////////////////////////////////
		System.out.println("\n==== Teste 3: seller findAll ====");
	    list = sellerDao.findAll();
		for (Seller obj : list ) {
			System.out.println(obj);
		}
        //////////////////////////////////////////////////////////////
		System.out.println("\n==== Teste 4: seller insert ====");
		Seller newSeller = new Seller(null, "Gred", "gred@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		//System.out.println("Inserted! New Id = " + newSeller.getId());
		System.out.println("Inserido! Novo Id = " + newSeller.getId());
        //////////////////////////////////////////////////////////////
        System.out.println("\n==== Teste 5: seller update ====");
        seller = sellerDao.findById(1);
        seller.setName("Martha Waine");
        sellerDao.update(seller);
        //System.out.println("Update completed");
        System.out.println("Update conclu�do");
        //////////////////////////////////////////////////////////////
        System.out.println("\n==== Teste 6: seller delete ====");
        //System.out.println("Enter id for delete test: ");
        System.out.println("Digite id para o teste delete: ");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        //System.out.println("Delete completed");
        System.out.println("Delete conclu�do");
        sc.close();
        //////////////////////////////////////////////////////////////
	}

}
