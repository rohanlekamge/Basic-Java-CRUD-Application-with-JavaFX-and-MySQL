package Contract;

public class ModelTable3 {

    String coid, emid, cuid, description, date, jobtype;

    public ModelTable3(String coid, String emid, String cuid, String description, String date, String jobtype) {
        this.coid = coid;
        this.emid = emid;
        this.cuid = cuid;
        this.description = description;
        this.date = date;
        this.jobtype = jobtype;
    }

    public String getCoid() {
        return coid;
    }

    public void setCoid(String coid) {
        this.coid = coid;
    }

    public String getEmid() {
        return emid;
    }

    public void setEmid(String emid) {
        this.emid = emid;
    }

    public String getCuid() {
        return cuid;
    }

    public void setCuid(String cuid) {
        this.cuid = cuid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getJobtype() {
        return jobtype;
    }

    public void setJobtype(String jobtype) {
        this.jobtype = jobtype;
    }
}