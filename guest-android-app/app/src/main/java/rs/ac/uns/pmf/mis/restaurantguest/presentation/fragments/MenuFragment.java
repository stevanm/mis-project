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
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import rs.ac.uns.pmf.mis.restaurantguest.R;
import rs.ac.uns.pmf.mis.restaurantguest.data.RestaurantRepository;
import rs.ac.uns.pmf.mis.restaurantguest.framework.RestaurantApplication;
import rs.ac.uns.pmf.mis.restaurantguest.presentation.adapters.OrderMenuAdapter;
import rs.ac.uns.pmf.mis.restaurantguest.presentation.viewmodels.MainViewModel;
import rs.ac.uns.pmf.mis.restaurantguest.presentation.viewmodels.MainViewModelFactory;

public class MenuFragment extends Fragment {

    private Context context;

    private RecyclerView recyclerView;
    private MainViewModel viewModel;

    public MenuFragment() {
        // Required empty public constructor
    }

    public static MenuFragment newInstance(String param1, String param2) {
        MenuFragment fragment = new MenuFragment();
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
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RestaurantRepository restaurantRepository = ((RestaurantApplication) context.getApplicationContext()).getRestaurantRepository();
        viewModel = new ViewModelProvider(this,
                new MainViewModelFactory(((RestaurantApplication) context.getApplicationContext()), restaurantRepository))
                .get(MainViewModel.class);
        viewModel.getRestaurantData().observe(getViewLifecycleOwner(),
                restaurantEntity ->
                {
                    if (null != restaurantEntity) {
                        Toast.makeText(context, restaurantEntity.toString(), Toast.LENGTH_SHORT).show();
                    }
                }
        );

        recyclerView = view.findViewById(R.id.order_menu);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        OrderMenuAdapter orderMenuAdapter = new OrderMenuAdapter();
        recyclerView.setAdapter(orderMenuAdapter);
    }

}