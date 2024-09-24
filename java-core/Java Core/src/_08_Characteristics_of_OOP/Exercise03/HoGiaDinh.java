package _08_Characteristics_of_OOP.Exercise03;

public class HoGiaDinh {
    private String electricCode;
    private String familyHost;
    private String address;

    public HoGiaDinh(String familyHost, String address, String electricCode) {
        this.familyHost = familyHost;
        this.address = address;
        this.electricCode = electricCode;
    }

    public String getFamilyHost() {
        return familyHost;
    }

    public void setFamilyHost(String familyHost) {
        this.familyHost = familyHost;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getElectricCode() {
        return electricCode;
    }

    public void setElectricCode(String electricCode) {
        this.electricCode = electricCode;
    }
}
