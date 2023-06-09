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
public class GenderDao {

    public static Gender getById(Integer id) {
        HashMap hmap = new HashMap();
        hmap.put("id", id);

        return (Gender) CommonDao.select("Gender.findById", hmap).get(0);
    }

    public static ObservableList getAll() {
        return CommonDao.select("Gender.findAll");
    }

}
