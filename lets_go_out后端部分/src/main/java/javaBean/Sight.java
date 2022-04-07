package javaBean;

public class Sight {
    private int sightID;
    private String sightPho;
    private String sightName;
    private String sightInfo;
    private String sightAddress;
    private int status;

    public int getSightID() {
        return sightID;
    }

    public void setSightID(int sightID) {
        this.sightID = sightID;
    }

    public String getSightPho() {
        return sightPho;
    }

    public void setSightPho(String sightPho) {
        this.sightPho = sightPho;
    }

    public String getSightName() {
        return sightName;
    }

    public void setSightName(String sightName) {
        this.sightName = sightName;
    }

    public String getSightInfo() {
        return sightInfo;
    }

    public void setSightInfo(String sightInfo) {
        this.sightInfo = sightInfo;
    }

    public String getSightAddress() {
        return sightAddress;
    }

    public void setSightAddress(String sightAddress) {
        this.sightAddress = sightAddress;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Sight{" +
                "sightID=" + sightID +
                ", sightPho='" + sightPho + '\'' +
                ", sightName='" + sightName + '\'' +
                ", sightInfo='" + sightInfo + '\'' +
                ", sightAddress='" + sightAddress + '\'' +
                ", status=" + status +
                '}';
    }
}
