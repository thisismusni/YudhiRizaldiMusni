package PBO_I_172055;
import java.io.*;

public class Tugas_5_172055
{
    public static String me()throws IOException
    {       
        DataInputStream baca = new DataInputStream(System.in);
        String[] name = new String[10];
        String[] stb = new String[10];
        String[] umur = new String[10];
        String[] prodi = new String[10];
        String jawab;
        int indeks=0;
        
        do
        {
            indeks++;
            System.out.print("NIM \t: ");
            stb[indeks] = baca.readLine();
            System.out.print("NAMA \t: ");
            name[indeks] = baca.readLine();
            System.out.print("UMUR \t: ");
            umur[indeks] = baca.readLine();
            System.out.print("Lanjut Menginput Data?(y/n) : ");
            jawab = baca.readLine();
        }   
        while(jawab.equals("y"));
        
        try
        {
            System.out.println("Jumlah Data Mahasiswa yang Terinput = "+indeks);
            System.out.print("Ingin Menampilkan Data Mahasiswa yang ke : ");
            indeks = Integer.parseInt(baca.readLine());
            System.out.println("+==============================+");
            System.out.println("Data Mahasiswa yang urutan ke-"+indeks);
            System.out.println("+==============================+");
            prodi[indeks] = stb[indeks].substring(2,3);
            switch(prodi[indeks])
            {
                case "1": System.out.println("PRODI \t: Sistem Informasi");
                break;
                case "2": System.out.println("PRODI \t: Teknik Informatika");
                break;
                case "3": System.out.println("PRODI \t: Manajemen Informatika");
                break;
                case "4": System.out.println("PRODI \t: Rekayasa Perangkat Lunak");
                break;
                default: System.out.println("Prodi Belum Ada");
            }  
            System.out.println("NIM \t: " +stb[indeks]);
            System.out.println("NAMA \t: " +name[indeks]);
            System.out.println("UMUR \t: "+umur[indeks]+"Thn");
            System.out.println("--------------------------------");
            
        }
        catch(NullPointerException ex)
        {
            System.out.println("Tidak ada data mahasiswa pada urutan ke-"+indeks);
        }
        finally
        {
            System.out.println("Succesful");
        }
        return("");
    } 
    
    public static void main(String[] args) throws IOException
    {
        System.out.println(me());
    }   
}