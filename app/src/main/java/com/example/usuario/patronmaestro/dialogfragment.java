package com.example.usuario.patronmaestro;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DialogTitle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
 import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link dialogfragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link dialogfragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class dialogfragment extends DialogFragment implements prueba.OnFragmentInteractionListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
View view;
TextView textView;
ImageView imageView;
RecyclerView recyclerView;
Toolbar toolbar;
MenuItem menuItem;
ArrayList<extraccion>listamenu;
adaptador adaptador;
    public dialogfragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment dialogfragment.
     */
    // TODO: Rename and change types and number of parameters
    public static dialogfragment newInstance(String param1, String param2) {
        dialogfragment fragment = new dialogfragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        try {  // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_dialogfragment, container, false);

          toolbar = view.findViewById(R.id.toolbar);

          menuItem = view.findViewById(R.id.estado);
          textView = view.findViewById(R.id.titulo);
          imageView = view.findViewById(R.id.salir);
          recyclerView = view.findViewById(R.id.galeria);
          imageView.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  getDialog().dismiss();
              }
          });
          recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

          listamenu = new extraccion().listademenu();

          adaptador = new adaptador(listamenu, new adaptador.onClickrecycler() {
              @Override
              public void onCLickItemRecycler(extraccion extraccion) {
                  imageView.setImageResource(extraccion.getImagen());
                  textView.setText(extraccion.getTitulo());
              }
          });

          recyclerView.setAdapter(adaptador);
      }catch (Exception ex){

      }
      return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        String m  = "";
        switch (item.getItemId()){

            case R.id.estado:


                m = "escogido el primer item";
                break;
                default:
                    break;

        }
        Toast.makeText(getContext(),m,Toast.LENGTH_SHORT).show();

        return super.onOptionsItemSelected(item);
    }


}
