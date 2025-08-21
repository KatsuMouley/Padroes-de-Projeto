
public class fabricaRetangulo implements iFabrica {

    @Override
    public iForma fabricar() {
        return new retangulo();
    }
    
}
