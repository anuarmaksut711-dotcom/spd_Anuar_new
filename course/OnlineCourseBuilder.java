package course;

import java.util.List;

public final class OnlineCourseBuilder extends AbstractCourseBuilder {
    @Override
    protected String delivery() { return "Online"; }

    @Override
    protected Lesson createLesson(String topic, int minutes) {
        return new Lesson(topic, minutes, "Recorded video and interactive coding exercise");
    }

    @Override
    protected List<String> createResources() {
        return List.of("Downloadable workbook", "Browser coding sandbox", "Discussion forum");
    }

    @Override
    protected String createAssessment() {
        return "Submit a repository to the LMS and complete an automated quiz";
    }
}
