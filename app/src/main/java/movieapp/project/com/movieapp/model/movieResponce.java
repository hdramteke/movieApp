package movieapp.project.com.movieapp.model;

import java.util.List;

/**
 * Created by hemant on 23/10/18.
 */

public class movieResponce {

    private int page;
    private List<movie> results;
    private int totalResults;
    private int totalPages;


    public int getPage() {
        return page;
    }

    public List<movie> getResults() {
        return results;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setResults(List<movie> results) {
        this.results = results;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

}
