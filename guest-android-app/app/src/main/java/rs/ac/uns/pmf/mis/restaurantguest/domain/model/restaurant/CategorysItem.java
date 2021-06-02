package rs.ac.uns.pmf.mis.restaurantguest.domain.model.restaurant;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategorysItem implements Parcelable {

	@SerializedName("menu-items")
	private List<MenuItemsItem> menuItems;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private String id;

	@SerializedName("position")
	private String position;

	protected CategorysItem(Parcel in) {
		name = in.readString();
		id = in.readString();
		position = in.readString();
	}

	public static final Creator<CategorysItem> CREATOR = new Creator<CategorysItem>() {
		@Override
		public CategorysItem createFromParcel(Parcel in) {
			return new CategorysItem(in);
		}

		@Override
		public CategorysItem[] newArray(int size) {
			return new CategorysItem[size];
		}
	};

	public List<MenuItemsItem> getMenuItems() {
		return menuItems;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public String getPosition() {
		return position;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(name);
		dest.writeString(id);
		dest.writeString(position);
	}
}