package rs.ac.uns.pmf.mis.restauranthost.presentation.fragments.employee;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import rs.ac.uns.pmf.mis.restauranthost.R;
import rs.ac.uns.pmf.mis.restauranthost.domain.model.ManagerEmployeeItem;
import rs.ac.uns.pmf.mis.restauranthost.presentation.adapters.ManagerEmployeesAdapter;
import rs.ac.uns.pmf.mis.restauranthost.presentation.viewmodels.MainViewModel;


public class EmployeeDetailsFragment extends Fragment {

    private Context context;
    private MainViewModel viewModel;
    private RecyclerView recyclerView;
    private ManagerEmployeesAdapter managerEmployeesAdapter;

    private ManagerEmployeeItem employee;

    public EmployeeDetailsFragment() {
        // Required empty public constructor
    }

    public static EmployeeDetailsFragment newInstance(ManagerEmployeeItem managerEmployeeItem) {
        EmployeeDetailsFragment fragment = new EmployeeDetailsFragment();
        Bundle args = new Bundle();
        args.putParcelable("EMPLOYEE", managerEmployeeItem);
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
        return inflater.inflate(R.layout.fragment_employee_details, container, false);
    }


    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (null != getArguments()) {
            employee = getArguments().getParcelable("EMPLOYEE");
        }
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {

        TextView idTextView = view.findViewById(R.id.employee_id);
        TextView firstNameTextView = view.findViewById(R.id.first_name);
        TextView secondNameTextView = view.findViewById(R.id.second_name);
        if (null != employee) {
            idTextView.setText(String.valueOf(employee.getEmployeeId()));
            firstNameTextView.setText(employee.getEmployeeFirstName());
            secondNameTextView.setText(employee.getEmployeeSecondName());
        }
    }
}