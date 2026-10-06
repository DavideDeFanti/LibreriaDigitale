public class Libro<T> {

    private final T codice;
    private String titolo;

    public Libro(T codice, String titolo){
        this.codice = codice;
        this.titolo = titolo;
    }

    public T getCodice() {
        return codice;
    }
    public String getTitolo(){
        return titolo;
    }

    @Override
    public String toString() {
        return "Codice: " + codice + " Titolo: " + titolo;
    }
}