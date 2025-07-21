public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Books
        library.addBook(new Novel(1, "1984", "George Orwell", 1949, 3));
        library.addBook(new AcademicBook(2, "AI: A Modern Approach", "Russell & Norvig", 2010, 2));

        // Members
        library.addMember(new Student(101, "Ali"));
        library.addMember(new Academic(202, "Dr. Ayşe"));

        // Actions
        library.borrowBook(1, 101); // Ali borrows 1984
        library.borrowBook(2, 202); // Dr. Ayşe borrows AI

        library.listLoans();
        System.out.println();

        library.returnBook(1, 101); // Ali returns 1984
        library.listBooks();
    }
}