package h01_anotasyonlar;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class H2_Save {

	public static void main(String[] args) {
		
		Configuration con=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(H1_Sehir.class);
//		cfg.xml dosyasindaki bilgilerle mysql e baglan ve kalip classimizi buraya cagir.
		
		SessionFactory sf=con.buildSessionFactory(); // acacagimiz alanlarin parenti, alan fabrikasi
		Session session=sf.openSession(); // alan fabrikasindan bir yer baslattik
		
		// Acilan session icerisinde islemlere baslayabilmek icin Transaction aciyoruz.
				/*Transactionlar ile bir işlem yarıda kaldıysa veya 
				 * tam olarak tamamlanadıysa tüm adımlar başa alınır
				 * veri ve işlem güvenliği için önemlidir.Kısacası ya hep 
				 * ya hiç prensibine göre çalışır
				 */
		Transaction tx=session.beginTransaction();
//		H1_Sehir sehir1 = new H1_Sehir(37, "Istanbul", 10000000);
//		session.save(sehir1); //insert into
//		
//		session.save(new H1_Sehir(35,"Izmir",2500));
		Scanner scan=new Scanner(System.in);
		System.out.println("plaka");
		int plaka=scan.nextInt();
		
		System.out.println("sehir");
		String sehir=scan.next();
		
		System.out.println("nufus");
		int nufus=scan.nextInt();
		
		session.save(new H1_Sehir(plaka,sehir,nufus));
		tx.commit(); // islemlerin DBye hizli gitmesini saglar..
		
		scan.close();
		sf.close();
		session.close();
	}

}
