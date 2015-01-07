
/**
 * Write a description of class Waktu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Waktu
{
    // instance variables - replace the example below with your own
    public static final int MAX_JAM = 23;
    public static final int MIN_JAM = 0;
    public static final int MAX_MENIT_DETIK = 59;
    
    private int jam;
    private int menit;
    private int detik;

    /**
     * Constructor for objects of class Waktu
     */
    public Waktu()
    {
        // initialise instance variables
        
    }
    
    public void setJam(int jam){
    this.jam=jam;
    }
    
    public void setMenit(int menit){
    this.menit=menit;
    }
    
    public void setDetik(int detik){
    this.detik=detik;
    }
    
    private boolean cekInputan(int jam1, int menit2, int detik3){
    return ((jam1<=MAX_JAM && jam1>=MIN_JAM)&&(menit2<=MAX_MENIT_DETIK)&&(detik3<=MAX_MENIT_DETIK));       
    }
    
    public void TambahWaktu(int a, int b, int c){
    if(cekInputan(a,b,c)){
        setJam(a);
        setMenit(b);
        setDetik(c);
    }
    else {
    System.out.println("Inputan Salah!\nJam Harus Antara 0 - 23\nMenit Maksimal 59\nDetik Maksimal adalah 59\nSilahkan Coba lagi!");
    setJam(0);
    setMenit(0);
    setDetik(0);
    }
    }
    
    public void jamUp(){
        if(jam<23){
        jam++;
    }
    else if(jam>=24) {
    jam=0;
    }
    }
    
    public void downMenit(){
        menit--;
        if(menit==0){
        menit=59;
        jam -=1;
        }
    }
    
        
    public void upMenit(){
        menit++;
        if(menit >= 60){
        menit =1;
        jam+=1;
        }
    }
    
    public void downDetik(){
        detik--;
        if(detik==0){
            menit -=1;
            detik=59;
            if(menit==0){
            menit =59;
            jam-=1;
            }
        }
    }
    
    
    public void upDetik(){
        detik++;
        if(detik >= 60){
        detik = 1;
        menit+=1;
        if(menit >=60 ){
        jam+=1;
        menit =1;
        }
        }
    }
    
    public Waktu (int jam, int menit, int detik){
    this.jam=jam;
    this.menit=menit;
    this.detik=detik;
    TambahWaktu(jam, menit, detik);
    }
    
    public Waktu selisih(Waktu waktu2){
    return toWaktu(toDetik() - waktu2.toDetik());
    }
    
    
    private long toDetik(){
        return detik+(60*menit)+(60*60*jam);
    }
    
    private Waktu toWaktu(long detik){
     int j = (int)detik/3600;
     int m = (int)detik%3600/60;
     int d = (int)detik%60;
     return new Waktu (j,m,d);
    }
}
