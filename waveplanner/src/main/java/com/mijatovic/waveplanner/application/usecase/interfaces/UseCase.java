package com.mijatovic.waveplanner.application.usecase.interfaces;

import com.mijatovic.waveplanner.application.usecase.exception.InvalidInputException;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * An interface for defining use cases in a clean architecture.
 *
 * @param <I> the input values type
 * @param <O> the output values type
 */
public interface UseCase<I extends UseCase.InputValues, O extends UseCase.OutputValues> {

    /**
     * An interface for defining input values for use cases.
     */
    public interface InputValues {}

    /**
     * An interface for defining output values for use cases.
     */
    public interface OutputValues {}

    /**
     * An implementation of the {@link InputValues} interface representing a use case with no input.
     */
    public static class VoidInput implements InputValues {}

    /**
     * An implementation of the {@link OutputValues} interface representing a use case with no output.
     */
    public static class VoidOutput implements OutputValues {}

    /**
     * Executes the use case with the given input values.
     *
     * @param input the input values
     * @return the output values
     */
    O execute(I input);

    /**
     * Validates that none of the fields in the given input values are null.
     *
     * @param input the input values to validate
     * @throws InvalidInputException if any of the input fields are null
     * @throws RuntimeException if an IllegalAccessException occurs (which should not happen, as it is handled by the RestControllerAdvice class)
     */
    default void validateNotNull(I input) throws InvalidInputException {
        List<Field> fields = Arrays.stream(input.getClass().getDeclaredFields())
                .filter(field -> !Modifier.isStatic(field.getModifiers()))
                .collect(Collectors.toList());

        fields.forEach(field -> {
            try {
                field.setAccessible(true);
                Object value = field.get(input);
                if (value == null) {
                    throw new InvalidInputException("Input field " + field.getName() + " is empty.");
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException("This should never happen, as IllegalAccessException is handled in the RestControllerAdvice class", e);
            }
        });
    }
}
