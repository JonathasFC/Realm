package pooa20171.iff.br.realm.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;
import pooa20171.iff.br.realm.Model.Proprietario;

public class ProprietarioDetalheActivity extends AppCompatActivity {

    EditText idProprietario, nomeProprietario, enderecoProprietario, bairroProprietario, cidadeProprietario, cnhProprietario, telefoneProprietario, emailProprietario, latitudeProprietario, longitudeProprietario;
    Button btsalvar,btalterar, btdeletar;
    int id;
    Proprietario proprietario;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livro_detalhe);

        idProprietario = (EditText) findViewById(R.id.ed_id_proprietario);
        nomeProprietario = (EditText) findViewById(R.id.ed_nome_proprietario);
        enderecoProprietario = (EditText) findViewById(R.id.ed_endereco_proprietario);
        bairroProprietario = (EditText) findViewById(R.id.ed_bairro_proprietario);
        cidadeProprietario = (EditText) findViewById(R.id.ed_cidade_proprietario);
        cnhProprietario = (EditText) findViewById(R.id.ed_cnh_proprietario);
        telefoneProprietario = (EditText) findViewById(R.id.ed_telefone_proprietario);
        emailProprietario = (EditText) findViewById(R.id.ed_email_proprietario);
        latitudeProprietario = (EditText) findViewById(R.id.ed_latitude_proprietario);
        longitudeProprietario = (EditText) findViewById(R.id.ed_longitude_proprietario);


        btsalvar = (Button) findViewById(R.id.bt_salvar_livro);
        btalterar = (Button) findViewById(R.id.bt_alterar_livro);
        btdeletar = (Button) findViewById(R.id.bt_deletar_livro);

        Intent intent    = getIntent();
        id = (int) intent.getSerializableExtra("id");
        realm = Realm.getDefaultInstance();


        if (id !=0) {
            btsalvar.setEnabled(false);
            btsalvar.setClickable(false);
            btsalvar.setVisibility(View.INVISIBLE);
            proprietario = realm.where(Proprietario.class).equalTo("id",id).findFirst();

            idProprietario.setText(proprietario.getNome());
            nomeProprietario.setText(proprietario.getNome());
            enderecoProprietario.setText(proprietario.getNome());
            bairroProprietario.setText(proprietario.getNome());
            cidadeProprietario.setText(proprietario.getNome());
            cnhProprietario.setText(proprietario.getNome());
            telefoneProprietario.setText(proprietario.getNome());
            emailProprietario.setText(proprietario.getNome());
            latitudeProprietario.setText(proprietario.getNome());
            longitudeProprietario.setText(proprietario.getNome());

        }else{
            btalterar.setEnabled(false);
            btalterar.setClickable(false);
            btalterar.setVisibility(View.INVISIBLE);
            btdeletar.setEnabled(false);
            btdeletar.setClickable(false);
            btdeletar.setVisibility(View.INVISIBLE);

        }



        btsalvar.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                salvar();
            }
        });
        btalterar.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                alterar();
            }
        });
        btdeletar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                deletar();
            }
        });


    }

    public void deletar(){
        realm.beginTransaction();
        proprietario.deleteFromRealm();
        realm.commitTransaction();
        realm.close();

        Toast.makeText(this,"Proprietario deletado",Toast.LENGTH_LONG).show();
        this.finish();

    }

    public void salvar() {


        int proximoID = 1;
        if(realm.where(Proprietario.class).max("id") !=null)
            proximoID = realm.where(Proprietario.class).max("id").intValue()+1;

        realm.beginTransaction();
        Proprietario proprietario = new Proprietario();
        proprietario.setId(proximoID);
        proprietario.setNome(nomeProprietario.getText().toString());
        proprietario.setEndereco(enderecoProprietario.getText().toString());
        proprietario.setBairro(bairroProprietario.getText().toString());
        proprietario.setCidade(cidadeProprietario.getText().toString());
        proprietario.setCNH(cnhProprietario.getText().toString());
        proprietario.setTelefone(telefoneProprietario.getText().toString());
        proprietario.setEmail(emailProprietario.getText().toString());
        proprietario.setLatitude(latitudeProprietario.getText().toString());
        proprietario.setLongitude(longitudeProprietario.getText().toString());


        realm.copyToRealm(proprietario);
        realm.commitTransaction();
        realm.close();

        Toast.makeText(this,"Livro Cadastrado",Toast.LENGTH_LONG).show();
        this.finish();

    }
    public void alterar() {

        realm.beginTransaction();


        proprietario.setNome(nomeProprietario.getText().toString());
        proprietario.setEndereco(enderecoProprietario.getText().toString());
        proprietario.setBairro(bairroProprietario.getText().toString());
        proprietario.setCidade(cidadeProprietario.getText().toString());
        proprietario.setCNH(cnhProprietario.getText().toString());
        proprietario.setTelefone(telefoneProprietario.getText().toString());
        proprietario.setEmail(emailProprietario.getText().toString());
        proprietario.setLatitude(latitudeProprietario.getText().toString());
        proprietario.setLongitude(longitudeProprietario.getText().toString());

        realm.copyToRealm(proprietario);
        realm.commitTransaction();
        realm.close();

        Toast.makeText(this,"Livro Alterado",Toast.LENGTH_LONG).show();
        this.finish();

    }
}
