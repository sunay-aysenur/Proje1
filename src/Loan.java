import java.time.LocalDate;

public class Loan {
    private Book book;
    private Member member;
    private LocalDate borrowDate;
    private LocalDate dueDate;

    public Loan(Book book, Member member) {
        this.book = book;
        this.member = member;
        this.borrowDate = LocalDate.now();
        this.dueDate = borrowDate.plusDays(book.getBorrowDuration());
    }

    public Book getBook() {
        return book;
    }

    public Member getMember() {
        return member;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    @Override
    public String toString() {
        return member + " borrowed '" + book.title + "' on " + borrowDate + ", due " + dueDate;
    }
}
