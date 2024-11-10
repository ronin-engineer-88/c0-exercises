package src.job;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import src.constant.ConfigConstant;
import src.service.*;


@Component
@Slf4j
@RequiredArgsConstructor
public class DataCleanupJob {

    // use constructor injection
    private final IChapterService chapterService;
    private final ILessonService lessonService;
    private final ICourseService courseService;
    private final IUserService userService;
    private final ITeacherService teacherService;
    private final IAdminService adminService;
    private final IUserCourseLessonService userCourseLessonService;
    private final IUserCourseService userCourseService;
    private final IFullNameService fullNameService;

    @Scheduled(cron = "0 0 0 1 6 *")
    @Transactional
    public void cleanupJob() {
        userCourseLessonService.deleteByStatus(ConfigConstant.INACTIVE.getValue());
        lessonService.deleteByStatus(ConfigConstant.INACTIVE.getValue());
        chapterService.deleteByStatus(ConfigConstant.INACTIVE.getValue());
        userCourseService.deleteByStatus(ConfigConstant.INACTIVE.getValue());
        courseService.deleteByStatus(ConfigConstant.INACTIVE.getValue());
        fullNameService.deleteByStatus(ConfigConstant.INACTIVE.getValue());
        userService.deleteByStatus(ConfigConstant.INACTIVE.getValue());
        teacherService.deleteByStatus(ConfigConstant.INACTIVE.getValue());
        adminService.deleteByStatus(ConfigConstant.INACTIVE.getValue());

        log.info("Job to delete INACTIVE records completed.");
    }
}
