package src.exception;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import src.exception.ChapterException.ChapterNotFoundException;
import src.exception.CourseException.CourseNotFoundException;
import src.exception.LessonException.LessonNotFoundException;
import src.exception.LessonException.NoLessonInCourseException;
import src.exception.TeacherException.TeacherNotFoundException;
import src.exception.UserException.InvalidPasswordException;
import src.exception.UserException.UserNotFoundException;
import src.exception.UserException.UserNotYetEnrolledException;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult().getAllErrors().stream()
                                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                                .collect(Collectors.toList());
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> handleValidationExceptions(UserNotFoundException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(CourseNotFoundException.class)
    public ResponseEntity<?> handleValidationExceptions(CourseNotFoundException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(LessonNotFoundException.class)
    public ResponseEntity<?> handleValidationExceptions(LessonNotFoundException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(ChapterNotFoundException.class)
    public ResponseEntity<?> handleValidationExceptions(ChapterNotFoundException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(TeacherNotFoundException.class)
    public ResponseEntity<?> handleValidationExceptions(TeacherNotFoundException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(InvalidPasswordException.class)
    public ResponseEntity<?> handleValidationExceptions(InvalidPasswordException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(UserNotYetEnrolledException.class)
    public ResponseEntity<?> handleValidationExceptions(UserNotYetEnrolledException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(NoLessonInCourseException.class)
    public ResponseEntity<?> handleValidationExceptions(NoLessonInCourseException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }


}