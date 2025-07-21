import java.util.ArrayList;
import java.util.List;

public class Library {
        private List<Book> books;
        private List<Member> members;
        private List<Loan> loans;

        public Library() {
            books = new ArrayList<>();
            members = new ArrayList<>();
            loans = new ArrayList<>();
        }

        public void addBook(Book book) {
            books.add(book);
        }

        public void addMember(Member member) {
            members.add(member);
        }

        public boolean borrowBook(int bookId, int memberId) {
            Book book = findBookById(bookId);
            Member member = findMemberById(memberId);
            if (book != null && member != null && book.borrow(member)) {
                Loan loan = new Loan(book, member);
                loans.add(loan);
                member.borrowBook(loan);
                System.out.println(member + " borrowed '" + book.title + "' until " + loan.getDueDate());
                return true;
            }
            return false;
        }

        public boolean returnBook(int bookId, int memberId) {
            Loan loanToReturn = null;
            for (Loan loan : loans) {
                if (loan.getBook().id == bookId && loan.getMember().id == memberId) {
                    loanToReturn = loan;
                    break;
                }
            }
            if (loanToReturn != null) {
                loanToReturn.getBook().returnBook();
                loanToReturn.getMember().returnBook(loanToReturn);
                loans.remove(loanToReturn);
                System.out.println(loanToReturn.getMember() + " returned '" + loanToReturn.getBook().title + "'");
                return true;
            }
            return false;
        }

        private Book findBookById(int id) {
            for (Book b : books) {
                if (b.id == id) return b;
            }
            return null;
        }

        private Member findMemberById(int id) {
            for (Member m : members) {
                if (m.id == id) return m;
            }
            return null;
        }

        public void listBooks() {
            System.out.println("Books in Library:");
            for (Book b : books) {
                System.out.println(b);
            }
        }

        public void listMembers() {
            System.out.println("Library Members:");
            for (Member m : members) {
                System.out.println(m);
            }
        }

        public void listLoans() {
            System.out.println("Active Loans:");
            for (Loan l : loans) {
                System.out.println(l.getMember() + " has '" + l.getBook().title + "' due on " + l.getDueDate());
            }
        }
}
