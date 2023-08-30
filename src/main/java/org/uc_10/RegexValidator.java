package org.uc_10;

import java.util.regex.Pattern;

public class RegexValidator {

    public static final String REGEX =
            "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!\"#$%%&'()*+,-./:;<=>?@[\\]^_`{|}~])[^\\s]{1,%d}$";

    public boolean validateInputString(String input, int maxLength) {

        String compiledRegex = String.format(REGEX, maxLength);
        Pattern pattern = Pattern.compile(compiledRegex);

        return pattern.matcher(input).matches();
    }
}
