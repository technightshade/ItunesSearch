
package com.sample.itunessample.model;

import java.util.List;


public class ItunesData {


//    public String toString() {
//        return "Example{" +
//                "resultCount=" + resultCount +
//                ", results=" + results +
//                '}';
//    }


    private Integer resultCount;

    private List<ItunesDataItem> results = null;


    public Integer getResultCount() {
        return resultCount;
    }


    public void setResultCount(Integer resultCount) {
        this.resultCount = resultCount;
    }


    public List<ItunesDataItem> getResults() {
        return results;
    }


    public void setResults(List<ItunesDataItem> results) {
        this.results = results;
    }

}
