public interface Borrowable {
    boolean borrow(Member member);
    void returnBook();
    boolean isAvailable();
}
