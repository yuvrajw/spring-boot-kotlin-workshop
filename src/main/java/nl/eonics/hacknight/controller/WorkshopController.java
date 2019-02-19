package nl.eonics.hacknight.controller;

import nl.eonics.hacknight.model.LombokValueObject;
import nl.eonics.hacknight.model.ValueObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkshopController {

    static final String MODIFIED = "MODIFIED";
    static final String JAVA = "/java";
    static final String KOTLIN = "/kotlin";

    @PostMapping(path = JAVA)
    public LombokValueObject postJava(final LombokValueObject valueObject) {
        valueObject.setValue(MODIFIED);
        return valueObject;
    }

    @PostMapping(path = KOTLIN)
    public ValueObject postKotlin(final ValueObject valueObject) {
        valueObject.setValue(MODIFIED);
        return valueObject;
    }
}
