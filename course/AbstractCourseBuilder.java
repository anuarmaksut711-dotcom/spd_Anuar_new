package course;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCourseBuilder implements CourseBuilder {
    private String title;
    private final List<Lesson> lessons = new ArrayList<>();
    private List<String> resources = List.of();
    private String assessment;

    @Override
    public final CourseBuilder reset() {
        title = null;
        lessons.clear();
        resources = List.of();
        assessment = null;
        return this;
    }

    @Override
    public final CourseBuilder setTitle(String title) {
        this.title = requireText(title, "Title");
        return this;
    }

    @Override
    public final CourseBuilder addLesson(String topic, int minutes) {
        String validTopic = requireText(topic, "Lesson topic");
        if (minutes <= 0) {
            throw new IllegalArgumentException("Lesson duration must be positive");
        }
        lessons.add(createLesson(validTopic, minutes));
        return this;
    }

    @Override
    public final CourseBuilder addResources() {
        resources = List.copyOf(createResources());
        return this;
    }

    @Override
    public final CourseBuilder addAssessment() {
        assessment = createAssessment();
        return this;
    }

    @Override
    public final Course build() {
        validateState();
        return new Course(title, delivery(), lessons, resources, assessment);
    }

    private void validateState() {
        if (title == null) {
            throw new IllegalStateException("Set the course title before build()");
        }
        if (lessons.isEmpty()) {
            throw new IllegalStateException("Add at least one lesson before build()");
        }
        if (resources.isEmpty()) {
            throw new IllegalStateException("Add resources before build()");
        }
        if (assessment == null || assessment.isBlank()) {
            throw new IllegalStateException("Add an assessment before build()");
        }
    }

    private static String requireText(String value, String field) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(field + " must not be blank");
        }
        return value.strip();
    }

    protected abstract String delivery();
    protected abstract Lesson createLesson(String topic, int minutes);
    protected abstract List<String> createResources();
    protected abstract String createAssessment();
}
