
package miniprojekti.Services;
import java.util.HashMap;

public class RefTypes {
 
 private HashMap<String, HashMap> types;

 public RefTypes() {
    this.types = new HashMap<String, HashMap>();
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

private generateBook() {
    HashMap<String, Boolean[]> map;
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
}

private generateArticle() {
    HashMap<String, Boolean[]> map;
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
}

private generateBooklet() {
    HashMap<String, Boolean[]> map;
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
}

private generateConference() {
    HashMap<String, Boolean[]> map;
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
}

private generateInbook() {
    HashMap<String, Boolean[]> map;
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
}

private generateIncollection() {
    HashMap<String, Boolean[]> map;
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
}

private generateInproceedings() {
    HashMap<String, Boolean[]> map;
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
}

private generateManual() {
    HashMap<String, Boolean[]> map;
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
}

private generateMastersthesis() {
    HashMap<String, Boolean[]> map;
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
}

private generateMisc() {
    HashMap<String, Boolean[]> map;
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
}

private generatePhdthesis() {
    HashMap<String, Boolean[]> map;
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
}

private generateProceedings() {
    HashMap<String, Boolean[]> map;
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
}

private generateTechreport() {
    HashMap<String, Boolean[]> map;
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
}

private generateUnpublished() {
    HashMap<String, Boolean[]> map;
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
}


}

