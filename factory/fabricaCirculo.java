
public class fabricaCirculo implements iFabrica {

    @Override
    public iForma fabricar() {
        return new circulo();
    }
    
}
