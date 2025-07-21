public abstract class Book implements Borrowable{
    protected int id;
    protected String title;
    protected String author;
    protected int year;
    protected int stock;

    public Book (int id, String title, String author, int year, int  stock){
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.stock = stock;
    }

    public abstract int getBorrowDuration();

    @Override
    public boolean isAvailable() {
        return stock > 0;
    }

    @Override
    public void returnBook() {
        stock++;
    }

    @Override
    public boolean borrow(Member member) {
        if (isAvailable() && member.canBorrow()) {
            stock--;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return title + " by " + author + " (" + year + ") - Stock: " + stock;
    }
}
