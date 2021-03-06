package tp2;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Coordenadas {

	ArrayList<Coordenada> Coordenadas = new ArrayList<Coordenada>();

	public Coordenadas(String archivo) {
		Gson gson = new Gson();
		try {
			BufferedReader br = new BufferedReader(new FileReader(archivo));
			this.Coordenadas = gson.fromJson(br, new TypeToken<ArrayList<Coordenada>>() {
			}.getType());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public double LatitudPromedio() {
		double ret = 0;
		for (int x = 0; x < Coordenadas.size(); x++) {
			ret += Coordenadas.get(x).getLatitud();
		}
		ret = ret / Coordenadas.size();
		return ret;
	}

	public double LongitudPromedio() {
		double ret = 0;
		for (int x = 0; x < Coordenadas.size(); x++) {
			ret += Coordenadas.get(x).getLongitud();
		}
		ret = ret / Coordenadas.size();
		return ret;
	}

	public void MarcarPuntos(MapMarker marker, JMapViewer Mapa) {
		for (int x = 0; x < Coordenadas.size(); x++) {
			marker = new MapMarkerDot(Coordenadas.get(x).getLatitud(), Coordenadas.get(x).getLongitud());
			marker.getStyle().setBackColor(Color.RED);
			Mapa.addMapMarker(marker);
		}
	}

	public Coordenada PedirCoordenada(int e) {
		return Coordenadas.get(e);
	}

}
