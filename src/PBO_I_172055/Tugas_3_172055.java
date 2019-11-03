package PBO_I_172055;
import java.util.Scanner;

public class Tugas_3_172055 {

    public static void main(String[] args) {

        Scanner baca = new Scanner(System.in);
        int k = 1;
        
        String[] nim = new String[5];
        String[] nama = new String[5];
        String[] umur = new String[5];
        String[] prodi = new String[5];
        
        char jawaban;
        boolean jawab = true;
        
        for(int x = 0 ; jawab ; x++)
        {
            System.out.print("Masukkan NIM \t: ");
            nim[x] = baca.nextLine();
            System.out.print("Masukkan Nama \t: ");
            nama[x] = baca.nextLine();
            System.out.print("Masukkan Umur \t: ");
            umur[x] = baca.nextLine();
            
            if (nim[x].charAt(2) == '1') 
            {
                prodi[x] = "Sistem Informasi";
            }
            else if(nim[x].charAt(2) == '2')
            {
                prodi[x] = "Teknik Informatika";
            }
            else if (nim[x].charAt(2) == '3')
            {
                prodi[x] = "Manajemen Informatika";
            }
            else
            {
                prodi[x] = "parodi tidak terdaftar";
            }
            
            System.out.print("Masih Ingin menginput data [Y/N]");
            jawaban = baca.nextLine().charAt(0);
            
            jawab = jawaban == 'y'; 
            System.out.println("");
        }
        
        for(int j = 0 ; j < nama.length; j++)
        {
            int q = j + k;
            System.out.println("Data Mahasiswa ke-" + q);
            System.out.println("NIM \t: " + nim[j]);
            System.out.println("NAMA \t: " + nama[j]);
            System.out.println("PRODI \t: " + prodi[j]);
            System.out.println("UMUR \t: " + umur[j] + "TAHUN");
            System.out.println("");
        } 

    }
    
}