package rs.ac.uns.pmf.mis.restauranthost.presentation.fragments.employee;

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

import rs.ac.uns.pmf.mis.restauranthost.R;
import rs.ac.uns.pmf.mis.restauranthost.data.MainRepository;
import rs.ac.uns.pmf.mis.restauranthost.framework.HostApplication;
import rs.ac.uns.pmf.mis.restauranthost.presentation.adapters.ManagerEmployeesAdapter;
import rs.ac.uns.pmf.mis.restauranthost.presentation.viewmodels.MainViewModel;
import rs.ac.uns.pmf.mis.restauranthost.presentation.viewmodels.MainViewModelFactory;


public class EmployeeFragment extends Fragment {

    private Context context;
    private MainViewModel viewModel;
    private RecyclerView recyclerView;
    private ManagerEmployeesAdapter managerEmployeesAdapter;

    public EmployeeFragment() {
        // Required empty public constructor
    }

    public static EmployeeFragment newInstance() {
        EmployeeFragment fragment = new EmployeeFragment();
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
        return inflater.inflate(R.layout.fragment_employee, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        managerEmployeesAdapter = new ManagerEmployeesAdapter(getActivity());
        recyclerView.setAdapter(managerEmployeesAdapter);

        MainRepository mainRepository = ((HostApplication) context.getApplicationContext()).getMainRepository();
        viewModel = new ViewModelProvider(requireActivity(),
                new MainViewModelFactory(((HostApplication) context.getApplicationContext()), mainRepository))
                .get(MainViewModel.class);

        viewModel.getManagerEmployeeItem().observe(getViewLifecycleOwner(), managerEmployeeItems -> managerEmployeesAdapter.setManagerEmployeeItems(managerEmployeeItems));

    }
}