import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Libro<String> libro1 = new Libro<>("9128", "Alfa");
        Libro<String> libro2 = new Libro<>("8237", "Gamma");
        Libro<String> libro3 = new Libro<>("4756", "omega");
        Libro<String> libro4 = new Libro<>("4150", "Zeta");
        Libro<String> libro5 = new Libro<>("6439", "Omicron");
        Libro<String> libro6 = new Libro<>("9421", "Kappa");
        Libro<String> libro7 = new Libro<>("6109", "beta");

        Biblioteca biblioteca = new Biblioteca();
        biblioteca.aggiungiLibro(libro1);
        try {
            biblioteca.aggiungiLibro(libro1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        biblioteca.aggiungiLibro(libro2);
        biblioteca.aggiungiLibro(libro3);
        biblioteca.aggiungiLibro(libro4);
        biblioteca.aggiungiLibro(libro6);
        biblioteca.aggiungiLibro(libro7);

        System.out.println("Lista libri disponibili: " + biblioteca.libri);

        biblioteca.rimuoviLibro(libro1);
        try {
            biblioteca.rimuoviLibro(libro1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Lista libri disponibili dopo la rimozione: " + biblioteca.libri);

        biblioteca.registaUtente("Emanuele");
        biblioteca.registaUtente("Valentina");
        System.out.println("Utenti registrati: " + biblioteca.utenti);

        try {
            biblioteca.prestaLibro("Davide", libro2);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            biblioteca.prestaLibro("Emanuele", libro5);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            biblioteca.prestaLibro("Emanuele", libro2);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            biblioteca.prestaLibro("Emanuele", libro4);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(biblioteca.pilaLibriUtente);

        try {
            biblioteca.restauraLibro("Valentina");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        biblioteca.restauraLibro("Emanuele");
        System.out.println("Coda dei libri da restituire" + biblioteca.codaResi);
        System.out.println("Pila di libri dopo la restituzione " + biblioteca.pilaLibriUtente);

        //Ordinamento personalizzato
        System.out.println("Lista libri non ordinata: " + biblioteca.libri);
        Collections.sort(biblioteca.libri, new Comparator<Libro<?>>() {
            @Override
            public int compare(Libro<?> libro1, Libro<?> libro2) {
                return libro1.getTitolo().compareToIgnoreCase(libro2.getTitolo());
            }
        });
        System.out.println("Lista libri ordinata: " + biblioteca.libri);
    }
}