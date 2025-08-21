
public class program {
    public static void main(String[] args) {
        desenhista paint = new desenhista();
        paint.desenhar(new fabricaCirculo());
        paint.desenhar(new fabricaRetangulo());        
        paint.desenhar(new fabricaTriangulo());
    }
}
