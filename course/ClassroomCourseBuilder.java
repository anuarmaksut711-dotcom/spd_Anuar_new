package course;

import java.util.List;

public final class ClassroomCourseBuilder extends AbstractCourseBuilder {
    @Override
    protected String delivery() { return "Classroom"; }

    @Override
    protected Lesson createLesson(String topic, int minutes) {
        return new Lesson(topic, minutes, "Instructor demonstration and supervised pair programming");
    }

    @Override
    protected List<String> createResources() {
        return List.of("Printed workbook", "Lab workstation", "Whiteboard");
    }

    @Override
    protected String createAssessment() {
        return "Demonstrate the project in the lab and defend the design orally";
    }
}
