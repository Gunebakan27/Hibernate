package stokTakibiZekademi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Kaydet {

	public static void main(String[] args) {
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Cari.class)
				.addAnnotatedClass(Stok.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		Stok stok1 = new Stok(510, 10, "Ürün 1", 100);
		Stok stok2 = new Stok(511, 10, "Ürün 2", 200);
		Stok stok3 = new Stok(512, 30, "Ürün 3", 80);
		Stok stok4 = new Stok(513, 15, "Ürün 4", 100);
		Stok stok5 = new Stok(514, 15, "Ürün 5", 200);
		
		Cari cari1 = new Cari(100,"Zekademi","14568799","izmir","Satıcı",100,50);
		cari1.getStokListesi().add(stok1);
		cari1.getStokListesi().add(stok5);
		cari1.getStokListesi().add(stok4);
		cari1.getStokListesi().add(stok2);
		
		Cari cari2 = new Cari(101,"Gunduz AŞ","987465212","Almanya","Satıcı",200,100);
		cari2.getStokListesi().add(stok1);
		cari2.getStokListesi().add(stok2);
		cari2.getStokListesi().add(stok3);
		cari2.getStokListesi().add(stok4);
		cari2.getStokListesi().add(stok5);
		
		Cari cari3 = new Cari(102,"Hatice AŞ","600800799","Dünya","Alıcı",300,270);
		cari3.getStokListesi().add(stok5);
		cari3.getStokListesi().add(stok3);
		cari3.getStokListesi().add(stok4);
		cari3.getStokListesi().add(stok1);
//		
//		
//		stok1.getCariListesi().add(cari1);
//		stok1.getCariListesi().add(cari2);
//		stok1.getCariListesi().add(cari3);
//		stok2.getCariListesi().add(cari1);
//		stok2.getCariListesi().add(cari2);
//		stok3.getCariListesi().add(cari3);
		
		
		session.save(cari1);
		session.save(cari2);
		session.save(cari3);
		session.save(stok1);
		session.save(stok2);
		session.save(stok3);
		session.save(stok4);
		session.save(stok5);
		
		tx.commit();
		sf.close();
		session.close();
		

	}

}
