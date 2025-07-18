package com.learn.dao;

import com.learn.Utils.DbUtils;
import com.learn.model.UploadFile;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

public class FileDao {
    private QueryRunner queryRunner = new QueryRunner(DbUtils.getDataSource());
    public int uploadFileInfo(UploadFile fileObj) throws SQLException {
        Object[] params = {
                fileObj.getOriginal_name(),
                fileObj.getStored_name(),
                fileObj.getContent_type(),
                fileObj.getFile_size(),
                fileObj.getStorage_path(),
                fileObj.getDownload_url()
        };
        return queryRunner.update(
        "insert into uploaded_files(original_name, stored_name, content_type, file_size, storage_path, download_url) values " +
            "(?,?,?,?,?,?)",
        params
        );
    }
}
