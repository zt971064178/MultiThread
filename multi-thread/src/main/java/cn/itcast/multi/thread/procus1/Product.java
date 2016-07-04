package cn.itcast.multi.thread.procus1;

public class Product {
	private int id;

    public Product(int id) {
        this.setId(id);
    }


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String toString() {
		return "产品：" + this.id;
	}
}
