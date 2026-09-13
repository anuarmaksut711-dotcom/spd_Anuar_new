package course;

public interface CourseBuilder {
    CourseBuilder reset();
    CourseBuilder setTitle(String title);
    CourseBuilder addLesson(String topic, int minutes);
    CourseBuilder addResources();
    CourseBuilder addAssessment();
    Course build();
}
