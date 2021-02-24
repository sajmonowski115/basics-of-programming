package simonovsky.builder;

import java.util.*;
import java.lang.*;

public class GoalTester {
    public static void main(String[] args) {
        Goal SchoolProject = new Goal.Builder()
                .name("Unix Presentation")
                //.description("Prepare presentation about Unix system")
                .manager("Jan Kowalski")
                .price(0)
                .days(11)
                .achived(true)
                .build();

        System.out.println("Project name: " + SchoolProject.getName());
        System.out.println("Desctiprion: " + SchoolProject.getDescription());
        System.out.println("Is the project finished: " + SchoolProject.isAchived());
    }
}
