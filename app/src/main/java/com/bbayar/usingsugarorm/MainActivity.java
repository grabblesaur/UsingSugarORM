package com.bbayar.usingsugarorm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @BindViews({R.id.etName, R.id.etEmail})
    List<EditText> mEditTextList;

    @BindViews({R.id.btnAdd, R.id.btnRead, R.id.btnClear})
    List<Button> mButtonList;

    @BindView(R.id.textview)
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        for (Button b : mButtonList) {
            b.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {

        String name = mEditTextList.get(0).getText().toString();
        String email = mEditTextList.get(1).getText().toString();

        switch (view.getId()) {

            case R.id.btnAdd:
                Contact contact = new Contact(name, email);
                contact.save();
                break;

            case R.id.btnRead:
                List<Contact> allContacts = Contact.listAll(Contact.class);
                mTextView.setText(allContacts.toString());
                break;

            case R.id.btnClear:
                Contact.deleteAll(Contact.class);
                break;
        }
    }
}
