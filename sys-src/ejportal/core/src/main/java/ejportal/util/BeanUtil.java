package ejportal.util;

import ejportal.model.Journal;
import ejportal.service.dto.JournalBaseTO;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

/**
 * Created by IntelliJ IDEA.
 * User: Florian
 * Date: 01.07.2010
 * Time: 13:20:02
 * To change this template use File | Settings | File Templates.
 */
public class BeanUtil {

    public void copyEntityToBaseTO(Object entity, Object entityBase) throws Exception {
        Class entityClazz = entity.getClass();
        Class baseClazz = entityBase.getClass();

        //alle Methoden holen
        Method[] allMethods = baseClazz.getDeclaredMethods();
        for (Method baseMethod : allMethods) {
            String methodName = baseMethod.getName();

            //ab hier sind nur die setter interessant
            if(!methodName.startsWith("set")){
              continue;
            }

            //kleine Fehlerpruefung
            Type[] types = baseMethod.getGenericParameterTypes();
            if (types.length != 1){
                throw new Exception("BeanUtil: Moep! Da ging was total schief");
            }

            //wie heisst wohl der getter zum setter ;-)
            String getter = "get"+ methodName.substring(3,methodName.length());

            //Do it!
            try {
                Method entityMethod = entityClazz.getDeclaredMethod(getter);
                baseMethod.invoke(entityBase,entityMethod.invoke(entity));

            } catch (Exception e) {
                //TODO Fehlerbehandlung
                System.err.println("## Fehler bei " + methodName);
                e.printStackTrace();
                throw new Exception("BeanUtil: Reflection Voodoo ging schief");
            }

        }

    }

    public void copyBaseTOtoEntity(Object entityBase, Object entity) throws Exception{
        Class entityClazz = entity.getClass();
        Class baseClazz = entityBase.getClass();

        //alle Methoden holen
        Method[] allMethods = baseClazz.getDeclaredMethods();
        for (Method baseMethod : allMethods) {
            String methodName = baseMethod.getName();

            //ab hier sind nur die getter interessant
            if(!methodName.startsWith("get")){
              continue;
            }

            //kleine Fehlerpruefung
            Type[] types = baseMethod.getGenericParameterTypes();
            if (types.length != 0){
                throw new Exception("BeanUtil: Moep! Da ging was total schief");
            }

            //wie heisst wohl der setter zum getter ;-)
            String setter = "set"+ methodName.substring(3,methodName.length());


            try {
                //Do it!
                Method entityMethod = entityClazz.getDeclaredMethod(setter,baseMethod.getReturnType());
                entityMethod.invoke(entity,baseMethod.invoke(entityBase));

            } catch (Exception e) {
                //TODO Fehlerbehandlung
                e.printStackTrace();
                throw new Exception("BeanUtil: Reflection Voodoo ging schief");
            }

        }


    }
}
