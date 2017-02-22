package oak.shef.ac.uk.testrunningservicesbackgroundrelaunched;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentOneForImageActivity extends Fragment {


    public FragmentOneForImageActivity() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_fragment_one_for_image, container, false);

        ImageView imgofUser= (ImageView) view.findViewById(R.id.imgBigImage);

        String pcode = getArguments().getString("image");
        Picasso.with(getContext()).load(pcode).into(imgofUser);


        return view;
    }

}
