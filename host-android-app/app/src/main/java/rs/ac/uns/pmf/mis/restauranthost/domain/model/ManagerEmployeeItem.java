package rs.ac.uns.pmf.mis.restauranthost.domain.model;

import android.os.Parcel;
import android.os.Parcelable;

public class ManagerEmployeeItem implements Parcelable {

    private int employeeId;
    private String employeeFirstName;
    private String employeeSecondName;

    public ManagerEmployeeItem(int employeeId, String employeeFirstName, String employeeSecondName) {
        this.employeeId = employeeId;
        this.employeeFirstName = employeeFirstName;
        this.employeeSecondName = employeeSecondName;
    }

    protected ManagerEmployeeItem(Parcel in) {
        employeeId = in.readInt();
        employeeFirstName = in.readString();
        employeeSecondName = in.readString();
    }

    public static final Creator<ManagerEmployeeItem> CREATOR = new Creator<ManagerEmployeeItem>() {
        @Override
        public ManagerEmployeeItem createFromParcel(Parcel in) {
            return new ManagerEmployeeItem(in);
        }

        @Override
        public ManagerEmployeeItem[] newArray(int size) {
            return new ManagerEmployeeItem[size];
        }
    };

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    public String getEmployeeSecondName() {
        return employeeSecondName;
    }

    public void setEmployeeSecondName(String employeeSecondName) {
        this.employeeSecondName = employeeSecondName;
    }

    @Override
    public String toString() {
        return "ManagerEmployeeItem{" +
                "employeeId=" + employeeId +
                ", employeeFirstName='" + employeeFirstName + '\'' +
                ", employeeSecondName='" + employeeSecondName + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(employeeId);
        dest.writeString(employeeFirstName);
        dest.writeString(employeeSecondName);
    }
}
