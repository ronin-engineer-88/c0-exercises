package src.constant;

public class UrlConstant {

    private UrlConstant() {}

    public static final String USER_LOGIN = "/api/v1/users/login";
    //
    public static final String DELETE_USERS = "/api/v1/users/{user_id}";
    //
    public static final String UPDATE_TEACHERS = "/api/v1/teachers/{teacher_id}";
    //
    public static final String DELETE_TEACHERS = "/api/v1/teachers/{teacher_id}";
    //
    public static final String ADD_COURSES = "/api/v1/courses";
    //
    public static final String UPDATE_COURSES = "/api/v1/courses/{course_id}";
    //
    public static final String DELETE_COURSES = "/api/v1/courses/{course_id}";
    //
    public static final String ADD_CHAPTERS = "/api/v1/courses/{course_id}/chapters";
    //
    public static final String UPDATE_CHAPTERS = "/api/v1/courses/{course_id}/chapters/{chapter_id}";
    //
    public static final String DELETE_CHAPTERS = "/api/v1/courses/{course_id}/chapters/{chapter_id}";
    //
    public static final String ADD_LESSONS = "/api/v1/courses/{course_id}/chapters/{chapter_id}/lessons";
    //
    public static final String UPDATE_LESSONS = "/api/v1/courses/{course_id}/chapters/{chapter_id}/lessons/{lesson_id}";
    //
    public static final String DELETE_LESSONS = "/api/v1/courses/{course_id}/chapters/{chapter_id}/lessons/{lesson_id}";

    //
    public static final String GET_USERS = "/api/v1/users";
    //
    public static final String GET_TEACHERS = "/api/v1/teachers";
    //
    public static final String GET_COURSES = "/api/v1/courses";
    //
    public static final String GET_CHAPTERS = "/api/v1/courses/{course_id}/chapters";
    //
    public static final String GET_LESSONS = "/api/v1/courses/{course_id}/chapters/{chapter_id}/lessons";
}
