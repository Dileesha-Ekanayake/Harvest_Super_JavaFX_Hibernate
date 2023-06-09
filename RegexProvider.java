import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Hashtable;

public class RegexProvider{

//    public static String get(){

//         Employee emp = new Employee();

//         String regexname = "";

//         try{

//             Method setName = emp.getClass().getMethod("setName", String.class);
//             Patern name = setName.getAnnotation(Patern.class);

//          regexname = name.regexp();   
            
//        }catch (NoSuchMethodException e) {
//             System.out.println("No Method");
//         }
//         return regexname;

//     }

    public static Hashtable<String,String> get(){

         Employee emp = new Employee();

            Hashtable<String,String> htRegexes = new Hashtable<String,String>();


                Field[] fs = emp.getClass().getFields();
                System.out.println(fs.length);

                for(Field f : fs){

                    Patern a = f.getAnnotation(Patern.class);
                    System.out.println(f);
                    if(a != null){
                        // htRegexes.put(f.getName().substring(3).toLowerCase(), a.regexp());
                        htRegexes.put(f.getName(), a.regexp());
                    }

                }
                


            //     Annotation all [] = emp.getClass().getAnnotations();
            //     System.out.println(all.length);

            //      Method setName = emp.getClass().getMethod("setName", String.class);
            //      Patern name = setName.getAnnotation(Patern.class);
            //      Method setNic = emp.getClass().getMethod("setNic", String.class);
            //      Patern nic = setNic.getAnnotation(Patern.class);

            //      htRegexes.put("name", name.regexp());
            //      htRegexes.put("nic", nic.regexp());   
        
            // }catch (NoSuchMethodException e) {
            //     System.out.println("No Method");
             
                return htRegexes;
            }

        }

    


