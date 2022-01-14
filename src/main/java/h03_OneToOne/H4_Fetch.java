package h03_OneToOne;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class H4_Fetch {

	public static void main(String[] args) {
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(H1_Kisi.class)
				.addAnnotatedClass(H2_Gunluk.class);

		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();

		// 1) id=101 olan işi bilfgilerini getir
		System.out.println("1. soru "+session.get(H1_Kisi.class, 101));
		
		// 2) id=12 olan gunluk bilgilerini getir.
		System.out.println("2. soru "+session.get(H2_Gunluk.class, 12));
		
		// 2-a) gunluk class ındaki tum verileri getir.
		List<Object[]>liste= session.createQuery("FROM H1_Kisi k JOIN H2_Gunluk g ON k.kisiId=g.kisi").getResultList();
				//liste.forEach((x)->System.out.println(Arrays.toString(x)));
		liste.stream().forEach((t)->System.out.println(Arrays.deepToString((Object[]) t)));	//2. YONTEM
		System.out.println("************** SORU 2 SONU **********************************");
		
		//3) Kisiler ve Gunlukler tablolarindaki ortak olan (one to one ile birebir bağladığımız) kayıtların,
		// Kisi adi, gunluk yazisi(yazilar) ve kisi yası (kisiYas) bilgilerini sorgulayiniz.
		
		  String sorgu = "Select k.kisi_ad, g.owner, k.kisiYas"
                  + " from kisiler k inner join gunlukler g"
                  +" on k.kisi_id=g.baglanti";
List<Object[]> sonuc=session.createSQLQuery(sorgu).getResultList();
for(Object[] each : sonuc) {
  System.out.println(Arrays.toString(each));
}
		System.out.println("*************** SORU 3 SONU *********************************");
		
		tx.commit();
		
		sf.close();
		session.close();
	}

}