package ru.job4j.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.job4j.grabber.Post;
import ru.job4j.grabber.Parse;
import ru.job4j.grabber.utils.DateTimeParser;
import ru.job4j.grabber.utils.SqlRuDateTimeParser;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SqlRuParse implements Parse {
    private final DateTimeParser dateTimeParser;

    public SqlRuParse(DateTimeParser dateTimeParser) {
        this.dateTimeParser = dateTimeParser;
    }

    public static void main(String[] args) throws Exception {
        int pages = 1;
        List<Post> list = new ArrayList<>();
        String page = String.format("https://www.sql.ru/forum/job-offers/%d", pages);
        for (int i = 0; i <= pages; i++) {
            list = new SqlRuParse(new SqlRuDateTimeParser()).list(page);
        }
        for (Post p : list) {
            System.out.println(p);
        }
    }


    @Override
    public List<Post> list(String link) throws IOException {
        List<Post> list = new ArrayList<>();
        Document doc = Jsoup.connect(link).get();
        Elements row = doc.select(".postslisttopic");
        for (Element td : row) {
            if (!td.text().startsWith("Важно:")) {
                String linkNext = td.child(0).attr("href");
                list.add(detail(linkNext));
            }
        }
        return list;
    }

    @Override
    public Post detail(String link) throws IOException {
        Post post = new Post();
        Document doc = Jsoup.connect(link).get();
        Elements row = doc.select(".msgBody").eq(1);
        SqlRuDateTimeParser dp = new SqlRuDateTimeParser();
        for (Element td : row) {
            Element parent = td.parent().parent();
            post.setDescription(td.text());
            post.setTitle(parent.child(0).child(0).text());
            LocalDateTime localDateTime = dp.parse(parent.child(2)
                    .child(0).ownText().split("\\[")[0]);
            post.setCreated(localDateTime);
        }
        post.setLink(link);
        return post;
    }
}