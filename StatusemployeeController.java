import java.util.List;

public class StatusemployeeController{

    public static List<Statusemployee> get(){

       List<Statusemployee> statusemployees = StatusemployeeDao.getAll();
       
       return statusemployees;
       
    }
    

}