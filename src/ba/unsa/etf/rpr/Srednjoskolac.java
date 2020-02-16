package ba.unsa.etf.rpr;

public class Srednjoskolac extends Ucenik implements Slavljenik {
    private int[] ocjeneSrednja=new int[100];
    private int velicinaSrednja=0;
    public Srednjoskolac(String ime) {
        super(ime);
    }

    @Override
    public String toString() {
        return "Učenik srednje škole "+super.toString();
    }

    public void dodajOcjenuSrednja(int i) throws IlegalnaOcjena {
        if(velicinaSrednja>=100)throw new IllegalArgumentException("Dosegnut maksimalan broj ocjena");
        if(i<1 || i>5)throw new IlegalnaOcjena("Ilegalna ocjena "+i);
        ocjeneSrednja[velicinaSrednja]=i;
        velicinaSrednja++;
    }

    public double prosjekSrednja() {
        double sum=0;
        for(int i=0;i<velicinaSrednja;i++){
            sum+=ocjeneSrednja[i];
        }
        double prosjek=sum/velicinaSrednja;
       prosjek=Math.round(prosjek*10);
        prosjek/=10;
        return prosjek;
    }
    @Override
    public double prosjek(){
        double sum=0;
        for(int i=0;i<velicinaSrednja;i++){
            sum+=ocjeneSrednja[i];
        }
        for(int i=0;i<super.getVelicina();i++){
            sum+=super.getOcjene()[i];
        }
        double prosjek=sum/(velicinaSrednja+super.getVelicina());
       prosjek=Math.round(prosjek*10);
        prosjek/=10;
        return prosjek;
    }

}
