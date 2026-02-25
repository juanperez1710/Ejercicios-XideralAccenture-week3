package com.Ejercicio3;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.*;

record ValidationResult(boolean isValid, List<String> errors) {
    static ValidationResult valid() {
        return new ValidationResult(true, List.of());
    }

    static ValidationResult invalid(String... errors) {
        return new ValidationResult(false, List.of(errors));
    }

    // TODO: metodo para combinar dos resultados
    ValidationResult merge(ValidationResult other) {
        if (this.isValid && other.isValid) return valid();
        List<String> allErrors = new ArrayList<>(this.errors);
        allErrors.addAll(other.errors);
        return new ValidationResult(false, allErrors);
    }
}