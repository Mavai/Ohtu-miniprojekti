package miniprojekti.Services;

import java.util.HashMap;
import java.util.LinkedHashMap;

import org.springframework.stereotype.Component;

@Component
public class RefTypes {

    private HashMap<String, LinkedHashMap<String, Boolean[]>> types;

    public RefTypes() {
        types = new HashMap();
        setFieldsForAllTypes();
    }

    private void setFieldsForAllTypes() {
        setFields("article", new String[]{"article", "author", "title", "journal", "year", "volume"}
                , new String[]{"article", "number", "pages", "month", "note", "key"});
        setBookFields();
        setBookletFields();
        setConferenceFields();
        setInbookFields();
        setIncollectionFields();
        setInproceedingsFields();
        setManualFields();
        setMasterthesisFields();
        setMiscFields();
        setPhdThesisFields();
        setFields("proceedings", new String[]{"proceedings", "title", "year"}
                , new String[]{"editor", "volume", "number", "series", "address", "month", "publisher", "organization", "note", "key"});
        setFields("techreport", new String[]{"techreport", "author", "title", "institution", "year"}
                , new String[]{"techreport", "type", "number", "address", "month", "note", "key"});
        setFields("unpublished", new String[]{"unpublished", "author", "title", "note"}
                , new String[]{"month", "year", "key"});
    }

    private void setFields(String type, String[] required, String[] optional) {
        types.put(type, generateReference());
        setIsField(optional);
        setIsRequired(required);
    }

    private void setPhdThesisFields() {
        types.put("phdthesis", generateReference());
        setIsField(new String[]{"phdthesis", "author", "title", "school", "year", "type", "address", "month", "note", "key"});
        setIsRequired(new String[]{"phdthesis", "author", "title", "school", "year"});
    }

    private void setMiscFields() {
        types.put("misc", generateReference());
        setIsField(new String[]{"misc", "author", "title", "howpublished", "month", "year", "note", "key"});
    }

    private void setMasterthesisFields() {
        types.put("mastersthesis", generateReference());
        setIsField(new String[]{"mastersthesis", "author", "title", "school", "year", "type", "address", "month", "note", "key"});
        setIsRequired(new String[]{"mastersthesis", "author", "title", "school", "year"});
    }

    private void setManualFields() {
        types.put("manual", generateReference());
        setIsField(new String[]{"manual", "title", "author", "organization", "address", "edition", "month", "year", "note", "key"});
        setIsRequired(new String[]{"manual", "title"});
    }

    private void setInproceedingsFields() {
        types.put("inproceedings", generateReference());
        setIsField(new String[]{"inproceedings", "author", "title", "booktitle", "year", "editor", "volume", "number", "series", "pages", "address", "month", "organization", "publisher", "note", "key"});
        setIsRequired(new String[]{"inproceedings", "author", "title", "booktitle", "year"});
    }

    private void setIncollectionFields() {
        types.put("incollection", generateReference());
        setIsField(new String[]{"incollection", "author", "title", "booktitle", "publisher", "year", "editor", "volume", "number", "series", "type", "chapter", "pages", "address", "edition", "month", "note", "key"});
        setIsRequired(new String[]{"incollection", "author", "title", "booktitle", "publisher", "year"});
    }

    private void setInbookFields() {
        types.put("inbook", generateReference());
        setIsField(new String[]{"inbook", "author", "title", "chapter", "pages", "publisher", "year", "volume", "number", "series", "type", "address", "edition", "month", "note", "key"});
        setIsRequired(new String[]{"inbook", "author", "title", "chapter", "pages", "publisher", "year"});
    }

    private void setConferenceFields() {
        types.put("conference", generateReference());
        setIsField(new String[]{"conference", "author", "title", "booktitle", "year", "editor", "volume", "number", "series", "pages", "address", "month", "organization", "publisher", "note", "key"});
        setIsRequired(new String[]{"conference", "author", "title", "booktitle", "year"});
    }

    private void setBookletFields() {
        types.put("booklet", generateReference());
        setIsField(new String[]{"booklet", "title", "author", "howpublished", "address", "month", "year", "note", "key"});
        setIsRequired(new String[]{"booklet", "title"});
    }

    private void setBookFields() {
        types.put("book", generateReference());
        setIsField(new String[]{"book", "author", "editor", "title", "publisher", "year", "volume", "number", "series", "address", "edition", "month", "note", "key"});
        setIsRequired(new String[]{"book", "author", "editor", "title", "publisher", "year"});
    }

    private void setIsField(String... fields) {
        LinkedHashMap<String, Boolean[]> map = types.get(fields[0]);

        map.get("name")[0] = true;

        for (int i = 1; i < fields.length; i++) {
            map.get(fields[i])[0] = true;
        }
    }

    private void setIsRequired(String... fields) {
        LinkedHashMap<String, Boolean[]> map = types.get(fields[0]);

//        map.get("name")[1] = true;

        for (int i = 1; i < fields.length; i++) {
            map.get(fields[i])[1] = true;
        }
    }

    private LinkedHashMap generateReference() {
        LinkedHashMap<String, Boolean[]> map = new LinkedHashMap();
        map.put("name", new Boolean[]{false, false});
        map.put("author", new Boolean[]{false, false});
        map.put("title", new Boolean[]{false, false});
        map.put("journal", new Boolean[]{false, false});
        map.put("year", new Boolean[]{false, false});
        map.put("volume", new Boolean[]{false, false});
        map.put("number", new Boolean[]{false, false});
        map.put("pages", new Boolean[]{false, false});
        map.put("month", new Boolean[]{false, false});
        map.put("note", new Boolean[]{false, false});
        map.put("key", new Boolean[]{false, false});
        map.put("publisher", new Boolean[]{false, false});
        map.put("series", new Boolean[]{false, false});
        map.put("address", new Boolean[]{false, false});
        map.put("edition", new Boolean[]{false, false});
        map.put("annote", new Boolean[]{false, false});
        map.put("chapter", new Boolean[]{false, false});
        map.put("crossref", new Boolean[]{false, false});
        map.put("editor", new Boolean[]{false, false});
        map.put("howpublished", new Boolean[]{false, false});
        map.put("institution", new Boolean[]{false, false});
        map.put("organization", new Boolean[]{false, false});
        map.put("school", new Boolean[]{false, false});
        map.put("booktitle", new Boolean[]{false, false});
        map.put("type", new Boolean[]{false, false});
        return map;
    }

    public LinkedHashMap<String, Boolean[]> getTypeMap(String type) {
        return types.get(type);
    }

    public HashMap<String, LinkedHashMap<String, Boolean[]>> getTypes() {
        return types;
    }


}
