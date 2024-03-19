package ecom.mobile.app.service.serviceInterface;

import ecom.mobile.app.model.Search;

import java.util.List;

public interface SearchService {

    List<Search> fetchSearchByUserId(int id);

    Search saveSearch(Search search);

    String deleteSearch(int id);

}
