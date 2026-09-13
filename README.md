CourseBuilder defines the construction steps, while OnlineCourseBuilder and ClassroomCourseBuilder implement them for each course format. Shared logic is kept in AbstractCourseBuilder.

Main shows how to create both course formats using CourseDirector and a custom course by chaining builder methods.
