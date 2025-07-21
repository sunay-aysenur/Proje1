public class AcademicBook extends Book{
    public AcademicBook(int id, String title, String author, int year, int stock){
        super(id, title, author, year, stock);
    }

    @Override
    public int getBorrowDuration() {
        return 30;
    }
}
