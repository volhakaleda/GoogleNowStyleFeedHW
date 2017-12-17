package nyc.c4q.googlenowpractice.models;


import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class GitHubJob implements Parcelable{

    private String id;
    private String created_at;
    private String title;
    private String location;
    private String type;
    private String description;
    private String how_to_apply;
    private String company;
    private String company_url;
    private String company_logo;
    private String url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHow_to_apply() {
        return how_to_apply;
    }

    public void setHow_to_apply(String how_to_apply) {
        this.how_to_apply = how_to_apply;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompany_url() {
        return company_url;
    }

    public void setCompany_url(String company_url) {
        this.company_url = company_url;
    }

    public String getCompany_logo() {
        return company_logo;
    }

    public void setCompany_logo(String company_logo) {
        this.company_logo = company_logo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.created_at);
        dest.writeString(this.title);
        dest.writeString(this.location);
        dest.writeString(this.type);
        dest.writeString(this.description);
        dest.writeString(this.how_to_apply);
        dest.writeString(this.company);
        dest.writeString(this.company_url);
        dest.writeString(this.company_logo);
        dest.writeString(this.url);
    }


    protected GitHubJob(Parcel in) {
        this.id = in.readString();
        this.created_at = in.readString();
        this.title = in.readString();
        this.location = in.readString();
        this.type = in.readString();
        this.description = in.readString();
        this.how_to_apply = in.readString();
        this.company = in.readString();
        this.company_url = in.readString();
        this.company_logo = in.readString();
        this.url = in.readString();
    }

    public static final Creator<GitHubJob> CREATOR = new Creator<GitHubJob>() {
        @Override
        public GitHubJob createFromParcel(Parcel source) {
            return new GitHubJob(source);
        }

        @Override
        public GitHubJob[] newArray(int size) {
            return new GitHubJob[size];
        }
    };
}
