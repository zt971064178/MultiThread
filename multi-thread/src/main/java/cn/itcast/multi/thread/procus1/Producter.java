package cn.itcast.multi.thread.procus1;

public class Producter implements Runnable {
	private String name;
    private Storage s = null;

    public Producter(String name, Storage s) {
        this.name = name;
        this.s = s;
    }

    public void run() {
        try {
            while (true) {
                Product product = new Product((int) (Math.random() * 10000)); // 产生0~9999随机整数
                System.out.println(name + "准备生产(" + product.toString() + ").");
                s.push(product);
                System.out.println(name + "已生产(" + product.toString() + ").");
                System.out.println("===============");
                Thread.sleep(2000);
            }
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

    }

}
