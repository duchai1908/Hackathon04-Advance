package Advance.HN_JV240408_AD_NguyenDucHai.Exam_Advance_1.ra.model;

import Advance.HN_JV240408_AD_NguyenDucHai.Exam_Advance_1.ra.validate.CatalogValidate;

import java.util.Scanner;

public class Catalog {
    private int catalogId;
    private String catalogName,descriptions;

    public Catalog() {
    }

    public Catalog(int catalogId, String catalogName, String descriptions) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.descriptions = descriptions;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    //Input Data Catalog
    public void inputData(Scanner sc){
        this.catalogId = CatalogValidate.inputCatalogId(sc);
        this.catalogName = CatalogValidate.inputCatalogName(sc);
        this.descriptions = CatalogValidate.inputCatalogDescriptions(sc);
    }

    //Update Data Catalog
    public void saveData(Scanner sc){
        this.catalogName = CatalogValidate.inputCatalogName(sc);
        this.descriptions = CatalogValidate.inputCatalogDescriptions(sc);
    }

    //Display Catalog
    @Override
    public String toString() {
        return "CatalogID: " +this.catalogId + "   |   CatalogName: "+this.catalogName +"\n"
                +"------------------------------------------------------------------";
    }
}
