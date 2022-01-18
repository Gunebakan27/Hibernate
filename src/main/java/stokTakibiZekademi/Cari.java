package stokTakibiZekademi;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
public class Cari {

	@Id
	private int cari_id;

	private String cari_adi;
	private String cari_tel, cari_adres, cari_tipi;
	private double cari_borc, cari_alacak;
	
	@ManyToMany
	@JoinTable(name="cari_stok",
	joinColumns= {@JoinColumn(name="cari_id")},
	inverseJoinColumns={@JoinColumn(name="stok_id")}
			)
	private List<Stok> stokListesi = new ArrayList<>();
	

	public Cari() {}


	public Cari(int cari_id, String cari_adi, String cari_tel, String cari_adres, String cari_tipi, double cari_borc,
			double cari_alacak) {
		
		this.cari_id = cari_id;
		this.cari_adi = cari_adi;
		this.cari_tel = cari_tel;
		this.cari_adres = cari_adres;
		this.cari_tipi = cari_tipi;
		this.cari_borc = cari_borc;
		this.cari_alacak = cari_alacak;
		
	}


	public int getCari_id() {
		return cari_id;
	}


	public void setCari_id(int cari_id) {
		this.cari_id = cari_id;
	}


	public String getCari_adi() {
		return cari_adi;
	}


	public void setCari_adi(String cari_adi) {
		this.cari_adi = cari_adi;
	}


	public String getCari_tel() {
		return cari_tel;
	}


	public void setCari_tel(String cari_tel) {
		this.cari_tel = cari_tel;
	}


	public String getCari_adres() {
		return cari_adres;
	}


	public void setCari_adres(String cari_adres) {
		this.cari_adres = cari_adres;
	}


	public String getCari_tipi() {
		return cari_tipi;
	}


	public void setCari_tipi(String cari_tipi) {
		this.cari_tipi = cari_tipi;
	}


	public double getCari_borc() {
		return cari_borc;
	}


	public void setCari_borc(double cari_borc) {
		this.cari_borc = cari_borc;
	}


	public double getCari_alacak() {
		return cari_alacak;
	}


	public void setCari_alacak(double cari_alacak) {
		this.cari_alacak = cari_alacak;
	}


	public List<Stok> getStokListesi() {
		return stokListesi;
	}


	public void setStokListesi(List<Stok> stokListesi) {
		this.stokListesi = stokListesi;
	}


	@Override
	public String toString() {
		return "Cari [cari_id=" + cari_id + ", cari_adi=" + cari_adi + ", cari_tel=" + cari_tel + ", cari_adres="
				+ cari_adres + ", cari_tipi=" + cari_tipi + ", cari_borc=" + cari_borc + ", cari_alacak=" + cari_alacak
				+ ", stokListesi=" + stokListesi + "]";
	}
	

	
	
}
