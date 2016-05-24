import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.imageio.stream.FileImageInputStream;

public class Mapeador {

	private Map<Class<?>, Class<?>> mapa = new HashMap<>();
	
	public void load (String nomearquivo) throws FileNotFoundException, IOException, ClassNotFoundException{
		Properties p = new Properties();
		p.load(new FileInputStream(nomearquivo));
		
		for (Object key: p.keySet()) {
			Class<?> interf = Class.forName(key.toString());
			Class<?> impl = Class.forName(p.get(key).toString());
			mapa.put(interf, impl);
		}
	}
	
	public Class<?> getImplementacao (Class<?> interf){
		return mapa.get(interf);
	}
}
