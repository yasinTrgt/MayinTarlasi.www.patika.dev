import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
/*
 Oyun Kuralları :
 Oyun metin tabanlıdır.
 Çift boyutlu diziler üzerinden oynanmalı ve MineSweeper sınıfı içerisinde tasarlanmalı.
 Matris boyutunu yani satır ve sütun sayısını kullanıcı belirlemeli.
 Diziye ait eleman sayısının çeyreği (elemanSayisi / 4) kadar rastgele mayın yerleştirilmeli.
 Örneğin dizi 4x3 boyutunda ise eleman sayısı (satırSayısı * sütunSayısı) formülü ile hesaplanmalı ve boyutu 12 olmalı.
 Bu durumda mayın sayısı 12 / 4 = 3 adet olmalıdır. (ipucu : bu mayınların konumlarını tutacak ikinci bir dizi oluşturabilirsiniz.)
 Kullanıcı matris üzerinden bir nokta seçmeli. Nokta seçimi için satır ve sütun değerlerini girmeli.
 Seçilen noktanın dizinin sınırları içerisinde olup olmadığını kontrol edilmeli ve koşul sağlanmazsa tekrar nokta istenmeli.
 Kullanıcının girdiği noktada mayın var ise oyunu kaybetmeli.
 Mayın yok ise, ilgili noktaya değen tüm konumlarına bakılmalı
 (sağı, solu, yukarısı, aşağısı, sol üst çapraz, sağ üst çapraz, sağ alt çapraz, sol alt çapraz) ve
 etrafındaki mayınların sayısının toplamı ilgili noktaya yazılmalı. Noktaya değen herhangi bir
 mayın yok ise "0" değeri atanmalı.
 Kullanıcı hiç bir mayına basmadan tüm noktaları seçebilirse oyunu kazanmalı.

 */
    int satir;
    int sutun;
    String [][] tarla;
    String [][] mayinYeri;
    int mayin;
    int tarlaBoyutu;

    public MineSweeper(int satir,int sutun){
      this.satir=satir;
      this.sutun=sutun;
      this.tarla = new String[satir][sutun];
      this.mayinYeri = new String[satir][sutun];
      this.mayin = (this.satir*this.sutun)/4;
      this.tarlaBoyutu=this.satir*this.sutun;
    }
    public void tarlaDoldur(){
        for(int i=0;i<this.satir;i++){
            for(int j=0;j<this.sutun;j++){
                tarla[i][j]="-";
            }
        }
    }
    public void mayinla(){
        System.out.println("Mayınların Konumu");
        tarlaDoldur();
        for(int i=0;i<this.mayin;i++){
            Random rand = new Random();
            int rand_int1 = rand.nextInt(this.satir);
            int rand_int2 = rand.nextInt(this.sutun);
            if(tarla[rand_int1][rand_int2] != "*"){
                tarla[rand_int1][rand_int2]="*";
                mayinYeri[rand_int1][rand_int2] = "*";
            }
        }
        goster();
        System.out.println("============================================");
        System.out.println("Göster Kendini!!!");
    }

    public void goster(){
        for(int i=0;i<this.satir;i++){
            for(int j=0;j<this.sutun;j++){
                System.out.print(tarla[i][j]+" ");
            }
            System.out.println();
        }
    }

    public void play(){
        Scanner input = new Scanner(System.in);
        int bosAlan=this.tarlaBoyutu-this.mayin;
        while(bosAlan>0){
            System.out.print("İşaretlenecek satır değeri: ");
            int seciliSatir =input.nextInt()-1;
            System.out.print("İşaretlenecek sütun değeri: ");
            int seciliSütun =input.nextInt()-1;

            if(mayinYeri[seciliSatir][seciliSütun]=="*"){
                System.out.println("====GAME OVER====");
                return;
            }
            if(tarla[seciliSatir][seciliSütun]=="-"){
                tarla[seciliSatir][seciliSütun]=mayinSayar(seciliSatir,seciliSütun);
            }
            goster();
            System.out.println("============================================");
            bosAlan--;
        }
        System.out.println("Tebrikler kazandınız!!!");
    }

    public String mayinSayar(int seciliSatir,int seciliSütun){
        int mayinSayar=0;
        for (int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(seciliSatir-1+i>=0 && seciliSatir-1+i<tarla.length){
                    if(seciliSütun-1+j>=0 && seciliSütun-1+j<tarla[i].length){
                        if(mayinYeri[seciliSatir-1+i][seciliSütun-1+j]=="*"){
                            mayinSayar++;
                        }
                    }
                }
            }


        }
        String s=Integer.toString(mayinSayar);
        return s;
    }

    public void run(){

        mayinla();
        tarlaDoldur();
        goster();
        play();


    }








}
