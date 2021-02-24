package simonovsky.car;


public class Clutch extends Component {
    protected boolean pressed = false;

    public Clutch() {
        weight = 50;
        price = 320;
    }

    public void pressTheClutch() {
        pressed = true;
    }

    public void releaseTheClutch() {
        pressed = false;
    }
}
