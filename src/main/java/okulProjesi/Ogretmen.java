package okulProjesi;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Ogretmen extends Kisi {
	@Id
	private int ogrt_id;
	private String ogrt_brans;
	
	@ManyToMany(mappedBy = "ogretmenListesi")//ogretmen objesi ile aynı isim olsun
	private List<Ogrenci> ogrenciListesi = new ArrayList<>(); 

	public Ogretmen() {
		
	}

	public Ogretmen(int ogrt_id, String tc_No, String ad, String soyad, Date d_tarihi, String tel, String adres, String ogrt_brans) {
		super(tc_No, ad, soyad, d_tarihi, tel, adres);
		this.ogrt_brans = ogrt_brans;
		this.ogrt_id = ogrt_id;
	}

	public String getOgrt_brans() {
		return ogrt_brans;
	}

	public void setOgrt_brans(String ogrt_brans) {
		this.ogrt_brans = ogrt_brans;
	}

	@Override
	public String toString() {
		return "ogrt_id=" + ogrt_id + ", ogrt_brans=" + ogrt_brans + ", getTc_No()=" + getTc_No() + ", getAd()=" + getAd()
				+ ", getSoyad()=" + getSoyad() + ", getD_tarihi()=" + getD_tarihi() + ", getTel()=" + getTel()
				+ ", getAdres()=" + getAdres();
	}

	public List<Ogrenci> getOgrenciListesi() {
		return ogrenciListesi;
	}

	public void setOgrenciListesi(List<Ogrenci> ogrenciListesi) {
		this.ogrenciListesi = ogrenciListesi;
	}

	public int getOgrt_id() {
		return ogrt_id;
	}

	public void setOgrt_id(int ogrt_id) {
		this.ogrt_id = ogrt_id;
	} 
	
	
	
}
