package src.exception;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import src.dto.AppError;
import src.exception.CourseException.CourseInactiveException;
import src.exception.CourseException.CourseNotFoundException;
import src.exception.LessonException.LessonNotFoundException;
import src.exception.LessonException.NoLessonInCourseException;
import src.exception.UserException.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<AppError>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<AppError> errors = ex.getBindingResult().getAllErrors().stream()
                                .map(error -> {
                                    AppError err = new AppError();
                                    err.setField(
                                            error instanceof FieldError ? ((FieldError) error).getField() : null
                                    );
                                    err.setMessage(error.getDefaultMessage());
                                    err.setDate(new Date());
                                    return err;
                                })
                                .collect(Collectors.toList());
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(AppException.class)
    public ResponseEntity<?> handleValidationExceptions(AppException ex) {
        AppError err = new AppError();
        err.setField(
                ex.getField() != null ? ex.getField() : null
        );
        err.setMessage(ex.getMessage());
        err.setDate(ex.getDate());

        return ResponseEntity.badRequest().body(err);
    }
}