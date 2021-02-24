package simonovsky.observer;

import java.util.*;
import java.lang.*;

public interface Observable {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers();
}
