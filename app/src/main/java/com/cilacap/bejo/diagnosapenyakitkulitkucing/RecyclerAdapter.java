package com.cilacap.bejo.diagnosapenyakitkulitkucing;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {


    private final Context context;

    String [] name={"Ringworm","Kulit Kering (Ketombe)","Infeksi Jamur (Yeast)","Jerawat Kucing",
            "Eosinophilic Granuloma","Alergic Dermatitis","Stud Tail"," Rambut Rontok"};

    int  [] thumb = {R.drawable.ringworm, R.drawable.ketombe, R.drawable.yeast_infection, R.drawable.feline_acne , R.drawable.eosinophilicgranuloma, R.drawable.allergicdermatitis, R.drawable.studtail, R.drawable.hairloss};

    LayoutInflater inflater;
    public RecyclerAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v=inflater.inflate(R.layout.item_list, parent, false);

            RecyclerViewHolder viewHolder=new RecyclerViewHolder(v);
            return viewHolder;
    }

    @Override
    public void onBindViewHolder( RecyclerViewHolder holder, int position) {


            holder.tv1.setText(name[position]);
            holder.tv1.setOnClickListener(clickListener);
            holder.imageView.setImageResource(thumb [position]);
            holder.imageView.setOnClickListener(clickListener);
            holder.tv1.setTag(holder);
            holder.imageView.setTag(holder);
    }

        View.OnClickListener clickListener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//member aksi saat cardview diklik berdasarkan posisi tertentu
                RecyclerViewHolder vholder = (RecyclerViewHolder) v.getTag();

                int position = vholder.getPosition();

                if (position == 0 && position < getItemCount())
                {  Intent intent = new Intent(context , RingwormActivity.class);
                    context.startActivity(intent);
                }
                else if (position == 1 && position < getItemCount()){

                    Intent intent = new Intent(context, KetombeActivity.class);
                    context.startActivity(intent);

                }
                else if (position == 2 && position < getItemCount()){
                    Intent intent = new Intent(context, InfeksiActivity.class);
                    context.startActivity(intent);

                }
                else if (position == 3 && position < getItemCount()){
                    Intent intent = new Intent(context, JerawatActivity.class);
                    context.startActivity(intent);

                }
                else if (position == 4 && position < getItemCount()){
                    Intent intent = new Intent(context, EosinophilicActivity.class);
                    context.startActivity(intent);

                }
                else if (position == 5 && position < getItemCount()){
                    Intent intent = new Intent(context, AlergicActivity.class);
                    context.startActivity(intent);

                }
                else if (position == 6 && position < getItemCount()){
                    Intent intent = new Intent(context, StudTailActivity.class);
                    context.startActivity(intent);

                }
                else if (position == 7 && position < getItemCount()){
                    Intent intent = new Intent(context, RambutRontokActivity.class);
                    context.startActivity(intent);

                }

            }
        };


        @Override
    public int getItemCount() {
        return name.length;
    }
}
