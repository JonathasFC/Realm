package pooa20171.iff.br.realm.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import pooa20171.iff.br.realm.Model.Proprietario;
import pooa20171.iff.br.realm.R;

/**
 * Created by aluno on 07/08/17.
 */

public class ProprietarioAdapter {

    private List<Proprietario> proprietarios;
    private Context context;
    private static ClickRecyclerViewListener clickRecyclerViewListener;

    public ProprietarioAdapter(List<Proprietario> proprietario, Context context,ClickRecyclerViewListener clickRecyclerViewListener) {

        this.proprietarios = proprietarios;
        this.context = context;
        this.clickRecyclerViewListener = clickRecyclerViewListener;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_proprietario, parent, false);
        ProprietarioViewHolder proprietarioViewHolder = new ProprietarioViewHolder(view);
        return proprietarioViewHolder;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

        ProprietarioViewHolder holder = (ProprietarioViewHolder) viewHolder;

        Proprietario proprietario = proprietarios.get(position) ;
        holder.idProprietario.setText(proprietario.getId());
        holder.nomeProprietario.setText(proprietario.getNome());
        holder.enderecoProprietario.setText(proprietario.getEndereco());
        holder.bairroProprietario.setText(proprietario.getBairro());
        holder.cidadeProprietario.setText(proprietario.getBairro());
        holder.cnhProprietario.setText(proprietario.getBairro());
        holder.telefoneProprietario.setText(proprietario.getBairro());
        holder.emailProprietario.setText(proprietario.getBairro());
        holder.latitudeProprietario.setText(proprietario.getBairro());
        holder.longitudeProprietario.setText(proprietario.getBairro());


    }


    public int getItemCount() {

        return proprietarios.size();
    }

    private void updateItem(int position) {

    }

    // Método responsável por remover um usuário da lista.
    private void removerItem(int position) {

    }

    public class ProprietarioViewHolder extends RecyclerView.ViewHolder {

        private final TextView idProprietario;
        private final TextView nomeProprietario;
        private final TextView enderecoProprietario;
        private final TextView bairroProprietario;
        private final TextView cidadeProprietario;
        private final TextView cnhProprietario;
        private final TextView telefoneProprietario;
        private final TextView emailProprietario;
        private final TextView latitudeProprietario;
        private final TextView longitudeProprietario;



        public ProprietarioViewHolder(View itemView) {
            super(itemView);
            idProprietario = (TextView) itemView.findViewById(R.id.idProprietario);
            nomeProprietario = (TextView) itemView.findViewById(R.id.nomeProprietario);
            enderecoProprietario = (TextView) itemView.findViewById(R.id.enderecoProprietario);
            bairroProprietario = (TextView) itemView.findViewById(R.id.bairroProprietario);
            cidadeProprietario = (TextView) itemView.findViewById(R.id.cidadeProprietario);
            cnhProprietario = (TextView) itemView.findViewById(R.id.cnhProprietario);
            telefoneProprietario = (TextView) itemView.findViewById(R.id.telefoneProprietario);
            emailProprietario = (TextView) itemView.findViewById(R.id.emailProprietario);
            latitudeProprietario = (TextView) itemView.findViewById(R.id.latitudeProprietario);
            longitudeProprietario = (TextView) itemView.findViewById(R.id.longitudeProprietario);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickRecyclerViewListener.onClick(proprietarios.get(getLayoutPosition()));

                }
            });


        }
    }
}
