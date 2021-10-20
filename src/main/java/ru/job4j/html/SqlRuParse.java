package ru.job4j.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.job4j.grabber.utils.SqlRuDateTimeParser;

public class SqlRuParse {
    public static void main(String[] args) throws Exception {
        int pages = 5;
        String page = String.format("https://www.sql.ru/forum/job-offers/%d", pages);
        for (int i = 0; i <= pages; i++) {
            Document doc = Jsoup.connect(page).get();
            Elements row = doc.select(".postslisttopic");
            for (Element td : row) {
                Element parent = td.parent();
                SqlRuDateTimeParser dt = new SqlRuDateTimeParser();
                System.out.println(dt.parse(parent.child(5).text()));
            }
        }
    }
}