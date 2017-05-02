
package miniprojekti.Services;
import java.util.HashMap;

public class RefTypes {
 
 private HashMap<String, HashMap> types;

 public RefTypes() {
    this.types = new HashMap<>();
    types.put("article", generateArticle());
    types.put("book", generateBook());
    types.put("booklet", generateBooklet());
    types.put("conference", generateConference());
    types.put("inbook", generateInbook());
    types.put("incollection", generateIncollection());
    types.put("inproceedings", generateInproceedings());
    types.put("manual", generateManual());
    types.put("mastersthesis", generateMastersthesis());
    types.put("misc", generateMisc());
    types.put("phdthesis", generatePhdthesis());
    types.put("proceedings", generateProceedings());
    types.put("techreport", generateTechreport());
    types.put("unpublished", generateUnpublished());
 }

private HashMap generateBook() {
    HashMap<String, Boolean[]> map = new HashMap();
    map.put("name", new Boolean[] {true, true});
    map.put("author", new Boolean[] {true, true});
    map.put("title", new Boolean[] {true, true});
    map.put("journal", new Boolean[] {true, true});
    map.put("year", new Boolean[] {true, true});
    map.put("volume", new Boolean[] {true, true});
    map.put("number", new Boolean[] {true, true});
    map.put("pages", new Boolean[] {true, true});
    map.put("month", new Boolean[] {true, true});
    map.put("note", new Boolean[] {true, true});
    map.put("key", new Boolean[] {true, true});
    map.put("publisher", new Boolean[] {true, true});
    map.put("series", new Boolean[] {true, true});
    map.put("address", new Boolean[] {true, true});
    map.put("edition", new Boolean[] {true, true});
    map.put("annote", new Boolean[] {true, true});
    map.put("chapter", new Boolean[] {true, true});
    map.put("crossref", new Boolean[] {true, true});
    map.put("editor", new Boolean[] {true, true});
    map.put("howpublished", new Boolean[] {true, true});
    map.put("institution", new Boolean[] {true, true});
    map.put("organization", new Boolean[] {true, true});
    map.put("school", new Boolean[] {true, true});
    map.put("booktitle", new Boolean[] {true, true});
    map.put("type", new Boolean[] {true, true});
    return map;
}

private HashMap generateArticle() {
    HashMap<String, Boolean[]> map = new HashMap();
    map.put("name", new Boolean[] {true, true});
    map.put("author", new Boolean[] {true, true});
    map.put("title", new Boolean[] {true, true});
    map.put("journal", new Boolean[] {true, true});
    map.put("year", new Boolean[] {true, true});
    map.put("volume", new Boolean[] {true, true});
    map.put("number", new Boolean[] {true, true});
    map.put("pages", new Boolean[] {true, true});
    map.put("month", new Boolean[] {true, true});
    map.put("note", new Boolean[] {true, true});
    map.put("key", new Boolean[] {true, true});
    map.put("publisher", new Boolean[] {true, true});
    map.put("series", new Boolean[] {true, true});
    map.put("address", new Boolean[] {true, true});
    map.put("edition", new Boolean[] {true, true});
    map.put("annote", new Boolean[] {true, true});
    map.put("chapter", new Boolean[] {true, true});
    map.put("crossref", new Boolean[] {true, true});
    map.put("editor", new Boolean[] {true, true});
    map.put("howpublished", new Boolean[] {true, true});
    map.put("institution", new Boolean[] {true, true});
    map.put("organization", new Boolean[] {true, true});
    map.put("school", new Boolean[] {true, true});
    map.put("booktitle", new Boolean[] {true, true});
    map.put("type", new Boolean[] {true, true});
    return map;
}

private HashMap generateBooklet() {
    HashMap<String, Boolean[]> map = new HashMap();
    map.put("name", new Boolean[] {true, true});
    map.put("author", new Boolean[] {true, true});
    map.put("title", new Boolean[] {true, true});
    map.put("journal", new Boolean[] {true, true});
    map.put("year", new Boolean[] {true, true});
    map.put("volume", new Boolean[] {true, true});
    map.put("number", new Boolean[] {true, true});
    map.put("pages", new Boolean[] {true, true});
    map.put("month", new Boolean[] {true, true});
    map.put("note", new Boolean[] {true, true});
    map.put("key", new Boolean[] {true, true});
    map.put("publisher", new Boolean[] {true, true});
    map.put("series", new Boolean[] {true, true});
    map.put("address", new Boolean[] {true, true});
    map.put("edition", new Boolean[] {true, true});
    map.put("annote", new Boolean[] {true, true});
    map.put("chapter", new Boolean[] {true, true});
    map.put("crossref", new Boolean[] {true, true});
    map.put("editor", new Boolean[] {true, true});
    map.put("howpublished", new Boolean[] {true, true});
    map.put("institution", new Boolean[] {true, true});
    map.put("organization", new Boolean[] {true, true});
    map.put("school", new Boolean[] {true, true});
    map.put("booktitle", new Boolean[] {true, true});
    map.put("type", new Boolean[] {true, true});
    return map;
}

private HashMap generateConference() {
    HashMap<String, Boolean[]> map = new HashMap();
    map.put("name", new Boolean[] {true, true});
    map.put("author", new Boolean[] {true, true});
    map.put("title", new Boolean[] {true, true});
    map.put("journal", new Boolean[] {true, true});
    map.put("year", new Boolean[] {true, true});
    map.put("volume", new Boolean[] {true, true});
    map.put("number", new Boolean[] {true, true});
    map.put("pages", new Boolean[] {true, true});
    map.put("month", new Boolean[] {true, true});
    map.put("note", new Boolean[] {true, true});
    map.put("key", new Boolean[] {true, true});
    map.put("publisher", new Boolean[] {true, true});
    map.put("series", new Boolean[] {true, true});
    map.put("address", new Boolean[] {true, true});
    map.put("edition", new Boolean[] {true, true});
    map.put("annote", new Boolean[] {true, true});
    map.put("chapter", new Boolean[] {true, true});
    map.put("crossref", new Boolean[] {true, true});
    map.put("editor", new Boolean[] {true, true});
    map.put("howpublished", new Boolean[] {true, true});
    map.put("institution", new Boolean[] {true, true});
    map.put("organization", new Boolean[] {true, true});
    map.put("school", new Boolean[] {true, true});
    map.put("booktitle", new Boolean[] {true, true});
    map.put("type", new Boolean[] {true, true});
    return map;
}

private HashMap generateInbook() {
    HashMap<String, Boolean[]> map = new HashMap();
    map.put("name", new Boolean[] {true, true});
    map.put("author", new Boolean[] {true, true});
    map.put("title", new Boolean[] {true, true});
    map.put("journal", new Boolean[] {true, true});
    map.put("year", new Boolean[] {true, true});
    map.put("volume", new Boolean[] {true, true});
    map.put("number", new Boolean[] {true, true});
    map.put("pages", new Boolean[] {true, true});
    map.put("month", new Boolean[] {true, true});
    map.put("note", new Boolean[] {true, true});
    map.put("key", new Boolean[] {true, true});
    map.put("publisher", new Boolean[] {true, true});
    map.put("series", new Boolean[] {true, true});
    map.put("address", new Boolean[] {true, true});
    map.put("edition", new Boolean[] {true, true});
    map.put("annote", new Boolean[] {true, true});
    map.put("chapter", new Boolean[] {true, true});
    map.put("crossref", new Boolean[] {true, true});
    map.put("editor", new Boolean[] {true, true});
    map.put("howpublished", new Boolean[] {true, true});
    map.put("institution", new Boolean[] {true, true});
    map.put("organization", new Boolean[] {true, true});
    map.put("school", new Boolean[] {true, true});
    map.put("booktitle", new Boolean[] {true, true});
    map.put("type", new Boolean[] {true, true});
    return map;
}

private HashMap generateIncollection() {
    HashMap<String, Boolean[]> map = new HashMap();
    map.put("name", new Boolean[] {true, true});
    map.put("author", new Boolean[] {true, true});
    map.put("title", new Boolean[] {true, true});
    map.put("journal", new Boolean[] {true, true});
    map.put("year", new Boolean[] {true, true});
    map.put("volume", new Boolean[] {true, true});
    map.put("number", new Boolean[] {true, true});
    map.put("pages", new Boolean[] {true, true});
    map.put("month", new Boolean[] {true, true});
    map.put("note", new Boolean[] {true, true});
    map.put("key", new Boolean[] {true, true});
    map.put("publisher", new Boolean[] {true, true});
    map.put("series", new Boolean[] {true, true});
    map.put("address", new Boolean[] {true, true});
    map.put("edition", new Boolean[] {true, true});
    map.put("annote", new Boolean[] {true, true});
    map.put("chapter", new Boolean[] {true, true});
    map.put("crossref", new Boolean[] {true, true});
    map.put("editor", new Boolean[] {true, true});
    map.put("howpublished", new Boolean[] {true, true});
    map.put("institution", new Boolean[] {true, true});
    map.put("organization", new Boolean[] {true, true});
    map.put("school", new Boolean[] {true, true});
    map.put("booktitle", new Boolean[] {true, true});
    map.put("type", new Boolean[] {true, true});
    return map;
}

private HashMap generateInproceedings() {
    HashMap<String, Boolean[]> map = new HashMap();
    map.put("name", new Boolean[] {true, true});
    map.put("author", new Boolean[] {true, true});
    map.put("title", new Boolean[] {true, true});
    map.put("journal", new Boolean[] {true, true});
    map.put("year", new Boolean[] {true, true});
    map.put("volume", new Boolean[] {true, true});
    map.put("number", new Boolean[] {true, true});
    map.put("pages", new Boolean[] {true, true});
    map.put("month", new Boolean[] {true, true});
    map.put("note", new Boolean[] {true, true});
    map.put("key", new Boolean[] {true, true});
    map.put("publisher", new Boolean[] {true, true});
    map.put("series", new Boolean[] {true, true});
    map.put("address", new Boolean[] {true, true});
    map.put("edition", new Boolean[] {true, true});
    map.put("annote", new Boolean[] {true, true});
    map.put("chapter", new Boolean[] {true, true});
    map.put("crossref", new Boolean[] {true, true});
    map.put("editor", new Boolean[] {true, true});
    map.put("howpublished", new Boolean[] {true, true});
    map.put("institution", new Boolean[] {true, true});
    map.put("organization", new Boolean[] {true, true});
    map.put("school", new Boolean[] {true, true});
    map.put("booktitle", new Boolean[] {true, true});
    map.put("type", new Boolean[] {true, true});
    return map;
}

private HashMap generateManual() {
    HashMap<String, Boolean[]> map = new HashMap();
    map.put("name", new Boolean[] {true, true});
    map.put("author", new Boolean[] {true, true});
    map.put("title", new Boolean[] {true, true});
    map.put("journal", new Boolean[] {true, true});
    map.put("year", new Boolean[] {true, true});
    map.put("volume", new Boolean[] {true, true});
    map.put("number", new Boolean[] {true, true});
    map.put("pages", new Boolean[] {true, true});
    map.put("month", new Boolean[] {true, true});
    map.put("note", new Boolean[] {true, true});
    map.put("key", new Boolean[] {true, true});
    map.put("publisher", new Boolean[] {true, true});
    map.put("series", new Boolean[] {true, true});
    map.put("address", new Boolean[] {true, true});
    map.put("edition", new Boolean[] {true, true});
    map.put("annote", new Boolean[] {true, true});
    map.put("chapter", new Boolean[] {true, true});
    map.put("crossref", new Boolean[] {true, true});
    map.put("editor", new Boolean[] {true, true});
    map.put("howpublished", new Boolean[] {true, true});
    map.put("institution", new Boolean[] {true, true});
    map.put("organization", new Boolean[] {true, true});
    map.put("school", new Boolean[] {true, true});
    map.put("booktitle", new Boolean[] {true, true});
    map.put("type", new Boolean[] {true, true});
    return map;
}

private HashMap generateMastersthesis() {
    HashMap<String, Boolean[]> map = new HashMap();
    map.put("name", new Boolean[] {true, true});
    map.put("author", new Boolean[] {true, true});
    map.put("title", new Boolean[] {true, true});
    map.put("journal", new Boolean[] {true, true});
    map.put("year", new Boolean[] {true, true});
    map.put("volume", new Boolean[] {true, true});
    map.put("number", new Boolean[] {true, true});
    map.put("pages", new Boolean[] {true, true});
    map.put("month", new Boolean[] {true, true});
    map.put("note", new Boolean[] {true, true});
    map.put("key", new Boolean[] {true, true});
    map.put("publisher", new Boolean[] {true, true});
    map.put("series", new Boolean[] {true, true});
    map.put("address", new Boolean[] {true, true});
    map.put("edition", new Boolean[] {true, true});
    map.put("annote", new Boolean[] {true, true});
    map.put("chapter", new Boolean[] {true, true});
    map.put("crossref", new Boolean[] {true, true});
    map.put("editor", new Boolean[] {true, true});
    map.put("howpublished", new Boolean[] {true, true});
    map.put("institution", new Boolean[] {true, true});
    map.put("organization", new Boolean[] {true, true});
    map.put("school", new Boolean[] {true, true});
    map.put("booktitle", new Boolean[] {true, true});
    map.put("type", new Boolean[] {true, true});
    return map;
}

private HashMap generateMisc() {
    HashMap<String, Boolean[]> map = new HashMap();
    map.put("name", new Boolean[] {true, true});
    map.put("author", new Boolean[] {true, true});
    map.put("title", new Boolean[] {true, true});
    map.put("journal", new Boolean[] {true, true});
    map.put("year", new Boolean[] {true, true});
    map.put("volume", new Boolean[] {true, true});
    map.put("number", new Boolean[] {true, true});
    map.put("pages", new Boolean[] {true, true});
    map.put("month", new Boolean[] {true, true});
    map.put("note", new Boolean[] {true, true});
    map.put("key", new Boolean[] {true, true});
    map.put("publisher", new Boolean[] {true, true});
    map.put("series", new Boolean[] {true, true});
    map.put("address", new Boolean[] {true, true});
    map.put("edition", new Boolean[] {true, true});
    map.put("annote", new Boolean[] {true, true});
    map.put("chapter", new Boolean[] {true, true});
    map.put("crossref", new Boolean[] {true, true});
    map.put("editor", new Boolean[] {true, true});
    map.put("howpublished", new Boolean[] {true, true});
    map.put("institution", new Boolean[] {true, true});
    map.put("organization", new Boolean[] {true, true});
    map.put("school", new Boolean[] {true, true});
    map.put("booktitle", new Boolean[] {true, true});
    map.put("type", new Boolean[] {true, true});
    return map;
}

private HashMap generatePhdthesis() {
    HashMap<String, Boolean[]> map = new HashMap();
    map.put("name", new Boolean[] {true, true});
    map.put("author", new Boolean[] {true, true});
    map.put("title", new Boolean[] {true, true});
    map.put("journal", new Boolean[] {true, true});
    map.put("year", new Boolean[] {true, true});
    map.put("volume", new Boolean[] {true, true});
    map.put("number", new Boolean[] {true, true});
    map.put("pages", new Boolean[] {true, true});
    map.put("month", new Boolean[] {true, true});
    map.put("note", new Boolean[] {true, true});
    map.put("key", new Boolean[] {true, true});
    map.put("publisher", new Boolean[] {true, true});
    map.put("series", new Boolean[] {true, true});
    map.put("address", new Boolean[] {true, true});
    map.put("edition", new Boolean[] {true, true});
    map.put("annote", new Boolean[] {true, true});
    map.put("chapter", new Boolean[] {true, true});
    map.put("crossref", new Boolean[] {true, true});
    map.put("editor", new Boolean[] {true, true});
    map.put("howpublished", new Boolean[] {true, true});
    map.put("institution", new Boolean[] {true, true});
    map.put("organization", new Boolean[] {true, true});
    map.put("school", new Boolean[] {true, true});
    map.put("booktitle", new Boolean[] {true, true});
    map.put("type", new Boolean[] {true, true});
    return map;
}

private HashMap generateProceedings() {
    HashMap<String, Boolean[]> map = new HashMap();
    map.put("name", new Boolean[] {true, true});
    map.put("author", new Boolean[] {true, true});
    map.put("title", new Boolean[] {true, true});
    map.put("journal", new Boolean[] {true, true});
    map.put("year", new Boolean[] {true, true});
    map.put("volume", new Boolean[] {true, true});
    map.put("number", new Boolean[] {true, true});
    map.put("pages", new Boolean[] {true, true});
    map.put("month", new Boolean[] {true, true});
    map.put("note", new Boolean[] {true, true});
    map.put("key", new Boolean[] {true, true});
    map.put("publisher", new Boolean[] {true, true});
    map.put("series", new Boolean[] {true, true});
    map.put("address", new Boolean[] {true, true});
    map.put("edition", new Boolean[] {true, true});
    map.put("annote", new Boolean[] {true, true});
    map.put("chapter", new Boolean[] {true, true});
    map.put("crossref", new Boolean[] {true, true});
    map.put("editor", new Boolean[] {true, true});
    map.put("howpublished", new Boolean[] {true, true});
    map.put("institution", new Boolean[] {true, true});
    map.put("organization", new Boolean[] {true, true});
    map.put("school", new Boolean[] {true, true});
    map.put("booktitle", new Boolean[] {true, true});
    map.put("type", new Boolean[] {true, true});
    return map;
}

private HashMap generateTechreport() {
    HashMap<String, Boolean[]> map = new HashMap();
    map.put("name", new Boolean[] {true, true});
    map.put("author", new Boolean[] {true, true});
    map.put("title", new Boolean[] {true, true});
    map.put("journal", new Boolean[] {true, true});
    map.put("year", new Boolean[] {true, true});
    map.put("volume", new Boolean[] {true, true});
    map.put("number", new Boolean[] {true, true});
    map.put("pages", new Boolean[] {true, true});
    map.put("month", new Boolean[] {true, true});
    map.put("note", new Boolean[] {true, true});
    map.put("key", new Boolean[] {true, true});
    map.put("publisher", new Boolean[] {true, true});
    map.put("series", new Boolean[] {true, true});
    map.put("address", new Boolean[] {true, true});
    map.put("edition", new Boolean[] {true, true});
    map.put("annote", new Boolean[] {true, true});
    map.put("chapter", new Boolean[] {true, true});
    map.put("crossref", new Boolean[] {true, true});
    map.put("editor", new Boolean[] {true, true});
    map.put("howpublished", new Boolean[] {true, true});
    map.put("institution", new Boolean[] {true, true});
    map.put("organization", new Boolean[] {true, true});
    map.put("school", new Boolean[] {true, true});
    map.put("booktitle", new Boolean[] {true, true});
    map.put("type", new Boolean[] {true, true});
    return map;
}

private HashMap generateUnpublished() {
    HashMap<String, Boolean[]> map = new HashMap();
    map.put("name", new Boolean[] {true, true});
    map.put("author", new Boolean[] {true, true});
    map.put("title", new Boolean[] {true, true});
    map.put("journal", new Boolean[] {false, false});
    map.put("year", new Boolean[] {true, false});
    map.put("volume", new Boolean[] {false, false});
    map.put("number", new Boolean[] {false, false});
    map.put("pages", new Boolean[] {false, false});
    map.put("month", new Boolean[] {true, false});
    map.put("note", new Boolean[] {true, true});
    map.put("key", new Boolean[] {true, false});
    map.put("publisher", new Boolean[] {false, false});
    map.put("series", new Boolean[] {false, false});
    map.put("address", new Boolean[] {false, false});
    map.put("edition", new Boolean[] {false, false});
    map.put("annote", new Boolean[] {false, false});
    map.put("chapter", new Boolean[] {false, false});
    map.put("crossref", new Boolean[] {false, false});
    map.put("editor", new Boolean[] {false, false});
    map.put("howpublished", new Boolean[] {false, false});
    map.put("institution", new Boolean[] {false, false});
    map.put("organization", new Boolean[] {false, false});
    map.put("school", new Boolean[] {false, false});
    map.put("booktitle", new Boolean[] {false, false});
    map.put("type", new Boolean[] {false, false});
    return map;
}


}

