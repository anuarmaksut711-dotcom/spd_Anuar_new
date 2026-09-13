package course;

public final class Main {
    private static final int CUSTOM_LESSON_MINUTES = 45;

    private Main() { }

    public static void main(String[] args) {
        CourseDirector director = new CourseDirector();
        printCourse(director.createJavaWorkshop(new OnlineCourseBuilder()));
        printCourse(director.createJavaWorkshop(new ClassroomCourseBuilder()));

        Course custom = new OnlineCourseBuilder()
                .setTitle("Clean Code Practice")
                .addLesson("Refactoring", CUSTOM_LESSON_MINUTES)
                .addResources()
                .addAssessment()
                .build();
        printCourse(custom);
    }

    private static void printCourse(Course course) {
        System.out.printf("%n%s [%s], %d minutes%n",
                course.title(), course.delivery(), course.totalMinutes());
        for (Lesson lesson : course.lessons()) {
            System.out.printf("- %s (%d min): %s%n",
                    lesson.topic(), lesson.minutes(), lesson.activity());
        }
        System.out.println("Resources: " + String.join(", ", course.resources()));
        System.out.println("Assessment: " + course.assessment());
    }
}
