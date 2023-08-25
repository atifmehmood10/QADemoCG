package demoQA.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Book {

    @JsonProperty("ISBN")
    String ISBN;

    @JsonProperty("Title")
    String Title;

    @JsonProperty("Sub Title")
    String SubTitle;

    @JsonProperty("Author")
    String Author;

    @JsonProperty("Publisher")
    String Publisher;

    @JsonProperty("Total Pages")
    String TotalPages;

    @JsonProperty("Description")
    String Description;

    @JsonProperty("Website")
    String Website;


    public void setAllFields(String isbn,
                             String title,
                             String subTitle,
                             String author,
                             String publisher,
                             String totalPages,
                             String description,
                             String website){
        this.ISBN = isbn;
        this.Title = title;
        this.SubTitle = subTitle;
        this.Author = author;
        this.Publisher = publisher;
        this.TotalPages = totalPages;
        this.Description = description;
        this.Website = website;
    }

    public String getISBN(){ return ISBN;}
    public String getTitle(){return Title;}
    public String getSubTitle(){return SubTitle;}
    public String getAuthor(){return Author;}
    public String getPublisher(){return Publisher;}
    public String getTotalPages(){return TotalPages;}
    public String getDescription(){return Description;}
    public String getWebsite(){return Website;}
}
