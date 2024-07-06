package com.example.dacn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContractAdapter extends RecyclerView.Adapter<ContractAdapter.ContractViewHolder> {
    Context context;
    List<Contract> contractList;

    public ContractAdapter(Context context, List<Contract> contractList) {
        this.contractList = contractList;
        this.context = context;
    }

    @NonNull
    @Override
    public ContractViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contract_page_item, parent, false);
        return new ContractViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContractViewHolder holder, int position) {
        Contract contract = contractList.get(position);
        holder.departmentName.setText(contract.getName());
        holder.departmentPhoneNumber.setText(contract.getPhoneNumber());
    }

    @Override
    public int getItemCount() {
        return contractList.size();
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
        notifyDataSetChanged();
    }

    static class ContractViewHolder extends RecyclerView.ViewHolder {
        TextView departmentName;
        TextView departmentPhoneNumber;

        ContractViewHolder(@NonNull View itemView) {
            super(itemView);
            departmentName = itemView.findViewById(R.id.contract_page_name_department_item);
            departmentPhoneNumber = itemView.findViewById(R.id.contract_page_phone_number_item);
        }
    }
}
