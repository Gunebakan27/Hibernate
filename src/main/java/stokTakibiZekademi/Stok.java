package stokTakibiZekademi;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
public class Stok {
	
@Id
	private int stok_id;
	private int stok_adet;
	private String stok_adi;
	private double stok_fiyat;
	
	@ManyToMany(mappedBy = "stokListesi") // diger classdaki liste ismiyle ayni olmali
	List<Cari> cariListesi = new ArrayList<>();
	
	public Stok() {}

	public Stok(int stok_id, int stok_adet, String stok_adi, double stok_fiyat) {
	
		this.stok_id = stok_id;
		this.stok_adet = stok_adet;
		this.stok_adi = stok_adi;
		this.stok_fiyat = stok_fiyat;
	}

	public int getStok_id() {
		return stok_id;
	}

	public void setStok_id(int stok_id) {
		this.stok_id = stok_id;
	}

	public int getStok_adet() {
		return stok_adet;
	}

	public void setStok_adet(int stok_adet) {
		this.stok_adet = stok_adet;
	}

	public String getStok_adi() {
		return stok_adi;
	}

	public void setStok_adi(String stok_adi) {
		this.stok_adi = stok_adi;
	}

	public double getStok_fiyat() {
		return stok_fiyat;
	}

	public void setStok_fiyat(double stok_fiyat) {
		this.stok_fiyat = stok_fiyat;
	}

	public List<Cari> getCariListesi() {
		return cariListesi;
	}

	public void setCariListesi(List<Cari> cariListesi) {
		this.cariListesi = cariListesi;
	}

	@Override
	public String toString() {
		return "Stok [stok_id=" + stok_id + ", stok_adet=" + stok_adet + ", stok_adi=" + stok_adi + ", stok_fiyat="
				+ stok_fiyat + "]";
	}
	

}
