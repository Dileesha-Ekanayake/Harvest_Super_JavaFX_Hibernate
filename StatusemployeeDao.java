/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.HashMap;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author Suranga
 */
public class StatusemployeeDao {

    public static Statusemployee getById(Integer id) {
        HashMap hmap = new HashMap();
        hmap.put("id", id);

        return (Statusemployee) CommonDao.select("Statusemployee.findById", hmap).get(0);
    }

    public static ObservableList getAll() {
        return CommonDao.select("Statusemployee.findAll");
    }

}
