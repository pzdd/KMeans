import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main {

	public static void main(String[] args) {
		
		//Dados de entrada
		List<Ponto> pontos = new ArrayList<>();
		Ponto p1 = new Ponto(1, 1, "A");
		pontos.add(p1);
		Ponto p2 = new Ponto(2, 1, "B");
		pontos.add(p2);
		Ponto p3 = new Ponto(4, 3, "C");
		pontos.add(p3);
		Ponto p4 = new Ponto(5, 4, "D");
		pontos.add(p4);
		
		//Centroides escolhidos
		List<Ponto> centroides = new ArrayList<>();
		centroides.add(p1);
		centroides.add(p2);
		
		int iterador=0;
		final int MAX = 3;
		
		while(iterador < MAX){
			
		System.out.println("Iteração:"+iterador);
		System.out.println("");
		
		double matriz[][] = distancias(pontos,centroides);
		
		System.out.println("Resultado do calculo das distâncias");
		for(int i=0;i<centroides.size();i++){
			for(int j=0;j<pontos.size();j++){
				System.out.print(matriz[i][j]+" ");
			}
			System.out.println("");
		}
		
		Map<Ponto,List<Ponto>> map = new HashMap<>();
		
		//inicializa o mapa
		for(int i=0;i<centroides.size();i++){
			if(!map.containsKey(centroides.get(i)))
				map.put(centroides.get(i), new ArrayList<Ponto>());
		}
		
		//populando o mapa associando os pontos aos centroides
		for(int i=0;i<pontos.size();i++){
			if(matriz[0][i] < matriz[1][i]){
				map.get(centroides.get(0)).add(pontos.get(i));
			}else if(matriz[0][i] > matriz[1][i]){
				map.get(centroides.get(1)).add(pontos.get(i));
			}
		}
		System.out.println("\nCentroide - Ponto");
		for(Ponto key : map.keySet()){
			List<Ponto> array = map.get(key);
			for(Ponto p: array){
				System.out.println(key.getNome()+"-"+p.getNome()+" ["+p.getX()+","+p.getY()+"]");
			}
		}
		System.out.println("");
		
		centroides = new ArrayList<>();
		
		//calcula o ponto medio de cada grupo
		for(Ponto key : map.keySet()){
			List<Ponto> array = map.get(key);
			Ponto p = media(array);
			p.setNome(key.getNome());
			centroides.add(p);
		}
		
		System.out.println("Pontos médios");
		for(Ponto p:centroides){
			System.out.println("["+p.getX()+","+p.getY()+"]");
		}
		System.out.println("");
		
		iterador++;
		}
	}
	
	
	/**Calcula a distância do centroide a um ponto*/
	public static double calculaDistancia(Ponto centroide, Ponto ponto){
		return Math.sqrt(Math.pow(centroide.getX()-ponto.getX(),2) + Math.pow(centroide.getY()-ponto.getY(),2)); 
	}
	
	/**Calcula a distância de todos os centroides a todos os pontos*/
	public static double[][] distancias(List<Ponto> ponto,List<Ponto> centroides){
		double[][] saida = new double[centroides.size()][ponto.size()];
		for(int i=0;i<centroides.size();i++){
			for(int j=0;j<ponto.size();j++){
				saida[i][j] = calculaDistancia(centroides.get(i), ponto.get(j));
			}
		}
		return saida;
	}
	
	/**Calcula a média de uma lista de pontos*/
	public static Ponto media(List<Ponto> pontos){
		Ponto saida = new Ponto();
		double x_media=0,y_media=0;
		for(Ponto p: pontos){
			x_media += p.getX();
			y_media += p.getY();
		}
		saida.setX(x_media/pontos.size());
		saida.setY(y_media/pontos.size());
		return saida;
	}

}
