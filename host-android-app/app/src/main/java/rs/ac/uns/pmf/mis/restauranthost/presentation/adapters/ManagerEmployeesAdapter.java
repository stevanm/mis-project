package rs.ac.uns.pmf.mis.restauranthost.presentation.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import rs.ac.uns.pmf.mis.restauranthost.R;
import rs.ac.uns.pmf.mis.restauranthost.domain.model.ManagerEmployeeItem;
import rs.ac.uns.pmf.mis.restauranthost.presentation.fragments.employee.EmployeeDetailsFragment;

public class ManagerEmployeesAdapter extends RecyclerView.Adapter<ManagerEmployeesAdapter.EmployeeViewHolder> {

    private final Context context;

    private final List<ManagerEmployeeItem> managerEmployeeItems = new ArrayList<>();

    public ManagerEmployeesAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.employee_item, parent, false);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        ManagerEmployeeItem item = managerEmployeeItems.get(position);
        holder.id.setText(String.valueOf(item.getEmployeeId()));
        holder.firstName.setText(item.getEmployeeFirstName());
        holder.secondName.setText(item.getEmployeeSecondName());
        holder.workPosition.setText(item.getWorkPosition());
        holder.itemView.setOnClickListener(v -> {
            ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.container, EmployeeDetailsFragment.newInstance(item))
                    .commit();
        });

    }

    @Override
    public int getItemCount() {
        return managerEmployeeItems.size();
    }

    public List<ManagerEmployeeItem> getManagerEmployeeItems() {
        return managerEmployeeItems;
    }

    public static class EmployeeViewHolder extends RecyclerView.ViewHolder {

        private final TextView id;
        private final TextView firstName;
        private final TextView secondName;
        private final TextView workPosition;

        public EmployeeViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.employee_id);
            firstName = itemView.findViewById(R.id.first_name);
            secondName = itemView.findViewById(R.id.second_name);
            workPosition = itemView.findViewById(R.id.work_position);
        }
    }

    public void setManagerEmployeeItems(List<ManagerEmployeeItem> employeeItems) {
        managerEmployeeItems.clear();
        managerEmployeeItems.addAll(employeeItems);
        notifyDataSetChanged();
    }

}
