package com.example.familydb;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ChildAdapter extends RecyclerView.Adapter<ChildAdapter.ChildVH> {

    ArrayList<Child> children;
    Context context;

    public ChildAdapter(ArrayList<Child> children, Context context){
        this.children = children;
        this.context = context;
    }

    @NonNull
    @Override
    public ChildVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_child, parent, false);
        ChildVH childVH = new ChildVH(view);
        return childVH;
    }

    @Override
    public void onBindViewHolder(@NonNull ChildAdapter.ChildVH holder, int position) {

        Child c = children.get(position);
        holder.tvCName.setText(c.getnChild());
        holder.tvFName.setText(c.getnFather());
        holder.tvMName.setText(c.getnMother());
        holder.tvCAge.setText(c.getChildAge());
        holder.tvMobile.setText(c.getMobile());
        holder.tvCaseR.setText(c.getCaseR());

        holder.cardUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(context, c.getnChild() + " will be updated!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(context, UpdateFamilyActivity.class);
                intent.putExtra("CHILD", c);
                context.startActivity(intent);
            }
        });

        holder.cardDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, c.getnChild() + " will be Deleted!", Toast.LENGTH_LONG).show();

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Confirmation !!!");
                builder.setMessage("Are you sure you want to Delete " +
                        "\n" + "\n" + c.getnChild() + "?");

                builder.setIcon(android.R.drawable.ic_menu_delete);
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        DatabaseHelper db = new DatabaseHelper(context);
                        int result = db.deleteChild(c.getId());

                        if (result > 0){
                            Toast.makeText(context, "Deleted! ", + Toast.LENGTH_LONG).show();
                        }else {
                            Toast.makeText(context, "Failed! ", + Toast.LENGTH_LONG).show();
                        }
                    }
                });
                builder.setNegativeButton("No", null);
                builder.show();






            }
        });

    }

    @Override
    public int getItemCount() {
        return children.size();
    }

    class ChildVH extends RecyclerView.ViewHolder{
        TextView tvCName, tvFName, tvMName, tvCAge, tvMobile, tvCaseR;
        CardView cardUpdate, cardDelete;



        public ChildVH(@NonNull View v) {
            super(v);

            tvCName = v.findViewById(R.id.tvChildName);
            tvFName = v.findViewById(R.id.tvFather);
            tvMName = v.findViewById(R.id.tvMother);
            tvCAge = v.findViewById(R.id.tvCAge);
            tvMobile = v.findViewById(R.id.tvMobile);
            tvCaseR = v.findViewById(R.id.tvRCase);

            cardDelete = v.findViewById(R.id.cardDelete);
            cardUpdate = v.findViewById(R.id.cardUpdate);

        }
    }
}
