package projetomps.com.notech.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import projetomps.com.notech.R;
import projetomps.com.notech.model.Noticia;

public class NoticiaDetalhesFragment extends Fragment {

    private static final String TAG = "NoticiaDetalesFragment";
    private View view;
    private Noticia noticia;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //recupera a noticia selecionada passada como argumento e atribui ao fragmento
        noticia = getArguments().getParcelable("noticia");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //infla a view
        view = inflater.inflate(R.layout.noticia_detalhe_frag, container, false);

        //verificar se passar a imagem seria melhor
        Picasso.get().load(noticia.getUrlImagem()).into((ImageView) view.findViewById(R.id.noticiaImagem));
        ((TextView) view.findViewById(R.id.noticiaTitulo)).setText(noticia.getTitulo());
        ((TextView) view.findViewById(R.id.data)).setText(noticia.getData());
        ((TextView) view.findViewById(R.id.descricao)).setText(R.string.noticia_mcafee);
        //((TextView) view.findViewById(R.id.descricao)).setText(noticia.getTexto());
        ((TextView) view.findViewById(R.id.autor)).setText(noticia.getAutor());

        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable("noticia", noticia);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if(savedInstanceState != null) {
            Noticia estado = (Noticia) savedInstanceState.get("noticia");
            Picasso.get().load(estado.getUrlImagem()).into((ImageView) view.findViewById(R.id.noticiaImagem));
            ((TextView) view.findViewById(R.id.noticiaTitulo)).setText(estado.getTitulo());
            ((TextView) view.findViewById(R.id.data)).setText(estado.getData());
            ((TextView) view.findViewById(R.id.descricao)).setText(R.string.noticia_mcafee);
            //((TextView) view.findViewById(R.id.descricao)).setText(noticia.getTexto());
            ((TextView) view.findViewById(R.id.autor)).setText(estado.getAutor());
        }
    }
}
