package com.liberty.fifahelper.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.liberty.fifahelper.crawler.pojo.ImageUrls;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document(collection = "nations")
public class Nation implements Serializable {

    @Id
    @JsonProperty("id")
    private Long id;

    @JsonProperty("imageUrls")
    private ImageUrls imageUrls;

    @JsonProperty("abbrName")
    private String abbrName;

    @JsonProperty("imgUrl")
    private String imgUrl;

    @JsonProperty("name")
    private String name;


}