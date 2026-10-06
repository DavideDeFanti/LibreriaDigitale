import java.util.*;

public class Biblioteca {
    List<Libro<?>> libri = new ArrayList<>();
    Set<String> utenti = new HashSet<>();
    Map<String, Stack<Libro<?>>> pilaLibriUtente = new HashMap<>();
    Queue<Libro<?>> codaResi = new LinkedList<>();

    // Metodo per aggiungere libri
    public void aggiungiLibro(Libro<?> libro) {
        if (libri.contains(libro)) {
            throw new IllegalArgumentException("Libro già aggiunto");
        } else {
            libri.add(libro);
        }
    }

    // Metodo per rimuovere libri
    public <T> void rimuoviLibro(T id) {
        if (libri.contains(id)) {
            libri.remove(id);
        } else {
            throw new IllegalArgumentException("Libro non disponibile");
        }
    }

    // Metodo per registrare un utente
    public void registaUtente(String nome) {
        utenti.add(nome);
    }

    // Metodo per prestare libri ad utenti
    public void prestaLibro(String utente, Libro<?> libro) {
        if (! utenti.contains(utente)) {
            throw new IllegalArgumentException("Utente non registrato");
        }

        if (! libri.contains(libro)) {
            throw new IllegalArgumentException("Libro non disponibile");
        }
        Stack<Libro<?>> valore = new Stack<>();
        if (pilaLibriUtente.get(utente) == null) {
            pilaLibriUtente.put(utente, valore);
        }
        pilaLibriUtente.get(utente).push(libro);
        libri.remove(libro);

    }

    // Metodo per restituire il libro e inserirlo nella coda dei resi
    public void restauraLibro(String utente) {
        Stack<Libro<?>> pilaUtente = pilaLibriUtente.get(utente);
        if (pilaUtente == null || pilaUtente.isEmpty()) {
            throw new IllegalArgumentException("L'utente non ha nessun libro da restituire");
        }

        Libro<?> libroRestituito = pilaUtente.pop();
        codaResi.offer(libroRestituito);

    }

}