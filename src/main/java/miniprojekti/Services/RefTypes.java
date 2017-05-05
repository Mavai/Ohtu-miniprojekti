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
        setFields(new String[]{"article", "author", "title", "journal", "year", "volume"}
                , new String[]{"article", "number", "pages", "month", "note", "key"});
        setFields(new String[]{"book", "author", "editor", "title", "publisher", "year"}
                , new String[]{"book", "volume", "number", "series", "address", "edition", "month", "note", "key"});
        setFields(new String[]{"booklet", "title"}
                , new String[]{"booklet", "author", "howpublished", "address", "month", "year", "note", "key"});
        setFields(new String[]{"conference", "author", "title", "booktitle", "year"}
                , new String[]{"conference", "editor", "volume", "number", "series", "pages", "address", "month", "organization", "publisher", "note", "key"});
        setFields(new String[]{"inbook", "author", "title", "chapter", "pages", "publisher", "year"}
                , new String[]{"inbook", "volume", "number", "series", "type", "address", "edition", "month", "note", "key"});
        setFields(new String[]{"incollection", "author", "title", "booktitle", "publisher", "year"}
                , new String[]{"incollection", "editor", "volume", "number", "series", "type", "chapter", "pages", "address", "edition", "month", "note", "key"});
        setFields(new String[]{"inproceedings", "author", "title", "booktitle", "year"}
                , new String[]{"inproceedings", "editor", "volume", "number", "series", "pages", "address", "month", "organization", "publisher", "note", "key"});
        setFields(new String[]{"manual", "title"}
                , new String[]{"manual", "author", "organization", "address", "edition", "month", "year", "note", "key"});
        setFields(new String[]{"mastersthesis", "author", "title", "school", "year"}
                , new String[]{"mastersthesis", "type", "address", "month", "note", "key"});
        setFields(new String[]{}, new String[]{"misc", "author", "title", "howpublished", "month", "year", "note", "key"});
        setFields(new String[]{"phdthesis", "author", "title", "school", "year"}
                , new String[]{"phdthesis", "type", "address", "month", "note", "key"});
        setFields(new String[]{"proceedings", "title", "year"}
                , new String[]{"proceedings", "editor", "volume", "number", "series", "address", "month", "publisher", "organization", "note", "key"});
        setFields(new String[]{"techreport", "author", "title", "institution", "year"}
                , new String[]{"techreport", "type", "number", "address", "month", "note", "key"});
        setFields(new String[]{"unpublished", "author", "title", "note"}
                , new String[]{"unpublished", "month", "year", "key"});
    }

    private void setFields(String[] required, String[] optional) {
        types.put(optional[0], generateReference());
        setIsField(optional);
        setIsRequired(required);
    }

    private void setIsField(String... fields) {
        LinkedHashMap<String, Boolean[]> map = types.get(fields[0]);
        map.get("name")[0] = true;
        for (int i = 1; i < fields.length; i++) {
            map.get(fields[i])[0] = true;
        }
    }

    private void setIsRequired(String... fields) {
        if (fields.length > 0) {
            LinkedHashMap<String, Boolean[]> map = types.get(fields[0]);
            for (int i = 1; i < fields.length; i++) {
                map.get(fields[i])[1] = true;
            }
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
