package twincatstudio.io.pokedex;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import fr.tvbarthel.lib.blurdialogfragment.SupportBlurDialogFragment;

public class PokemonDialogFragment extends SupportBlurDialogFragment {

    private static final String BUNDLE_IMAGE_URL = "bundle_image_url";
    private static final String BUNDLE_NAME = "bundle_name";
    private static final String BUNDLE_NUM = "bundle_num";
    private static final String BUNDLE_TYPE = "bundle_type";
    private static final String BUNDLE_HEIGHT = "bundle_height";
    private static final String BUNDLE_WEIGHT = "bundle_weight";

    private String mImageUrl;
    private String mName;
    private String mNum;
    private String mType;
    private String mHeight;
    private String mWeight;

    public static PokemonDialogFragment newInstance(
            String imageUrl, String name, String num, String type, String height, String weight) {

        PokemonDialogFragment fragment = new PokemonDialogFragment();

        Bundle args = new Bundle();
        args.putString(BUNDLE_IMAGE_URL, imageUrl);
        args.putString(BUNDLE_NAME, name);
        args.putString(BUNDLE_NUM, num);
        args.putString(BUNDLE_TYPE, type);
        args.putString(BUNDLE_HEIGHT, height);
        args.putString(BUNDLE_WEIGHT, weight);

        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        Bundle bundle = getArguments();
        mImageUrl = bundle.getString(BUNDLE_IMAGE_URL);
        mName = bundle.getString(BUNDLE_NAME);
        mNum = bundle.getString(BUNDLE_NUM);
        mType = bundle.getString(BUNDLE_TYPE);
        mHeight = bundle.getString(BUNDLE_HEIGHT);
        mWeight = bundle.getString(BUNDLE_WEIGHT);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_fragment, null);

        ImageView image = (ImageView) view.findViewById(R.id.dialog_image);
        Picasso.with(getActivity()).load(mImageUrl).into(image);
        ((TextView) view.findViewById(R.id.dialog_num)).setText(mNum);
        ((TextView) view.findViewById(R.id.dialog_name)).setText(mName);
        ((TextView) view.findViewById(R.id.dialog_type)).setText(mType);
        ((TextView) view.findViewById(R.id.dialog_height)).setText(mHeight);
        ((TextView) view.findViewById(R.id.dialog_weight)).setText(mWeight);

        builder.setView(view);
        return builder.create();
    }
}
