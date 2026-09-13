package course;

import java.util.List;

public final class Course {
    private final String title;
    private final String delivery;
    private final List<Lesson> lessons;
    private final List<String> resources;
    private final String assessment;

    Course(String title, String delivery, List<Lesson> lessons,
           List<String> resources, String assessment) {
        this.title = title;
        this.delivery = delivery;
        this.lessons = List.copyOf(lessons);
        this.resources = List.copyOf(resources);
        this.assessment = assessment;
    }

    public String title() { return title; }
    public String delivery() { return delivery; }
    public List<Lesson> lessons() { return lessons; }
    public List<String> resources() { return resources; }
    public String assessment() { return assessment; }

    public int totalMinutes() {
        return lessons.stream().mapToInt(Lesson::minutes).sum();
    }
}
