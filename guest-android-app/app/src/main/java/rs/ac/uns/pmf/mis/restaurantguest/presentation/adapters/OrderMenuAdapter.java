package rs.ac.uns.pmf.mis.restaurantguest.presentation.adapters;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import rs.ac.uns.pmf.mis.restaurantguest.domain.model.restaurant.RestaurantEntity;

public class OrderMenuAdapter extends RecyclerView.Adapter<OrderMenuAdapter.OrderViewHolder> {

    private RestaurantEntity restaurantEntity;

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class OrderViewHolder extends RecyclerView.ViewHolder {

        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);
        }


    }
}
