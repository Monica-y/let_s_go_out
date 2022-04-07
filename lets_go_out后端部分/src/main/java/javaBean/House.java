package javaBean;

public class House {
    private int houseID;
    private String housePho;
    private String houseName;
    private String houseInfo;
    private String houseAddress;
    private int status;

    public int getHouseID() {
        return houseID;
    }

    public void setHouseID(int houseID) {
        this.houseID = houseID;
    }

    public String getHousePho() {
        return housePho;
    }

    public void setHousePho(String housePho) {
        this.housePho = housePho;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getHouseInfo() {
        return houseInfo;
    }

    public void setHouseInfo(String houseInfo) {
        this.houseInfo = houseInfo;
    }

    public String getHouseAddress() {
        return houseAddress;
    }

    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "House{" +
                "houseID=" + houseID +
                ", housePho='" + housePho + '\'' +
                ", houseName='" + houseName + '\'' +
                ", houseInfo='" + houseInfo + '\'' +
                ", houseAddress='" + houseAddress + '\'' +
                ", status=" + status +
                '}';
    }
}
