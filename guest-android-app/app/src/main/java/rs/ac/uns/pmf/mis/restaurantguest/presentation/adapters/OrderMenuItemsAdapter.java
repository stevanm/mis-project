package rs.ac.uns.pmf.mis.restaurantguest.presentation.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import rs.ac.uns.pmf.mis.restaurantguest.R;
import rs.ac.uns.pmf.mis.restaurantguest.domain.model.restaurant.MenuItemsItem;
import rs.ac.uns.pmf.mis.restaurantguest.domain.model.restaurant.SubItemsItem;
import rs.ac.uns.pmf.mis.restaurantguest.presentation.fragments.OrderMenuItemsFragment;

public class OrderMenuItemsAdapter extends RecyclerView.Adapter<OrderMenuItemsAdapter.OrderViewHolder> {

    private List<MenuItemsItem> menuItems = new ArrayList<>();
    private HashMap<String, SubItemsItem> orders = new HashMap<>();

    private final MenuSubItemSelectable menuSubItemSelectable;

    public OrderMenuItemsAdapter(OrderMenuItemsFragment orderMenuItemsFragment) {
        menuSubItemSelectable = orderMenuItemsFragment;
    }

    public interface MenuSubItemSelectable {
        void onSubItemSelected(boolean removeFromList, SubItemsItem price);
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item, parent, false);
        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        MenuItemsItem item = menuItems.get(position);
        holder.name.setText(item.getName());
        holder.desc.setText(item.getDescription());
        if (null == item.getDescription() || item.getDescription().isEmpty()) {
            holder.desc.setVisibility(View.GONE);
        } else {
            holder.desc.setVisibility(View.VISIBLE);
        }

        for (int i = 0; i < item.getSubItems().size(); i++) {

            SubItemsItem subItemsItem = item.getSubItems().get(i);
            LinearLayout subItemLinearLayout = new LinearLayout(holder.itemView.getContext());
            subItemLinearLayout.setOrientation(LinearLayout.HORIZONTAL);

            //position
            TextView subItemNamePositionTextView = new TextView(holder.itemView.getContext());
            subItemNamePositionTextView.setText((i + 1) + ". ");
            subItemLinearLayout.addView(subItemNamePositionTextView);

            //name
            TextView subItemNameTextView = new TextView(holder.itemView.getContext());
            subItemNameTextView.setId(R.id.submenu_name);
            subItemNameTextView.setText(subItemsItem.getName() + " ");
            subItemLinearLayout.addView(subItemNameTextView);

            //price
            TextView subItemPriceTextView = new TextView(holder.itemView.getContext());
            subItemPriceTextView.setId(R.id.submenu_price);
            subItemPriceTextView.setText(subItemsItem.getPrice());
            subItemLinearLayout.addView(subItemPriceTextView);

            //check
            ImageView subItemCheckImageView = new ImageView(holder.itemView.getContext());
            subItemCheckImageView.setId(R.id.submenu_check);
            subItemCheckImageView.setImageResource(R.drawable.ic_check);
            //check ordered order
            if (orders.containsKey(subItemsItem.getId())) {
                subItemCheckImageView.setVisibility(View.VISIBLE);
            } else {
                subItemCheckImageView.setVisibility(View.GONE);
            }
            subItemLinearLayout.addView(subItemCheckImageView);

            //add listener
            subItemLinearLayout.setOnClickListener(v -> {
                int visiblity = v.findViewById(R.id.submenu_check).getVisibility();
                if (visiblity == View.VISIBLE) {
                    menuSubItemSelectable.onSubItemSelected(true, subItemsItem);
                } else {
                    menuSubItemSelectable.onSubItemSelected(false, subItemsItem);
                }
                subItemCheckImageView.setVisibility(visiblity == View.VISIBLE ? View.GONE : View.VISIBLE);
            });

            holder.submenu.addView(subItemLinearLayout);
        }

    }

    @Override
    public int getItemCount() {
        return menuItems.size();
    }

    public static class OrderViewHolder extends RecyclerView.ViewHolder {

        private final TextView name;
        private final TextView desc;
        private final LinearLayout submenu;

        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            desc = itemView.findViewById(R.id.description);
            submenu = itemView.findViewById(R.id.submenu);
        }
    }

    public void setMenuItems(List<MenuItemsItem> menuItems) {
        this.menuItems.clear();
        this.menuItems.addAll(menuItems);
        notifyDataSetChanged();
    }

    public void setOrders(HashMap<String, SubItemsItem> orders) {
        this.orders.clear();
        this.orders = orders;
        notifyDataSetChanged();
    }
}
