package okulProjesi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Save {

	public static void main(String[] args) {
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml")
							.addAnnotatedClass(Ogrenci.class)
							.addAnnotatedClass(Ogretmen.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		Ogrenci ogr1 = new Ogrenci(11, "123456789", "Zühre", "Canbal", null, "555 555 55 55", "İzmir Türkiye", "Zekeriya", 10, "A");
		Ogrenci ogr2 = new Ogrenci(12, "234567890", "Nil Hifa", "Canbal", null, "555 555 55 55", "İzmir Türkiye", "Zekeriya", 5, "B");		
		Ogrenci ogr3 = new Ogrenci(13, "345678901", "Mehmet", "Gündüz", null, "444 444 44 44", "Almanya", "İslam", 12, "A");
		
		Ogretmen ogrt1 = new Ogretmen (101, "987654321", "Burhan", "Bediz", null, "yok", "Karşıyaka/İzmir", "Matematik");
		Ogretmen ogrt2 = new Ogretmen (102, "876543210", "İslam", "GÜZDÜZ", null, "yok", "Almanya", "Matematik");
		Ogretmen ogrt3 = new Ogretmen (103, "765432101", "Zekeriya", "CANBAL", null, "yok", "İzmir", "Bilgisayar");
		Ogretmen ogrt4 = new Ogretmen (104, "765432109", "İpek", "Bilgin", null, "555 555 55 55", "Denizli", "IT & BT");
		Ogretmen ogrt5 = new Ogretmen (105, "654321098", "Haluk", "Bilgin", null, "555 555 55 55", "Denizli", "IT & BT");
		
		ogr1.getOgretmenListesi().add(ogrt1);
		ogr1.getOgretmenListesi().add(ogrt2);
		ogr2.getOgretmenListesi().add(ogrt2);
		ogr2.getOgretmenListesi().add(ogrt4);
		ogr2.getOgretmenListesi().add(ogrt5);
		ogr3.getOgretmenListesi().add(ogrt4);
		ogr3.getOgretmenListesi().add(ogrt5);
		ogr3.getOgretmenListesi().add(ogrt1);
		
		session.save(ogr1);
		session.save(ogr2);
		session.save(ogr3);
		session.save(ogrt1);
		session.save(ogrt2);
		session.save(ogrt3);
		session.save(ogrt4);
		session.save(ogrt5);
		
		tx.commit();
		sf.close();
		session.close();
	}

}
