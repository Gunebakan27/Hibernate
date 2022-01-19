package h07_crudProject;

public class Main {

	public static void main(String[] args) {

		CrudMethods metod=new CrudMethods();
		metod.sessionFactoryOlustur();// her run edildiginde cagirmak gerekli
//		metod.ekle("Ayse", "Bilir", 5500);
//		metod.ekle("Ali", "Bilmez", 8800);
//		metod.ekle("Veli", "Can", 5500);
//		metod.idIleSatirSil(1);
//		metod.idIleMaasGuncelle(2, 7700);
		
		metod.sil();
		
		metod.verileriGoster();
	}

}
