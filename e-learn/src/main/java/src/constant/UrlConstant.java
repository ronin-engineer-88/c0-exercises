package src.constant;

public class UrlConstant {

    private UrlConstant() {}

    //
    public static final String API_V1 = "/api/v1";
    //
    public static final String USER_LOGIN = "/users/login";
    //
    public static final String DELETE_USERS = "/users/{user_id}";
    //
    public static final String UPDATE_TEACHERS = "/teachers/{teacher_id}";
    //
    public static final String DELETE_TEACHERS = "/teachers/{teacher_id}";
    //
    public static final String ADD_COURSES = "/courses";
    //
    public static final String UPDATE_COURSES = "/courses/{course_id}";
    //
    public static final String DELETE_COURSES = "/courses/{course_id}";
    //
    public static final String ADD_CHAPTERS = "/courses/{course_id}/chapters";
    //
    public static final String UPDATE_CHAPTERS = "/courses/{course_id}/chapters/{chapter_id}";
    //
    public static final String DELETE_CHAPTERS = "/courses/{course_id}/chapters/{chapter_id}";
    //
    public static final String ADD_LESSONS = "/courses/{course_id}/chapters/{chapter_id}/lessons";
    //
    public static final String UPDATE_LESSONS = "/courses/{course_id}/chapters/{chapter_id}/lessons/{lesson_id}";
    //
    public static final String DELETE_LESSONS = "/courses/{course_id}/chapters/{chapter_id}/lessons/{lesson_id}";

    //
    public static final String GET_USERS = "/users";
    //
    public static final String GET_TEACHERS = "/teachers";
    //
    public static final String GET_COURSES = "/courses";
    //
    public static final String GET_CHAPTERS = "/courses/{course_id}/chapters";
    //
    public static final String GET_LESSONS = "/courses/{course_id}/chapters/{chapter_id}/lessons";
}
