package com.mphasis.pfizerappDoctor.model;

/**
 * Created by Sourav.Bhattacharya on 1/18/2017.
 */

public class TransactionModel {

    /**
     * FileName : Sample.xml
     * FileType : XML
     * CKSUM : 3480166257
     * DATA : 3c3f786d6c2076657273696f6e3d2233e4e5e1233
     */

    private String FileName;
    private String FileType;
    private String CKSUM;
    private String DATA;

    public String getFileName() {
        return FileName;
    }

    public void setFileName(String FileName) {
        this.FileName = FileName;
    }

    public String getFileType() {
        return FileType;
    }

    public void setFileType(String FileType) {
        this.FileType = FileType;
    }

    public String getCKSUM() {
        return CKSUM;
    }

    public void setCKSUM(String CKSUM) {
        this.CKSUM = CKSUM;
    }

    public String getDATA() {
        return DATA;
    }

    public void setDATA(String DATA) {
        this.DATA = DATA;
    }
}
