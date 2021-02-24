package simonovsky.builder;

import java.util.*;
import java.lang.*;

public class Goal {
    private String name;
    private String description;
    private String mananger;
    private int price;
    private int days;
    private boolean achived = false;

    public static final class Builder {
        private String name = "";
        private String description = "";
        private String mananger;
        private int price;
        private int days;
        private boolean achived;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder manager(String mananger) {
            this.mananger = mananger;
            return this;
        }

        public Builder price(int price) {
            this.price = price;
            return this;
        }

        public Builder days(int days) {
            this.days = days;
            return this;
        }

        public Builder achived(boolean achived) {
            this.achived = achived;
            return this;
        }

        Scanner scan = new Scanner(System.in);

        public Goal build() {
            if (name.equals("")) {
                throw new IllegalStateException("Name cannot be empty");
//                System.out.println("Name cannot be empty.");
//                System.out.print("Enter goal name: "); this.name = scan.nextLine();
            }
            if (description.equals("")) {
                //throw new IllegalStateException("Must enter description");
                System.out.println("Description cannot be empty.");
                System.out.print("Enter goal description: "); this.description = scan.nextLine();
            }

            Goal goal = new Goal();

            goal.name = this.name;
            goal.description = this.description;
            goal.mananger = this.mananger;
            goal.price = this.price;
            goal.days = this.days;
            goal.achived = this.achived;

            return goal;
        }
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getMananger() {
        return mananger;
    }

    public int getPrice() {
        return price;
    }

    public int getDays() {
        return days;
    }

    public boolean isAchived() {
        return achived;
    }
}
