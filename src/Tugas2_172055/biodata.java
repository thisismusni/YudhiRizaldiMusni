package Tugas2_172055;
import java.util.Scanner;

public class biodata 
{
     public static void main(String[] args) 
    {
        String name, stb, umur;
        
        Scanner baca = new Scanner(System.in);
        
        System.out.println("BIODATA MAHASISWA\n");
        
        System.out.print("Masukkan Nama Anda \t: ");
        name = baca.nextLine();
        System.out.print("Masukkan Stambuk Anda \t: ");
        stb = baca.nextLine();
        System.out.print("Masukkan Umur Anda \t: ");
        umur = baca.nextLine();
        
        System.out.println("");
        System.out.println("Nim " + stb + " Dengan Nama " + name + " Berumur " + umur + " Tahun");        
    }
}
