package br.usjt.arqdesis.sistemapredial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    public final static String EXTRA_USERTYPE_MESSAGE = "br.usjt.arqdesis.sistemapredial.USERTYPE_MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void requestLogin(View view)
    {
        Intent intent = new Intent(this, SistemaPredialMainActivity.class);
        EditText editTextLogin = (EditText)findViewById(R.id.login_message);
        EditText editTextPassword = (EditText)findViewById(R.id.password_message);
        String login = editTextLogin.getText().toString();
        String password = editTextPassword.getText().toString();

        //valida o dados do login e senha, e depois retorna o tipo de usuario. Ou '-1' indicando que não achou o perfil
        int userType = validaLogin(login, password);

        if(userType != -1)
        {
            String aux = "" + userType;
            intent.putExtra(EXTRA_USERTYPE_MESSAGE, aux);
            startActivity(intent);
        }
        else
        {
            System.out.println("caiu em rotina de erro");
        }
    }

    //métodos de validação

    public ArrayList<String> geraListaUsuarios() {
        ArrayList<String> lista = new ArrayList<>();
        lista.add("1abcde1234567890");
        lista.add("2fghij0987654321");
        lista.add("3klmno1234509876");
        return lista;
    }

    //varre a lista de usuarios; valida o login e a senha; retorna o tipo de usuario
    public int validaLogin(String login, String password)
    {
        ArrayList<String> lista = geraListaUsuarios();
        String loginAux = "";
        String passwordAux = "";
        int tipoUsuario = 0;

        for(int i = 0; i < lista.size(); i++)
        {
            loginAux = lista.get(i).substring(1, 6);
            passwordAux = lista.get(i).substring(6);
            tipoUsuario = Integer.parseInt(lista.get(i).substring(0, 1));

            if(loginAux.equals(login))
            {
                if(passwordAux.equals(password))
                {
                    //encontrou o usuario
                    return tipoUsuario;
                }
            }
        }
        //não encontrou o usuario
        return -1;
    }

}
