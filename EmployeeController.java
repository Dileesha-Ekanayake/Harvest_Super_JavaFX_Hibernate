import java.util.List;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Hashtable;

public class EmployeeController {

    public static List<Employee> get(Hashtable<String, Object> ht) {

        List<Employee> employees = new ArrayList<>();

        if (ht == null) {
            employees = EmployeeDao.getAll();
        } else {

            String name = (String) ht.get("name");
            Gender gender = (Gender) ht.get("gender");
            Designation designation = (Designation) ht.get("designation");

            if (name.equals("") && gender == null && designation == null)
                employees = EmployeeDao.getAll();

            if (!name.equals("") && gender == null && designation == null)
                employees = EmployeeDao.getAllByName(name);

            if (name.equals("") && gender != null && designation == null)
                employees = EmployeeDao.getAllByGender(gender);

            if (name.equals("") && gender == null && designation != null)
                employees = EmployeeDao.getAllByDesignation(designation);

            if (!name.equals("") && gender != null && designation == null)
                employees = EmployeeDao.getAllByNameGender(name, gender);

            if (name.equals("") && gender != null && designation != null)
                employees = EmployeeDao.getAllByGenderDesignation(gender, designation);

            if (!name.equals("") && gender == null && designation != null)
                employees = EmployeeDao.getAllByNameDesignation(name, designation);

            if (!name.equals("") && gender != null && designation != null)
                employees = EmployeeDao.getAllByNameGenderDesignation(name, gender, designation);

        }

        return employees;

    }

    public static String post(Employee employee) {

        String msg = "";
        String err = "";

        LocalDate today = LocalDate.now();
        int age = today.getYear() - employee.getDob().getYear();

        if (age < 18)
            err = err + "\nMust be 18 Years";

        List<Employee> empNic = EmployeeDao.getByNic(employee.getNic());

        if (!empNic.isEmpty())
            err = err + "\nNIC Exists";
        if (err.isEmpty()) {
            String dberr = EmployeeDao.add(employee);

            if (dberr.equals("1"))
                msg = "1";
            else
                msg = "DB error as : " + dberr;
        } else {
            msg = "Data Errors : \n" + err;
        }

        return msg;
    }

    public static String put(Employee employee) {

        String msg = "";
        String err = "";
        int id = 0;

        LocalDate today = LocalDate.now();
        int age = today.getYear() - employee.getDob().getYear();
        // System.out.println(age);

        if (age < 18)
            err = err + "\nMust be 18 Years";

        List<Employee> empNic = EmployeeDao.getByNic(employee.getNic());
        for (Employee emp : empNic) {
            id = emp.getId();
        }
        
        if (!empNic.isEmpty() && id != employee.getId())
            err = err + "\nNIC Exists";

        if (err.isEmpty()) {
            String dberr = EmployeeDao.update(employee);
            if (dberr.equals("1"))
                msg = "1";
            else
                msg = "DB error as : " + dberr;
        } else {
            msg = "Validation Data Errors : \n" + err;
        }

        return msg;
    }

    public static String delete(Employee employee) {
        String msg = "";

        String dberr = EmployeeDao.delete(employee);
        if (dberr.equals("1"))
            msg = "1";
        else
            msg = "DB Error As : " + dberr;

        return msg;

    }

}