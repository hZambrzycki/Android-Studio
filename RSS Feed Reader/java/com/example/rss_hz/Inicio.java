package com.example.rss_hz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class Inicio extends AppCompatActivity {
    ListView listView;

    String[] nombreRSS = {"La Nueva España", "Metricool", "La Vanguardia", "El Pais", "The Daily by The New York Times", "The Bible in Year", "Crime Junkie",
            "The Dan Bongino Show", "Unraveled: Long Island Serial Killer", "Morbid: A True Crime Podcast",
            "Dateline NBC", "The Lincoln Project", "LifeHacker", "Reuters", "Politico", "Europa Press", "Microsiervos", "El Confidencial", "El Mundo", "Portal web del Ayuntamiento de Madrid"};
    String[] RSS_Descripcion = {"Noticias de Asturias. Información, opinión y toda la actualidad del Principado de Asturias en el diario líder de Asturias.",
            "Metricool es una herramienta de gestión de redes sociales y publicidad en línea web y móvil se usa para gestionar redes sociales y anuncios en línea " +
                    "por particulares, agencias o freelance",
            "La Vanguardia, titulado La Vanguardia Española entre 1939 y 1978, es un diario matinal de información general editado en Barcelona para toda España",
            "El País es un periódico español fundado en 1976. Se redacta en español, aunque también publica contenidos en catalán, inglés y portugués",
            "This is what the news should sound like. The biggest stories of our time, told by the best journalists in the world. Hosted by Michael Barbaro. " +
                    "Twenty minutes a day, five days a week, ready by 6 a.m.",
            "In The Bible in a Year podcast, Fr. Mike Schmitz walks you through the entire Bible in 365 episodes, providing commentary, reflection, and prayer along the way.",
            "Crime Junkie is a weekly true crime podcast dedicated to giving you a fix. Every Monday, Ashley Flowers will tell you about whatever crime she’s been obsessing " +
                    "over that week in a way that sounds like you’re sitting around talking crime with your best friends.",
            "He’s a former Secret Service Agent, former NYPD officer, and New York Times best-selling author. Join Dan Bongino each weekday as he tackles the hottest political issues, " +
                    "debunking both liberal and Republican establishment rhetoric.",
            "Unraveled: Long Island Serial Killer is a search for answers in one of the biggest murder mysteries in American history. It’s been ten years since eleven bodies were found on the coast" +
                    " of Long Island. Amongst a backdrop of police corruption and cover ups at the highest levels of Suffolk County, co-hosts Alexis Linkletter and Billy " +
                    "Jensen reinvestigate the murders from a decade ago to expose the untold story of why the case remains unsolved."
            , "Morbid is a true crime, creepy history, and all things spooky podcast hosted by an autopsy technician and a hairstylist. Join them for a heavy dose of research with a dash of comedy thrown in for flavor.",
            "Current and classic episodes, featuring compelling true-crime mysteries, powerful documentaries and in-depth investigations.",
            "Trump may be gone but American politics is still in crisis. The Lincoln Project has sparked a nationwide movement to restore our democracy. The Lincoln Podcast 2.0 is hosted by co-founder Reed Galen and he is " +
                    "regularly joined by our political experts and guests that helped defeat Trump and continue the mission to stamp out Trumpism and the seditionists who backed him. The podcast discusses today’s political " +
                    "challenges, our vision for the future and how all Americans can be part of our pro-democracy movement."
            , "Lifehacker’s an award-winning daily blog that features tips, shortcuts, and downloads that help you work and live smarter and more efficiently.",
            "Business and financial news, U.S. and international breaking news.",
            "POLITICO strives to be the dominant source for news on politics and policy in power centers across every continent where access to reliable information," +
                    " nonpartisan journ.lism and real-time tools create, inform and engage a global citizenry.",
            "Europa Press es una agencia de noticias privada española. Fue fundada en 1953 por Torcuato Luca de Tena Brunet y otras personalidades miembros +" +
                    "del Opus Dei que poseían altos cargos gubernamentales durante el segundo franquismo",
            "Microsiervos es un blog español multitemático, aunque con énfasis en temas científicos, tecnológicos y curiosidades.",
            "El Confidencial es un diario digital español de información general, especializado en noticias económicas, financieras y " +
                    "de actualidad política fundado en 2001",
            "El Mundo, antes denominado El Mundo del Siglo XXI, es un periódico español diario. Tiene su sede en Madrid. El director desde su fundación el 23 de octubre de 1989 hasta el 30 de enero de 2014 fue Pedro J. Ramírez.",
            "El Ayuntamiento de Madrid es el organismo que se encarga del gobierno y de la administración del municipio de Madrid, España. Está presidido por el correspondiente alcalde, actualmente José Luis Martínez-Almeida, del Partido Popular"};

    int[] imagen_RSS = {R.drawable.lne, R.drawable.metricool,
            R.drawable.vanguardia, R.drawable.pais, R.drawable.daily,
            R.drawable.biblia, R.drawable.crime, R.drawable.bongino,
            R.drawable.unraveled, R.drawable.morbid, R.drawable.dateline,
            R.drawable.lincoln, R.drawable.lifehacker, R.drawable.reuters,
            R.drawable.politico, R.drawable.europapress, R.drawable.microsiervos,
            R.drawable.confidencial, R.drawable.elmundo, R.drawable.ayuntamiento};

    String[] urls = {"https://www.lne.es/rss/section/1600479/",
            "https://metricool.com/feed/",
            "https://www.lavanguardia.com/rss/opinion.xml",
            "https://feeds.elpais.com/mrss-s/pages/ep/site/elpais.com/portada",
            "https://feeds.simplecast.com/54nAGcIl",
            "https://feeds.fireside.fm/bibleinayear/rss",
            "https://feeds.simplecast.com/qm_9xx0g",
            "https://feeds.megaphone.fm/WWO3519750118",
            "https://feeds.acast.com/public/shows/5ea17537-f11f-4532-8202-294d976b9d5c",
            "https://audioboom.com/channels/4997220.rss",
            "https://podcastfeeds.nbcnews.com/HL4TzgYC",
            "https://lincolnproject.libsyn.com/rss",
            "https://lifehacker.com/rss",
            "https://cdn.feedcontrol.net/8/1114-wioSIX3uu8MEj.xml",
            "https://www.politico.com/rss/politicopicks.xml",
            "https://www.europapress.es/rss/rss.aspx?ch=00279",
            "https://www.microsiervos.com/index.xml",
            "https://www.elconfidencialdigital.com/rss",
            "https://e00-elmundo.uecdn.es/elmundo/rss/portada.xml",
            "https://www.madrid.es/ContentPublisher/jsp/apl/obtenerRSS.jsp?tipoContenido=Noticia&idCanal=e40362215c483510VgnVCM2000001f4a900aRCRD"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        listView = findViewById(R.id.listView);
        ProgramAdapter programAdapter = new ProgramAdapter(this, nombreRSS, imagen_RSS, RSS_Descripcion, urls);
        listView.setAdapter(programAdapter);
    }
}