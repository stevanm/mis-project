package rs.ac.uns.pmf.mis.restaurantguest.presentation.fragments;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import rs.ac.uns.pmf.mis.restaurantguest.R;
import rs.ac.uns.pmf.mis.restaurantguest.data.RestaurantRepository;
import rs.ac.uns.pmf.mis.restaurantguest.domain.model.restaurant.CategorysItem;
import rs.ac.uns.pmf.mis.restaurantguest.domain.model.restaurant.SubItemsItem;
import rs.ac.uns.pmf.mis.restaurantguest.framework.RestaurantApplication;
import rs.ac.uns.pmf.mis.restaurantguest.presentation.adapters.OrderMenuItemsAdapter;
import rs.ac.uns.pmf.mis.restaurantguest.presentation.viewmodels.MainViewModel;
import rs.ac.uns.pmf.mis.restaurantguest.presentation.viewmodels.MainViewModelFactory;

public class OrderMenuItemsFragment extends Fragment implements OrderMenuItemsAdapter.MenuSubItemSelectable {

    private Context context;
    private CategorysItem categorysItem;

    private RecyclerView recyclerView;
    private MainViewModel viewModel;

    private Button cancel;
    private Button make_order;

    private TextView currentPrice;
    private TextView currentTime;

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
        make_order = view.findViewById(R.id.make_order);
        cancel = view.findViewById(R.id.cancel);
        recyclerView = view.findViewById(R.id.order_menu_items);
        currentPrice = view.findViewById(R.id.current_price);
        currentTime = view.findViewById(R.id.current_time);

        make_order.setOnClickListener(v ->
                {
                    Toast.makeText(getContext(), context.getString(R.string.order_made), Toast.LENGTH_SHORT).show();
                    currentTime.setText(new Random().nextInt(100) + " min");
                    viewModel.clearRepositoryData();
                    new Handler().postDelayed(() -> Navigation.findNavController(v).navigate(R.id.action_orderMenuItemsFragment_to_startFragment), 5000);
                }
        );

        cancel.setOnClickListener(v ->
                {
                    Navigation.findNavController(v).navigate(R.id.action_orderMenuItemsFragment_to_menuCategoryFragment);
                }
        );

        RestaurantRepository restaurantRepository = ((RestaurantApplication) context.getApplicationContext()).getRestaurantRepository();
        viewModel = new ViewModelProvider(requireActivity(),
                new MainViewModelFactory(((RestaurantApplication) context.getApplicationContext()), restaurantRepository))
                .get(MainViewModel.class);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        OrderMenuItemsAdapter orderMenuItemsAdapter = new OrderMenuItemsAdapter(this);
        recyclerView.setAdapter(orderMenuItemsAdapter);

        if (null != categorysItem) {
            orderMenuItemsAdapter.setMenuItems(categorysItem.getMenuItems());

            HashMap<String, SubItemsItem> orders = viewModel.getOrderedItems().getValue();
            orderMenuItemsAdapter.setOrders(orders);
        }

        viewModel.getOrderedItems().observe(getViewLifecycleOwner(), stringSubItemsItemHashMap -> {
            if (null != stringSubItemsItemHashMap) {
                float sum = 0.0f;
                for (Map.Entry<String, SubItemsItem> entry : stringSubItemsItemHashMap.entrySet()) {
                    sum += Float.parseFloat(entry.getValue().getPrice());
                }
                currentPrice.setText(sum + " din");
            }
        });

    }

    @Override
    public void onSubItemSelected(boolean removeFromBill, SubItemsItem item) {
        viewModel.addOrRemoveFromBill(removeFromBill, item);
    }
}