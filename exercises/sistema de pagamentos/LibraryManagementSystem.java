public class LibraryManagementSystem {
    
    public static void main(String[] args) {
        
        LibraryItem book = new Book("O Senhor dos Anéis", "J.R.R. Tolkien", 1954, "Fantasia");
        LibraryItem magazine = new Magazine("National Geographic", "Vários", 2023, 158);
        LibraryItem digitalMedia = new DigitalMedia("Curso de Java", "OpenAI", 2022, "MP4");


        LibraryItem[] items = { book, magazine, digitalMedia };

        for (LibraryItem item : items) {
            System.out.println("\n--- Informações do Item ---");
            item.displayInfo();
            item.borrow();
            item.returnItem();

            if (item instanceof Book) {
                ((Book) item).readSample();
            } else if (item instanceof Magazine) {
                ((Magazine) item).flipPages();
            } else if (item instanceof DigitalMedia) {
                ((DigitalMedia) item).play();
            }
        }
    }
}
