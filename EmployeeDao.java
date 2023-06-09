/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import javafx.collections.ObservableList;

/**
 *
 * @author Suranga
 */
public class EmployeeDao {

    public static String add(Employee employee) {
        String msg = "0";
        msg = CommonDao.insert(employee);
        return msg;
    }

    public static String update(Employee employee) {
        String msg = "Cant connent to Database";
        msg = CommonDao.update(employee);
        return msg;
    }

    public static String delete(Employee employee) {
        String msg = "Cant Connect Database";
        msg = CommonDao.delete(employee);
        return msg;
    }

    public static ObservableList getAll() {
        return CommonDao.select("Employee.findAll");
    }

    public static Employee getById(Integer id) {
        HashMap hmap = new HashMap();
        hmap.put("id", id);

        return (Employee) CommonDao.select("Employee.findById", hmap).get(0);
    }

    public static ObservableList getAllByName(String name) {
        HashMap hmap = new HashMap();
        hmap.put("name", name + "%");

        return CommonDao.select("Employee.findAllByName", hmap);
    }

    public static List<Employee> getByNic(String nic) {
        HashMap hmap = new HashMap();
        hmap.put("nic", nic + "%");

        return CommonDao.select("Employee.findAllByNic", hmap);
    }
    // public static Employee getByNic(String nic) {

    // Employee employee = null;

    // HashMap hmap = new HashMap();
    // hmap.put("nic", nic);

    // try {

    // ObservableList<Employee> rslt = CommonDao.select("Employee.findAllByNic",
    // hmap);

    // if (rslt != null && rslt.next()) {

    // employee = new Employee();
    // employee.setId(rslt.getInt("id"));
    // employee.setName(rslt.getObject("name").toString());
    // employee.setNic(rslt.getObject("nic").toString());
    // employee.setDob(LocalDate.parse(rslt.getObject("dob").toString()));
    // employee.setMobile(rslt.getObject("mobile").toString());
    // employee.setEmail(rslt.getObject("email").toString());

    // employee.setDesignation(DesignationDao.getById(rslt.getInt("designation_id")));
    // employee.setGender(GenderDao.getById(rslt.getInt("gender_id")));
    // employee.setStatusEmployee(StatusemployeeDao.getById(rslt.getInt("statusemployee_id")));
    // }
    // } catch (SQLException e) {
    // System.out.println("Can't Get Results as : " + e.getMessage());
    // }

    // return employee;
    // }

    public static ObservableList getAllByDesignation(Designation designation) {
        HashMap hmap = new HashMap();
        hmap.put("designation", designation);

        return CommonDao.select("Employee.findAllByDesignation", hmap);
    }

    public static ObservableList getAllByGender(Gender gender) {
        HashMap hmap = new HashMap();
        hmap.put("gender", gender);

        return CommonDao.select("Employee.findAllByGender", hmap);
    }

    public static ObservableList getAllByNameGender(String name, Gender gender) {
        HashMap hmap = new HashMap();
        hmap.put("gender", gender);
        hmap.put("name", name + "%");
        return CommonDao.select("Employee.findAllByNameGender", hmap);

    }

    public static ObservableList getAllByNameDesignation(String name, Designation designation) {
        HashMap hmap = new HashMap();
        hmap.put("designation", designation);
        hmap.put("name", name + "%");
        return CommonDao.select("Employee.findAllByNameDesignation", hmap);

    }

    public static ObservableList getAllByGenderDesignation(Gender gender, Designation designation) {
        HashMap hmap = new HashMap();
        hmap.put("gender", gender);
        hmap.put("designation", designation);
        return CommonDao.select("Employee.findAllByGenderDesignation", hmap);

    }

    public static ObservableList getAllByNameGenderDesignation(String name, Gender gender, Designation designation) {
        HashMap hmap = new HashMap();
        hmap.put("gender", gender);
        hmap.put("designation", designation);
        hmap.put("name", name + "%");
        return CommonDao.select("Employee.findAllByNameGenderDesignation", hmap);

    }

}
