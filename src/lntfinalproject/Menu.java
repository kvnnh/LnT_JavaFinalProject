package lntfinalproject;

public class Menu {
	
	private String code, name;
	private int price;
	private int stock;
	public Menu(String kode, String nama, int harga, int stok) {
		this.code = kode;
		this.name = nama;
		this.price = harga;
		this.stock = stok;
	}
	
	public Menu(String kode2, int harga2, int stok2) {
		this.code = kode2;
		this.price = harga2;
		this.stock = stok2;
	}

	public Menu(String kode3) {
		this.code = kode3;
	}
	
	public String getKode() {
		return code;
	}
	
	public void setKode(String kode) {
		this.code = kode;
	}
	
	public String getNama() {
		return name;
	}
	
	public void setNama(String nama) {
		this.name = nama;
	}
	
	public int getHarga() {
		return price;
	}
	
	public void setHarga(int harga) {
		this.price = harga;
	}
	
	public int getStok() {
		return stock;
	}
	
	public void setStok(int stok) {
		this.stock = stok;
	}

}