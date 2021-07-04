package rs.ac.uns.pmf.mis.restaurantguest.domain.model.restaurant;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MenuItemsItem implements Parcelable {

	@SerializedName("sub-items")
	private List<SubItemsItem> subItems;

	@SerializedName("name")
	private String name;

	@SerializedName("description")
	private String description;

	@SerializedName("id")
	private String id;

	@SerializedName("position")
	private Integer position;

	protected MenuItemsItem(Parcel in) {
		name = in.readString();
		description = in.readString();
		id = in.readString();
		if (in.readByte() == 0) {
			position = null;
		} else {
			position = in.readInt();
		}
	}

	public static final Creator<MenuItemsItem> CREATOR = new Creator<MenuItemsItem>() {
		@Override
		public MenuItemsItem createFromParcel(Parcel in) {
			return new MenuItemsItem(in);
		}

		@Override
		public MenuItemsItem[] newArray(int size) {
			return new MenuItemsItem[size];
		}
	};

	public List<SubItemsItem> getSubItems() {
		return subItems;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getId() {
		return id;
	}

	public Integer getPosition() {
		return position;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(name);
		dest.writeString(description);
		dest.writeString(id);
		if (position == null) {
			dest.writeByte((byte) 0);
		} else {
			dest.writeByte((byte) 1);
			dest.writeInt(position);
		}
	}
}