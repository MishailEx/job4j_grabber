package ru.job4j.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.job4j.Post;
import ru.job4j.grabber.utils.SqlRuDateTimeParser;

import java.io.IOException;
import java.time.LocalDateTime;

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


    public Post parseDetailForPost(String link) throws IOException {
        Post post = new Post();
        Document doc = Jsoup.connect(link).get();
        Elements row = doc.select(".msgBody").eq(1);
        SqlRuDateTimeParser dp = new SqlRuDateTimeParser();
        for (Element td : row) {
            Element parent = td.parent().parent();
            post.setDescription(td.text());
            post.setTitle(parent.child(1).child(1).text());
            LocalDateTime localDateTime = dp.parse(parent.child(2)
                    .child(0).ownText().split("\\[")[0]);
            post.setCreated(localDateTime);
        }
        post.setLink(link);

        return post;
    }
}