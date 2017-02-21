package com.iesb.tcc.amberbr.activity.adapters;

import android.content.Context;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
//import android.widget.ResourceCursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.iesb.tcc.amberbr.R;

import com.iesb.tcc.amberbr.entity.Alerta;
import com.iesb.tcc.amberbr.entity.TipoAlerta;

import java.util.List;

/**
 * Criado por Sinvas em 08/02/2017.
 */

public class ListaAlertasAdapter extends ArrayAdapter<Alerta> {

    //private Context context;
    //private List<Alerta> alertas;

    public ListaAlertasAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }


    public ListaAlertasAdapter(Context context, int resource, List<Alerta> alertas){
        super(context, resource, alertas);

        //this.context = context;
        //this.alertas = alertas;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Alerta alerta = getItem(position);

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_item_lista_alerta, null);

            ImageView foto = (ImageView) convertView.findViewById(R.id.imageViewFoto);
            if(alerta.getFotos().size() > 0) {
                //foto.setImageAlpha(alerta.getFotos().get(0).getImagem());
            }

            TextView nome = (TextView) convertView.findViewById(R.id.textNome);
            nome.setTypeface(null, Typeface.BOLD);
            if(alerta.getDesaparecido().getNome().length() > 20) {
                nome.setText(alerta.getDesaparecido().getNome().substring(0, 20));
            }else{
                nome.setText(alerta.getDesaparecido().getNome());
            }

            TextView idade = (TextView) convertView.findViewById(R.id.textIdade);
            idade.setTypeface(null, Typeface.BOLD);
            if(alerta.getDesaparecido().getIdade() > 0) {
                idade.setText(alerta.getDesaparecido().getIdade() + " anos");
            }else{
                idade.setText("Bebê");
            }

            TextView tipoAlerta = (TextView) convertView.findViewById(R.id.textTipoAlerta);
            tipoAlerta.setText(alerta.getTipoAlerta().getNome().toUpperCase());
            tipoAlerta.setTypeface(null, Typeface.BOLD);
            tipoAlerta.setTextSize(16);
            if(alerta.getTipoAlerta() == TipoAlerta.ALERTA_POLICIAL) {
                //Mostrar imagem do escudo da polícia
                tipoAlerta.setTextColor(Color.parseColor("#ffcc0000"));
            }else{
                tipoAlerta.setTextColor(Color.parseColor("#ff000000"));
            }

            TextView tipoDesaparecimento = (TextView) convertView.findViewById(R.id.textTipoDesaparecimento);
            tipoDesaparecimento.setText(alerta.getTipoDesaparecimento().getNome().toUpperCase());

            TextView tempoDecorrido = (TextView) convertView.findViewById(R.id.textTempoDecorrido);
            tempoDecorrido.setText(alerta.getDataHoraAbertura().toString());
            //Fazer o tratamento para acrescentar texto de acordo com o tempo decorrido.

            TextView distancia = (TextView) convertView.findViewById(R.id.textDistancia);
            //tempoDecorrido.setText(alerta.getLocalizacao().get .toString());

        }
        return convertView;

    }
}
