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
import javax.persistence.Column;

@Entity
public class Reference {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    String refType;
    String type;
    @Column(unique = true)
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
    String annote;
    String chapter;
    String crossref;
    String editor;
    String howpublished;
    String institution;
    String organization;
    String school;
    String booktitle;

    public Reference() {
    }

    public Reference(String... args) {
        Map<String, String> arguments = extractArguments(args);
        this.refType = arguments.get("refType") != null ? arguments.get("refType") : "";
        this.type = arguments.get("type") != null ? arguments.get("type") : "";
        this.name = arguments.get("name") != null ? arguments.get("name") : "";
        this.author = arguments.get("author") != null ? arguments.get("author") : "";
        this.title = arguments.get("title") != null ? arguments.get("title") : "";
        this.journal = arguments.get("journal") != null ? arguments.get("journal") : "";
        this.year = arguments.get("year") != null ? arguments.get("year") : "";
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
        this.annote = arguments.get("annote") != null ? arguments.get("annote") : "";
        this.chapter = arguments.get("chapter") != null ? arguments.get("chapter") : "";
        this.crossref = arguments.get("crossref") != null ? arguments.get("crossref") : "";
        this.editor = arguments.get("editor") != null ? arguments.get("editor") : "";
        this.howpublished = arguments.get("howpublished") != null ? arguments.get("howpublished") : "";
        this.institution = arguments.get("institution") != null ? arguments.get("institution") : "";
        this.organization = arguments.get("organization") != null ? arguments.get("organization") : "";
        this.school = arguments.get("school") != null ? arguments.get("school") : "";
        this.booktitle = arguments.get("booktitle") != null ? arguments.get("booktitle") : "";
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
        this.refType = type;
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
        return this.type;
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

    public String getAnnote() {
        return annote;
    }

    public void setAnnote(String annote) {
        this.annote = annote;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public String getCrossref() {
        return crossref;
    }

    public void setCrossref(String crossref) {
        this.crossref = crossref;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getHowpublished() {
        return howpublished;
    }

    public void setHowpublished(String howpublished) {
        this.howpublished = howpublished;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getRefType() {
        return refType;
    }

    public void setRefType(String refType) {
        this.refType = refType;
    }

    public String getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }

    public String getBibtex() {
        String bibtex = "";
        bibtex += "@" + getRefType() + "{" + getName() + ",\n";
        bibtex += getAuthor() != null && !getAuthor().equals("") ? " author    = \"" + getAuthor() + "\",\n" : "";
        bibtex += getTitle() != null && !getTitle().equals("") ? " title     = \"" + getTitle() + "\",\n" : "";
        bibtex += getPublisher() != null && !getPublisher().equals("") ? " publisher = \"" + getPublisher() + "\",\n" : "";
        bibtex += getYear() != null && !getYear().equals("") ? " year      = \"" + getYear() + "\",\n" : "";
        bibtex += getMonth() != null && !getMonth().equals("") ? " month     = \"" + getMonth() + "\",\n" : "";
        bibtex += getAddress() != null && !getAddress().equals("") ? " address   = \"" + getAddress() + "\",\n" : "";
        bibtex += getEdition() != null && !getEdition().equals("") ? " edition   = \"" + getEdition() + "\",\n" : "";
        bibtex += getJournal() != null && !getJournal().equals("") ? " journal   = \"" + getJournal() + "\",\n" : "";
        bibtex += getVolume() != null && !getVolume().equals("") ? " volume    = \"" + getVolume() + "\",\n" : "";
        bibtex += getNumber() != null && !getNumber().equals("") ? " number    = \"" + getNumber() + "\",\n" : "";
        bibtex += getPages() != null && !getPages().equals("") ? " pages     = \"" + getPages() + "\",\n" : "";
        bibtex += getNote() != null && !getNote().equals("") ? " note       = \"" + getNote() + "\",\n" : "";
        bibtex += getKey() != null && !getKey().equals("") ? " key          = \"" + getKey() + "\",\n" : "";
        bibtex += getSeries() != null && !getSeries().equals("") ? " series   = \"" + getSeries() + "\",\n" : "";
        bibtex += getAddress() != null && !getAddress().equals("") ? " address   = \"" + getAddress() + "\",\n" : "";
        bibtex += getEdition() != null && !getEdition().equals("") ? " edition   = \"" + getEdition() + "\",\n" : "";
        bibtex += getAnnote() != null && !getAnnote().equals("") ? " annote   = \"" + getAnnote() + "\",\n" : "";
        bibtex += getChapter() != null && !getChapter().equals("") ? " chapter   = \"" + getChapter() + "\",\n" : "";
        bibtex += getCrossref() != null && !getCrossref().equals("") ? " crossref   = \"" + getCrossref() + "\",\n" : "";
        bibtex += getEditor() != null && !getEditor().equals("") ? " editor   = \"" + getEditor() + "\",\n" : "";
        bibtex += getHowpublished() != null && !getHowpublished().equals("") ? " howpublished   = \"" + getHowpublished() + "\",\n" : "";
        bibtex += getInstitution() != null && !getInstitution().equals("") ? " institution   = \"" + getInstitution() + "\",\n" : "";
        bibtex += getOrganization() != null && !getOrganization().equals("") ? " organization   = \"" + getOrganization() + "\",\n" : "";
        bibtex += getSchool() != null && !getSchool().equals("") ? " school   = \"" + getSchool() + "\",\n" : "";
        bibtex += getBooktitle() != null && !getBooktitle().equals("") ? " booktitle   = \"" + getBooktitle() + "\",\n" : "";
        bibtex = bibtex.substring(0, bibtex.length() - 2);
        bibtex += "\n}\n\n";
        bibtex = bibtex.replaceAll("ä", "{\\\\" + "\"a}");
        bibtex = bibtex.replaceAll("Ä", "{\\\\" + "\"A}");
        bibtex = bibtex.replaceAll("ö", "{\\\\" + "\"o}");
        bibtex = bibtex.replaceAll("Ö", "{\\\\" + "\"O}");
        bibtex = bibtex.replaceAll("å", "{\\\\" + "\"aa}");
        bibtex = bibtex.replaceAll("Å", "{\\\\" + "\"AA}");
        return bibtex;
    }

    public boolean validate() {
        if (title.equals("")) {
            return false;
        }
        return true;
    }
}
