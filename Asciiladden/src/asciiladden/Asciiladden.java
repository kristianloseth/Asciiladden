package asciiladden;

public class Asciiladden {

    public static void main(String[] args) throws Exception {
        GetMinne minne = new GetMinne(args[0]);
        String streng = minne.getRespons();
        System.out.println(streng);
        minne.getInfo(streng);
    }
    
}
