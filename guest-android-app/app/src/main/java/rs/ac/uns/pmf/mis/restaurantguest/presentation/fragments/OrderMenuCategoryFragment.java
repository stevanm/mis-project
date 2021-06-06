package rs.ac.uns.pmf.mis.restaurantguest.presentation.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import rs.ac.uns.pmf.mis.restaurantguest.R;
import rs.ac.uns.pmf.mis.restaurantguest.data.RestaurantRepository;
import rs.ac.uns.pmf.mis.restaurantguest.framework.RestaurantApplication;
import rs.ac.uns.pmf.mis.restaurantguest.presentation.adapters.OrderMenuCategoryAdapter;
import rs.ac.uns.pmf.mis.restaurantguest.presentation.viewmodels.MainViewModel;
import rs.ac.uns.pmf.mis.restaurantguest.presentation.viewmodels.MainViewModelFactory;

public class OrderMenuCategoryFragment extends Fragment {

    private Context context;

    private RecyclerView recyclerView;
    private MainViewModel viewModel;

    public OrderMenuCategoryFragment() {
        // Required empty public constructor
    }

    public static OrderMenuCategoryFragment newInstance() {
        OrderMenuCategoryFragment fragment = new OrderMenuCategoryFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull @NotNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_order_menu_category, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // ui
        recyclerView = view.findViewById(R.id.order_menu_category);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        OrderMenuCategoryAdapter orderMenuCategoryAdapter = new OrderMenuCategoryAdapter(getActivity());
        recyclerView.setAdapter(orderMenuCategoryAdapter);

        RestaurantRepository restaurantRepository = ((RestaurantApplication) context.getApplicationContext()).getRestaurantRepository();
        viewModel = new ViewModelProvider(requireActivity(),
                new MainViewModelFactory(((RestaurantApplication) context.getApplicationContext()), restaurantRepository))
                .get(MainViewModel.class);
        viewModel.getRestaurantData().observe(getViewLifecycleOwner(),
                restaurantEntity ->
                {
                    if (null != restaurantEntity) {
                        orderMenuCategoryAdapter.setCategoriesItems(restaurantEntity.getCategorys());
                    }
                }
        );


    }

}