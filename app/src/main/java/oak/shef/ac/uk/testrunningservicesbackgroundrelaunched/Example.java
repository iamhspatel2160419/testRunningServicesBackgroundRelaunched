package oak.shef.ac.uk.testrunningservicesbackgroundrelaunched;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Example {

    private String page;

    public Integer getPer_page() {
        return per_page;
    }

    public void setPer_page(Integer per_page) {
        this.per_page = per_page;
    }

    public Integer getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(Integer total_pages) {
        this.total_pages = total_pages;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    private Integer per_page;
    private Integer total;
    private Integer total_pages;
    private List<Datum> data = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }



    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }



    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}


