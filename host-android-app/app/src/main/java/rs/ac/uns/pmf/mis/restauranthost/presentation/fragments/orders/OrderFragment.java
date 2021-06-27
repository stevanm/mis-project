package rs.ac.uns.pmf.mis.restauranthost.presentation.fragments.orders;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import rs.ac.uns.pmf.mis.restauranthost.R;
import rs.ac.uns.pmf.mis.restauranthost.data.MainRepository;
import rs.ac.uns.pmf.mis.restauranthost.domain.model.ManagerOrderItem;
import rs.ac.uns.pmf.mis.restauranthost.framework.HostApplication;
import rs.ac.uns.pmf.mis.restauranthost.presentation.adapters.ManagerOrderAdapter;
import rs.ac.uns.pmf.mis.restauranthost.presentation.viewmodels.MainViewModel;
import rs.ac.uns.pmf.mis.restauranthost.presentation.viewmodels.MainViewModelFactory;


public class OrderFragment extends Fragment {

    private Context context;
    private MainViewModel viewModel;
    private ManagerOrderAdapter managerOrderAdapter;
    private Button createOrder;

    @Override
    public void onAttach(@NonNull @NotNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    public static Fragment newInstance() {
        return new OrderFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_order, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {

        createOrder = view.findViewById(R.id.create_order);
        createOrder.setOnClickListener(v ->
                {
                    Toast.makeText(v.getContext(), v.getContext().getString(R.string.articles_list_created), Toast.LENGTH_SHORT).show();
                    onListUpdated(managerOrderAdapter.getManagerOrderItems());
                    new Handler().postDelayed(() -> getParentFragmentManager().popBackStack(), 2000);
                }
        );

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        managerOrderAdapter = new ManagerOrderAdapter(getActivity());
        recyclerView.setAdapter(managerOrderAdapter);

        MainRepository mainRepository = ((HostApplication) context.getApplicationContext()).getMainRepository();
        viewModel = new ViewModelProvider(requireActivity(),
                new MainViewModelFactory(((HostApplication) context.getApplicationContext()), mainRepository))
                .get(MainViewModel.class);

        viewModel.getManagerOrderedItems().observe(getViewLifecycleOwner(), managerOrderItems -> managerOrderAdapter.setManagerOrderItems(managerOrderItems));

    }

    public void onListUpdated(List<ManagerOrderItem> managerOrderItems) {
        viewModel.sendManagerOrderedItems(managerOrderItems);
    }
}