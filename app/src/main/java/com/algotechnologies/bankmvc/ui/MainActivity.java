package com.algotechnologies.bankmvc.ui;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.algotechnologies.bankmvc.R;
import com.algotechnologies.bankmvc.model.account.CheckingAccount;
import com.algotechnologies.bankmvc.model.account.SavingAccount;
import com.algotechnologies.bankmvc.model.account.base.BankAccount;
import com.algotechnologies.bankmvc.model.database.entity.AccountInfo;
import com.algotechnologies.bankmvc.model.repository.AccountRepository;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnCreateAccount;
    private EditText etAccountTitle;
    private EditText etDepositeAmount;
    private RadioButton rbChecking;
    private RadioButton rbSaving;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AccountRepository accountRepository = new AccountRepository(getApplicationContext());
        accountRepository.getAllAccounts(new IAccountListener() {
            @Override
            public void onAccountsReceived(List<AccountInfo> accountsList) {
                //Log.d("ASS", String.valueOf(accountsList.get(0).getTitle()));
            }
        });

        bindViews();
        initListeners();

    }

    private void bindViews() {
        btnCreateAccount = (Button) findViewById(R.id.btn_create_account);
        etAccountTitle = (EditText) findViewById(R.id.account_title);
        etDepositeAmount = (EditText) findViewById(R.id.deposite_amount);
        rbChecking = (RadioButton) findViewById(R.id.rb_checking);
        rbSaving = (RadioButton) findViewById(R.id.rb_saving);
    }

    private void initListeners() {
        btnCreateAccount.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if ( etAccountTitle.getText().toString().isEmpty() || etDepositeAmount.getText().toString().isEmpty() ) {
            Toast.makeText(this, "Account title & amount must not be empty", Toast.LENGTH_SHORT).show();
            return;
        }

        String accountTitle = etAccountTitle.getText().toString();
        double depositeAmount = Double.valueOf(etDepositeAmount.getText().toString());

        BankAccount bankAccount = null;

        if ( rbChecking.isChecked() ) {
            bankAccount = new CheckingAccount(getApplicationContext());
        } else if ( rbSaving.isChecked() ) {
            bankAccount = new SavingAccount(getApplicationContext());
        } else {
            Toast.makeText(this, "Select an account type", Toast.LENGTH_SHORT).show();
            return;
        }

        bankAccount.open(accountTitle, depositeAmount);

        Toast.makeText(this, "Account has been opened successfully", Toast.LENGTH_SHORT).show();

        etAccountTitle.setText("");
        etDepositeAmount.setText("");

    }

}
