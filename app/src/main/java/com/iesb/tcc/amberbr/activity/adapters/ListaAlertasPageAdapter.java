package com.iesb.tcc.amberbr.activity.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.iesb.tcc.amberbr.activity.fragments.AlertasEncerradosFragment;
import com.iesb.tcc.amberbr.activity.fragments.AlertasRecentesFragment;
import com.iesb.tcc.amberbr.entity.Alerta;
import com.iesb.tcc.amberbr.entity.TipoAlerta;
import com.iesb.tcc.amberbr.entity.TipoDesaparecimento;

import java.util.ArrayList;

/**
 * Criado por Sinvas em 06/02/2017.
 */

public class ListaAlertasPageAdapter extends FragmentStatePagerAdapter {

    int mNumOfTabs;
    private String[] tabTitles = new String[]{"Alertas Recentes",
                                              "Encerrados"};

    public ListaAlertasPageAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        //return super.getPageTitle(position);
        return tabTitles[position];
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                AlertasRecentesFragment tab1 = new AlertasRecentesFragment();

                //TODO: SBL
                ArrayList<Alerta> listaAlertasRecentes = new ArrayList<>();

                listaAlertasRecentes.add(new Alerta(TipoAlerta.ALERTA_LOCAL, TipoDesaparecimento.FUGA_DE_CASA, "Jonas", "", (short)12));
                listaAlertasRecentes.add(new Alerta(TipoAlerta.ALERTA_POLICIAL, TipoDesaparecimento.PERDIDO, "Mariana", "", (short)2));
                listaAlertasRecentes.add(new Alerta(TipoAlerta.ALERTA_POLICIAL, TipoDesaparecimento.POSSIVEL_SEQUESTRO, "Jorginho", "", (short)-1));
                listaAlertasRecentes.add(new Alerta(TipoAlerta.ALERTA_LOCAL, TipoDesaparecimento.PERDIDO, "Francisco", "", (short)6));

                tab1.newInstance(listaAlertasRecentes);
                return tab1;
            case 1:
                AlertasEncerradosFragment tab2 = new AlertasEncerradosFragment();
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
