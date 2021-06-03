package rs.ac.uns.pmf.mis.restaurantguest.presentation.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
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
    private Button cancelOrder;
    private Button makeOrder;

    public OrderMenuItemsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        OrderMenuItemsFragmentArgs orderMenuItemsFragmentArgs = OrderMenuItemsFragmentArgs.fromBundle(getArguments());
        categorysItem = orderMenuItemsFragmentArgs.getSelectedCategory();
    }

    @Override
    public void onAttach(@NonNull @NotNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_order_menu_items, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // ui
        makeOrder = view.findViewById(R.id.make_order);
        cancelOrder = view.findViewById(R.id.cancel);

        recyclerView = view.findViewById(R.id.order_menu_items);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        OrderMenuItemsAdapter orderMenuItemsAdapter = new OrderMenuItemsAdapter();
        recyclerView.setAdapter(orderMenuItemsAdapter);

        if (null != categorysItem) {
            orderMenuItemsAdapter.setMenuItems(categorysItem.getMenuItems());
        }

        makeOrder.setOnClickListener(v ->
                {
                    Toast.makeText(v.getContext(), "You made your order!", Toast.LENGTH_SHORT).show();
                }
        );

        cancelOrder.setOnClickListener(v ->
                {
                    Navigation.findNavController(v).navigate(R.id.action_orderMenuItemsFragment_to_menuFragment);
                }
        );

    }

}