package Tugas2_172055;
import java.util.Scanner;

public class biodata 
{
     public static void main(String[] args) 
    {
        String nama, nim, umur;
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("BIODATA MAHASISWA\n");
        
        System.out.print("Masukkan Nama Anda \t: ");
        nama = input.nextLine();
        System.out.print("Masukkan Stambuk Anda \t: ");
        nim = input.nextLine();
        System.out.print("Masukkan Umur Anda \t: ");
        umur = input.nextLine();
        
        System.out.println("");
        System.out.println("Nim " + nim + " Dengan Nama " + nama + " Berumur " + umur + " Tahun");        
    }
}
