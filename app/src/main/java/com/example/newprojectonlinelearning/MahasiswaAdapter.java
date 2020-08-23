package com.example.newprojectonlinelearning;

import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaAdapter.MahasiswaViewHolder> {
    private ArrayList<Model> dataList;
    private Callback callback;
    View viewku;
    int posku;

    interface Callback {
        void onClick(int position);
        void test();
    }


    public MahasiswaAdapter(ArrayList<Model> dataList, Callback callback) {
        this.callback = callback;
        this.dataList = dataList;
        Log.d("makanan", "MahasiswaAdapter: "+dataList.size()+"");
    }

    @Override
    public MahasiswaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.adapterrv, parent, false);
        return new MahasiswaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MahasiswaViewHolder holder, final int position) {
//        holder.txtNama.setText(dataList.get(position).getId()+" , "+dataList.get(position).getNama());
        holder.txtNama.setText(dataList.get(position).getOriginal_title());
        holder.txtNpm.setText(dataList.get(position).getOverview());
        Glide
                .with(holder.itemView.getContext())
                .load(dataList.get(position).getPoster_path())
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.ivprofile);

//        holder.txtAlamat.setText(dataList.get(position).getAlamat());

//        holder.card.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(holder.itemView.getContext(), ""+position, Toast.LENGTH_SHORT).show();
//                Intent in =new Intent(holder.itemView.getContext().getApplicationContext(), EditData.class);
//                in.putExtra("id",dataList.get(position).getId());
//                in.putExtra("nama",dataList.get(position).getNama());
//                in.putExtra("pesanan",dataList.get(position).getPesanan());
//                in.putExtra("no-hp",dataList.get(position).getNo_hp());
//                in.putExtra("alamat",dataList.get(position).getAlamat());
//                holder.itemView.getContext().startActivity(in);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class MahasiswaViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener{
        private TextView txtNama, txtNpm, txtNoHp, txtAlamat;
        CardView card;
        ImageView ivprofile;

        public MahasiswaViewHolder(View itemView) {
            super(itemView);
            viewku=itemView;
            card = (CardView) itemView.findViewById(R.id.cardku);
            ivprofile = (ImageView) itemView.findViewById(R.id.ivprofile);
            txtNama = (TextView) itemView.findViewById(R.id.tvname);
            txtNpm = (TextView) itemView.findViewById(R.id.tvdesc);
//            txtNoHp = (TextView) itemView.findViewById(R.id.txt_nohp_mahasiswa);
//            txtAlamat = (TextView) itemView.findViewById(R.id.txt_alamat);
            itemView.setOnCreateContextMenuListener(this);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callback.onClick(getAdapterPosition());
                }
            });
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            MenuItem Edit = menu.add(Menu.NONE, 1, 1, "Edit");
            MenuItem Delete = menu.add(Menu.NONE, 2, 2, "Delete");
            posku=getAdapterPosition();
            Edit.setOnMenuItemClickListener(onEditMenu);
            Delete.setOnMenuItemClickListener(onEditMenu);
        }

    }
    private final MenuItem.OnMenuItemClickListener onEditMenu = new MenuItem.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {

            switch (item.getItemId()) {
                case 1:
                    //Do stuff
                    Toast.makeText(viewku.getContext(), ""+posku, Toast.LENGTH_SHORT).show();
                    break;

                case 2:
                    //Do stuff

                    break;
            }
            return true;
        }
    };

}
