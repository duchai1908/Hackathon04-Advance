package Advance.HN_JV240408_AD_NguyenDucHai.Exam_Advance_1.ra.service;

import Advance.HN_JV240408_AD_NguyenDucHai.Exam_Advance_1.ra.model.Catalog;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CatalogService implements IGenericService<Catalog,Integer>{
    private static ArrayList<Catalog> catalogs = new ArrayList<>();
    static {
        catalogs.add(new Catalog(1,"Quan Ao","Dep"));
        catalogs.add(new Catalog(2,"Giay Dep","Dep"));
    }
    //get Arraylist catalogs
    @Override
    public List<Catalog> getAll() {
        return catalogs;
    }

    //Add or update catalog
    @Override
    public void save(Catalog catalog) {
        Scanner sc = new Scanner(System.in);
        if(findById(catalog.getCatalogId()) == null){
            catalogs.add(catalog);
        }else{
            catalog.saveData(sc);
            catalogs.set(findIndexById(catalog.getCatalogId()),catalog);
            System.out.println("Update catalog success");
        }

    }

    //find Catalog by Id
    @Override
    public Catalog findById(Integer integer) {
        for(Catalog catalog: catalogs){
            if(catalog.getCatalogId() == integer){
                return catalog;
            }
        }
        return null;
    }

    //delete catalog by id
    @Override
    public void delete(Integer integer) {
        if(findById(integer) == null){
            System.err.println("Cant found catalog with Id: " + integer);
        }else{
            catalogs.remove(findById(integer));
        }
    }

    //find index catalog by id
    public int findIndexById(Integer id){
        for(int i = 0; i < catalogs.size();i++){
            if(catalogs.get(i).getCatalogId() == id){
                return i;
            }
        }
        return -1;
    }
}
