package twincatstudio.io.pokedex;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.List;

import twincatstudio.io.pokedex.gson.PokedexJson;
import twincatstudio.io.pokedex.gson.Pokemon;
import twincatstudio.io.pokedex.protobuf.ProtoPokedex;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Demo";
    private static final int PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE = 100;

    private GridView mGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (checkPermission()) {
            startApp();
        }
    }

    @Override
    public void onRequestPermissionsResult(
            int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode) {
            case PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    startApp();
                } else {
                    // Without permission. stop app
                    finish();
                }
            }
        }
    }

    private boolean checkPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE);
            return false;
        }
        return true;
    }

    private void startApp() {
        mGridView = (GridView) findViewById(R.id.grid);
    }

    private void updateGridView(boolean usingJson) {
        PokemonAdapter adapter = new PokemonAdapter(this, usingJson);

        mGridView.setNumColumns(5);
        mGridView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.use_json) {
            updateGridView(true);
            return true;
        } else if (id == R.id.use_protobuf) {
            updateGridView(false);
            return true;
        } else if (id == R.id.performance_test) {
            Utils.performanceTest(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private class PokemonAdapter extends BaseAdapter {

        private Context mContext;
        private boolean mUsingJson;
        private List<Pokemon> mJsonList;
        private List<ProtoPokedex.Pokemon> mProtoList;

        public PokemonAdapter(Context ctx, boolean usingJson) {
            mContext = ctx;
            mUsingJson = usingJson;

            if (usingJson) {
                mJsonList = Utils.getJsonPokedex(mContext, true).getPokemon();
            } else {
                mProtoList = Utils.getProtoPokedex(mContext, true).getPokemonList();
            }
        }

        @Override
        public int getCount() {
            if (mUsingJson) {
                return mJsonList.size();
            } else {
                return mProtoList.size();
            }
        }

        @Override
        public Object getItem(int i) {
            if (mUsingJson) {
                return mJsonList.get(i);
            } else {
                return mProtoList.get(i);
            }
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup viewGroup) {

            View viewRoot;

            if (convertView == null) {
                viewRoot = getLayoutInflater().inflate(R.layout.grid_item, null);
            } else {
                viewRoot = convertView;
            }

            final String imageUrl;
            final String name;
            final String number;
            final String type;
            final String height;
            final String weight;

            if (mUsingJson) {
                final Pokemon pokemon = mJsonList.get(i);
                imageUrl = pokemon.getImg();
                name = pokemon.getName();
                number = pokemon.getNum();
                type = pokemon.getType();
                height = pokemon.getHeight();
                weight = pokemon.getWeight();
            } else {
                final ProtoPokedex.Pokemon pokemon = mProtoList.get(i);
                imageUrl = pokemon.getImg();
                name = pokemon.getName();
                number = pokemon.getNum();
                type = pokemon.getType();
                height = pokemon.getHeight();
                weight = pokemon.getWeight();
            }

            ImageView imageView = (ImageView) viewRoot.findViewById(R.id.img);
            Picasso.with(mContext).load(imageUrl).into(imageView);

            viewRoot.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    PokemonDialogFragment fragment = PokemonDialogFragment.newInstance(
                            imageUrl,
                            name,
                            number,
                            type,
                            height,
                            weight);

                    fragment.show(getSupportFragmentManager(), "pokemon");
                    return false;
                }
            });

            viewRoot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

            return viewRoot;
        }
    }
}
