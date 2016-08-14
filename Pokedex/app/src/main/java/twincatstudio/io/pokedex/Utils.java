package twincatstudio.io.pokedex;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.util.Pair;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Writer;
import java.util.List;

import twincatstudio.io.pokedex.gson.NextEvolution;
import twincatstudio.io.pokedex.gson.PokedexJson;
import twincatstudio.io.pokedex.gson.Pokemon;
import twincatstudio.io.pokedex.gson.PrevEvolution;
import twincatstudio.io.pokedex.protobuf.ProtoPokedex;

public final class Utils {
    public static final String TAG = "Pokedex.Utils";

    public static ProtoPokedex.Pokedex getProtoPokedex(Context ctx, boolean fromAsset) {
        ProtoPokedex.Pokedex pokedex = null;

        try {
            if (fromAsset) {
                pokedex = ProtoPokedex.Pokedex.parseFrom(CodedInputStreamMicro.newInstance(
                        ctx.getAssets().open("pokedex.protodata")));
            } else {
                // From external storage
                File f = new File(
                        Environment.getExternalStoragePublicDirectory(
                                Environment.DIRECTORY_DOWNLOADS), "pokedex.protodata");
                pokedex = ProtoPokedex.Pokedex.parseFrom(CodedInputStreamMicro.newInstance(
                        new FileInputStream(f)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return pokedex;
    }

    public static PokedexJson getJsonPokedex(Context ctx, boolean fromAsset) {
        Gson gson = new Gson();
        JsonReader reader = null;

        try {
            if (fromAsset) {
                reader = new JsonReader(new InputStreamReader(
                        ctx.getAssets().open("pokedex.json")));
            } else {
                // From external storage
                File f = new File(
                        Environment.getExternalStoragePublicDirectory(
                                Environment.DIRECTORY_DOWNLOADS), "pokedex.json");
                reader = new JsonReader(new InputStreamReader(new FileInputStream(f)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        PokedexJson pokedex = gson.fromJson(reader, PokedexJson.class);
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return pokedex;
    }

    public static ProtoPokedex.Pokedex translateGsonToProto(PokedexJson pokedexJson) {
        List<Pokemon> gsonPokemons = pokedexJson.getPokemon();

        ProtoPokedex.Pokedex pokedex = new ProtoPokedex.Pokedex();

        for (Pokemon p : gsonPokemons) {
            ProtoPokedex.Pokemon pokemon = new ProtoPokedex.Pokemon();

            pokemon.setId(p.getId());
            pokemon.setNum(p.getNum());
            pokemon.setName(p.getName());
            pokemon.setImg(p.getImg());
            pokemon.setType(p.getType());
            pokemon.setHeight(p.getHeight());
            pokemon.setWeight(p.getWeight());
            pokemon.setCandy(p.getCandy());
            pokemon.setEgg(p.getEgg());

            for (String weak : p.getWeaknesses()) {
                pokemon.addWeaknesses(weak);
            }

            for (PrevEvolution e : p.getPrevEvolution()) {
                ProtoPokedex.Evolution evolution = new ProtoPokedex.Evolution();
                evolution.setName(e.getName());
                evolution.setNum(e.getNum());
                pokemon.addPrevEvolution(evolution);
            }

            for (NextEvolution n : p.getNextEvolution()) {
                ProtoPokedex.Evolution evolution = new ProtoPokedex.Evolution();
                evolution.setName(n.getName());
                evolution.setNum(n.getNum());
                pokemon.addNextEvolution(evolution);
            }

            pokedex.addPokemon(pokemon);
        }

        return pokedex;
    }

    public static void performanceTest(Context ctx) {
        Pair<Long, Long> json_result  = jsonReadWriteTest(ctx);
        Pair<Long, Long> proto_result = protobufReadWriteTest(ctx);

        Toast.makeText(ctx,
                "READ: " + json_result.first + " ms : " + proto_result.first + " ms\n" +
                "WRITE: " + json_result.second + " ms : " + proto_result.second + " ms",
                Toast.LENGTH_SHORT).show();
    }

    public static Pair<Long, Long> protobufReadWriteTest(Context ctx) {
        Log.d(TAG, "protobufReadWriteTest");

        ProtoPokedex.Pokedex protoPokedex = Utils.getProtoPokedex(ctx, true);

        // WRITE
        File f = new File(
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
                "pokedex.protodata");

        Log.d(TAG, "Proto_Size = " + protoPokedex.getSerializedSize());

        long readMs = 0, writeMs = 0;
        long before, after;
        try {
            OutputStream os = new FileOutputStream(f);
            CodedOutputStreamMicro co = CodedOutputStreamMicro.newInstance(os);

            before = System.currentTimeMillis();
            protoPokedex.writeTo(co);
            co.flush(); // MUST flush!!
            os.flush();
            os.close();

            after = System.currentTimeMillis();
            writeMs = after - before;
            Log.d(TAG, "Proto_write time = " + writeMs);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // READ
        File rf = new File(
                Environment.getExternalStoragePublicDirectory(
                        Environment.DIRECTORY_DOWNLOADS), "pokedex.protodata");

        ProtoPokedex.Pokedex p = null;
        try {
            before = System.currentTimeMillis();

            p = ProtoPokedex.Pokedex.parseFrom(
                    CodedInputStreamMicro.newInstance(
                    new FileInputStream(rf)));

            after = System.currentTimeMillis();
            readMs = after - before;
            Log.d(TAG, "Proto_read time = " + readMs);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Log.d(TAG, "Proto_Size = " + p.getSerializedSize());

        return new Pair<Long, Long>(readMs, writeMs);
    }

    private static Pair<Long, Long> jsonReadWriteTest(Context ctx) {
        Log.d(TAG, "jsonReadWriteTest");

        PokedexJson pokedex = getJsonPokedex(ctx, true);

        Gson gson = new Gson();
        long readMs = 0, writeMs = 0;
        long before, after;

        // WRITE
        File f = new File(
                Environment.getExternalStoragePublicDirectory(
                        Environment.DIRECTORY_DOWNLOADS), "pokedex.json");
        Log.d(TAG, "File: " + f.getAbsolutePath());

        try {
            if (f.exists()) {
                f.delete();
            }
            f.createNewFile();
            Writer writer = new FileWriter(f);

            before = System.currentTimeMillis();
            gson.toJson(pokedex, writer);
            writer.flush();
            writer.close();

            after = System.currentTimeMillis();
            writeMs = after - before;
            Log.d(TAG, "GSON write: " + writeMs);
        } catch (IOException e) {
            e.printStackTrace();
        }


        File rf = new File(
                Environment.getExternalStoragePublicDirectory(
                        Environment.DIRECTORY_DOWNLOADS), "pokedex.json");
        JsonReader reader = null;

        try {
            reader = new JsonReader(new InputStreamReader(new FileInputStream(f)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        before = System.currentTimeMillis();
        PokedexJson p = gson.fromJson(reader, PokedexJson.class);
        after = System.currentTimeMillis();

        readMs = after - before;

        Log.d(TAG, "GSON read:" + readMs);

        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Pair<>(readMs, writeMs);
    }

}
