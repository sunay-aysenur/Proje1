import java.util.ArrayList;
import java.util.List;

public abstract class Member {
    protected int id;
    protected String name;
    protected int borrowLimit;
    protected List<Loan> borrowedBooks;

    public Member(int id, String name, int borrowLimit) {
        this.id = id;
        this.name = name;
        this.borrowLimit = borrowLimit;
        this.borrowedBooks = new ArrayList<>();
    }

    public boolean canBorrow() {
        return borrowedBooks.size() < borrowLimit;
    }

    public void borrowBook(Loan loan) {
        borrowedBooks.add(loan);
    }

    public void returnBook(Loan loan) {
        borrowedBooks.remove(loan);
    }

    @Override
    public String toString() {
        return name + " (ID: " + id + ", Borrowed: " + borrowedBooks.size() + ")";
    }
}
