import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("===MİNE SWEEPER===");
        System.out.print("Satır boyutunu giriniz: ");
        int satir =sc.nextInt();
        System.out.print("Sütun boyutunu giriniz: ");
        int sütun = sc.nextInt();

        MineSweeper ms = new MineSweeper(satir,sütun);
        ms.run();
    }
}
