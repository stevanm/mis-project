package rs.ac.uns.pmf.mis.restaurantguest.presentation.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import rs.ac.uns.pmf.mis.restaurantguest.R;
import rs.ac.uns.pmf.mis.restaurantguest.domain.model.restaurant.CategorysItem;
import rs.ac.uns.pmf.mis.restaurantguest.presentation.adapters.OrderMenuItemsAdapter;

public class OrderMenuItemsFragment extends Fragment {

    private Context context;
    private CategorysItem categorysItem;

    private RecyclerView recyclerView;

    public OrderMenuItemsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        categorysItem = savedInstanceState != null ?
                savedInstanceState.getParcelable("selected_category") : null;
    }

    @Override
    public void onAttach(@NonNull @NotNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_order_menu_item, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // ui
        recyclerView = view.findViewById(R.id.order_menu_items);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        OrderMenuItemsAdapter orderMenuItemsAdapter = new OrderMenuItemsAdapter();
        recyclerView.setAdapter(orderMenuItemsAdapter);

        if (null != categorysItem) {
            Toast.makeText(context, categorysItem.toString(), Toast.LENGTH_SHORT).show();
            orderMenuItemsAdapter.setMenuItems(categorysItem.getMenuItems());
        }

    }

}