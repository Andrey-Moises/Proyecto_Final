package com.example.proyecto_final;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.ContentProviderOperation;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

import com.example.proyecto_final.databinding.ActivityMainBinding;

public class Contacto extends AppCompatActivity {

    private String[] contactPermissions;
    private Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        Intent GO = getIntent();

        contactPermissions = new String[]{Manifest.permission.WRITE_CONTACTS};

        ImageView contactImage = findViewById(R.id.image);
        Button saveContact     = findViewById(R.id.buttonSave);

        contactImage.setOnClickListener(view ->
        {

            abrirGaleria();

        });

        saveContact.setOnClickListener(view ->
        {

            guardarContacto();

        });


    }
    private void guardarContacto()
    {

        EditText nameInput          = findViewById(R.id.nameInput),
                inputLastName1      = findViewById(R.id.inputLastName1),
                inputLastName2      = findViewById(R.id.inputLastName2),
                inputPhonePersonal  = findViewById(R.id.inputPhonePersonal),
                inputPhoneHouse     = findViewById(R.id.inputPhoneHouse),
                inputEmail          = findViewById(R.id.inputEmail),
                inputAdress         = findViewById(R.id.inputAdress);

        String nombre           = nameInput.getText().toString().trim();
        String apellidoPaterno  = inputLastName1.getText().toString().trim();
        String apellidoMaterno  = inputLastName2.getText().toString().trim();
        String telefonoPersonal = inputPhonePersonal.getText().toString().trim();
        String telefonoCasa     = inputPhoneHouse.getText().toString().trim();
        String email            = inputEmail.getText().toString().trim();
        String direccion        = inputAdress.getText().toString().trim();

        ArrayList<ContentProviderOperation> cpo = new ArrayList<ContentProviderOperation>();

        int contactId = cpo.size();

        cpo.add(ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI)
                .withValue(ContactsContract.RawContacts.ACCOUNT_TYPE, null)
                .withValue(ContactsContract.RawContacts.ACCOUNT_NAME, null)
                .build());

        cpo.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI)
                .withValueBackReference("raw_contact_id", contactId)
                .withValue(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE)
                .withValue(ContactsContract.CommonDataKinds.StructuredName.GIVEN_NAME, nombre)
                .withValue(ContactsContract.CommonDataKinds.StructuredName.FAMILY_NAME, apellidoPaterno + " " + apellidoMaterno)
                .build());

        cpo.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI)
                .withValueBackReference("raw_contact_id", contactId)
                .withValue(ContactsContract.RawContacts.Data.MIMETYPE, ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE)
                .withValue(ContactsContract.CommonDataKinds.Phone.NUMBER, telefonoPersonal)
                .withValue(ContactsContract.CommonDataKinds.Phone.TYPE,
                        ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE)
                .build());

        cpo.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI)
                .withValueBackReference("raw_contact_id", contactId)
                .withValue(ContactsContract.RawContacts.Data.MIMETYPE, ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE)
                .withValue(ContactsContract.CommonDataKinds.Phone.NUMBER, telefonoCasa)
                .withValue(ContactsContract.CommonDataKinds.Phone.TYPE,
                        ContactsContract.CommonDataKinds.Phone.TYPE_HOME)
                .build());

        cpo.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI)
                .withValueBackReference("raw_contact_id", contactId)
                .withValue(ContactsContract.RawContacts.Data.MIMETYPE,
                        ContactsContract.CommonDataKinds.Email.CONTENT_ITEM_TYPE)
                .withValue(ContactsContract.CommonDataKinds.Email.DATA, email)
                .withValue(ContactsContract.CommonDataKinds.Email.TYPE,
                        ContactsContract.CommonDataKinds.Email.TYPE_WORK)
                .build());

        cpo.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI)
                .withValueBackReference("raw_contact_id", contactId)
                .withValue(ContactsContract.RawContacts.Data.MIMETYPE,
                        ContactsContract.CommonDataKinds.SipAddress.CONTENT_ITEM_TYPE)
                .withValue(ContactsContract.CommonDataKinds.SipAddress.DATA, direccion)
                .withValue(ContactsContract.CommonDataKinds.SipAddress.TYPE,
                        ContactsContract.CommonDataKinds.SipAddress.TYPE_HOME)
                .build());

    }

    private void abrirGaleria()
    {

        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, 100);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK)
        {

            if (requestCode == 100)
            {

                imageUri = data.getData();
                ImageView contactImage = findViewById(R.id.image);
                contactImage.setImageURI(imageUri);
                Toast.makeText(this, "Traigo imagen", Toast.LENGTH_SHORT);

            }
            else
            {

                Toast.makeText(this, "No traigo imagen", Toast.LENGTH_SHORT);

            }
        }

    }



}