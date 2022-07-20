package collection.inject;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		CollectionBean bean = (CollectionBean)container.getBean("collectionBean");
		
		List<String> addrList = bean.getAddressList();
		
		for(String addr : addrList) {
			System.out.println(addr);
		}
		
		List<Book> bookList = bean.getBookList();
		
		for(Book book : bookList) {
			System.out.println(book);
		}
		
		Set<String> movieList = bean.getMovieList();
		
		for(String movie : movieList) {
			System.out.println(movie);
		}
		
		Map<String, String> map = bean.getPrefList();
		
		Set<String> keys = map.keySet();
		
		for(String key : keys) {
			System.out.println(key + " : " + map.get(key));
		}
		
		Properties propList = bean.getPropList();
		
		Set<String> items = (Set)propList.keySet();
		
		for(String item : items) {
			System.out.println(item + " : " + propList.getProperty(item));
		}
	}
}