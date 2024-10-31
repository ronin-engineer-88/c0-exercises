package src.exception;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import src.exception.CourseException.CourseInactiveException;
import src.exception.CourseException.CourseNotFoundException;
import src.exception.LessonException.LessonNotFoundException;
import src.exception.LessonException.NoLessonInCourseException;
import src.exception.UserException.*;

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

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleValidationExceptions(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(UsernameExistException.class)
    public ResponseEntity<?> handleValidationExceptions(UsernameExistException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> handleValidationExceptions(UserNotFoundException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(InvalidPasswordException.class)
    public ResponseEntity<?> handleValidationExceptions(InvalidPasswordException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(CourseNotFoundException.class)
    public ResponseEntity<?> handleValidationExceptions(CourseNotFoundException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(UserCourseNotFoundException.class)
    public ResponseEntity<?> handleValidationExceptions(UserCourseNotFoundException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(UserAlreadyEnrolledException.class)
    public ResponseEntity<?> handleValidationExceptions(UserAlreadyEnrolledException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(CourseInactiveException.class)
    public ResponseEntity<?> handleValidationExceptions(CourseInactiveException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(UserInactiveException.class)
    public ResponseEntity<?> handleValidationExceptions(UserInactiveException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(UserNotYetEnrolledException.class)
    public ResponseEntity<?> handleValidationExceptions(UserNotYetEnrolledException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(LessonNotFoundException.class)
    public ResponseEntity<?> handleValidationExceptions(LessonNotFoundException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(NoLessonInCourseException.class)
    public ResponseEntity<?> handleValidationExceptions(NoLessonInCourseException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}