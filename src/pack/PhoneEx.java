package pack;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneEx {

private Pattern pattern;
private Matcher matcher;

private static final String MOBILE_PATTERN = 
 "\\d{10}";

public PhoneEx() {
 pattern = Pattern.compile(MOBILE_PATTERN);
}


public boolean validate(final String hex) {

 matcher = pattern.matcher(hex);
 return matcher.matches();

}
}