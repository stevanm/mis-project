package rs.ac.uns.pmf.mis.restauranthost.presentation.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import rs.ac.uns.pmf.mis.restauranthost.R;
import rs.ac.uns.pmf.mis.restauranthost.domain.model.ManagerOrderItem;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {

    private final Activity activity;

    private final List<ManagerOrderItem> managerOrderItems = new ArrayList<>();

    public OrderAdapter(Activity activity) {
        this.activity = activity;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_item, parent, false);
        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        ManagerOrderItem item = managerOrderItems.get(position);
        holder.name.setText(item.getOrderName());
        holder.amount.setText(String.valueOf(item.getOrderAmount()));
        holder.addOrderAmount.setOnClickListener(v -> {
            Integer c_amount = Integer.parseInt(holder.amount.getText().toString().trim());
            holder.amount.setText(String.valueOf(c_amount + 1));
            item.setOrderAmount(c_amount + 1);
        });
        holder.removeOrderAmount.setOnClickListener(v -> {
            Integer c_amount = Integer.parseInt(holder.amount.getText().toString().trim());
            if (c_amount >= 1) {
                holder.amount.setText(String.valueOf(c_amount - 1));
                item.setOrderAmount(c_amount - 1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return managerOrderItems.size();
    }

    public List<ManagerOrderItem> getManagerOrderItems() {
        return managerOrderItems;
    }

    public static class OrderViewHolder extends RecyclerView.ViewHolder {

        private final TextView name;
        private final TextView amount;
        private final ImageButton addOrderAmount;
        private final ImageButton removeOrderAmount;

        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.order_name);
            amount = itemView.findViewById(R.id.order_amount);
            addOrderAmount = itemView.findViewById(R.id.add_order_amount);
            removeOrderAmount = itemView.findViewById(R.id.remove_order_amount);
        }
    }

    public void setManagerOrderItems(List<ManagerOrderItem> orderItems) {
        managerOrderItems.clear();
        managerOrderItems.addAll(orderItems);
        notifyDataSetChanged();
    }

}
