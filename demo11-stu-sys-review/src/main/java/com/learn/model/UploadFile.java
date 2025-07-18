package com.learn.model;

import java.util.Date;

public class UploadFile {
    private Integer id;
    private String original_name;
    private String stored_name;
    private String content_type;
    private Integer file_size;
    private String storage_path;
    private String download_url;
    private Date upload_time;

    public UploadFile() {
    }

    public UploadFile(String original_name, String stored_name, String content_type, Integer file_size, String storage_path, String download_url) {
        this.original_name = original_name;
        this.stored_name = stored_name;
        this.content_type = content_type;
        this.file_size = file_size;
        this.storage_path = storage_path;
        this.download_url = download_url;
        this.upload_time = upload_time;
    }

    @Override
    public String toString() {
        return "UploadFile{" +
        "id=" + id +
        ", original_name='" + original_name + '\'' +
        ", stored_name='" + stored_name + '\'' +
        ", content_type='" + content_type + '\'' +
        ", file_size=" + file_size +
        ", storage_path='" + storage_path + '\'' +
        ", download_url='" + download_url + '\'' +
        ", upload_time=" + upload_time +
        '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOriginal_name() {
        return original_name;
    }

    public void setOriginal_name(String original_name) {
        this.original_name = original_name;
    }

    public String getStored_name() {
        return stored_name;
    }

    public void setStored_name(String stored_name) {
        this.stored_name = stored_name;
    }

    public String getContent_type() {
        return content_type;
    }

    public void setContent_type(String content_type) {
        this.content_type = content_type;
    }

    public Integer getFile_size() {
        return file_size;
    }

    public void setFile_size(Integer file_size) {
        this.file_size = file_size;
    }

    public String getStorage_path() {
        return storage_path;
    }

    public void setStorage_path(String storage_path) {
        this.storage_path = storage_path;
    }

    public String getDownload_url() {
        return download_url;
    }

    public void setDownload_url(String download_url) {
        this.download_url = download_url;
    }

    public Date getUpload_time() {
        return upload_time;
    }

    public void setUpload_time(Date upload_time) {
        this.upload_time = upload_time;
    }
}
