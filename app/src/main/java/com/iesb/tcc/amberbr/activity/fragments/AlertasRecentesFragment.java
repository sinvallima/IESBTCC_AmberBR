package com.iesb.tcc.amberbr.activity.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.iesb.tcc.amberbr.R;
import com.iesb.tcc.amberbr.activity.adapters.ListaAlertasAdapter;
import com.iesb.tcc.amberbr.entity.Alerta;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AlertasRecentesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AlertasRecentesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AlertasRecentesFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static List<Alerta> listaAlertasRecentes;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public AlertasRecentesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment AlertasRecentesFragment.
     */
    // TODO: Rename and change types and number of parameters
    //public static AlertasRecentesFragment newInstance(String param1, String param2) {
    public static AlertasRecentesFragment newInstance(List<Alerta> lista) {
        AlertasRecentesFragment fragment = new AlertasRecentesFragment();
        Bundle args = new Bundle();
        //args.putString(ARG_PARAM1, param1);
        //args.putString(ARG_PARAM2, param2);
        //fragment.setArguments(args);

        listaAlertasRecentes = lista;

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

/*
        ListaAlertasAdapter mAdapter = new ListaAlertasAdapter(this.getContext(), listaAlertasRecentes);

        ListView listView = (ListView) getView().findViewById(R.id.lv_alertas_recentes);
        listView.setAdapter(mAdapter);
*/

/*
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View v = inflater.inflate(R.layout.fragment_alertas_recentes, container, false);

        ListaAlertasAdapter mAdapter = new ListaAlertasAdapter(this.getContext(), R.layout.fragment_item_lista_alerta, listaAlertasRecentes);
        ListView listView = (ListView) v.findViewById(R.id.lv_alertas_recentes);
        listView.setAdapter(mAdapter);


        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
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
}
