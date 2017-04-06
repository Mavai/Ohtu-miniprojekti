/*
 */
package miniprojekti.entities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Reference {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    String type;
    String name;
    String author;
    String title;
    String journal;
    String year;
    String volume;
    String number;
    String pages;
    String month;
    String note;
    String key;
    String publisher;
    String series;
    String address;
    String edition;

    public Reference() {
    }
    
    public Reference(Long id, String type, String name, String author, String journal, String year, String volume, String number, String pages, String month, String note, String key, String publisher, String series, String address, String edition, String title) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.author = author;
        this.title = title;
        this.journal = journal;
        this.year = year;
        this.volume = volume;
        this.number = number;
        this.pages = pages;
        this.month = month;
        this.note = note;
        this.key = key;
        this.publisher = publisher;
        this.series = series;
        this.address = address;
        this.edition = edition;
    }

    public Reference (String... args) {
        Map<String, String> arguments = extractArguments(args);
        this.type = arguments.get("type") != null ? arguments.get("type") : "";
        this.name = arguments.get("name") != null ? arguments.get("name") : "";
        this.author= arguments.get("author") != null ? arguments.get("author") : "";
        this.title = arguments.get("title") != null ? arguments.get("title") : "";
        this.journal = arguments.get("journal") != null ? arguments.get("journal") : "";
        this.year = arguments.get("year") != null ?  arguments.get("year") : "";
        this.volume = arguments.get("volume") != null ? arguments.get("volume") : "";
        this.number = arguments.get("number") != null ? arguments.get("number") : "";
        this.pages = arguments.get("pages") != null ? arguments.get("pages") : "";
        this.month = arguments.get("month") != null ? arguments.get("month") : "";
        this.note = arguments.get("note") != null ? arguments.get("note") : "";
        this.key = arguments.get("key") != null ? arguments.get("key") : "";
        this.publisher = arguments.get("publisher") != null ? arguments.get("publisher") : "";
        this.series = arguments.get("series") != null ? arguments.get("series") : "";
        this.address = arguments.get("address") != null ? arguments.get("address") : "";
        this.edition = arguments.get("edition") != null ? arguments.get("edition") : "";
    }

    private Map<String, String> extractArguments(String[] args) {
        Map<String, String> arguments = new HashMap<>();
        for (String argument : args) {
            String[] info = argument.split(":");
            arguments.put(info[0], info[1]);
        }
        return arguments;
    }

    public Reference(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
