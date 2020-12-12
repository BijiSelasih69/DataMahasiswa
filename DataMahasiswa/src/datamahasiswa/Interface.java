package datamahasiswa;

/**
 *
 * @author BijiSelasih69
 */
import java.util.Scanner;

public class Interface {
    
    Scanner input = new Scanner(System.in);
    boolean benar = true;
    
    void mainMenu() {
        
        Case menu = new Case();
        
        while(benar) {
            System.out.println("=======================");
            System.out.println("     Data Mahasiswa    ");
            System.out.println("=======================");
            System.out.println("1. Input Data\n2. Hapus Data\n3. Cari Data\n4. Tampil Data\n5. Keluar");
            System.out.println("=======================");
            System.out.print("Masukkan Pilihan Anda : ");
            
            switch(input.nextLine()) {
                
                case "1": {
                    menu.tambah();
                    break;
                }
                case "2": {
                    menu.hapus();
                    break;
                }
                case "3": {
                    menu.cariData();
                    break;
                }    
                case "4": {
                    menu.tampilData();
                    break;
                }
                case "5": {
                    System.out.println("========================");
                    System.out.println("  ❤Sampai Jumpa Lagi❤  ");
                    System.out.println("========================");
                    benar = false;
                    break;
                }
                default : {
                    System.out.println("=============================");
                    System.out.println("Masukkan Pilihan Dengan Benar");
                    System.out.println("=============================");
                }
            }
        }
    }
}
