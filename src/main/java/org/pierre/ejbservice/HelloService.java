package org.pierre.ejbservice;

import javax.ejb.Stateless;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Locale;

@Stateless
public class HelloService {
    public String hello() {
        Instant now = Instant.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)
                .withLocale(Locale.ENGLISH)
                .withZone(ZoneId.systemDefault());
        return formatter.format(now);
    }
}
