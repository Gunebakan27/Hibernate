package okulProjesi;

import java.util.Date;

public class Kisi {
	
	private String tc_No;
	
	private String ad;
	private String soyad;
	private Date d_tarihi;
	private String tel;
	private String adres;
	
	public Kisi() {
		
	}

	public Kisi(String tc_No, String ad, String soyad, Date d_tarihi, String tel, String adres) {
		
		this.tc_No = tc_No;
		this.ad = ad;
		this.soyad = soyad;
		this.d_tarihi = d_tarihi;
		this.tel = tel;
		this.adres = adres;
	}

	public String getTc_No() {
		return tc_No;
	}

	public void setTc_No(String tc_No) {
		this.tc_No = tc_No;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	public Date getD_tarihi() {
		return d_tarihi;
	}

	public void setD_tarihi(Date d_tarihi) {
		this.d_tarihi = d_tarihi;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	@Override
	public String toString() {
		return "tc_No=" + tc_No + ", ad=" + ad + ", soyad=" + soyad + ", d_tarihi=" + d_tarihi + ", tel=" + tel
				+ ", adres=" + adres;
	}
	
	
}
