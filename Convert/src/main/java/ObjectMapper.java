import java.lang.reflect.Field;
import java.util.Collection;

public class ObjectMapper {
	
	public String object2Json(Object anyObject){
		if(anyObject == null){
			return "null";
		}
		StringBuilder sb = new StringBuilder();
		value2Json(anyObject, sb);
		//object2Json(anyObject, sb);
		return sb.toString();
	}

	private void value2Json(Object value, StringBuilder sb) {
		if(value == null){
			sb.append("null");
		} else if(value instanceof String){
			sb.append("\"" + value + "\"");
		}
		else if(value instanceof Integer){
			sb.append(value);
		}
		else if(value instanceof Object){
			sb.append(object2Json(value));
		}
		else if(value instanceof Collection){
			collection2Json((Collection) value, sb);
		} else {
			object2Json(value, sb);
		}
	}
		

	private void object2Json(Object value, StringBuilder sb) {
		Class clss = value.getClass();
		Field[] fields = clss.getFields();
		for(int i = 0; i < fields.length; i++){
			Field f = fields[i];
			Object fieldValue;
			try{
				fieldValue = f.get(value);
				
			}catch(IllegalArgumentException | IllegalAccessException e){
				continue;
			}
			sb.append("\"" + f.getName() + "\": ");
			if(fieldValue == null){
				sb.append("null");
			}else if(fieldValue instanceof String){
				sb.append("\"" + fieldValue + "\"");
			}else{
				sb.append("" + fieldValue);
			}
			if(i+1 < fields.length){
				sb.append(", ");
			}
		}
	}
	
	private void collection2Json(Object value, StringBuilder sb) {
		sb.append("[ ");
		sb.append(" ]");
	}
}
