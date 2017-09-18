package br.usjt.arqdesis.sistemapredial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class SistemaPredialMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sistema_predial_main);

        Intent intent = getIntent();
        String uType = intent.getStringExtra(LoginActivity.EXTRA_USERTYPE_MESSAGE);
        int userType = Integer.parseInt(uType);

        if(userType == 1)
        {
            Button reconfgAC = (Button)findViewById(R.id.reconfg_ar_cond);
            reconfgAC.setEnabled(true);
        }
        else if(userType == 2 || userType == 3)
        {
            Button cUsuario = (Button)findViewById(R.id.cadastrar_usuario);
            cUsuario.setEnabled(true);
            Button cEmpresa = (Button)findViewById(R.id.cadastrar_empresa);
            cEmpresa.setEnabled(true);
            Button gArqAcesso= (Button)findViewById(R.id.gerar_arq_acesso);
            gArqAcesso.setEnabled(true);
        }
    }

    public void cadastrarUsuario(View view)
    {
        Intent intent = new Intent(this, UsuarioActivity.class);
        startActivity(intent);
    }

    public void cadastrarEmpresa(View view)
    {
        Intent intent = new Intent(this, EmpresaActivity.class);
        startActivity(intent);
    }

    public void gerarArquivoAcesso(View view)
    {
        Intent intent = new Intent(this, ArquivoAcessoActivity.class);
        startActivity(intent);
    }

    public void reconfgArCond(View view)
    {
        Intent intent = new Intent(this, ArCondicionadoActivity.class);
        startActivity(intent);
    }

}
