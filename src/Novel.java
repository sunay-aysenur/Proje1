public class Novel extends Book {
    public Novel(int id, String title, String author, int year, int stock){
        super(id, title, author,year, stock);
    }

    @Override
    public int getBorrowDuration() {
        return 14;
    }
}
