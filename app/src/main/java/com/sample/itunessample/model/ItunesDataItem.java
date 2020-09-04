
package com.sample.itunessample.model;


import java.util.Objects;

public class ItunesDataItem {

    private String wrapperType;

//    @Override
//    public String toString() {
//        return "Result{" +
//                "wrapperType='" + wrapperType + '\'' +
//                ", kind='" + kind + '\'' +
//                ", artistId=" + artistId +
//                ", collectionId=" + collectionId +
//                ", trackId=" + trackId +
//                ", artistName='" + artistName + '\'' +
//                ", collectionName='" + collectionName + '\'' +
//                ", trackName='" + trackName + '\'' +
//                ", collectionCensoredName='" + collectionCensoredName + '\'' +
//                ", trackCensoredName='" + trackCensoredName + '\'' +
//                ", artistViewUrl='" + artistViewUrl + '\'' +
//                ", collectionViewUrl='" + collectionViewUrl + '\'' +
//                ", trackViewUrl='" + trackViewUrl + '\'' +
//                ", previewUrl='" + previewUrl + '\'' +
//                ", artworkUrl30='" + artworkUrl30 + '\'' +
//                ", artworkUrl60='" + artworkUrl60 + '\'' +
//                ", artworkUrl100='" + artworkUrl100 + '\'' +
//                ", collectionPrice=" + collectionPrice +
//                ", trackPrice=" + trackPrice +
//                ", releaseDate='" + releaseDate + '\'' +
//                ", collectionExplicitness='" + collectionExplicitness + '\'' +
//                ", trackExplicitness='" + trackExplicitness + '\'' +
//                ", discCount=" + discCount +
//                ", discNumber=" + discNumber +
//                ", trackCount=" + trackCount +
//                ", trackNumber=" + trackNumber +
//                ", trackTimeMillis=" + trackTimeMillis +
//                ", country='" + country + '\'' +
//                ", currency='" + currency + '\'' +
//                ", primaryGenreName='" + primaryGenreName + '\'' +
//                ", contentAdvisoryRating='" + contentAdvisoryRating + '\'' +
//                ", isStreamable=" + isStreamable +
//                '}';
//    }

    private String kind;
    private Integer artistId;
    private Integer collectionId;
    private Integer trackId;
    private String artistName;
    private String collectionName;
    private String trackName;
    private String collectionCensoredName;
    private String trackCensoredName;
    private String artistViewUrl;
    private String collectionViewUrl;
    private String trackViewUrl;
    private String previewUrl;
    private String artworkUrl30;
    private String artworkUrl60;
    private String artworkUrl100;
    private Float collectionPrice;
    private Float trackPrice;
    private String releaseDate;
    private String collectionExplicitness;
    private String trackExplicitness;
    private Integer discCount;
    private Integer discNumber;
    private Integer trackCount;
    private Integer trackNumber;
    private Integer trackTimeMillis;
    private String country;
    private String currency;
    private String primaryGenreName;
    private String contentAdvisoryRating;
    private Boolean isStreamable;


