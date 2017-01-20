package com.mehmetzahit.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by GUNEY on 13.01.2017.
 */
public class Search implements Serializable {

    private Content content;
    private Keyword keyword;

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public Keyword getKeyword() {
        return keyword;
    }

    public void setKeyword(Keyword keyword) {
        this.keyword = keyword;
    }
}
