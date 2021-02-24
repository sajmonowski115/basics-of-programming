package simonovsky.observer;

public class BlogMain {
    public static void main(String[] args) {
        Blog GeeksForGeeks = new Blog();

        GeeksForGeeks.publishArticle("UML");

        Reader nowak = new Reader(GeeksForGeeks);
        Reader kowalski = new Reader(GeeksForGeeks);
        GeeksForGeeks.attach(nowak);
        GeeksForGeeks.attach(kowalski);

        GeeksForGeeks.publishArticle("algorithms");

//        System.out.println(nowak.getNewestArticle());
//        System.out.println(kowalski.getNewestArticle());
    }
}
