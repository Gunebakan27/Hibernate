package h02_embeddable;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import h01_anotasyonlar.H1_Sehir;

public class H3_SaveFetch {
	public static void main(String[] args) {
		SessionFactory sf=
				new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(H1_Ogrenci.class).buildSessionFactory();
Session session=sf.openSession();
Transaction tx=session.beginTransaction();
		H2_Dersler dersler=new H2_Dersler("Music", "Math");
		H1_Ogrenci ogr=new H1_Ogrenci(101,"Ali Can",15,dersler);
		
//		session.save(ogr);
		System.out.println(session.get(H1_Ogrenci.class,101));
		
//		session.save(new H1_Ogrenci(102,"Veli Han",90,new H2_Dersler("Beden","Fizik")));
		System.out.println(session.get(H1_Ogrenci.class,102));

//		Scanner scan=new Scanner(System.in);
//		System.out.println("silinecek no?");
//		int no=scan.nextInt();
//		
//session.delete(session.get(H1_Ogrenci.class, no));

		session.get(H1_Ogrenci.class, 102).setAd("Ali");
		
		

tx.commit();
sf.close();
session.close();
//scan.close();
	}

}
