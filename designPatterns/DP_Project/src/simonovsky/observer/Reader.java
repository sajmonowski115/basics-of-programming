package simonovsky.observer;

public class Reader implements Observer {
    private final Blog blog;
    private String newestArticle = "no new articles";

    public Reader(Blog blog) {
        this.blog = blog;
        newestArticle = blog.getNewestArticle();
    }

    public String getNewestArticle() {
        return this.newestArticle;
    }

    @Override
    public void update() {
        this.newestArticle = blog.getNewestArticle();
        System.out.println("An article " + this.newestArticle + " was published");
    }
}
