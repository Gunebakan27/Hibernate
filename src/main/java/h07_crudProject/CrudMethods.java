package h07_crudProject;

import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CrudMethods {
	private static SessionFactory sf;
	
public void sessionFactoryOlustur() {
	try {
		Configuration con = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Personel.class);
	 sf= con.buildSessionFactory();
	
	} catch (Throwable e) { //oturum açmak veya yanlış gidebilecek her şeyi kesinlikle ele almak 
        //istediğiniz bir iş parçacığının en yüksek "tümünü yakala" düzeyi
	System.out.println("Session Factory olusurken hata olustu"+e.getMessage());
	throw new ExceptionInInitializerError(e);//üstteki de kullanilabilir
	}
}
// veri tabanina personel ekleyen method
public void  ekle(String ad, String soyad, int maas) {
	Session session = sf.openSession();
	Transaction tx = session.beginTransaction();
	try {
		session.save(new Personel(ad,soyad,maas));
		
		tx.commit();
	} catch (HibernateException e) {
		if(tx!=null) {
			tx.rollback();
		}e.printStackTrace();	
	}finally {// her durumda kapatsin diye
		session.close();
	}
}
public void idIleSatirSil(long id) {// Long seklinde de olabilir
	Session session = sf.openSession();
	Transaction tx = session.beginTransaction();
	try {
		Personel person=session.get(Personel.class, id);
		if (person==null) {
			System.out.println(id +" nolu kisi bulunamamistir");
		}else {
			session.delete(person);
			tx.commit();
			System.out.println(id+" nolu "+person+" isimli kisi sillinmistir");
		}
		
	}  catch (HibernateException e) {
		if(tx!=null) {
			tx.rollback();
		}e.printStackTrace();	
	}finally {// her durumda kapatsin diye
		session.close();
	}
}
public void idIleMaasGuncelle(long id, int maas) {
	Session session = sf.openSession();
	Transaction tx = session.beginTransaction();
	
	try {
		Personel person=session.get(Personel.class, id);
		if (person==null) {
			System.out.println(id +" nolu kisi bulunamamistir");
		}else {
			person.setMaas(maas);		
			tx.commit();
			System.out.println(id+" nolu "+person+" maasi "+maas+" olarak güncellenmistir");
		}
		
	} catch (HibernateException e) {
		if(tx!=null) {
			tx.rollback();
		}e.printStackTrace();	
	}finally {// her durumda kapatsin diye
		session.close();
	}
}
public void verileriGoster() {
	Session session = sf.openSession();
	Transaction tx = session.beginTransaction();
	try {
		List<Personel>persons=session.createQuery("from Personel").getResultList(); // HQL sorgusu - list döndürür
		persons.stream().forEach(t->System.out.println(t));
		tx.commit();
	} catch (HibernateException e) {
		if(tx!=null) {
			tx.rollback();
		}e.printStackTrace();	
	}finally {// her durumda kapatsin diye
		session.close();
	}
}
public void sil() {
	
	
	Session session = sf.openSession();
	 
	Transaction	tx = session.beginTransaction();
	
   Scanner scan=new Scanner(System.in);
   System.out.println("lütfen silmek istediğiniz kişinin id sini giriniz");
   long no =scan.nextLong();

  Personel personel = session.get(Personel.class, no);
		
		if(personel == null) {
			System.out.println(no + " nolu kisinin kaydi bulunamamistir.");
		}else {
			session.delete(personel);
			tx.commit(); //önce silinmeyi kaydet sonra syso ile göster
			System.out.println(no + " nolu kisinin kaydi silinmistir.");
		}
		scan.close();
		session.close();
}

}
