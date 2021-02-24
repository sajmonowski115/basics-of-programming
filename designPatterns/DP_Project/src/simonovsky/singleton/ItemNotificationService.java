package simonovsky.singleton;

public class ItemNotificationService {
    private static ItemNotificationService instance = null;

    private ItemNotificationService() {
        if(instance != null) {
            throw new RuntimeException("Not allowed. Please use getInstance() method");
        }
    }

    public static ItemNotificationService getInstance() {

        if (instance == null) {
            instance = new ItemNotificationService();
        }

        return instance;
    }
}
