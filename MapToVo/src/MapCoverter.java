import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapCoverter {

   public static Map convertObjectToMap(Object obj){
		Map map = new HashMap();
		Field[] fields = obj.getClass().getDeclaredFields();
		for(int i=0; i <fields.length; i++){
		    fields[i].setAccessible(true);
		    try{
		        map.put(fields[i].getName(), fields[i].get(obj));
		    }catch(Exception e){
		        e.printStackTrace();
		    }
		}        
		return map;
    }
	
   
   public static Object convertMapToObject(Map<String,Object> map,Object obj){
       String keyAttribute = null;
       String setMethodString = "set";
       String methodString = null;
       Iterator itr = map.keySet().iterator();
       
       while(itr.hasNext()){
           keyAttribute = (String) itr.next();
           methodString = setMethodString+keyAttribute.substring(0,1).toUpperCase()+keyAttribute.substring(1);            
           Method[] methods = obj.getClass().getDeclaredMethods();
           for(int i=0;i<methods.length;i++){
               if(methodString.equals(methods[i].getName())){
                   try{
                       methods[i].invoke(obj, map.get(keyAttribute));
                   }catch(Exception e){
                       e.printStackTrace();
                   }
               }
           }
       }
       return obj;
   }


	public static void main(String[] args) {
		DefaultVo vo = new DefaultVo();
        vo.setAAA("Youngwon");
        vo.setBBB("서영원");
        vo.setCCC("Korea");
        
        Map map = convertObjectToMap(vo);    
        System.out.println(map);
        
        DefaultVo vo2 = new DefaultVo();
        convertMapToObject(map,vo2);
        System.out.println(vo2.toString());
	}
}
