
public class fabricaTriangulo implements iFabrica {

    @Override
    public iForma fabricar() {
        return new triangulo();
    }
    
}
