package ba.unsa.etf.rpr;

public class Ucenik extends Osoba implements Comparable<Ucenik>  {
    private String brojKnjizice="";
    private int velicina=0;
    private int[] ocjene=new int[100];
    public Ucenik(String imePrezime) {
        super(imePrezime);
    }

    @Override
    public String toString() {
        String vracam="";
        vracam+=super.getImePrezime()+" ("+getBrojKnjizice()+"), prosjek ocjena: "+prosjek();
        return vracam;
    }

    public String getBrojKnjizice() {
        return brojKnjizice;
    }

    public void setBrojKnjizice(String brojKnjizice) {
        this.brojKnjizice = brojKnjizice;
    }


    public void dodajOcjenu(int i) throws IlegalnaOcjena {
        if(velicina>100)throw new IllegalArgumentException("Dosegnut maksimalan broj ocjena");
        if(i<1 || i>5)throw new IlegalnaOcjena("Ilegalna ocjena "+i);
        ocjene[velicina]=i;
        velicina++;
    }

    public double prosjek() {
        double sum=0;
        if(velicina==0)return 0;
        for(int i=0;i<velicina;i++){
            sum+=ocjene[i];
;        }
        double prosjek=sum/velicina;
        prosjek=Math.round(prosjek*10);
        prosjek/=10;
        return prosjek;
    }

    public int getVelicina() {
        return velicina;
    }

    public void setVelicina(int velicina) {
        this.velicina = velicina;
    }

    public int[] getOcjene() {
        return ocjene;
    }

    public void setOcjene(int[] ocjene) {
        this.ocjene = ocjene;
    }

    @Override
    public int compareTo(Ucenik ucenik) {
        if(prosjek()>ucenik.prosjek())return -1;
        return 1;
    }
}
