package com.globant.finalproject.model;

public class ParamRequest {

    private String searchParam;
    private SearchType type;

    public String getSearchParam() {
        return searchParam;
    }

    public void setSearchParam(String searchParam) {
        this.searchParam = searchParam;
    }

    public SearchType getType() {
        return type;
    }

    public void setType(SearchType type) {
        this.type = type;
    }

    public enum SearchType {
        PR, CATEGORY
    }
}
