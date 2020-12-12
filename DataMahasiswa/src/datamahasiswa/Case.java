package datamahasiswa;

/**
 *
 * @author BijiSelasih69
 */
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Collections;

public class Case {
    ArrayList<String> nama = new ArrayList<>();
    ArrayList<String> nim = new ArrayList<>();
    ArrayList<Date> tglLahir = new ArrayList<>();
    ArrayList<Integer> jKel = new ArrayList<>();
    SimpleDateFormat simple = new SimpleDateFormat("dd/MMM/YYYY");
    
     
    void tambah() {
        Scanner input = new Scanner(System.in);
        System.out.println("======================");
        System.out.println("      Tambah Data     ");
        System.out.println("======================");
        System.out.print("\nMasukkan Nama\t: ");
        String nama2 = input.nextLine();
        System.out.print("Masukkan NIM\t: ");
        String nim2 = input.nextLine();
        System.out.println("Tanggal Lahir");
        System.out.print("Hari (HH)\t: ");
        int hari = input.nextInt();
        System.out.print("Bulan (BB)\t: ");
        int bulan = input.nextInt();
        System.out.print("Tahun (TTTT)\t: ");
        int tahun = input.nextInt();
        Date tglLahir2 = new GregorianCalendar(tahun, bulan -1, hari).getTime();
        //diberi -1 karena gregorian menghitung bulan dari 0
        System.out.print("Jenis Kelamin (1:L 2:P)\t: ");
        int jKel2 = input.nextInt();
        nama.add(nama2);
        nim.add(nim2);
        tglLahir.add(tglLahir2);
        jKel.add(jKel2);
        System.out.println("\nData Berhasil Dimasukkan!");
    }
    void hapus() {
        Scanner input = new Scanner(System.in);
        if (nim.isEmpty() == false) {
            try {
                System.out.println("=======================");
                System.out.println("       Hapus Data      ");
                System.out.println("=======================");
                System.out.print("Masukkan NIM\t: ");
                String nimHapus = input.next();
                int target = Collections.binarySearch(nim, nimHapus);
                nama.remove(target);
                nim.remove(target);
                tglLahir.remove(target);
                jKel.remove(target); 
                System.out.println("=========================");
                System.out.println("  Data Berhasil Dihapus  ");
                System.out.println("=========================");
            }
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("================");
                System.out.println(" Data Tidak Ada ");
                System.out.println("================");
            }
        }
        else {
            System.out.println("=====================");
            System.out.println("  Data Masih Kosong  ");
            System.out.println("=====================");
        }
    }
    void cariData() {
        Scanner input = new Scanner(System.in);
        if (nim.isEmpty() == false) {
            System.out.println("===============");
            System.out.println("   Cari Data   ");
            System.out.println("===============");
            System.out.println("Berdasarkan : ");
            System.out.println("1. NIM");
            System.out.println("2. Jenis Kelamin");
            System.out.println("===============");
            System.out.print("Masukkan Pilihan : ");
            switch(input.nextLine()) {
                case "1": {
                    try {
                        System.out.print("Masukkan NIM : ");
                        String cariNim = input.next();
                        int target = Collections.binarySearch(nim, cariNim);
                        String cariNama = nama.get(target);
                        String cariNIM =  nim.get(target);
                        String cariTgl = simple.format(tglLahir.get(target));
                        String cariJKel = (jKel.get(target) == 1) ? "Laki-Laki" : "Perempuan";
                        
                        System.out.println("Nama\t: "+ cariNama);
                        System.out.println("NIM\t: "+ cariNIM);
                        System.out.println("Tanggal Lahir\t: "+ cariTgl);
                        System.out.println("Jenis Kelamin\t: "+ cariJKel);
                        
                    }
                    catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("==================");
                        System.out.println("  Data Tidak Ada  ");
                        System.out.println("==================");
                    }
                    break;
                }
                case "2": {
                    System.out.print("Masukkan Jenis Kelamin (1:L 2:P) : ");
                    int carijKel = input.nextInt();
                    for (int i = 0; i < jKel.size(); i++) {
                        if (jKel.get(i) == carijKel) {
                            String cariNama = nama.get(i);
                            String cariNIM =  nim.get(i);
                            String cariTgl = simple.format(tglLahir.get(i));
                            String cariJKel = (jKel.get(i) == 1) ? "Laki-Laki" : "Perempuan";
                    
                            System.out.println("Nama\t: "+ cariNama);
                            System.out.println("NIM\t: "+ cariNIM);
                            System.out.println("Tanggal Lahir\t: "+ cariTgl);
                            System.out.println("Jenis Kelamin\t: "+ cariJKel);
                            System.out.println("=============================");
                        }   
                    }  
                }
            }
        }
        else {
            System.out.println("=====================");
            System.out.println("  Data Masih Kosong  ");
            System.out.println("=====================");
        }
    }
    void tampilData() {
        if (nama.isEmpty() == false) {
            System.out.println("===============");
            System.out.println("  Tampil Data  ");
            System.out.println("===============");
            for (int i = 0; i<nama.size(); i++) {
                String showNama = nama.get(i);
                String showNIM =  nim.get(i);
                String showTgl = simple.format(tglLahir.get(i));
                String showJKel = (jKel.get(i) == 1) ? "Laki-Laki" : "Perempuan";
                System.out.println("Mahasiswa "+ (i+1));
                System.out.println("===========");
                System.out.println("Nama\t: "+ showNama);
                System.out.println("NIM\t: "+ showNIM);
                System.out.println("Tanggal Lahir\t: "+ showTgl);
                System.out.println("Jenis Kelamin\t: "+ showJKel);
                System.out.println("=============================");
            }
        }
        else {
            System.out.println("=====================");
            System.out.println("  Data Masih Kosong  ");
            System.out.println("=====================");
        }
        System.out.println("================");
        System.out.println("Jumlah Data : "+ nama.size());
        System.out.println("================");
    }
}
