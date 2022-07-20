package collection.inject;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollectionBean {
	private List<String> addressList;
	private List<Book> bookList;
	private Set<String> movieList;
	private Map<String, String> prefList;
	private Properties propList;

	public List<String> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<String> addressList) {
		this.addressList = addressList;
	}

	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}

	public Set<String> getMovieList() {
		return movieList;
	}

	public void setMovieList(Set<String> movieList) {
		this.movieList = movieList;
	}

	public void setPrefList(Map<String, String> prefList) {
		this.prefList = prefList;
	}

	public Map<String, String> getPrefList() {
		return prefList;
	}

	public Properties getPropList() {
		return propList;
	}

	public void setPropList(Properties propList) {
		this.propList = propList;
	}
	
}