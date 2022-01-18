package h06_ManyToMany;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class H4_Fetch {

	public static void main(String[] args) {
		Configuration con = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(H1_Ogrenci.class)
				.addAnnotatedClass(H2_Kitap.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
// id=1111 olan ögrencinin bilgilerini getir
		
		System.out.println(session.get(H1_Ogrenci.class, 1111));
		
// id=101 olan kitabi getir		
		System.out.println(session.get(H2_Kitap.class, 101));
		
		// adi math olan kitabin bilgilerini getir
		String hqlQuery1="FROM H2_Kitap k WHERE k.book='math book'";
		System.out.println(session.createQuery(hqlQuery1).getSingleResult());
		
		//4)Adı "Ali Can" olan öğrenciyi getirin. Kitapları da görmek istiyorum.HQL yazıyoruz, from classismi yazılır.
		//herşey isteniyorsa select* gerek yok
		
	Object sorgu=session.createQuery("FROM H1_Ogrenci o WHERE o.name='Ali can'").getSingleResult();
		System.out.println(sorgu);
		
		List<H1_Ogrenci>sorgu3=session.createQuery("SELECT o.name FROM H1_Ogrenci o").getResultList();
		System.out.println(session.createQuery("SELECT o.name FROM H1_Ogrenci o").getResultList());
		
		System.out.println(session.createQuery("select k.book from H2_Kitap k").getResultList());
		//--------------------------------------------------------------------------
				//  LAZY FETCH VS EAGER FETCH  
				//------------------------------------------------------------------------
				
				/* 
				 *  Hibernate veritabanından verileri cekerken AC GOZLU(EAGER) veya TEMBEL(LAZY) olabilmektedir. 
				 *  EAGER Fetch isleminde bir tablodan veri cekilmesi istendiginde Hibernate o tablo ile iliskili
				 *  Tum tablolari da getirir. 
				 *  
				 *  Eger LAZY fetch islemi kullanilirsa sadece istenilen tablonun verileri getirilir. 
				 * 
				 *  2 yontemin de avantajlari ve dezavatanjlari vardir. Tercih, uygulanin gereksinimlerine gore belirlenir.  
				 * 
				 *  LAZY fetch gereksiz verilerin cekilmemesini saglamak icin ve daha dusuk bellek kullanimi icin daha elvereslidir. 
				 *  Ancak, zamana duyarlı uygulamalarda problem olusturuabilir. iliskili verilerin tek tek veritabnindan getirilmesi
				 *  zaman kayıolarina yol acabilir. 
				 * 
				 *  EAGER fetch ise bazen kullanimayacak veriler bastan pesin pesin getirilmesine yol acabilir.
				 *   
				 *   */
				
		 
			//	System.out.println(session.get(H1_Ogrenci.class, 333));
		
		
		
		tx.commit();
		sf.close();
		session.close();
	}

}
