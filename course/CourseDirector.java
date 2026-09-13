package course;

public final class CourseDirector {
    private static final int INTRODUCTION_MINUTES = 30;
    private static final int PRACTICE_MINUTES = 60;

    public Course createJavaWorkshop(CourseBuilder builder) {
        return builder.reset()
                .setTitle("Java: Builder Pattern")
                .addLesson("Construction steps and responsibilities", INTRODUCTION_MINUTES)
                .addLesson("Implementing and testing Builder", PRACTICE_MINUTES)
                .addResources()
                .addAssessment()
                .build();
    }
}
