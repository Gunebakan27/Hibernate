package okulProjesi;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Ogrenci extends Kisi {

	@Id
	private int ogr_id;
	private String ogr_veli_adi;
	private int ogr_sinif;
	private String ogr_sube;
	
	@ManyToMany
	@JoinTable(
            name = "Ogr_Ogrt", 
            joinColumns = { @JoinColumn(name = "ogrenci") }, 
            inverseJoinColumns = { @JoinColumn(name = "ogretmen") })
	
	private List<Ogretmen> ogretmenListesi = new ArrayList<>();
	
	
	
	
	
	public Ogrenci() {}

	public Ogrenci(int ogr_id, String tc_No, String ad, String soyad, Date d_tarihi, String tel, String adres, String ogr_veli_adi,
			int ogr_sinif, String ogr_sube) {
		super(tc_No, ad, soyad, d_tarihi, tel, adres);
		this.ogr_veli_adi = ogr_veli_adi;
		this.ogr_sinif = ogr_sinif;
		this.ogr_sube = ogr_sube;
		this.ogr_id = ogr_id;
	}

	public String getOgr_veli_adi() {
		return ogr_veli_adi;
	}

	public void setOgr_veli_adi(String ogr_veli_adi) {
		this.ogr_veli_adi = ogr_veli_adi;
	}

	public int getOgr_sinif() {
		return ogr_sinif;
	}

	public void setOgr_sinif(int ogr_sinif) {
		this.ogr_sinif = ogr_sinif;
	}

	public String getOgr_sube() {
		return ogr_sube;
	}

	public void setOgr_sube(String ogr_sube) {
		this.ogr_sube = ogr_sube;
	}

	
	@Override
	public String toString() {
		return "ogr_id=" + ogr_id + ",ogr_veli_adi=" + ogr_veli_adi + ", ogr_sinif=" + ogr_sinif + ", ogr_sube=" + ogr_sube
				+ ", getTc_No()=" + getTc_No() + ", getAd()=" + getAd() + ", getSoyad()=" + getSoyad()
				+ ", getD_tarihi()=" + getD_tarihi() + ", getTel()=" + getTel() + ", getAdres()=" + getAdres();
	}

	public List<Ogretmen> getOgretmenListesi() {
		return ogretmenListesi;
	}

	public void setOgretmenListesi(List<Ogretmen> ogretmenListesi) {
		this.ogretmenListesi = ogretmenListesi;
	}

	public int getOgr_id() {
		return ogr_id;
	}

	public void setOgr_id(int ogr_id) {
		this.ogr_id = ogr_id;
	}
	
	
	
}
