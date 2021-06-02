package rs.ac.uns.pmf.mis.restaurantguest.presentation.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import rs.ac.uns.pmf.mis.restaurantguest.R;
import rs.ac.uns.pmf.mis.restaurantguest.domain.model.restaurant.MenuItemsItem;

public class OrderMenuItemsAdapter extends RecyclerView.Adapter<OrderMenuItemsAdapter.OrderViewHolder> {

    private List<MenuItemsItem> menuItems = new ArrayList<>();

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
        holder.desc.setText(item.getName());

        holder.itemView.setOnClickListener(v ->
                {
                    Toast.makeText(v.getContext(), item.toString(), Toast.LENGTH_SHORT).show();
                    //navigate to menu items for specific category

                }
        );
    }

    @Override
    public int getItemCount() {
        return menuItems.size();
    }

    public static class OrderViewHolder extends RecyclerView.ViewHolder {

        private final TextView name;
        private final TextView desc;

        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            desc = itemView.findViewById(R.id.description);
        }
    }

    public void setMenuItems(List<MenuItemsItem> menuItems) {
        this.menuItems.clear();
        this.menuItems.addAll(menuItems);
        notifyDataSetChanged();
    }
}