    private boolean isSelected;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItunesDataItem that = (ItunesDataItem) o;
        return trackName.equalsIgnoreCase(that.trackName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trackName.toLowerCase());
    }

    public void setIsSelected(boolean flag){
        isSelected=flag;
    }

    public boolean isItemSelected(){
        return isSelected;
    }

    public String getWrapperType() {
        return wrapperType;
    }

    
    public void setWrapperType(String wrapperType) {
        this.wrapperType = wrapperType;
    }

    
    public String getKind() {
        return kind;
    }

    
    public void setKind(String kind) {
        this.kind = kind;
    }

    
    public Integer getArtistId() {
        return artistId;
    }

    
    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }

    
    public Integer getCollectionId() {
        return collectionId;
    }

    
    public void setCollectionId(Integer collectionId) {
        this.collectionId = collectionId;
    }

    
    public Integer getTrackId() {
        return trackId;
    }

    
    public void setTrackId(Integer trackId) {
        this.trackId = trackId;
    }

    
    public String getArtistName() {
        return artistName;
    }

    
    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    
    public String getCollectionName() {
        return collectionName;
    }

    
    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    
    public String getTrackName() {
        return trackName;
    }

    
    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    
    public String getCollectionCensoredName() {
        return collectionCensoredName;
    }

    
    public void setCollectionCensoredName(String collectionCensoredName) {
        this.collectionCensoredName = collectionCensoredName;
    }

    
    public String getTrackCensoredName() {
        return trackCensoredName;
    }

    
    public void setTrackCensoredName(String trackCensoredName) {
        this.trackCensoredName = trackCensoredName;
    }

    
    public String getArtistViewUrl() {
        return artistViewUrl;
    }

    
    public void setArtistViewUrl(String artistViewUrl) {
        this.artistViewUrl = artistViewUrl;
    }

    
    public String getCollectionViewUrl() {
        return collectionViewUrl;
    }

    
    public void setCollectionViewUrl(String collectionViewUrl) {
        this.collectionViewUrl = collectionViewUrl;
    }

    
    public String getTrackViewUrl() {
        return trackViewUrl;
    }

    
    public void setTrackViewUrl(String trackViewUrl) {
        this.trackViewUrl = trackViewUrl;
    }

    
    public String getPreviewUrl() {
        return previewUrl;
    }

    
    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    
    public String getArtworkUrl30() {
        return artworkUrl30;
    }

    
    public void setArtworkUrl30(String artworkUrl30) {
        this.artworkUrl30 = artworkUrl30;
    }

    
    public String getArtworkUrl60() {
        return artworkUrl60;
    }

    
    public void setArtworkUrl60(String artworkUrl60) {
        this.artworkUrl60 = artworkUrl60;
    }

    
    public String getArtworkUrl100() {
        return artworkUrl100;
    }

    
    public void setArtworkUrl100(String artworkUrl100) {
        this.artworkUrl100 = artworkUrl100;
    }

    
    public Float getCollectionPrice() {
        return collectionPrice;
    }

    
    public void setCollectionPrice(Float collectionPrice) {
        this.collectionPrice = collectionPrice;
    }

    
    public Float getTrackPrice() {
        return trackPrice;
    }

    
    public void setTrackPrice(Float trackPrice) {
        this.trackPrice = trackPrice;
    }

    
    public String getReleaseDate() {
        return releaseDate;
    }

    
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    
    public String getCollectionExplicitness() {
        return collectionExplicitness;
    }

    
    public void setCollectionExplicitness(String collectionExplicitness) {
        this.collectionExplicitness = collectionExplicitness;
    }

    
    public String getTrackExplicitness() {
        return trackExplicitness;
    }

    
    public void setTrackExplicitness(String trackExplicitness) {
        this.trackExplicitness = trackExplicitness;
    }

    
    public Integer getDiscCount() {
        return discCount;
    }

    
    public void setDiscCount(Integer discCount) {
        this.discCount = discCount;
    }

    
    public Integer getDiscNumber() {
        return discNumber;
    }

    
    public void setDiscNumber(Integer discNumber) {
        this.discNumber = discNumber;
    }

    
    public Integer getTrackCount() {
        return trackCount;
    }

    
    public void setTrackCount(Integer trackCount) {
        this.trackCount = trackCount;
    }

    
    public Integer getTrackNumber() {
        return trackNumber;
    }

    
    public void setTrackNumber(Integer trackNumber) {
        this.trackNumber = trackNumber;
    }

    
    public Integer getTrackTimeMillis() {
        return trackTimeMillis;
    }

    
    public void setTrackTimeMillis(Integer trackTimeMillis) {
        this.trackTimeMillis = trackTimeMillis;
    }

    
    public String getCountry() {
        return country;
    }

    
    public void setCountry(String country) {
        this.country = country;
    }

    
    public String getCurrency() {
        return currency;
    }

    
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    
    public String getPrimaryGenreName() {
        return primaryGenreName;
    }

    
    public void setPrimaryGenreName(String primaryGenreName) {
        this.primaryGenreName = primaryGenreName;
    }

    
    public String getContentAdvisoryRating() {
        return contentAdvisoryRating;
    }

    
    public void setContentAdvisoryRating(String contentAdvisoryRating) {
        this.contentAdvisoryRating = contentAdvisoryRating;
    }

    
    public Boolean getIsStreamable() {
        return isStreamable;
    }

    
    public void setIsStreamable(Boolean isStreamable) {
        this.isStreamable = isStreamable;
    }

}
